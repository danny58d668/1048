package kalah;
import kalah.model.SeedBin;
public class Util {
    public static SeedBin[] reverseBins(SeedBin[] input) {
        SeedBin[] output = new SeedBin[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[input.length - i - 1];
        }
        return output;
    }
}
