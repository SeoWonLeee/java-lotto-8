package lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.service.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.run();
    }
}
