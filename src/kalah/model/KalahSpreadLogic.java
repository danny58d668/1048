package kalah.model;
public class KalahSpreadLogic implements ISpreadLogic {
    @Override
    public TurnResult Spread(IBoard board, int fromBin, Player player) {
        int numSeeds = board.getBin(fromBin).getAndClearSeeds();
        int toBin = fromBin;
        while (numSeeds > 0) {
            toBin = (toBin + 1) % board.getNumBinsTotal();
            if (canSeed(board, toBin, player)) {
                board.getBin(toBin).addSeeds(1);
                numSeeds--;
            }
        }
        if (toBin == board.getOwnStoreNo(player)) {
            return TurnResult.TURN_CONTINUE;
        }
        if (board.isOwnBinNotStore(toBin, player)
                && board.getBin(toBin).getSeeds() == 1
                && board.getBin(board.getOppositeBinNo(toBin)).getSeeds() > 0) {
            int totalSeeds =
                    board.getBin(toBin).getAndClearSeeds() +
                    board.getBin(board.getOppositeBinNo(toBin)).getAndClearSeeds();
            board.getBin(board.getOwnStoreNo(player)).addSeeds(totalSeeds);
        }
        return TurnResult.TURN_FINISH;
    }
    private boolean canSeed(IBoard board, int bin, Player player) {
        if (player == Player.Player1) {
            return bin != board.getOwnStoreNo(Player.Player2);
        } else {
            return bin != board.getOwnStoreNo(Player.Player1);
        }
    }
}
