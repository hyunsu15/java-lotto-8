package lotto.client;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerBonusLottoNumberTaskTest {
    @Test
    @DisplayName("입력이 잘못되도 마지막에 올바른 값이 나오면 작동된다.")
    void test() {
        LinkedList<String> que = new LinkedList<>();
        que.add("1,2,3,4,5,6");
        que.add("-1");
        que.add("0");
        que.add("46");
        que.add("10");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력이 null이 들어와도 마지막에 올바른 값이 나오면 작동된다.")
    void test1() {
        LinkedList<String> que = new LinkedList<>();
        que.add(null);
        que.add("");
        que.add(" ");
        que.add("10");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    private TaskRunnable getTask(Queue<String> queue) {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.addBean(ApplicationContextKey.ANSWER_LOTTO, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        return new AnswerBonusLottoNumberTask(new TestCustomConsole(queue), applicationContext);
    }

}