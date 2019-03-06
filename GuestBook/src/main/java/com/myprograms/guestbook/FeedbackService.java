package com.myprograms.guestbook;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FeedbackService {

    private final DataSource dataSource;

    public FeedbackService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createFeedback(String name, String text, int rank) {

        String insert = "INSERT INTO feedback (name, comment, rating) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(insert)) {
            ps.setString(1, name);
            ps.setString(2, text);
            ps.setInt(3, rank);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> getFeedbackOrderedByDate() {
        String select = "SELECT * FROM feedback ORDER BY date DESC";
        List<Feedback> feedbacks = new ArrayList<>();

        try(PreparedStatement statement = dataSource.getConnection().prepareStatement(select); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Feedback feedback = new Feedback();

                feedback.setId(rs.getInt(1));
                feedback.setName(rs.getString(2));
                feedback.setText(rs.getString(3));
                feedback.setRank(rs.getInt(4));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                feedback.setDate(LocalDateTime.parse(rs.getString(5), formatter));

                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
