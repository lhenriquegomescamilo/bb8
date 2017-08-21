package com.company.services;

import com.company.models.Instruction;
import com.company.models.Tower;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ValidateTowers {
    private final List<Tower> towers;
    private List<Instruction> instructions;


    public ValidateTowers(List<Tower> towers) {
        this.towers = towers;
        this.instructions = new LinkedList<>();
    }


    public Boolean verify() {
        return this.towers.stream().allMatch(tower -> pillarsIsCorrectByTower(tower));
    }

    private boolean pillarsIsCorrectByTower(Tower tower) {
        return tower.getElementsForTower().stream()
                .mapToInt(Integer::intValue).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .equals(tower.getElementsForTower());
    }

    public List<Tower> solve() {
        if (this.verify()) {
            this.solve(this.towers.get(0).getElementsForTower().size(), this.towers.get(0).getName(), this.towers.get(1).getName(), this.towers.get(2).getName());

            instructions = instructions.stream().map(instruction -> {
                this.moveElementsTowerByInstruction(instruction);
                return instruction;

            }).collect(Collectors.toList());
            return this.towers;

        }
        return Collections.emptyList();
    }

    private void moveElementsTowerByInstruction(Instruction instruction) {
        Tower towerFrom = getTowerByInstruction(instruction.getFrom());
        Tower towerTo = getTowerByInstruction(instruction.getTo());

        Integer elementFrom = towerFrom.getElementsForTower()
                .get(towerFrom.getElementsForTower().size() - 1);

        towerTo.getElementsForTower().add(elementFrom);
        instruction.setElement(elementFrom);

        towerFrom.getElementsForTower()
                .remove(towerFrom.getElementsForTower().size() - 1);

        this.towers.set(this.towers.indexOf(towerFrom), towerFrom);
        this.towers.set(this.towers.indexOf(towerTo), towerTo);

    }

    private Tower getTowerByInstruction(String instruction) {
        return this.towers.stream().filter(tower -> tower.getName().equals(instruction)).findFirst().orElse(new Tower());
    }

    private void solve(int n, String start, String aux, String end) {
        if (n == 1) {
            instructions.add(new Instruction(start, end));
        } else {
            solve(n - 1, start, end, aux);
            instructions.add(new Instruction(start, end));
            solve(n - 1, aux, start, end);
        }
    }

    public List<Instruction> getInstructions() {
        return this.instructions;
    }

    public String steps() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Instruction instruction : this.instructions) {
            joiner.add(instruction.getTo()+" - "+instruction.getElement());
        }
        return joiner.toString();
    }
}
