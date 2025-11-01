package lotto.domain;

public class BonusLottoNumber {
    public static final String ILLEGAL_NUMBER_ERROR_EXCEPTION = "보너스 넘버도 1-45사이여야합니다. 현재값 :%d";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "보너스 볼은 본 로또와 중복될 수 없다.";
    private final int lottoNumber;

    public BonusLottoNumber(int lottoNumber, Lotto lotto) {
        validate(lottoNumber);
        containLottoNumber(lotto, lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void containLottoNumber(Lotto lotto, int lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || lottoNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_ERROR_EXCEPTION.formatted(lottoNumber));
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public boolean contains(Integer number) {
        return lottoNumber == number;
    }
}
