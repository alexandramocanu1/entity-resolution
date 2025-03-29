package org.example;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class CsvCleaner {

    private static final int EXPECTED_COLUMNS = 75;

    public static void cleanCsv(String inputFilePath, String outputFilePath) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))
        ) {
            int valid = 0, invalid = 0;

            String headerLine = reader.readLine();
            if (headerLine != null) {
                writer.writeNext(new CSVReader(new StringReader(headerLine)).readNext());
            }

            StringBuilder currentLine = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                currentLine.append(line).append("\n");

                try {
                    CSVReader tempReader = new CSVReader(new StringReader(currentLine.toString()));
                    String[] row = tempReader.readNext();

                    if (row != null && row.length == EXPECTED_COLUMNS && !Utils.isEmpty(row[0])) {
                        writer.writeNext(row);
                        valid++;
                        currentLine.setLength(0);
                    }
                } catch (Exception e) {
                    //
                }
            }

            System.out.println("Gata, sunt: " + valid + " valide");
            if (valid == 0) {
                System.err.println("Nu s linii valide! Vf input.csv!");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
