package pl.mateusz1364.tasksapplication.client.dto;

import java.util.List;

public class TaskCollectionDto {
    private List<TaskDto> tasks;

    public TaskCollectionDto() {
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}