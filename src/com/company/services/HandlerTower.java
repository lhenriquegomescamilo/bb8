package com.company.services;

import com.company.models.Tower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandlerTower {
    private List<Tower> towers;

    public HandlerTower readFileByPath(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            extractTowerName(stream);

            /*
            extrair os elementos para cada torre
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    private void extractTowerName(Stream<String> stream) {
        stream.map(element -> new Tower().setName(getFirstElementFromString(element)))
                .collect(Collectors.toList());
    }

    private String getFirstElementFromString(String element) {
        return element.substring(0, 1);
    }

}
