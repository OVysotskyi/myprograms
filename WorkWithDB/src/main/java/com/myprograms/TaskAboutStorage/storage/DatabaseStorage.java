package com.myprograms.TaskAboutStorage.storage;

import com.geekhub.hw11.TaskAboutStorage.objects.Entity;
import com.geekhub.hw11.TaskAboutStorage.objects.Ignore;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Implementation of {@link Storage} that uses database as a storage for objects.
 * It uses simple object type names to define target table to save the object.
 * It uses reflection to access objects fields and retrieve data to map to database tables.
 * As an identifier it uses field id of {@link Entity} class.
 * Could be created only with {@link Connection} specified.
 */
public class DatabaseStorage implements Storage {

    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        //this method is fully implemented, no need to do anything, it's just an example
        String sql = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\" WHERE id = " + id;

        try (Statement statement = connection.createStatement()) {
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        String request = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\"";

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(request);
            List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
            List<T> list = new ArrayList<>();

            while (rs.next()) {
                T newInstance = clazz.getConstructor().newInstance();
                newInstance.setId(rs.getInt("id"));

                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();

                    try {
                        Object value = rs.getObject(name);
                        field.set(newInstance, value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(newInstance);
            }
            return list;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        Class clazz = entity.getClass();

        String request = "DELETE FROM \"" + clazz.getSimpleName().toLowerCase() + "\" WHERE id = " + entity.getId();

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(request);
            return true;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException {
        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String tableName = clazz.getSimpleName().toLowerCase();
        Map map = prepareEntity(entity);
        String request;

        if (entity.isNew()) {
            String[] fieldsList = new String[fields.length];
            String[] questionMarks = new String[fields.length];
            int counter = 0;

            for (Field field : fields) {
                fieldsList[counter] = field.getName();
                questionMarks[counter] = "?";
                counter++;
            }

            request = "INSERT INTO \"" + tableName + "\" (" + String.join(", ", fieldsList) + ") " +
                    "VALUES (" + String.join(", ", questionMarks) + ");";
        } else {
            request = "UPDATE \"" + tableName + "\" SET admin = ? WHERE id = " + entity.getId();
        }

        try (PreparedStatement statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)) {
            if (!entity.isNew()) {
                Field field = clazz.getDeclaredField("admin");
                field.setAccessible(true);
                statement.setObject(1, field.get(entity));
                statement.execute();
            } else {
                int count = 1;

                for (Object key : map.keySet()) {
                    statement.setObject(count, map.get(key));
                    count++;
                }
                statement.executeUpdate();
                ResultSet rsKey = statement.getGeneratedKeys();

                while (rsKey.next()) {
                    entity.setId(rsKey.getInt(1));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    //converts object to map, could be helpful in save method
    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws StorageException {
        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> mapEntity = new LinkedHashMap<>();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                mapEntity.put(field.getName(), field.get(entity));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
        return mapEntity;
    }

    //creates list of new instances of clazz by using data from resultset
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        List<T> list = new ArrayList<>();

        while (resultSet.next()) {
            T newInstance = clazz.getConstructor().newInstance();
            newInstance.setId(resultSet.getInt("id"));

            for (Field field : fields) {
                Ignore ignore = field.getAnnotation(Ignore.class);
                field.setAccessible(true);
                String name = field.getName();

                try {
                    Object value = resultSet.getObject(name);

                    if (ignore != null) {
                        continue;
                    }
                    field.set(newInstance, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            list.add(newInstance);
        }
        return list;
    }
}