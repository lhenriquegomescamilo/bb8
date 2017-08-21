package com.company.services;

import com.company.models.Tower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractValueToTowers {
    public static final int BEGIN_INDEX_TO_ELEMENT_OF_TOWERS = 2;
    public static final String SYMBOL_SPLIT_ARRAY_OF_ELEMENT = ":";
    private List<Tower> towers;

    public List<Tower> build(String filePathWithName) {
        try (Stream<String> stream = Files.lines(Paths.get(filePathWithName))) {
            this.extractValueToTowers(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return towers;
    }

    private void extractValueToTowers(Stream<String> stream) {
        towers = stream
                .map(element -> new Tower(getNameToTowers(element), getElementsToTowers(element)))
                .collect(Collectors.toList());
    }

    private String getNameToTowers(String element) {
        return element.substring(0, 1);
    }

    private List<Integer> getElementsToTowers(String element) {
        String elementOfTowers = element.substring(BEGIN_INDEX_TO_ELEMENT_OF_TOWERS);

        return Arrays
                .asList(elementOfTowers.split(SYMBOL_SPLIT_ARRAY_OF_ELEMENT))
                .stream()
                .filter(numberAsString -> !numberAsString.isEmpty())
                .map(Integer::parseInt)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }


}
