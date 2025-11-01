package lotto.client;

import java.util.Map;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.LottoRank;
import lotto.domain.LottoSize;

public class CalculateEarningTask implements TaskRunnable {
    private static final String RESULT_PREFIX_MESSAGE = "총 수익률은 ";
    private static final String RESULT_POST_FIX_MESSAGE = "%입니다.";
    private static final String ROUND_FORMAT = "%.1f";
    private static final int DEFAULT_PERCENTAGE = 100;
    private static final int PERCENTAGE = 100;
    private final ApplicationContext applicationContext;

    public CalculateEarningTask(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run() {
        LottoSize lottoSize = applicationContext.getBean(ApplicationContextKey.LOTTO_SIZE, LottoSize.class);
        double earning = calculate(lottoSize.getBuyMoney(), calculateResult());
        System.out.println(getResultMessage(earning));
    }

    private String getResultMessage(double earning) {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_PREFIX_MESSAGE);
        sb.append(String.format(ROUND_FORMAT, earning));
        sb.append(RESULT_POST_FIX_MESSAGE);
        return sb.toString();
    }

    private double calculate(Integer before, Integer after) {
        return DEFAULT_PERCENTAGE + ((double) after - before) / before * PERCENTAGE;
    }

    private Integer calculateResult() {
        Map<LottoRank, Integer> history = applicationContext.getBean(ApplicationContextKey.LOTTO_RESULT, Map.class);
        int result = 0;
        for (Map.Entry<LottoRank, Integer> entry : history.entrySet()) {
            result += entry.getKey().getReward() * entry.getValue();
        }
        return result;
    }
}
