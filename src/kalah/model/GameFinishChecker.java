package kalah.model;
public class GameFinishChecker {
    private IBoard _board;
    public GameFinishChecker(IBoard board) {
        _board = board;
    }
    public int getPlayerWinnings(Player player) {
        int offset = 1;
        if (player == Player.Player2) {
            offset = _board.getNumBinsAcross() + 2;
        }
        int count = 0;
        for (int i = offset; i <= offset + _board.getNumBinsAcross(); i++) {
            count += _board.getBin(i).getSeeds();
        }
        return count;
    }
    public boolean isGameOver(Player player) {
        int sideOffset = player == Player.Player1 ? 1 : _board.getNumBinsAcross() + 2;
        boolean sideEmpty = true;
        for (int i = sideOffset; i < _board.getNumBinsAcross() + sideOffset; i++) {
            if (_board.getBin(i).getSeeds() > 0) {
                sideEmpty = false;
            }
        }
        return sideEmpty;
    }
}
