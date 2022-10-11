package com.example.parser.service;

import com.example.parser.interfaces.IParser;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;

@Service
public class JSONParser implements IParser {

    @Override
    public <T> List<Object> read(File file, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        List<Object> result = new ArrayList<>();
        try {
            MappingIterator<T>  it = mapper.readValues((new JsonFactory()).createJsonParser(file), type);
            while (it.hasNextValue()) {
                result.add(it.nextValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
