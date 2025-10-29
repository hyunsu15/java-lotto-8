package lotto.client;

import java.util.Queue;
import lotto.input.CustomConsole;

public class TestCustomConsole extends CustomConsole {
    private Queue<String> readLine;

    public TestCustomConsole(Queue<String> readLine) {
        this.readLine = readLine;
    }

    @Override
    public String readLine() {
        return readLine.poll();
    }
}
