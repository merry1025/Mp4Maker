package mp4maker;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * This app can create empty mp4 files from a list of file names provided by user.
 * @author Adam
 */

public class Mp4Maker {

    private ArrayList<String> names = new ArrayList<String>();
    private Scanner sc = new Scanner(System.in);
    File f = null;

    public void getNames() {

        System.out.println("Enter names for mp4 files, type 0 when finished");
        String userInput = sc.nextLine();

        // Add user's input to arraylist
        do {
            names.add(userInput);
            userInput = sc.nextLine();
        } while (userInput.equalsIgnoreCase("0") == false);

        // Create new empty files to specified path
        for (int i = 0; i < names.size(); i++) {
            try {
                String path = "c:/temp/";
                File f = new File(path + names.get(i) + ".mp4");
                if (f.createNewFile()) {
                    System.out.println("File created");
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
        mp4Maker.getNames();
    }

}
