package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.ErrorMessageMaker;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessageMaker.getErrorMessage("로또 번호는 6개여야 합니다."));
        }
        if (numbers.stream().anyMatch(n -> MIN_NUMBER > n || n > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessageMaker.getErrorMessage("로또 번호는 1-45사이여야 합니다."));
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessageMaker.getErrorMessage("로또 번호는 중복이 있으면 안됩니다."));
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
