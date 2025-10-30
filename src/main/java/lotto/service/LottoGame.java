package lotto.service;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;

public class LottoGame {
    public static final int PRICE_PER_TICKET = 1000;

    public List<Lotto> purchase(int purchaseAmount, LottoGenerator generator) {
        return Collections.emptyList();
    }

    public LottoResult judge(List<Lotto> tickets, LottoWinningNumbers winningNumbers) {
        return null;
    }
}