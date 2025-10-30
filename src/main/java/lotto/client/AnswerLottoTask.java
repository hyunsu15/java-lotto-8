package lotto.client;

import java.util.Arrays;
import java.util.List;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.Lotto;
import lotto.input.CustomConsole;

public class AnswerLottoTask implements RequestTask<Lotto> {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.";
    private static final String NULL_OR_EMPTY_ERROR_MESSAGE = "입력값은 널이나 비어있는 값이 될 수 없다. 값:%s";
    private static final String READLINE_SPLITOR = ",";
    private static final String CONVERT_ERROR_MESSAGE = "숫자로 변환실패했습니다.";

    private final CustomConsole console;
    private final ApplicationContext applicationContext;

    public AnswerLottoTask(CustomConsole console, ApplicationContext applicationContext) {
        this.console = console;
        this.applicationContext = applicationContext;
    }

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public Lotto mappingRequest(String readLine) {
        try {
            if (readLine == null || readLine.isBlank()) {
                throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE.formatted(readLine));
            }
            List<Integer> numbers = Arrays.stream(readLine.trim().split(READLINE_SPLITOR))
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_ERROR_MESSAGE);
        }
    }

    @Override
    public CustomConsole getConsole() {
        return console;
    }

    @Override
    public void addBean(Lotto request) {
        applicationContext.addBean(ApplicationContextKey.ANSWER_LOTTO, request);
    }

}
