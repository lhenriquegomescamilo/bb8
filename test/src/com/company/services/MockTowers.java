package com.company.services;

import com.company.models.Tower;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockTowers {

    public static List<Tower> generateCorretTower() {
        List<Integer> list = IntStream.range(1,5)
                .boxed().sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(list);
        return Arrays.asList(
                new Tower("A", list),
                new Tower("B", new LinkedList<>()),
                new Tower("C", new LinkedList<>()));


    }

    public static List<Tower> generateTowerWithOrdersIncorret() {
        return Arrays.asList(
                new Tower("A", Arrays.asList(3, 4)),
                new Tower("B", Arrays.asList(1,2)),
                new Tower("C", new LinkedList<>()));


    }

    public static Tower[] towersOrdernatedExpected() {
        Tower[] towers = {new Tower("A", new LinkedList<>()),
                new Tower("B", new LinkedList<>()),
                new Tower("C", Arrays.asList(4, 3, 2, 1))};
        return towers;
    }
}
