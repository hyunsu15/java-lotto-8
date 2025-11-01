package lotto.client;

import java.util.List;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.LottoSize;
import lotto.service.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyLottoTaskTest {
    @Test
    @DisplayName("로또 구매한 내용을 보여준다.")
    public void test() {
        Assertions.assertThatCode(() -> getTask(List.of(1, 3, 2, 4, 5, 6)).run()).doesNotThrowAnyException();
    }

    private TaskRunnable getTask(List<Integer> number) {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.addBean(ApplicationContextKey.LOTTO_SIZE, new LottoSize(1_000));
        return new BuyLottoTask(new LottoNumberGenerator() {
            @Override
            public List<Integer> generateNumbers() {
                return number;
            }
        }, applicationContext);
    }
}