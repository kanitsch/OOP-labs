package agh.ics.oop;


import agh.ics.oop.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    public void dataInterpretation1(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
        List<MoveDirection> moveDirectionList= OptionsParser.dirs(args);
        List<MoveDirection> result =List.of(MoveDirection.FORWARD,MoveDirection.BACKWARD,
                MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD);

        assertEquals(result, moveDirectionList);
    }
    @Test
    public void ValidMoveDirections() {
        String[] testArgs = {"f", "b", "r", "l"};
        List<MoveDirection> directions = OptionsParser.dirs(testArgs);
        assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT), directions);
    }

    @Test
    public void dataInterpretation2(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
        List<Vector2d> positions= List.of(new Vector2d(2,2),new Vector2d(3,4));
        List<MoveDirection> moveDirectionList= OptionsParser.dirs(args);
        RectangularMap map = new RectangularMap(5,5);
        Simulation simulation=new Simulation(positions, moveDirectionList,map);

        List<Animal> animals= Arrays.asList(new Animal(new Vector2d(2,2)),new Animal(new Vector2d(3,4)));

        assertNotNull(simulation.getAnimals());
        assertNotNull(simulation.getAnimals());

        assertNotNull(simulation.getMoveDirectionList());
        assertInstanceOf(List.class, simulation.getMoveDirectionList());

        assertEquals(animals,simulation.getAnimals());
        assertEquals(moveDirectionList,simulation.getMoveDirectionList());
    }


    @Test
    public void animalPosition() {
        RectangularMap map = new RectangularMap(5,5);
        String[] testArgs = {"f", "b", "r", "l", "f", "f"};
        List<MoveDirection> directions = OptionsParser.dirs(testArgs);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(positions, directions,map);

        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).isAt(new Vector2d(2,3)));
        assertTrue(animals.get(1).isAt(new Vector2d(3,3)));
    }

    @Test
    public void animalOrientation(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
        RectangularMap map = new RectangularMap(5,5);
        List<Vector2d> positions= List.of(new Vector2d(2,2),new Vector2d(3,4));
        List<MoveDirection> moveDirectionList= OptionsParser.dirs(args);
        Simulation simulation=new Simulation(positions, moveDirectionList,map);
        simulation.run();


        Assertions.assertEquals(simulation.getAnimals().get(0).getOrient(), MapDirection.SOUTH);
        Assertions.assertEquals(simulation.getAnimals().get(1).getOrient(),MapDirection.NORTH);

    }

    @Test
    void emptyString(){
        RectangularMap map = new RectangularMap(5,5);
        String[] args={};
        List<Vector2d> positions= List.of(new Vector2d(2,2),new Vector2d(3,4));
        List<MoveDirection> moveDirectionList= OptionsParser.dirs(args);
        Simulation simulation=new Simulation(positions, moveDirectionList,map);
        simulation.run();
        Assertions.assertEquals(simulation.getAnimals().get(0).getOrient(), MapDirection.NORTH);
        Assertions.assertEquals(simulation.getAnimals().get(1).getOrient(),MapDirection.NORTH);
    }

    @Test
    void moreAnimals(){
        String[] testArgs = {"f", "b", "r", "l", "f", "f"};
        RectangularMap map = new RectangularMap(5,5);
        List<MoveDirection> directions = OptionsParser.dirs(testArgs);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4),new Vector2d(0,0));
        Simulation simulation = new Simulation(positions, directions,map);

        simulation.run();

        assertEquals("W",simulation.getAnimals().get(0).toString());
        assertEquals("N",simulation.getAnimals().get(1).toString());
        assertEquals("E",simulation.getAnimals().get(2).toString());
    }

    @Test
    public void testAnimalStaysWithinBounds() {
        String[] testArgs = {"f", "f", "f", "f", "f", "f", "f", "f","f","f"};
        RectangularMap map = new RectangularMap(5,5);
        List<MoveDirection> directions = OptionsParser.dirs(testArgs);
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(4, 4));
        Simulation simulation = new Simulation(positions, directions,map);

        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).isAt(new Vector2d(0, 5)));
        assertTrue(animals.get(1).isAt(new Vector2d(4, 5)));
    }


}