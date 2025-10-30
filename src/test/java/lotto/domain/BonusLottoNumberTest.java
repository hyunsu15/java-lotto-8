package lotto.domain;

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
        Assertions.assertThatCode(() -> new BonusLottoNumber(lottoNumber)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "-1"
            , "0"
            , "46"
    })
    @DisplayName("로또 넘버가 1-45가 아니면 예외를 반환한다.")
    void bonusLottoNumberTest1(int lottoNumber) {
        Assertions.assertThatThrownBy(() -> new BonusLottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}