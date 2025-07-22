package com.mashtura.crawler.core.utils.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashtura.crawler.core.exceptions.ScrapingException;
import com.mashtura.crawler.entity.EntityRecords;

import java.io.File;
import java.io.IOException;

public class ExportToJson {


    private final ObjectMapper objectMapper;

    public ExportToJson() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // pretty print
    }

    public void export(EntityRecords records, String fileName, String OUTPUT_FOLDER) throws ScrapingException {
        try {
            File outputFile = new File(OUTPUT_FOLDER + fileName + ".json");
            objectMapper.writeValue(outputFile, records);
            System.out.println("Data data exported to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new ScrapingException("Failed to export EntityRecords to JSON file", e);
        }
    }

}
