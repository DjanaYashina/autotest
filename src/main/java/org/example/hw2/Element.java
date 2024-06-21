package org.example.hw2;

public class Element implements IElements{


    private final int count;

    public Element(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }
}
