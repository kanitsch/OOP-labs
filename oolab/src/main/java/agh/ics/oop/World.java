package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.MapDirection;

import java.util.List;

public class World {
    public static void run(List<MoveDirection> directions) {
//        System.out.println("zwierzak idzie do przodu");
//        String separator="";
        for (MoveDirection direction : directions){
//            System.out.print(separator+str);
//            separator=",";
            switch (direction) {
                case FORWARD ->  System.out.println("Zwierzak idzie do przodu");
                case BACKWARD ->  System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT ->  System.out.println("Zwierzak idzie w lewo");
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("system wystartowal");
        List<MoveDirection> directions = OptionsParser.dirs(args);

        run(directions);
        System.out.println("system zakonczyl dzialanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction=MapDirection.EAST;
        System.out.println(direction.toString());
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());

        Animal pet=new Animal();
        System.out.println(pet.toString());

        System.out.println(pet.toString());

        List<MoveDirection> directions1 = OptionsParser.dirs(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions1);
        simulation.run();
    }

}

