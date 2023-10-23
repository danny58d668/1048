package kalah;
import kalah.model.GameFinishChecker;
import kalah.model.Player;
import kalah.model.TurnResult;
public class GameOrchestrator {
    private GameFinishChecker _finishChecker;
    private IController _controller;
    private IRenderer _renderer;
    private Player _nextTurn;
    public GameOrchestrator(IController controller, IRenderer boardRenderer, GameFinishChecker finishChecker) {
        _controller = controller;
        _renderer = boardRenderer;
        _finishChecker = finishChecker;
        _nextTurn = Player.Player1;
    }
    public void start() {
        while (true) {
            _renderer.render();
            if (_finishChecker.isGameOver(_nextTurn)) {
                _renderer.renderGameOver();
                return;
            }
            TurnResult result = _controller.makeMove(_nextTurn);
            switch (result) {
                case END_GAME:
                    _renderer.renderGameQuit();
                    return;
                case TURN_FINISH:
                    _nextTurn = _nextTurn == Player.Player1 ? Player.Player2 : Player.Player1;
                break;
                case TURN_CONTINUE:
                break;
            }
        }
    }
}
