package kalah.model;
public class Board implements IBoard {
    private int _numBinsTotal;
    private SeedBin[] _seedBins;
    private ISpreadLogic _spreadLogic;
    public Board(int startingSeedQuantity, int numBinsAcross, ISpreadLogic spreadLogic) {
        _numBinsTotal = 2 * (numBinsAcross + 1);
        _spreadLogic = spreadLogic;
        _seedBins = new SeedBin[_numBinsTotal];
        for (int bin = 0; bin < _numBinsTotal; bin++) {
            if (bin % (_numBinsTotal / 2) == 0) {
                _seedBins[bin] = new SeedBin(0);
            } else {
                _seedBins[bin] = new SeedBin(startingSeedQuantity);
            }
        }
    }
    public SeedBin getBin(int no) {
        return _seedBins[no % _numBinsTotal];
    }
    public int getNumBinsAcross() {
        return (_numBinsTotal / 2) - 1;
    }
    public int getNumBinsTotal() {
        return _numBinsTotal;
    }
    public boolean isBinEmpty(int bin) {
        return _seedBins[bin].getSeeds() == 0;
    }
    public TurnResult spread(int fromBin, Player player) {
        return _spreadLogic.Spread(this, fromBin, player);
    }
    public int getOwnStoreNo(Player player) {
        if (player == Player.Player1) {
            return _numBinsTotal /2;
        } else {
            return 0;
        }
    }
    public boolean isOwnBinNotStore(int bin, Player player) {
        if (player == Player.Player1) {
            return bin > 0 && bin < _numBinsTotal /2;
        } else {
            return bin > _numBinsTotal /2;
        }
    }
    public int getOppositeBinNo(int bin) {
        if (bin > _numBinsTotal /2) {
            return _numBinsTotal - bin;
        } else {
            return _numBinsTotal - bin;
        }
    }
}
