package lotto.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 넘버는 1-45 사이이고 사이즈가 6이다.")
    void test() {
        List<Integer> numbers = new LottoNumberGenerator().generateNumbers();
        Assertions.assertThat(numbers).hasSize(6);
        Assertions.assertThat(numbers.stream().allMatch(n -> 1 <= n && n <= 45)).isTrue();

    }

}