package org.example.hw1;

public class Door {
    private boolean hasPrize;

    public void setHasPrize(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }

    public boolean isHint() {
        return isHint;
    }

    public void setHint(boolean hint) {
        isHint = hint;
    }

    private boolean isHint;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    private boolean isSelected;

    public Door(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }

    public boolean hasPrize() {
        return hasPrize;
    }

    public boolean open(){
        if(hasPrize){
            System.out.println("Победа, за этой дверью приз!");
        }else{
            System.out.println("Вы проиграли, за этой дверью нет приза");
        }
        return hasPrize;
    }

    @Override
    public String toString() {
        return "Door{" +
                "hasPrize=" + hasPrize +
                ", isSelected=" + isSelected +
                '}';
    }


}
