package kalah;
import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.consoleIO.BoardConsoleRenderer;
import kalah.consoleIO.ConsoleController;
import kalah.consoleIO.ConsoleRenderer;
import kalah.model.Board;
import kalah.model.GameFinishChecker;
import kalah.model.IBoard;
import kalah.model.KalahSpreadLogic;
public class Kalah {
    public static void main(String[] args) {
        new Kalah().play(new MockIO());
    }
    public void play(IO io) {
        IBoard board = new Board(4, 6, new KalahSpreadLogic());
        GameFinishChecker finishChecker = new GameFinishChecker(board);
        IBoardRenderer boardRenderer = new BoardConsoleRenderer(board, io);
        IRenderer renderer = new ConsoleRenderer(boardRenderer, io, finishChecker);
        IController controller = new ConsoleController(board, io);
        new GameOrchestrator(controller, renderer, finishChecker)
            .start();
    }
}
