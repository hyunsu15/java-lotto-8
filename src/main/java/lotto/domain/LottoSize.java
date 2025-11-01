package lotto.domain;

public class LottoSize {
    static final int BUY_UNIT = 1_000;

    private final Integer size;

    public LottoSize(Integer money) {
        LottoSizeValidator.validate(money);
        this.size = money / BUY_UNIT;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getBuyMoney() {
        return size * BUY_UNIT;
    }
}
