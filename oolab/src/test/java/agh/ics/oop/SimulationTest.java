package agh.ics.oop;


import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
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
        Simulation simulation=new Simulation(positions, moveDirectionList);

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

        String[] testArgs = {"f", "b", "r", "l", "f", "f"};
        List<MoveDirection> directions = OptionsParser.dirs(testArgs);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(positions, directions);

        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).isAt(new Vector2d(3,3)));
        assertTrue(animals.get(1).isAt(new Vector2d(2,3)));
    }

    @Test
    public void animalOrientation(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};

        List<Vector2d> positions= List.of(new Vector2d(2,2),new Vector2d(3,4));
        List<MoveDirection> moveDirectionList= OptionsParser.dirs(args);
        Simulation simulation=new Simulation(positions, moveDirectionList);
        simulation.run();


        Assertions.assertEquals(simulation.getAnimals().get(0).getOrient(), MapDirection.SOUTH);
        Assertions.assertEquals(simulation.getAnimals().get(1).getOrient(),MapDirection.NORTH);

    }

    @Test
    public void testAnimalStaysWithinBounds() {
        String[] testArgs = {"f", "f", "f", "f", "f", "f", "f", "f","f","f"};
        List<MoveDirection> directions = OptionsParser.dirs(testArgs);
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(4, 4));
        Simulation simulation = new Simulation(positions, directions);

        simulation.run();

        List<Animal> animals = simulation.getAnimals();
        assertTrue(animals.get(0).isAt(new Vector2d(0, 4)));
        assertTrue(animals.get(1).isAt(new Vector2d(4, 4)));
    }


}