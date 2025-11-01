package lotto.client;

import java.util.LinkedList;
import java.util.Queue;
import lotto.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//todo displayName 좀더 명확하게 수정해야함
class DetermineLottoSizeTaskTest {

    @Test
    @DisplayName("해피케이스 테이스")
    public void buyLottoTaskTest() {
        LinkedList<String> que = new LinkedList<>();
        que.add("1");
        que.add("1_000");
        que.add("1000");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("널 테이스")
    public void test1() {
        LinkedList<String> que = new LinkedList<>();
        que.add(null);
        que.add("");
        que.add("1000");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    private TaskRunnable getTask(Queue<String> queue) {
        return new DetermineLottoSizeTask(new TestCustomConsole(queue), new ApplicationContext());
    }
}