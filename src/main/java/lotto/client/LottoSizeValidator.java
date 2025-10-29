package lotto.client;

public class LottoSizeValidator {
    private static final int BUY_UNIT = 1_000;

    private LottoSizeValidator() {
    }

    static void validate(Integer request) {
        if (request % BUY_UNIT != 0) {
            throw new IllegalArgumentException("처리값은 천원단위여야합니다. 처리값:%d".formatted(request));
        }
        if (request <= 0) {
            throw new IllegalArgumentException("처리된 값은 양수여야합니다. 처리값: %d".formatted(request));
        }
    }
}
