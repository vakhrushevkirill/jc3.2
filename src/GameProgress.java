import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public String saveGame(String saveDir, String saveFile){
        try (FileOutputStream fileOutputStream = new FileOutputStream(saveDir + "\\" + saveFile)){
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(this);
                return saveDir + "\\" + saveFile;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return "";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }
}