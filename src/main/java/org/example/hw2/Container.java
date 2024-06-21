package org.example.hw2;

import java.util.ArrayList;
import java.util.List;

public class Container implements IElements{


    public List<IElements> elements = new ArrayList<>();


    public void addElement(IElements element){
        elements.add(element);
    }

    public void removeElement(int index){
        elements.remove(index);
    }

    public List<IElements> getElements() {
        return elements;
    }

    @Override
    public int getCount() {
        return elements.stream()
                .map(IElements::getCount)
                .mapToInt(Integer::intValue).sum();
    }
}
