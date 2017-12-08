import java.io.FileReader;
import java.util.Scanner;

public class RaceTextReader {

    public static String readFile(String filename) {
        FileReader file;
        Scanner fileInput;
        StringBuilder text = new StringBuilder();

        try {
            file = new FileReader(filename);
            fileInput = new Scanner(file);

            while (fileInput.hasNext()) {
                text.append(fileInput.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return text.toString();
    }
}
