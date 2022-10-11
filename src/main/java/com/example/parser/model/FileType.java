package com.example.parser.model;

public enum FileType {
    CSV("csv"),
    JSON("json");

    private final String extension;

    private FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}
