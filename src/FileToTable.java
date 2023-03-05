/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 8
 * Date: 2023/03/04
 *
 * Reads from a CSV and outputs it in a table format.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileToTable {
    public static String[][] readData(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String[][] data = new String[0][0];

            // Read the file line by line and store the data in a 2D array
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (data.length == 0) {
                    // If this is the first row, initialize the data array with the correct number of columns
                    data = new String[1][row.length];
                    data[0] = row;
                } else {
                    // If this is not the first row, create a new array with an additional row and copy the old data over
                    String[][] newData = new String[data.length + 1][row.length];
                    System.arraycopy(data, 0, newData, 0, data.length);
                    newData[data.length] = row;
                    data = newData;
                }
            }

            return data;
        }
    }

    public static void printTable(String[][] data, int spacing) {
        // Determine the maximum width of each column, adding spacing to each element to allow for additional spacing
        int[] columnWidths = new int[data[0].length];
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].length() + spacing);
            }
        }

        // Print the data in a table format with each column having the same width
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                // Use printf to print each element with the appropriate padding based on the maximum width of the column
                System.out.printf("%-" + columnWidths[i] + "s", row[i]);
            }
            System.out.println();
        }
    }
}