package mp4maker;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Mp4Maker {

    private ArrayList<String> fileNames = new ArrayList<String>();
    private Scanner sc = new Scanner(System.in);
    File f = null;

    public void creator() {

        System.out.println("Enter names of folders need to be created");
        String folderNameInput = sc.nextLine();

        System.out.println("Enter names for mp4 files, type 0 when finished");
        String fileNameInputer = sc.nextLine();

        // Create new directory
        try {
            Path path = Paths.get("c:/temp/" + folderNameInput);
            Files.createDirectories(path);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add user's input to arraylist
        do {
            fileNames.add(fileNameInputer);
            fileNameInputer = sc.nextLine();
        } while (fileNameInputer.equalsIgnoreCase("0") == false);

        //
        for (int i = 0; i < fileNames.size(); i++) {    
                fileNames.set(i, String.valueOf(i + 1) +"." + fileNames.get(i));
        }

        // Create new empty files to specified path
        for (int i = 0; i < fileNames.size(); i++) {
            try {

                String pathOfDirectory = "c:/temp/" + folderNameInput + "/";
                String mp4File = fileNames.get(i) + ".mp4";
                File f = new File(pathOfDirectory + mp4File);
                if (f.createNewFile()) {
                    System.out.println("File " + mp4File + " created");
                } else {
                    System.out.println("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Mp4Maker mp4Maker = new Mp4Maker();
        mp4Maker.creator();
    }

}
