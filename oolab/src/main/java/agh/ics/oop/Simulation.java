package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation<T,P> {
    private final List<T> animals;
    private final List<MoveDirection> moves;
    private final WorldMap<T,P> map;
    //metoda simulation zaklada ze obiekty są już na mapie
    public Simulation(List<T> animals, List<MoveDirection> moves, WorldMap<T,P> map) {
        this.animals = animals;
        this.map = map;
        this.moves = moves;
    }

    public List<T> getAnimals() {
        return animals;
    }

    public void run() {
        System.out.println(map);
        int numberOfAnimals = animals.size();
        for (int i = 0; i < moves.size(); i++) {
            T animal = animals.get(i%numberOfAnimals);
            MoveDirection move = moves.get(i);
            map.move(animal, move);
            System.out.println(map);
        }
    }

    public List<MoveDirection> getMoveDirectionList() {
        return moves;
    }
}