package lotto.domain;

public class BonusLottoNumber {
    public static final String ILLEGAL_NUMBER_ERROR_EXCEPTION = "보너스 넘버도 1-45사이여야합니다. 현재값 :%d";
    private final int lottoNumber;

    public BonusLottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || lottoNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_ERROR_EXCEPTION.formatted(lottoNumber));
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
