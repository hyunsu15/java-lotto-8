package lotto.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.Lotto;
import lotto.domain.LottoSize;
import lotto.service.LottoNumberGenerator;

public class BuyLottoTask implements ResponseTask<Integer, List<Lotto>> {
    private final LottoNumberGenerator numberGenerator;
    private final ApplicationContext applicationContext;

    public BuyLottoTask(LottoNumberGenerator numberGenerator, ApplicationContext applicationContext) {
        this.numberGenerator = numberGenerator;
        this.applicationContext = applicationContext;
    }

    @Override
    public void printResponse(List<Lotto> response) {
        response.stream()
                .map(Lotto::getNumbers)
                .map(ArrayList::new)
                .forEach(numbers -> {
                    Collections.sort(numbers);
                    System.out.println(numbers);
                });
    }

    @Override
    public List<Lotto> mappingResponse(Integer request) {
        return IntStream.range(0, request)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
    }

    @Override
    public Integer getRequest() {
        return applicationContext.getBean(ApplicationContextKey.LOTTO_SIZE, LottoSize.class).getSize();
    }

    @Override
    public void addBean(List<Lotto> response) {
        applicationContext.addBean(ApplicationContextKey.LOTTOS, response);
    }

}
