package org.example.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InitGameTest extends BaseTest{
    @BeforeEach
    void before(){
        game.startGame();
    }
    @Test
    void atLeastOneDoorHasPrize(){
        List<Door> doors = game.getDoors();
        int doorWithPrizeCount = 0;
        for (Door door: doors){
            if (door.hasPrize()){
                doorWithPrizeCount++;
            }

        }
        Assertions.assertTrue(doorWithPrizeCount>0);
    }
    @Test
    void singleDoorHasPrize(){
        List<Door> doors = game.getDoors();
        int doorWithPrizeCount = 0;
        for (Door door: doors){
            if (door.hasPrize()){
                doorWithPrizeCount++;
            }

        }
        Assertions.assertEquals(1,doorWithPrizeCount);
    }

}
