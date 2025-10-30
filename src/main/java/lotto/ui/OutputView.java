package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    private OutputView() {

    }

    public static void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for(int i=0; i<lottos.size(); i++) {
            System.out.println(formatNumbers(lottos.get(i).getNumbers()));
        }
        System.out.println();
    }

    public static void printStatisticsHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printStatistics(Map<LottoRank, Integer> counts) {
        System.out.println("3개 일치 (5,000원) - " + counts.getOrDefault(LottoRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + counts.getOrDefault(LottoRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts.getOrDefault(LottoRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.getOrDefault(LottoRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts.getOrDefault(LottoRank.FIRST, 0) + "개");
    }

    public static void printProfitRate(double ratePercent) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", ratePercent);
    }

    private  static String formatNumbers(List<Integer> numbers) {
        return numbers.toString();
    }
}