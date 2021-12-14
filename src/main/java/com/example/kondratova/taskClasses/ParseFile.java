package com.example.kondratova.taskClasses;

import com.example.kondratova.CountryRepo;
import com.example.kondratova.models.CountryModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ParseFile {

    private static CountryRepo countryRepo;

    public ParseFile(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public static void parseCSVFile(String pathFile) throws IOException, CsvException {
        var read = new CSVReader(new FileReader(pathFile));
        var lines = read.readAll();

        Long id = 1l;
        for (var line:lines.subList(1, lines.size())) {

            countryRepo.save(new CountryModel(
                    id,
                    line[0],
                    line[1],
                    Integer.parseInt(line[2]),
                    Float.parseFloat(line[3]),
                    Float.parseFloat(line[4]),
                    Float.parseFloat(line[5]),
                    Float.parseFloat(line[6]),
                    Float.parseFloat(line[7]),
                    Float.parseFloat(line[8]),
                    Float.parseFloat(line[9]),
                    Float.parseFloat(line[10]),
                    Float.parseFloat(line[11]),
                    Float.parseFloat(line[12])
                )
            );
            id++;
        }
    }
}
