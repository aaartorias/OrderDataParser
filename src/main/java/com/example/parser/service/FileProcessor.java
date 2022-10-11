package com.example.parser.service;

import com.example.parser.model.FileType;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileProcessor {
    private final char FILE_EXTENSION_DELIMITER = '.';

    public FileType getFileType(File file) {
        String fileName = file.getName();
        int indexOfExtensionStart = 1 + fileName.lastIndexOf(FILE_EXTENSION_DELIMITER);
        String extension = fileName.substring(indexOfExtensionStart);
        return getFileType(extension);
    }

    public FileType getFileType(String extension) {
        for (FileType fileType : FileType.values()) {
            if (fileType.getExtension().equals(extension)) {
                return fileType;
            }
        }

        throw new RuntimeException("Illegal File extension. File with extension " + extension + " is not supported");
    }

}
