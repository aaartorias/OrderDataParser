package com.example.parser.service;

import com.example.parser.model.FileType;
import com.example.parser.model.OrderData;
import com.example.parser.repository.OrderDataRepository;
import com.example.parser.factory.ParserFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderFileProcessor {

    @Autowired
    private ParserFactory parserFactory;

    @Autowired
    private FileProcessor fileProcessor;

    @Autowired
    private OrderDataRepository orderDataRepository;

    public void process(String[] fileNames) {
        for (String fileName : fileNames) {
            File file = new File(fileName);
            FileType fileType = fileProcessor.getFileType(file);
             List<OrderData> orderData = (List<OrderData>) parserFactory.getParser(fileType).read(file, OrderData.class);
            final int[] lineNo = {1}; // Hack
            orderData.forEach(o -> {
                o.setFileName(fileName);
                o.setResult("OK");
                o.setLine(lineNo[0]);
                orderDataRepository.add(o);
                lineNo[0] = lineNo[0] + 1;
            });
//                    orderDataRepository.add(o.setFileName(fileName))); //orderDataRepository.add(orderData);
        }
        printAllOrderData();
    }

    public void printAllOrderData() {
        for (Integer id : orderDataRepository.getAllIds()) {
            OrderData orderData = orderDataRepository.get(id);
            System.out.println("id : " + id + ", " + orderData);
        }
    }

}
