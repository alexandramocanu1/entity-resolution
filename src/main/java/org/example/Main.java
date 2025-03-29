package org.example;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================");

        List<Company> companies = new ArrayList<>();

        String cleanedCsv = "./cleaned_input.csv";
        File cleanedFile = new File(cleanedCsv);


        int totalLines = 0;

        try (BufferedReader countReader = new BufferedReader(new FileReader(cleanedFile))) {
            while (countReader.readLine() != null) totalLines++;
            System.out.println("📊 Total linii în fișier (inclusiv header): " + totalLines);
        } catch (IOException e) {
            System.err.println("Eroare la numărare linii: " + e.getMessage());
        }

        try (Reader reader = new FileReader(cleanedFile)) {
            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(false).build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build();

            String[] values;
            while ((values = csvReader.readNext()) != null) {
                if (values.length != 75) continue;

                try {
                    Company company = new Company(values);
                    if (Utils.isEmpty(company.getCompanyName())) continue;
                    companies.add(company);
                } catch (Exception e) {
                    System.err.println("Eroare companie: " + String.join(",", values));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }


        // test
        for (int i = 0; i < Math.min(5, companies.size()); i++) {
            System.out.println(companies.get(i));
        }

        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 0; i < companies.size(); i++) {
            groupMap.put(i, i);
        }

        System.out.println("scrie in output.csv...");

        try (Writer fileWriter = new OutputStreamWriter(new FileOutputStream("output.csv"), StandardCharsets.UTF_8);
             CSVWriter writer = new CSVWriter(fileWriter)) {

            writer.writeNext(new String[]{"id", "company_name", "group_id", "legal_name", "domain", "email"});

            for (int i = 0; i < companies.size(); i++) {
                Company c = companies.get(i);
                writer.writeNext(new String[]{
                        String.valueOf(i),
                        c.getCompanyName(),
                        String.valueOf(groupMap.getOrDefault(i, -1)),
                        c.getCompanyLegalNames(),
                        c.getWebsiteDomain(),
                        c.getPrimaryEmail()
                });
                System.out.println(" Scris: " + c.getCompanyName());
            }

            System.out.println("Incarcate duplicate!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
