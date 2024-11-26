package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.util.MapVisualizer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void placeAnimalOnMap() {
        RectangularMap map= new RectangularMap(5,5);
        Animal animal1=new Animal();
        Animal animal2=new Animal(new Vector2d(2,3));
        Animal animal3=new Animal();
        Animal animal4=new Animal(new Vector2d(0,6));
        try{
            map.place(animal1);
        }
        catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }
        try{
            map.place(animal2);
        }
        catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }

        assertEquals(new Vector2d(2, 2), animal1.getLocation());
        assertEquals(new Vector2d(2, 3), animal2.getLocation());
    }
    @Test
    public void testPlace(){
        WorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2, 2));
        try {
            assertTrue(map.place(animal1));
        } catch (IncorrectPositionException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        assertThrows(IncorrectPositionException.class, () -> map.place(animal2));
    }

    @Test
    public void testPlaceWithInvalidPosition() {

        RectangularMap map = new RectangularMap(5, 5);

        assertThrows(IncorrectPositionException.class, () -> {
            Animal animal = new Animal(new Vector2d(6, 6));
            map.place(animal);
        });
    }



    @Test
    void canMoveTo(){
        RectangularMap map= new RectangularMap(5,5);
        Animal animal1=new Animal(new Vector2d(0,0));
        try {
            map.place(animal1);
        } catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }


        assertFalse(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(0,1)));
        assertFalse(map.canMoveTo(new Vector2d(0,-1)));
        assertFalse( map.canMoveTo(new Vector2d(-1,0)));
        assertFalse( map.canMoveTo(new Vector2d(6,0)));
        assertFalse( map.canMoveTo(new Vector2d(0,6)));
    }

    @Test
    void moveAnimalOnMap(){
        RectangularMap map= new RectangularMap(5,5);
        Animal animal1=new Animal();
        Animal animal2=new Animal(new Vector2d(2,0));
        try {
            map.place(animal1);
        } catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }
        try {
            map.place(animal2);
        } catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }


        map.move(animal2,MoveDirection.FORWARD);
        assertTrue(animal2.isAt(new Vector2d(2,1)));

        map.move(animal2,MoveDirection.FORWARD);
        assertTrue(animal2.isAt(new Vector2d(2,1)));
    }

    @Test
    void getters(){
        RectangularMap map= new RectangularMap(5,5);
        assertEquals(5,map.getHeight());
        assertEquals(5,map.getWidth());
        assertTrue(map.getAnimals().isEmpty());
    }

    @Test
    void getPlacedAnimals(){
        RectangularMap map= new RectangularMap(5,5);
        Animal animal1=new Animal();
        Animal animal2=new Animal(new Vector2d(2,0));
        try {
            map.place(animal1);
        } catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }
        try {
            map.place(animal2);
        } catch (IncorrectPositionException e) {
            System.err.println(e.getMessage());
        }

        Map<Vector2d, Animal> animals = map.getAnimals();
        assertEquals(2, animals.size());
        assertEquals(animal1, animals.get(new Vector2d(2, 2)));
        assertEquals(animal2, animals.get(new Vector2d(2, 0)));


    }

@Test
public void testToString() {
    WorldMap map = new RectangularMap(5,5);
    Animal animal1= new Animal(new Vector2d(2,2));
    Animal animal2= new Animal(new Vector2d(3,4));
    try {
        map.place(animal1);
        map.place(animal2);
    } catch (IncorrectPositionException e) {
        fail("Exception should not be thrown when placing animals");
    }
    String expected=
            """
                     y\\x  0 1 2 3 4 5
                      6: -------------
                      5: | | | | | | |
                      4: | | | |N| | |
                      3: | | | | | | |
                      2: | | |N| | | |
                      1: | | | | | | |
                      0: | | | | | | |
                     -1: -------------
                    """;
    expected = expected.replace("\n", "\r\n");
    assertEquals(expected, map.toString());
    }
}
