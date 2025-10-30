package lotto.client;

import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.BonusLottoNumber;
import lotto.input.CustomConsole;

public class AnswerBonusLottoNumberTask implements RequestTask<BonusLottoNumber> {
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String CONVERT_ERROR_MESSAGE = "숫자를 변환할수 없는 값입니다. 값:%s";
    private final CustomConsole console;
    private final ApplicationContext context;

    public AnswerBonusLottoNumberTask(CustomConsole console, ApplicationContext context) {
        this.console = console;
        this.context = context;
    }

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public BonusLottoNumber mappingRequest(String readLine) {
        try {
            int lottoNumber = Integer.parseInt(readLine);
            return new BonusLottoNumber(lottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_ERROR_MESSAGE.formatted(readLine));
        }
    }

    @Override
    public CustomConsole getConsole() {
        return console;
    }

    @Override
    public void addBean(BonusLottoNumber lottoNumber) {
        context.addBean(ApplicationContextKey.ANSWER_BONUS_LOTTO_NUMBER, lottoNumber);
    }
}
