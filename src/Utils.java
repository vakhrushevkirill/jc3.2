import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Utils {
    public String workerDir = "D:" + File.separator +
            "sources" + File.separator +
            "java" + File.separator +
            "netology" + File.separator +
            "javacore" + File.separator +
            "jc3.2" + File.separator +
            "games" + File.separator;

    private StringBuilder log = new StringBuilder();

//    private String zipSave = savegames.getAbsolutePath() + "\\" + "zipSave.zip";

    public Utils(){

    }

    public Utils(String workerDir){
        this.workerDir = workerDir;
    }

//    public String getSavegames() {
//        return savegames.getAbsolutePath();
//    }

    public void createWorkDir(){
        File worker = new File(workerDir);
        worker.mkdir();
    }

    public String makeDir(String path){
        File pathFile = new File(workerDir + path);
        if (pathFile.mkdir()){
            log.append("Create " + pathFile.getAbsolutePath() + "\n");
        } else {
            log.append("Path exist" + pathFile.getAbsolutePath() + "\n");
        }
        return pathFile.getAbsolutePath();
    }

    public void writeLog(String filePath) {
        File file = new File(workerDir + File.separator + filePath);
        try (FileWriter writer = new FileWriter(file, false)){
            writer.write(log.toString());
            writer.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String zipPath, List<String> saveFiles){

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipPath))) {
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
