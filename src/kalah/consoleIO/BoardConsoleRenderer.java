package kalah.consoleIO;
import com.qualitascorpus.testsupport.IO;
import kalah.IBoardRenderer;
import kalah.model.SeedBin;
import kalah.model.IBoard;
public class BoardConsoleRenderer implements IBoardRenderer {
    private IBoard _board;
    private IO _io;
    public BoardConsoleRenderer(IBoard board, IO io) {
        _board = board;
        _io = io;
    }
    public void render() {
        int numAcross = _board.getNumBinsAcross();
        drawBorderLn(numAcross);
        _io.print(ConsoleStrings.storePlayer2);
        drawBins(numAcross + 2, numAcross * 2 + 2, true);
        _io.println(
            ConsoleStrings.storePlayer1Seeds
                .replace("{seeds}", getBinString(_board.getBin(numAcross + 1)))
            );
        drawDividerLn(numAcross);
        _io.print(
            ConsoleStrings.storePlayer2Seeds
                .replace("{seeds}", getBinString(_board.getBin(0)))
            );
        drawBins(1, numAcross + 1, false);
        _io.println(ConsoleStrings.storePlayer1);
        drawBorderLn(numAcross);
    }
    private void drawBorderLn(int numBinsAcross) {
        _io.print(ConsoleStrings.borderStart);
        for (int i = 0; i < numBinsAcross; i++) {
            _io.print(ConsoleStrings.borderPiece);
        }
        _io.println(ConsoleStrings.borderEnd);
    }
    private void drawDividerLn(int numBinsAcross) {
        _io.print(ConsoleStrings.storePlayer2Middle);
        for (int i = 0; i < numBinsAcross - 1; i++) {
            _io.print(ConsoleStrings.borderPiece);
        }
        _io.print(ConsoleStrings.borderPieceNoConnector);
        _io.println(ConsoleStrings.storePlayer1Middle);
    }
    private void drawBins(int from, int to, boolean drawBackwards) {
        int numBins = to - from;
        for (int i = 0; i < numBins; i++) {
            int binDisplayNo = drawBackwards ? numBins - i : i + 1;
            int binInternalNo = drawBackwards ? to - i - 1 : from + i;
            _io.print(
                ConsoleStrings.bin
                    .replace("{bin}", ""+binDisplayNo)
                    .replace("{seeds}", getBinString(_board.getBin(binInternalNo)))
                );
        }
    }
    private String getBinString(SeedBin bin) {
        if (bin.getSeeds() < 10) {
            return " " + bin.getSeeds();
        } else {
            return "" + bin.getSeeds();
        }
    }
}
