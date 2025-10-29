package lotto.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.Lotto;
import lotto.service.LottoNumberGenerator;

public class BuyLottoTask implements TaskRunnable {
    private final LottoNumberGenerator numberGenerator;
    private final ApplicationContext applicationContext;

    public BuyLottoTask(LottoNumberGenerator numberGenerator, ApplicationContext applicationContext) {
        this.numberGenerator = numberGenerator;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run() {
        Integer lottoSize = applicationContext.getBean(ApplicationContextKey.LOTTO_SIZE, Integer.class);
        List<Lotto> lottos = IntStream.range(0, lottoSize)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
        printLottos(lottos);
        applicationContext.addBean(ApplicationContextKey.LOTTOS, lottos);
    }

    private void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .map(ArrayList::new)
                .forEach(numbers -> {
                    Collections.sort(numbers);
                    System.out.println(numbers);
                });
    }
}
