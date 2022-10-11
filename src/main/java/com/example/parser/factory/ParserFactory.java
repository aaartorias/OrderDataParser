package com.example.parser.factory;

import com.example.parser.interfaces.IParser;
import com.example.parser.model.FileType;
import com.example.parser.service.CSVParser;
import com.example.parser.service.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParserFactory {
    @Autowired
    private CSVParser csvParser;
    @Autowired
    private JSONParser jsonParser;

    public IParser getParser(FileType fileType) {
        switch(fileType) {
            case JSON:
                return jsonParser;
            case CSV:
                return csvParser;
        }
        throw new RuntimeException("File type " + fileType + " not supported");
    }

}
