package com.example.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CommandLineAppRunner implements CommandLineRunner {

    @Autowired
    private OrderFileProcessor orderFileProcessor;

    @Override
    public void run(String[] args) throws Exception {
        orderFileProcessor.process(args);
    }
}
