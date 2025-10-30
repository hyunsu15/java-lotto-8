package lotto.client;

import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.LottoSize;
import lotto.input.CustomConsole;

public class DetermineLottoSizeTask implements RequestTask<LottoSize> {

    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CONVERT_ERROR_MESSAGE = "숫자 변환이 되지않습니다. %s";
    private static final String REQUEST_MESSAGE = "%d개를 구매했습니다.";

    private final CustomConsole console;
    private final ApplicationContext applicationContext;

    public DetermineLottoSizeTask(CustomConsole console, ApplicationContext applicationContext) {
        this.console = console;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run() {
        RequestTask.super.run();
        printRequest(applicationContext.getBean(ApplicationContextKey.LOTTO_SIZE, LottoSize.class));
    }

    @Override
    public String getInputMessage() {
        return INPUT_MESSAGE;
    }

    @Override
    public LottoSize mappingRequest(String readLine) {
        try {
            Integer size = Integer.parseInt(readLine);
            return new LottoSize(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONVERT_ERROR_MESSAGE.formatted(readLine));
        }

    }


    private void printRequest(LottoSize request) {
        System.out.println(REQUEST_MESSAGE.formatted(request.getSize()));
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
