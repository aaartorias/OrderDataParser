package com.example.parser.interfaces;

import java.io.File;

public interface IParser {
    <T> Object read(File file, Class<T> type);
}
