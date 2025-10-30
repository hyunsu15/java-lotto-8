package lotto.service;

import java.util.Collection;
import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 넘버는 1-45 사이이고 사이즈가 중복없이 6개이다.")
    void test() {
        Collection<Integer> numbers = new HashSet<Integer>(new LottoNumberGenerator().generateNumbers());
        Assertions.assertThat(numbers).hasSize(6);
        Assertions.assertThat(numbers.stream().allMatch(n -> 1 <= n && n <= 45)).isTrue();
    }

}