package lotto;

import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumbersTest {

    @DisplayName("당첨 번호는 정확히 6개여야 한다")
    @Test
    void winning_size_must_be_6() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void winning_numbers_unique() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 1, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨/보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void winning_numbers_in_range() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonus_must_not_duplicate_with_winning() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}