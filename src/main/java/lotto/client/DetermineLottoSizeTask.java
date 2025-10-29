package lotto.client;

import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.input.CustomConsole;

public class DetermineLottoSizeTask extends TaskTemplate<Integer, Integer> {

    private static final int BUY_UNIT = 1_000;

    public DetermineLottoSizeTask(CustomConsole customConsole, ApplicationContext applicationContext) {
        super(customConsole, applicationContext);
    }


    @Override
    protected String getInputMessage() {
        return "구입금액을 입력해 주세요.";
    }

    @Override
    protected Integer mappingRequest(String readLine) {
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 변환이 되지않습니다. %s".formatted(readLine));
        }
    }

    @Override
    protected void validateRequest(Integer request) {
        LottoSizeValidator.validate(request);
    }

    @Override
    protected void printResponse(Integer response) {
        System.out.println("%d개를 구매했습니다".formatted(response));
    }

    @Override
    protected Integer mappingResponse(Integer request) {
        return request / BUY_UNIT;
    }

    @Override
    protected ApplicationContextKey getApplicationContextKey() {
        return ApplicationContextKey.LOTTO_SIZE;
    }

}
