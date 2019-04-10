package com.name.hacaton.zad1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class CsvToJsonConverter {

    File convert(File csvFile) throws IOException {
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile).readAll();

        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File(csvFile + ".json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, readAll);
        return jsonFile;
    }
}
