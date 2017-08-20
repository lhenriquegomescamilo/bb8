package com.company;

import com.company.models.Tower;
import com.company.services.HandlerTower;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**
     * 2.1. Há três hastes para onde o BB8 pode mover os discos de uma haste para a
     * outra
     * , sendo identificadas da letra A​ até a letra C​ da esquerda para direita;
     * <p>
     * 2.2. Há 4 discos de tamanho diferentes, sendo numerados de 1 a 4 do menor
     * para o maior;
     * <p>
     * 2.3. Um disco maior não pode ficar em cima de um disco menor;
     * <p>
     * 2.4. Um disco deve ser movido de cada vez;
     */
    public static void main(String[] args) {

        String fileName = "/Users/luiscamilo/dev/github/bb8/files/tower.txt";
        new HandlerTower().readFileByPath(fileName);;
    }

}
