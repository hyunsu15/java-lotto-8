package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusLottoNumberTest {
    @ParameterizedTest
    @CsvSource({
            "1"
            , "10"
            , "44"
            , "45"
    })
    @DisplayName("로또 넘버가 1-45사이면 생성된다.")
    void bonusLottoNumberTest(int lottoNumber) {
        Assertions.assertThatCode(() -> new BonusLottoNumber(lottoNumber, new Lotto(List.of(12, 11, 22, 33, 34, 35))))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "-1"
            , "0"
            , "46"
    })
    @DisplayName("로또 넘버가 1-45가 아니면 예외를 반환한다.")
    void bonusLottoNumberTest1(int lottoNumber) {
        Assertions.assertThatThrownBy(
                        () -> new BonusLottoNumber(lottoNumber, new Lotto(List.of(10, 11, 22, 33, 34, 35))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "10"
            , "11"
            , "22"
            , "33"
            , "34"
            , "35"
    })
    @DisplayName("로또 넘버가 기존로또와 겹치면 예외를 반환한다.")
    void bonusLottoNumberTest2(int lottoNumber) {
        Assertions.assertThatThrownBy(
                        () -> new BonusLottoNumber(lottoNumber, new Lotto(List.of(10, 11, 22, 33, 34, 35))))
                .isInstanceOf(IllegalArgumentException.class);
    }


}