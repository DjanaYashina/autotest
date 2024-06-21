package org.example.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerTest {

    @Test
    void GetCountOneContainer(){
        //given
        Container container = new Container();
        container.addElement(new Element(10));
        container.addElement(new Element(50));
        container.addElement(new Element(70));
        //when
        int result = container.getCount();
        //then
        Assertions.assertEquals(130, result);
    }

    @Test
    void GetCountAllContainer(){
        //given
        Container container1 = new Container();
        Container container2 = new Container();
        Container container3 = new Container();

        container1.addElement(new Element(10));
        container1.addElement(new Element(50));  //60

        container2.addElement(new Element(1000));
        container2.addElement(container1);              //1060

        container3.addElement(container1);
        container3.addElement(container2);              //1120

        //when
        int result = container3.getCount();
        //then
        Assertions.assertEquals(1120, result);
    }

    @Test
    void GetCountContainerRemoveElement(){
        //given
        Container container1 = new Container();
        Container container2 = new Container();
        Container container3 = new Container();

        container1.addElement(new Element(20));
        container1.addElement(new Element(30));  //50

        container2.addElement(new Element(100));
        container2.addElement(container1);
        container2.addElement(new Element(50));   //200

        container3.addElement(container1);
        container3.addElement(container2);              //250

        container2.removeElement(0);        //c1(50) + c2(100) = c3(150)
        container1.removeElement(0);        //c1(30) + c2(80) = c3(110)

        //when
        int result = container3.getCount();
        //then
        Assertions.assertEquals(110, result);
    }
}
