package kalah.consoleIO;
import com.qualitascorpus.testsupport.IO;
import kalah.model.GameFinishChecker;
import kalah.IBoardRenderer;
import kalah.IRenderer;
import kalah.model.Player;
public class ConsoleRenderer implements IRenderer {
    private IBoardRenderer _boardRenderer;
    private IO _io;
    private GameFinishChecker _finishChecker;
    public ConsoleRenderer(IBoardRenderer boardRenderer, IO io, GameFinishChecker finishChecker) {
        _boardRenderer = boardRenderer;
        _io = io;
        _finishChecker = finishChecker;
    }
    public void render() {
        _boardRenderer.render();
    }
    public void renderGameOver() {;
        _io.println(ConsoleStrings.gameOver);
        _boardRenderer.render();
        int p1Score = _finishChecker.getPlayerWinnings(Player.Player1);
        int p2Score = _finishChecker.getPlayerWinnings(Player.Player2);
        _io.println(
            ConsoleStrings.player1Score
                .replace("{score}", ""+p1Score)
            );
        _io.println(
            ConsoleStrings.player2Score
                .replace("{score}", ""+p2Score)
            );
        if (p1Score == p2Score) {
            _io.println(ConsoleStrings.tie);
        } else if (p1Score > p2Score) {
            _io.println(ConsoleStrings.player1Wins);
        } else {
            _io.println(ConsoleStrings.player2Wins);
        }
    }
    public void renderGameQuit() {
        _io.println(ConsoleStrings.gameOver);
        _boardRenderer.render();
    }
}
