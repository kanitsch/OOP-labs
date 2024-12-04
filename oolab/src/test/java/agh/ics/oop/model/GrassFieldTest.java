package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void placeAnimalOnMap(){
        WorldMap map = new GrassField(10);
        Animal animal = new Animal();
        try {
            map.place(animal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(new Vector2d(2, 2), animal.getLocation());
    }

    @Test
    public void moveAnimal(){
        WorldMap map = new GrassField(10);
        Animal animal = new Animal();
        try {
            map.place(animal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        map.move(animal,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getLocation());
    }

    @Test
    public void canMoveTo1(){
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        try {
            map.place(animal1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void placeException(){
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        try {
            map.place(animal1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThrows(IncorrectPositionException.class, () -> map.place(animal2));

    }



    @Test
    public void moveAnimalsMore(){
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3, 2));
        Animal animal3 = new Animal(new Vector2d(3, 10));
        animal2.move(MoveDirection.LEFT,map);
        animal2.move(MoveDirection.LEFT,map);
        try {
            map.place(animal1);
            map.place(animal2);
            map.place(animal3);
        } catch (IncorrectPositionException e) {
            System.out.println(e.getMessage());
        }

        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.FORWARD);
        map.move(animal3, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal1.getLocation());
        assertEquals(new Vector2d(3, 1), animal2.getLocation());
        assertEquals(new Vector2d(3, 11), animal3.getLocation());
    }

    @Test
    public void isOccupied(){
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        animal2.move(MoveDirection.LEFT,map);
        try {
            map.place(animal1);
            map.place(animal2);
        } catch (IncorrectPositionException e) {
            System.out.println(e.getMessage());
        }

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(2, 10)));
    }

    @Test
    public void testObjectAt(){
        WorldMap map = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        try {
            map.place(animal1);
            map.place(animal2);
        } catch (IncorrectPositionException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
    }


}