package com.company.services;


import com.company.models.Tower;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ValidateTowersTest {
    private static Integer STEP_NEEDED = 15;

    @Test
    public void  verify_each_pillars_is_ordernated() {
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateCorretTower());
        Boolean allCorrects = validateTowers.verify();
        Assert.assertTrue(allCorrects);
    }

    @Test
    public void  verify_each_pillars_is_not_ordernated() {
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateTowerWithOrdersIncorret());
        Boolean isIncorrect = validateTowers.verify();
        Assert.assertFalse(isIncorrect);
    }

    @Test
    public void  solve_pillars_of_towers() {
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateCorretTower());
        List<Tower> towersSolved = validateTowers.solve();
        Assert.assertArrayEquals(MockTowers.towersOrdernatedExpected(), towersSolved.toArray());
    }

    @Test
    public void have_15_step_to_solve(){
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateCorretTower());
        validateTowers.solve();
        Integer steps = validateTowers.getInstructions().size();
        Assert.assertEquals(steps, STEP_NEEDED);
    }

    @Test
    public void steps_to_solve(){
        ValidateTowers validateTowers = new ValidateTowers(MockTowers.generateCorretTower());
        validateTowers.solve();
        String steps = validateTowers.steps();
        Assert.assertNotNull(steps);
    }
}
