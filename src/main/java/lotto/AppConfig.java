package lotto;

import java.util.List;
import lotto.client.AnswerBonusLottoNumberTask;
import lotto.client.AnswerLottoTask;
import lotto.client.BuyLottoTask;
import lotto.client.Client;
import lotto.client.CompareLottoTask;
import lotto.client.DetermineLottoSizeTask;
import lotto.client.TaskRunnable;
import lotto.input.CustomConsole;
import lotto.service.LottoNumberGenerator;

public class AppConfig {
    public Client getClient() {
        ApplicationContext applicationContext = getApplicationContext();
        try (CustomConsole customConsole = getConsole()) {
            return new Client(getTasks(applicationContext, customConsole));
        }
    }

    private List<TaskRunnable> getTasks(ApplicationContext applicationContext, CustomConsole customConsole) {
        return List.of(
                new DetermineLottoSizeTask(customConsole, applicationContext)
                , new BuyLottoTask(new LottoNumberGenerator(), applicationContext)
                , new AnswerLottoTask(customConsole, applicationContext)
                , new AnswerBonusLottoNumberTask(customConsole, applicationContext)
                , new CompareLottoTask(applicationContext)
        );
    }

    private CustomConsole getConsole() {
        return new CustomConsole();
    }

    private ApplicationContext getApplicationContext() {
        return new ApplicationContext();
    }
}
