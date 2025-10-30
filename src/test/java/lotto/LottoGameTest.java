package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;
import lotto.service.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("구매 로또와 당첨 번호 비교 → 등수 집계")
    @Test
    void evaluate_result_counts() {
        LottoGame game = new LottoGame();

        List<Lotto> bought = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12))
        );

        LottoWinningNumbers winning = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResult result = game.evaluate(bought, winning);

        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("총 당첨금과 수익률 계산")
    @Test
    void profit_rate() {
        LottoGame game = new LottoGame();

        LottoResult result = new LottoResult(Map.of(
                LottoRank.FIFTH, 1
        ));

        assertThat(result.totalPrize()).isEqualTo(5_000L);

        long purchaseAmount = 8_000;
        double rate = game.calculateProfitRate(result, purchaseAmount);

        assertThat(rate).isEqualTo(62.5);
    }
}