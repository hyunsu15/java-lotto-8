package lotto.domain;

public class LottoSizeValidator {
    private static final String NOT_BUY_UNIT_ERROR_MESSAGE = "처리값은 천원단위여야합니다. 처리값:%d";
    private static final String NOT_POSITIVE_NUMBER_EXCEPTION = "처리된 값은 양수여야합니다. 처리값: %d";

    private static final int CHANGE_MONEY = 0;
    private static final int ZERO = 0;

    private LottoSizeValidator() {
    }

    static void validate(Integer money) {
        if (money % LottoSize.BUY_UNIT != CHANGE_MONEY) {
            throw new IllegalArgumentException(NOT_BUY_UNIT_ERROR_MESSAGE.formatted(money));
        }
        if (money <= ZERO) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION.formatted(money));
        }
    }
}
