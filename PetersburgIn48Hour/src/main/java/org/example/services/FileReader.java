package org.example.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader{
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new java.io.FileReader(filePath));
            String line = reader.readLine();
            while (line != null){
                data.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
