package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void placeAnimalOnMap(){
        RectangularMap map= new RectangularMap(5,5);
        Animal animal1=new Animal();
        Animal animal2=new Animal(new Vector2d(2,3));
        Animal animal3=new Animal();
        Animal animal4=new Animal(new Vector2d(0,6));
        assertTrue(map.place(animal1));
//        map.place(animal1);
        assertEquals(new Vector2d(2, 2), animal1.getLocation());
        assertTrue(map.place(animal2));
        assertFalse(map.place(animal3));
        assertFalse(map.place(animal4));
    }

    @Test
    void canMoveTo(){
        RectangularMap map= new RectangularMap(5,5);
        Animal animal1=new Animal(new Vector2d(0,0));
        map.place(animal1);

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
        map.place(animal1);
        map.place(animal2);

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
        map.place(animal1);
        map.place(animal2);
        Map<Vector2d, Animal> animals = map.getAnimals();
        assertEquals(2, animals.size());
        assertEquals(animal1, animals.get(new Vector2d(2, 2)));
        assertEquals(animal2, animals.get(new Vector2d(2, 0)));


    }

    @Test
    public void testToString() {
        RectangularMap map = new RectangularMap(3, 3);
        Animal animal1 = new Animal(new Vector2d(1, 1));
        Animal animal2 = new Animal();
        map.place(animal1);
        map.place(animal2);

        String expectedMap = new MapVisualizer(map).draw(new Vector2d(0, 0), new Vector2d(3, 3));
        assertEquals(expectedMap, map.toString());
    }

}