package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap map;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map) {
        this.animals = new ArrayList<>();
        this.map = map;
        for (Vector2d position : positions) {

            try {
                Animal animal1=new Animal(position);
                map.place(animal1);
                this.animals.add(animal1);
            } catch (IncorrectPositionException e) {
                System.out.println(e.getMessage());
            }
        }
        this.moves = moves;
    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void run() {
        System.out.println(map);
        int numberOfAnimals = animals.size();
        for (int i = 0; i < moves.size(); i++) {
            Animal animal = animals.get(i%numberOfAnimals);
            MoveDirection move = moves.get(i);
            map.move(animal, move);
//            System.out.println(map);
        }
    }

    public List<MoveDirection> getMoveDirectionList() {
        return moves;
    }
}
