package lotto.client;

import java.util.LinkedList;
import java.util.Queue;
import lotto.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DetermineLottoSizeTaskTest {

    @Test
    @DisplayName("입력이 잘못되도 마지막에 올바른 값이 나오면 작동된다.")
    public void buyLottoTaskTest() {
        LinkedList<String> que = new LinkedList<>();
        que.add("1");
        que.add("1_000");
        que.add("1000");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력이 null이 들어와도 마지막에 올바른 값이 나오면 작동된다.")
    public void test1() {
        LinkedList<String> que = new LinkedList<>();
        que.add(null);
        que.add("");
        que.add(" ");
        que.add("1000");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    private TaskRunnable getTask(Queue<String> queue) {
        return new DetermineLottoSizeTask(new TestCustomConsole(queue), new ApplicationContext());
    }
}