package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            this.animals.add(new Animal(position));
        }
        this.moves = moves;
    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void run() {
        int numberOfAnimals = animals.size();
        for (int i = 0; i < moves.size(); i++) {
            Animal animal = animals.get(i%numberOfAnimals);
            MoveDirection move = moves.get(i);
            animal.move(move);
            System.out.println("Zwierze " + (i%numberOfAnimals) + ": "+animal.toString());
        }
    }

    public List<MoveDirection> getMoveDirectionList() {
        return moves;
    }
}
