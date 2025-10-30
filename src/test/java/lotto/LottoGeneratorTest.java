package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("단일 로또 생성: 6개, 범위 1~45, 중복 없음, 오름차순")
    @Test
    void generate_one() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generateOne();

        List<Integer> nums = lotto.getNumbers();
        assertThat(nums).hasSize(6);
        assertThat(new HashSet<>(nums)).hasSize(6);
        assertThat(nums).allMatch(n -> 1 <= n && n <= 45);

        for (int i = 1; i < nums.size(); i++) {
            assertThat(nums.get(i)).isGreaterThan(nums.get(i - 1));
        }
    }

    @DisplayName("N장 생성: 요청한 만큼 생성")
    @Test
    void generate_many() {
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generateMany(8);

        assertThat(lottos).hasSize(8);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }
}