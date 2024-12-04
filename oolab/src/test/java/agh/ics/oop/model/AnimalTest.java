package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void animalIsAt() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(0, 3));
        assertTrue(animal1.isAt(new Vector2d(2, 2)));
        assertTrue(animal2.isAt(new Vector2d(0, 3)));
    }
    @Test
    void orientTest() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(0, 3));
        assertEquals(MapDirection.NORTH,animal1.getOrient());
        assertEquals(MapDirection.NORTH,animal2.getOrient());
    }

    @Test
    void animalToString(){
        Animal animal1=new Animal(new Vector2d(1,2));
        assertEquals("N",animal1.toString());

    }
    @Test
    void animalEquals() {
        Animal animal1 = new Animal(new Vector2d(1,2));
        Animal animal2 = new Animal(new Vector2d(1,2));
        Animal animal3 = animal1;
        Animal animal4 = new Animal(new Vector2d(2,2));
        assertTrue(animal1.equals(animal2));
        RectangularMap map = new RectangularMap(5,5);

        animal2.move(MoveDirection.LEFT, map);

        assertFalse(animal1.equals(animal2));
        assertTrue(animal1.equals(animal3));
        assertFalse(animal1.equals(null));
        assertFalse(animal1.equals(new String("")));
        assertFalse(animal1.equals(animal4));
    }

    @Test
    void animalHashCode() {
        Animal animal1 = new Animal(new Vector2d(1,2));
        Animal animal2 = new Animal(new Vector2d(1,2));
        assertEquals(animal1.hashCode(), animal2.hashCode());

    }

    @Test
    void animalTurn() {
        Animal animal1 = new Animal(new Vector2d(1,2));
        Animal animal2 = new Animal(new Vector2d(1,2));
        RectangularMap map = new RectangularMap(5,5);
        animal1.move(MoveDirection.LEFT, map);
        animal2.move(MoveDirection.RIGHT, map);

        assertEquals(MapDirection.WEST,animal1.getOrient());
        assertTrue(animal1.isAt(new Vector2d(1,2)));
        assertTrue(animal2.isAt(new Vector2d(1,2)));
        assertEquals(MapDirection.EAST,animal2.getOrient());

        animal1.move(MoveDirection.FORWARD, map);
        assertEquals(MapDirection.WEST,animal1.getOrient());
    }

    @Test
    void move() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();
        RectangularMap map = new RectangularMap(5,5);
        animal2.move(MoveDirection.LEFT, map);
        animal3.move(MoveDirection.RIGHT, map);
        animal4.move(MoveDirection.LEFT, map);
        animal4.move(MoveDirection.LEFT, map);

        animal1.move(MoveDirection.FORWARD, map);
        animal2.move(MoveDirection.FORWARD, map);
        animal3.move(MoveDirection.FORWARD, map);
        animal4.move(MoveDirection.FORWARD, map);

        assertTrue(animal1.isAt(new Vector2d(2,3)));
        assertTrue(animal2.isAt(new Vector2d(1,2)));
        assertTrue(animal3.isAt(new Vector2d(3,2)));
        assertTrue(animal4.isAt(new Vector2d(2,1)));

        animal1.move(MoveDirection.BACKWARD, map);
        animal2.move(MoveDirection.BACKWARD, map);
        animal3.move(MoveDirection.BACKWARD, map);
        animal4.move(MoveDirection.BACKWARD, map);

        assertTrue(animal1.isAt(new Vector2d(2,2)));
        assertTrue(animal2.isAt(new Vector2d(2,2)));
        assertTrue(animal3.isAt(new Vector2d(2,2)));
        assertTrue(animal4.isAt(new Vector2d(2,2)));


    }

    @Test
    void animalOutOfMap(){
        Animal animal1 = new Animal();
        RectangularMap map = new RectangularMap(5,5);
        animal1.move(MoveDirection.FORWARD, map);
        animal1.move(MoveDirection.FORWARD, map);
        animal1.move(MoveDirection.FORWARD, map);
        animal1.move(MoveDirection.FORWARD, map);
        assertTrue(animal1.isAt(new Vector2d(2,5)));
    }




}