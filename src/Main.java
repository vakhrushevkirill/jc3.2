import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.createWorkDir();
        String saveGames = utils.makeDir("savegames");

        GameProgress gm1 = new GameProgress(4, 3, 2, 1);
        GameProgress gm2 = new GameProgress(6, 5, 343, 1.3);
        GameProgress gm3 = new GameProgress(46, 34, 5, 34);
        List<String> saveGamesFile = new ArrayList<String>();
        saveGamesFile.add(gm1.saveGame(saveGames, "gm1.save"));
        saveGamesFile.add(gm2.saveGame(saveGames, "gm2.save"));
        saveGamesFile.add(gm3.saveGame(saveGames, "gm3.save"));


        utils.zipFiles(saveGames + File.separator + "zipSave.zip", saveGamesFile);
    }
}
