package lotto.client;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.LottoRank;

public class CompareLottoMessage {
    private static final String OUTPUT_MESSAGE = "%s - %d개";
    private static final String PREFIX_LOTTO_NUMBER_SIZE = "개 일치";
    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String MONEY_MESSAGE_FORMAT = " (%s원)";
    private static final int NUMBER_INDEX = 1;

    private CompareLottoMessage() {
    }

    static String getMessage(LottoRank lottoRank, Map<LottoRank, Integer> history) {
        return OUTPUT_MESSAGE.formatted(getPrefixResponse(lottoRank), history.get(lottoRank));
    }

    private static String getPrefixResponse(LottoRank lottoRank) {
        StringBuilder sb = new StringBuilder();

        sb.append(lottoRank.getMatchLottoNumber());
        sb.append(PREFIX_LOTTO_NUMBER_SIZE);
        if (lottoRank.getMatchBonusLottoNumber() != 0) {
            sb.append(BONUS_BALL_MESSAGE);
        }
        sb.append(MONEY_MESSAGE_FORMAT.formatted(getMoneyMessage(lottoRank)));
        return sb.toString();
    }

    private static String getMoneyMessage(LottoRank lottoRank) {
        return NumberFormat.getCurrencyInstance(Locale.KOREA).format(lottoRank.getReward()).substring(NUMBER_INDEX);
    }
}
