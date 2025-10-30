package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    ONE(6, 0, 2_000_000_000),
    TWO(5, 1, 30_000_000),
    THREE(5, 0, 1_500_000),
    FOUR(4, 0, 50_000),
    FIVE(3, 0, 5_000),
    GAME_OUT(Integer.MIN_VALUE, Integer.MIN_VALUE, 0);
    private int matchLottoNumber;
    private int matchBonusLottoNumber;
    private int reward;

    LottoRank(int matchLottoNumber, int matchBonusLottoNumber, int reward) {
        this.matchLottoNumber = matchLottoNumber;
        this.matchBonusLottoNumber = matchBonusLottoNumber;
        this.reward = reward;
    }

    public static LottoRank matchLotto(Lotto lotto, Lotto answerLotto, BonusLottoNumber bonusLottoNumber) {
        int matchLottoCount = lotto.matchLottoNumber(answerLotto);
        int matchBonusNumberCount = lotto.matchBonusNumber(bonusLottoNumber);

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchLottoNumber() == matchLottoCount
                        && lottoRank.getMatchBonusLottoNumber() == matchBonusNumberCount)
                .findFirst()
                .orElse(GAME_OUT);
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }

    public int getMatchBonusLottoNumber() {
        return matchBonusLottoNumber;
    }

    public int getReward() {
        return reward;
    }
}
