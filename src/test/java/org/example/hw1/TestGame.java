package org.example.hw1;

import java.util.List;

public class TestGame extends Game{
    public void startGame(int doorWithPrizeNumber) {
        doors.clear();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.get(doorWithPrizeNumber-1).setHasPrize(true);

    }
    public List<Door> getDoors() {
        return doors;
    }
    public boolean isSelectedDoorWithPrize() {
        for (Door door: doors){
            if(door.isSelected()){
                door.open();
                return door.hasPrize();
            }
        }
        return false;
    }

}
