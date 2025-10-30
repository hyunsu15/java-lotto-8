package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @Test
    @DisplayName("로또번호는 중복되면 안된다")
    void test1() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 4, 2, 3, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7"
    }, delimiter = '+')
    @DisplayName("로또번호는 6개가 아니면 안된다.")
    void test2(String value) {
        List<Integer> input = Arrays.stream(value.split(",")).map(Integer::parseInt).toList();
        Assertions.assertThatThrownBy(() -> new Lotto(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,46",
            "0,2,3,4,5,6"
    }, delimiter = '+')
    @DisplayName("로또번호는 1-45사이가 아니면 안된다.")
    void test3(String value) {
        List<Integer> input = Arrays.stream(value.split(",")).map(Integer::parseInt).toList();
        Assertions.assertThatThrownBy(() -> new Lotto(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,45"
    }, delimiter = '+')
    @DisplayName("나머지 경우는 로또가 된다.")
    void test4(String value) {
        List<Integer> input = Arrays.stream(value.split(",")).map(Integer::parseInt).toList();
        Assertions.assertThatCode(() -> new Lotto(input)).doesNotThrowAnyException();
    }
}