package lotto;

import java.util.List;
import lotto.client.Client;
import lotto.client.DetermineLottoSizeTask;
import lotto.client.TaskRunnable;
import lotto.input.CustomConsole;

public class AppConfig {
    public Client getClient() {
        ApplicationContext applicationContext = getApplicationContext();
        try (CustomConsole customConsole = getConsole()) {
            return new Client(getTasks(applicationContext, customConsole));
        }
    }

    private List<TaskRunnable> getTasks(ApplicationContext applicationContext, CustomConsole customConsole) {
        return List.of(new DetermineLottoSizeTask(customConsole, applicationContext));
    }

    private CustomConsole getConsole() {
        return new CustomConsole();
    }

    private ApplicationContext getApplicationContext() {
        return new ApplicationContext();
    }
}
