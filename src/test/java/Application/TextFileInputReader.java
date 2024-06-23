package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileInputReader {
    public Object[] readParamsFromFile(String fileName) {
        ArrayList<Object[]> linesRead = new ArrayList<>();
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        while (inputStream.hasNextLine()) {
            String singleLine = inputStream.nextLine();
            String[] tokens = singleLine.split(" ");
            int vip = Integer.parseInt(tokens[0]);
            int deluxe = Integer.parseInt(tokens[1]);
            int standard = Integer.parseInt(tokens[2]);
            int expectedVIP = Integer.parseInt(tokens[3]);
            int expectedDeluxe = Integer.parseInt(tokens[4]);
            int expectedStandard = Integer.parseInt(tokens[5]);
            linesRead.add(new Object[]{vip, deluxe, standard, expectedVIP, expectedDeluxe, expectedStandard});
        }
        inputStream.close();
        return linesRead.toArray();
    }
}

