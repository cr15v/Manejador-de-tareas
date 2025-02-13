package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty");
        }
        tasks.add(new Task(description));
    }

    public void completeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
        tasks.get(index).setCompleted(true);
    }

    public List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }
}

class Task {
    private final String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

// Test class
package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TaskManagerTest {
    private final TaskManager taskManager = new TaskManager();

    @Test
    public void testAddTask_ValidTask() {
        taskManager.addTask("Complete project");
        assertEquals(1, taskManager.getPendingTasks().size());
    }

    @Test
    public void testAddTask_EmptyDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            taskManager.addTask("");
        });
        assertEquals("Task description cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testCompleteTask_ValidIndex() {
        taskManager.addTask("Submit report");
        taskManager.completeTask(0);
        List<Task> pendingTasks = taskManager.getPendingTasks();
        assertEquals(0, pendingTasks.size());
    }

    @Test
    public void testCompleteTask_InvalidIndex() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            taskManager.completeTask(5);
        });
        assertEquals("Invalid task index", exception.getMessage());
    }
}
