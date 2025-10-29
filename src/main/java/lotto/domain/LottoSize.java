package lotto.domain;

public class LottoSize {
    static final int BUY_UNIT = 1_000;

    private final Integer size;

    public LottoSize(Integer size) {
        LottoSizeValidator.validate(size);
        this.size = size / BUY_UNIT;
    }

    public Integer getSize() {
        return size;
    }
}
