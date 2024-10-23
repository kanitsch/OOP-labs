package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void equalsTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(2,3);
        //then
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(2));

    }

    @Test
    void toStringTest(){
        //        given
        Vector2d v1=new Vector2d(1,2);

//        then
        assertEquals("(1,2)",v1.toString());

    }

    @Test
    void precedesTest(){
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);
        Vector2d v3=new Vector2d(2,3);

        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
        assertTrue(v2.precedes(v3));
    }

    @Test
    void followTest(){
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);
        Vector2d v3=new Vector2d(2,3);

        assertFalse(v1.follows(v2));
        assertTrue(v2.follows(v1));
        assertTrue(v2.follows(v3));
    }

    @Test
    void upperRightTest(){
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);
        Vector2d v3=new Vector2d(2,3);
        Vector2d v4=new Vector2d(1,4);

        assertEquals(new Vector2d(2,3),v3.upperRight(v2));
        assertEquals(new Vector2d(2,3),v3.upperRight(v1));
        assertEquals(new Vector2d(2,4),v3.upperRight(v4));
    }

    @Test
    void lowerLeftTest(){
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);
        Vector2d v3=new Vector2d(2,3);
        Vector2d v4=new Vector2d(1,4);
        assertEquals(new Vector2d(2,3),v3.lowerLeft(v2));
        assertEquals(new Vector2d(1,2),v3.lowerLeft(v1));
        assertEquals(new Vector2d(1,3),v3.lowerLeft(v4));

    }

    @Test
    void addTest(){
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);

        assertEquals(new Vector2d(3,5),v1.add(v2));
    }

    @Test
    void subtractTest(){
        Vector2d v1=new Vector2d(1,2);
        Vector2d v2=new Vector2d(2,3);

        assertEquals(new Vector2d(-1,-1),v1.subtract(v2));
    }

    @Test
    void oppositeTest(){
        Vector2d v1=new Vector2d(1,2);

        assertEquals(new Vector2d(-1,-2),v1.opposite());
    }


}