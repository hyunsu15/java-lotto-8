package lotto.client;

import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.LottoSize;
import lotto.input.CustomConsole;

public class DetermineLottoSizeTask implements RequestTask<LottoSize> {

    private static final int BUY_UNIT = 1_000;
    private final CustomConsole console;
    private final ApplicationContext applicationContext;

    public DetermineLottoSizeTask(CustomConsole console, ApplicationContext applicationContext) {
        this.console = console;
        this.applicationContext = applicationContext;
    }


    @Override
    public String getInputMessage() {
        return "구입금액을 입력해 주세요.";
    }

    @Override
    public LottoSize mappingRequest(String readLine) {
        try {
            Integer size = Integer.parseInt(readLine);
            return new LottoSize(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 변환이 되지않습니다. %s".formatted(readLine));
        }

    }

    @Override
    public void printRequest(LottoSize request) {
        System.out.println("%d개를 구매했습니다.".formatted(request.getSize()));
    }

    @Override
    public CustomConsole getConsole() {
        return console;
    }

    @Override
    public void addBean(LottoSize request) {
        applicationContext.addBean(ApplicationContextKey.LOTTO_SIZE, request);
    }
}
