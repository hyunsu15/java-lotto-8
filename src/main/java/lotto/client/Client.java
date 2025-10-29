package lotto.client;

import java.util.List;

public class Client {
    private final List<TaskRunnable> tasks;

    public Client(List<TaskRunnable> tasks) {
        this.tasks = tasks;
    }

    public void start() {
        tasks.forEach(TaskRunnable::run);
    }
}
