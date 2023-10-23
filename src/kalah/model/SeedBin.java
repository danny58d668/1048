package kalah.model;
public class SeedBin {
    private int _seeds;
    public SeedBin(int startingSeedsQuantity) {
        _seeds = startingSeedsQuantity;
    }
    public int getSeeds() {
        return _seeds;
    }
    public void addSeeds(int quantity) {
        _seeds += quantity;
    }
    public int getAndClearSeeds() {
        int seeds = _seeds;
        _seeds = 0;
        return seeds;
    }
}
