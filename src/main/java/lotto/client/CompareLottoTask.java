package lotto.client;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.ApplicationContext;
import lotto.ApplicationContextKey;
import lotto.domain.BonusLottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class CompareLottoTask implements ResponseTask<Map<LottoRank, Integer>> {
    private static final int HISTORY_DEFAULT_VALUE = 0;
    private static final int HISTORY_ADD_VALUE = 1;
    private final ApplicationContext context;

    public CompareLottoTask(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void printResponse(Map<LottoRank, Integer> response) {
        response.keySet().stream()
                .sorted(Comparator.comparing(LottoRank::getReward))
                .forEach(
                        rank -> System.out.println(CompareLottoMessage.getMessage(rank, response))
                );
    }

    @Override
    public Map<LottoRank, Integer> mappingResponse() {
        Lotto answerLotto = context.getBean(ApplicationContextKey.ANSWER_LOTTO, Lotto.class);
        BonusLottoNumber bonusLottoNumber = context.getBean(ApplicationContextKey.ANSWER_BONUS_LOTTO_NUMBER,
                BonusLottoNumber.class);
        List<Lotto> lottos = context.getBean(ApplicationContextKey.LOTTOS, List.class);
        Map<LottoRank, Integer> history = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> history.put(lottoRank, HISTORY_DEFAULT_VALUE));
        for (Lotto lotto : lottos) {
            LottoRank result = LottoRank.matchLotto(lotto, answerLotto, bonusLottoNumber);
            history.merge(result, HISTORY_ADD_VALUE, Integer::sum);
        }
        history.remove(LottoRank.GAME_OUT);
        return history;
    }

    @Override
    public void addBean(Map<LottoRank, Integer> response) {
        context.addBean(ApplicationContextKey.LOTTO_RESULT, response);
    }

}
