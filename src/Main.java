/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 8
 * Date: 2023/03/04
 *
 */
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // File that is in the root of your project
        String filename = "movies.csv";

        try {
            String[][] data = FileToTable.readData(filename);

            // Print the data in a table format with each column having the same width
            FileToTable.printTable(data, 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}