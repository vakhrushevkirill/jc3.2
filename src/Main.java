import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.createWorkDir();
        utils.makeDir();

        GameProgress gm1 = new GameProgress(4, 3, 2, 1);
        GameProgress gm2 = new GameProgress(6, 5, 343, 1.3);
        GameProgress gm3 = new GameProgress(46, 34, 5, 34);
        List<String> saveGamesFile = new ArrayList<String>();
        saveGamesFile.add(gm1.saveGame(utils.getSavegames(), "gm1.save"));
        saveGamesFile.add(gm2.saveGame(utils.getSavegames(), "gm2.save"));
        saveGamesFile.add(gm3.saveGame(utils.getSavegames(), "gm3.save"));


        utils.zipFiles(saveGamesFile);
    }
}
