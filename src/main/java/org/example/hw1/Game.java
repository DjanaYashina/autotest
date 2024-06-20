package org.example.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    protected final List<Door> doors= new ArrayList<>();


    public void startGame() {
        doors.clear();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        Collections.shuffle(doors);

    }


    /**
     * Метод возвращает true, если удалось успешно выбрать указанную дверь
     * и возвращает false, если указанной двери нет
     */


    public boolean chooseDoor(int firstSelectedDoor) {
        boolean success = false;
        if (firstSelectedDoor>=1 && firstSelectedDoor<=3){
            doors.get(firstSelectedDoor-1).setSelected(true);
            success = true;
        }
        return success;
    }

    public int giveHint() {
        //Список дверей не выбранных пользователем и не являются призовыми
        List<Door> list = new ArrayList<>();
        for (Door door: doors){
            if(!door.hasPrize() && !door.isSelected()){
                list.add(door);
            }
        }
        Collections.shuffle(list);
        Door hintDoor = list.get(0);
        hintDoor.setHint(true);
        return doors.indexOf(hintDoor);
    }

    public void changeChoice() {
        Door currentSelectedDoor = null;
        Door newSelectedDoor = null;
        for (Door door: doors){
            if (door.isSelected()){
                currentSelectedDoor = door;
                continue;
            }
            if (!door.isSelected()&& !door.isHint()){
                newSelectedDoor = door;
                continue;
            }

        }
        if (currentSelectedDoor !=null){
            currentSelectedDoor.setSelected(false);
        }
        if(newSelectedDoor != null){
            newSelectedDoor.setSelected(true);
        }

    }

    public void openSelectedDoor() {
        for (Door door: doors){
            if(door.isSelected()){
                door.open();
                return;
            }
        }
    }
}
