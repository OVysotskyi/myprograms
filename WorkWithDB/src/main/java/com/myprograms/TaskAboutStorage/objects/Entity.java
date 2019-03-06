package com.myprograms.TaskAboutStorage.objects;

import com.myprograms.TaskAboutStorage.storage.Storage;

/**
 * Base class for all objects that could be stored with any {@link Storage} implementation.
 */
public abstract class Entity {
    private Integer id;

    public boolean isNew() {
        return getId() == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
