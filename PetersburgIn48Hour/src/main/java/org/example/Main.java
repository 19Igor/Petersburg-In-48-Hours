package org.example;

import org.example.services.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new FileReader();
        List<String> data  = reader.readFromFile(Constants.DATA_FILE_PATH);
        float[] hours      = new float[data.size()];
        float[] priorities = new float[data.size()];

        DataHandler parser = new StringHandler();
        // Мне нужно заполнить массивы hours и priorities
        hours      = parser.getVisingAttributes(data, Constants.HOUR_SHIFT);
        priorities = parser.getVisingAttributes(data, Constants.PRIORITY_SHIFT);

        int ab = 11;

    }


}