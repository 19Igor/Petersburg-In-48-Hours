package org.example.services;

import java.util.List;

public class StringSplitter implements StringParser{

    @Override
    public float[] splitStrings(List<String> data) {
        for (String line : data){
            String[] strings = line.split(" ");

        }

        return null;
    }
}
