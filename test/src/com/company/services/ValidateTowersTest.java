package com.company.services;


import com.company.models.Tower;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ValidateTowersTest {

    @Test
    public void verifyEachPillarsIsOrdernated() {
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateCorretTower());
        Boolean allCorrects = validateTowers.verify();
        Assert.assertTrue(allCorrects);
    }

    @Test
    public void verifyEachPillarsIsNotOrdernated() {
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateTowerWithOrdersIncorret());
        Boolean isIncorrect = validateTowers.verify();
        Assert.assertFalse(isIncorrect);
    }

    @Test
    public void createStepToSolve() {
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateCorretTower());
        List<Tower> towersSolved = validateTowers.solve();
        System.out.println(MockTowers.towersOrdernatedExpected());
        Assert.assertTrue(MockTowers.towersOrdernatedExpected().equals(towersSolved.toArray()));
    }

}
