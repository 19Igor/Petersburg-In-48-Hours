package org.example.services;

import java.util.List;

public interface Reader {
    List<String> readFromFile(String filePath);
}
