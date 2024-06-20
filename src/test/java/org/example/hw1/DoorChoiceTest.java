package org.example.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DoorChoiceTest extends BaseTest{

    @BeforeEach
    void before(){
        game.startGame();
    }
    @ParameterizedTest
    @CsvSource({"1, true", "5, false", "2, true","8, false", "3, true","9, false"})
    void selectDoorTest (int selectedDoor, boolean ifDoorSet){
        game.chooseDoor(selectedDoor);
        boolean actualResult = false;
        for(Door door: game.getDoors()){
            if (door.isSelected()) {
                actualResult = true;
                break;
            }
        }
        Assertions.assertEquals(ifDoorSet,actualResult);
    }
}
