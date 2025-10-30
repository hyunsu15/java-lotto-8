package lotto.domain;

import java.util.List;

public class LottoValidator {
    private static final String NOT_SIX_SIZE_ERROR_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String ILLEGAL_NUMBER_ERROR_MESSAGE = "로또 번호는 1-45사이여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "로또 번호는 중복이 있으면 안됩니다.";


    private LottoValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(NOT_SIX_SIZE_ERROR_MESSAGE);
        }
        if (numbers.stream().anyMatch(n -> Lotto.MIN_NUMBER > n || n > Lotto.MAX_NUMBER)) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_ERROR_MESSAGE);
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }
}
