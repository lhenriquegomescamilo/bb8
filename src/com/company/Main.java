package com.company;

import com.company.models.Tower;
import com.company.services.ExtractValueToTowers;
import com.company.services.ValidateTowers;

import java.util.List;
import java.util.Scanner;

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
        List<Tower> towers = new ExtractValueToTowers().build(fileName);
        new ValidateTowers(towers);

    }

}

