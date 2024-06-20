package org.example.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

public class ProbabilityTest extends BaseTest{

   private final Random random = new Random();


    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000})
    void noRiskProbabilityTest(int iterationCount){
        int winCount = 0;
        for (int i = 0; i < iterationCount-1; i++) {
            game.startGame();
            game.chooseDoor(random.nextInt(1,4));
            game.giveHint();
            boolean isWin = game.isSelectedDoorWithPrize();
            if(isWin){
                winCount++;
            }
        }
        float winFrequency = winCount*100F/iterationCount;
        System.out.println("frequency = " + winFrequency);
        Assertions.assertTrue(winFrequency<50);

    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000})
    void riskProbabilityTest(int iterationCount){
        int winCount = 0;
        for (int i = 0; i < iterationCount-1; i++) {
            game.startGame();
            game.chooseDoor(random.nextInt(1,4));
            game.giveHint();
            game.changeChoice();
            boolean isWin = game.isSelectedDoorWithPrize();
            if(isWin){
                winCount++;
            }
        }
        float winFrequency = winCount*100F/iterationCount;
        System.out.println("frequency = " + winFrequency);
        Assertions.assertTrue(winFrequency>=50);

    }
}
