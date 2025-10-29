package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageMakerTest {
    @Test
    @DisplayName("예외메세지는 [ERROR]가 붙어야한다.")
    void test() {
        String expect = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        String message = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        Assertions.assertThat(ErrorMessageMaker.getErrorMessage(message)).isEqualTo(expect);
    }

}