package kalah.consoleIO;
import com.qualitascorpus.testsupport.IO;
import kalah.IController;
import kalah.model.Player;
import kalah.model.TurnResult;
import kalah.model.IBoard;
public class ConsoleController implements IController {
    private static int QUIT = -1;
    private IBoard _board;
    private IO _io;
    public ConsoleController(IBoard board, IO io) {
        _board = board;
        _io = io;
    }
    @Override
    public TurnResult makeMove(Player player) {
        while (true) {
            int binToSpread = promptMove(player);
            if (binToSpread == QUIT) {
                return TurnResult.END_GAME;
            }
            int binInternalNo = toBoardBinNo(binToSpread, player);
            if (!_board.isBinEmpty(binInternalNo)) {
                return _board.spread(binInternalNo, player);
            } else {
                _io.println(ConsoleStrings.moveAgain);
                return TurnResult.TURN_CONTINUE;
            }
        }
    }
    private int toBoardBinNo(int bin, Player player) {
        if (player == Player.Player2) {
            return bin + _board.getNumBinsAcross() + 1;
        } else {
            return bin;
        }
    }
    private int promptMove(Player player) {
        if (player == Player.Player1) {
            return promptBin(ConsoleStrings.promptPlayer1);
        } else {
            return promptBin(ConsoleStrings.promptPlayer2);
        }
    }
    private int promptBin(String prompt) {
        int maxValidMove = _board.getNumBinsAcross();
        while (true) {
            String input = _io.readFromKeyboard(prompt);
            if (input.equals(ConsoleStrings.inputQuit)) {
                return QUIT;
            }
            try {
                int bin = Integer.parseInt(input);
                if (bin < 1 || bin > maxValidMove) {
                    _io.print(ConsoleStrings.promptValidRange
                        .replace("{max}", ""+maxValidMove));
                } else {
                    return bin;
                }
            } catch (NumberFormatException e) {
                _io.print(ConsoleStrings.promptValidNum);
            }
        }
    }
}
