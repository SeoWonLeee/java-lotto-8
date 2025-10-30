package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumbers {
    private final Set<Integer> numbers;
    private final int bonusNumber;

    public LottoWinningNumbers(Set<Integer> numbers, int bonusNumber) {
        this.numbers = new HashSet<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        int cnt = 0;
        List<Integer> pick = lotto.getNumbers();
        for (int i = 0; i < pick.size(); i++) {
            if (numbers.contains(pick.get(i))) cnt++;
        }
        return cnt;
    }

    public boolean isBonusMatch(Lotto lotto) {
        List<Integer> pick = lotto.getNumbers();
        for (int i = 0; i < pick.size(); i++) {
            if (pick.get(i) == bonusNumber) return true;
        }
        return false;
    }

    public Set<Integer> getNumbers() {
        return new HashSet<>(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}