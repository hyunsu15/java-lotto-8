package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class CustomConsole implements AutoCloseable {
    @Override
    public void close() {
        Console.close();
    }

    public String readLine() {
        return Console.readLine();
    }
}
