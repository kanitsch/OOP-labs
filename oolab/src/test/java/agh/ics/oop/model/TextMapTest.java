package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextMapTest {

    @Test
    void textMapPlace() {
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        assertEquals("[Ala, ma, kota]", textMap.toString());
    }

    @Test
    void canMoveTo() {
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        assertTrue(textMap.canMoveTo(2));
        assertFalse(textMap.canMoveTo(3));
        assertFalse(textMap.canMoveTo(-4));
        assertFalse(textMap.canMoveTo(null));
    }

    @Test
    void move() {
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        textMap.move("Ala",MoveDirection.FORWARD);
        assertEquals("[ma, Ala, kota]", textMap.toString());
        textMap.move("Ala",MoveDirection.RIGHT);
        assertEquals("[ma, kota, Ala]", textMap.toString());
        textMap.move("Ala",MoveDirection.LEFT);
        assertEquals("[ma, Ala, kota]", textMap.toString());
        textMap.move("Ala",MoveDirection.BACKWARD);
        assertEquals("[Ala, ma, kota]", textMap.toString());

    }

    @Test
    void invalidMove(){
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        textMap.move("pies",MoveDirection.FORWARD);
        assertEquals("[Ala, ma, kota]", textMap.toString());
        textMap.move("Ala",MoveDirection.LEFT);
        assertEquals("[Ala, ma, kota]", textMap.toString());
        textMap.move("kota",MoveDirection.FORWARD);
        assertEquals("[Ala, ma, kota]", textMap.toString());
    }

    @Test
    void moveOutOfRange() {
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        textMap.move("Ala",MoveDirection.LEFT);
        assertEquals("[Ala, ma, kota]", textMap.toString());
        textMap.move("kota",MoveDirection.RIGHT);
        assertEquals("[Ala, ma, kota]", textMap.toString());
    }

    @Test
    void occupiedPlace() {
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        assertFalse(textMap.isOccupied(5));
        assertFalse(textMap.isOccupied(-1));
        assertTrue(textMap.isOccupied(0));
        assertFalse(textMap.isOccupied(null));
    }

    @Test
    void objectAt() {
        WorldMap<String, Integer> textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("kota");
        assertEquals("Ala", textMap.objectAt(0));
        assertNull(textMap.objectAt(-1));
        assertNull(textMap.objectAt(3));
        assertNull(textMap.objectAt(null));
    }
}