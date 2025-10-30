package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> counts = new EnumMap<>(LottoRank.class);
    private long totalPrize = 0;

    public void record(LottoRank rank) {
        counts.put(rank, counts.getOrDefault(rank, 0) + 1);
        totalPrize += rank.getPrize();
    }

    public Map<LottoRank, Integer> getCounts() {
        return new EnumMap<>(counts);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double profitRate(long purchaseAmount) {
        if (purchaseAmount == 0) return 0.0;
        return (totalPrize * 100.0) / purchaseAmount;
    }
}