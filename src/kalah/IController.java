package kalah;
import kalah.model.Player;
import kalah.model.TurnResult;
public interface IController {
    TurnResult makeMove(Player player);
}
