package com.example.parser.service;

import com.example.parser.interfaces.IParser;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CSVParser implements IParser {
    private static final CsvMapper mapper = new CsvMapper();

    @Override
    public <T> List<Object> read(File file, Class<T> type) {
        CsvSchema schema = mapper.schemaFor(type);
        ObjectReader reader = mapper.readerFor(type).with(schema);
        try {
            return reader.readValues(file).readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
