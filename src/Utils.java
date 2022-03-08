import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Utils {
    public String workerDir = "D:\\sources\\java\\netology\\javacore\\jc3.2\\games\\";
    private StringBuilder log = new StringBuilder();
    private File src = new File(workerDir + "src");
    private File res = new File(workerDir + "res");
    private File resDrawables = new File(res.getAbsolutePath() + "\\" + "drawables");
    private File resVectors = new File(res.getAbsolutePath() + "\\" + "vectors");
    private File resIcons = new File(res.getAbsolutePath() + "\\" + "icons");
    private File savegames = new File(workerDir + "savegames");
    private File temp = new File(workerDir + "temp");
    private File tempTxt = new File(temp.getAbsolutePath() + "\\temp.txt");
    private String zipSave = savegames.getAbsolutePath() + "\\" + "zipSave.zip";

    public Utils(){

    }

    public String getSavegames() {
        return savegames.getAbsolutePath();
    }

    public void createWorkDir(){
        File worker = new File(workerDir);
        worker.mkdir();
    }

    public void makeDir(){
        if (src.mkdir()){
            log.append("Create " + src.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
        if (res.mkdir()){
            log.append("Create " + res.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
        if (savegames.mkdir()){
            log.append("Create " + savegames.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
        if (temp.mkdir()){
            log.append("Create " + temp.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
        if (resDrawables.mkdir()){
            log.append("Create " + resDrawables.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
        if (resVectors.mkdir()){
            log.append("Create " + resVectors.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
        if (resIcons.mkdir()){
            log.append("Create " + resIcons.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + "\n");
        }
    }

    public void writeLog() {
        try (FileWriter writer = new FileWriter(tempTxt, false)){
            writer.write(log.toString());
            writer.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(List<String> saveFiles){

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipSave))) {
            for (String saveFile:
                    saveFiles) {
                File sFile = new File(saveFile);
                try (FileInputStream fis = new FileInputStream(saveFile)) {
                    ZipEntry zipEntry = new ZipEntry(sFile.getName());
                    zout.putNextEntry(zipEntry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);

                }
                sFile.delete();
            }
            zout.closeEntry();
        } catch (Exception ex){

        }

    }
}
