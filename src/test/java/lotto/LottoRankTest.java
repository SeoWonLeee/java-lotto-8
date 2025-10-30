package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("일치 개수/보너스 여부에 따라 등수를 결정한다.")
    @Test
    void rank_decision() {
        assertThat(LottoRank.from(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.from(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.from(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.from(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.from(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.from(2, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.from(0, false)).isEqualTo(LottoRank.NONE);
    }
}