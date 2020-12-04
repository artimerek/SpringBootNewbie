package io.github.artimerek.model.projection;

import io.github.artimerek.model.Task;

public class GroupTaskReadModel {
    private boolean done;
    private String description;

    public GroupTaskReadModel(Task source) {
        description = source.getDescription();
        done = source.isDone();

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
