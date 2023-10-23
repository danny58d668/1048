package kalah.model;
public interface IBoard {
    SeedBin getBin(int no);
    TurnResult spread(int fromBin, Player player);
    boolean isBinEmpty(int bin);
    int getNumBinsAcross();
    int getNumBinsTotal();
    int getOwnStoreNo(Player player2);
    int getOppositeBinNo(int bin);
    boolean isOwnBinNotStore(int bin, Player player);
}
