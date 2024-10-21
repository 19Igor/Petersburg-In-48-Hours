package org.example;

import org.example.services.FileReader;
import org.example.services.Reader;
import org.example.services.StringParser;
import org.example.services.StringSplitter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new FileReader();
        List<String> data = reader.readFromFile(Constants.dataFilePath);
        float[] hours      = new float[data.size()];
        float[] priorities = new float[data.size()];

        StringParser parser = new StringSplitter();
        hours      = parser.splitStrings(data);
        priorities = parser.splitStrings(data);

        int ab = 11;

    }


}