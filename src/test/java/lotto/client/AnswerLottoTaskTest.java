package lotto.client;

import java.util.LinkedList;
import java.util.Queue;
import lotto.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerLottoTaskTest {
    @Test
    @DisplayName("해피케이스 테이스")
    void test() {
        LinkedList<String> que = new LinkedList<>();
        que.add("1");
        que.add(" ,2,3,4,5,6");
        que.add("1,2,3,4 ,5,6");
        que.add("1,2,3,4,5,6+");
        que.add("1,2,3,4,5,6");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("널 테이스")
    void test1() {
        LinkedList<String> que = new LinkedList<>();
        que.add(null);
        que.add("");
        que.add("1000");
        que.add("1,2,3,4,5,6");
        Assertions.assertThatCode(() -> getTask(que).run()).doesNotThrowAnyException();
    }

    private TaskRunnable getTask(Queue<String> queue) {
        return new AnswerLottoTask(new TestCustomConsole(queue), new ApplicationContext());
    }
}