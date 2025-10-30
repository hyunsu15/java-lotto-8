package lotto.domain;

import java.util.List;

public interface LottoMatcher {
    default int matchLottoNumber(Lotto lotto) {
        return (int) getNumbers().stream()
                .filter(lotto::contains)
                .count();
    }

    default int matchBonusNumber(BonusLottoNumber bonusLottoNumber) {
        return (int) getNumbers().stream()
                .filter(bonusLottoNumber::contains)
                .count();
    }

    List<Integer> getNumbers();
}
