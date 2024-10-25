package org.example.services;

import org.example.Constants;

import java.util.List;

public class AttributeExtractor implements DataHandler{

    @Override
    public float[] getVisitingAttributes(List<String> list, int shift) {
        float[] res = new float[list.size()];
        for (int i = 0; i < list.size(); i++){
            String[] c = list.get(i).split(Constants.SPLITTER);
            res[i] = Float.parseFloat((c[c.length - shift]));
        }
        return res;
    }
}
