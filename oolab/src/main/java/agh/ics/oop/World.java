package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.MapDirection;
import javafx.application.Application;

import java.util.ArrayList;
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
//        try {
//            List<MoveDirection> directions = OptionsParser.dirs(args);
//
//            run(directions);
//
//
//            Vector2d position1 = new Vector2d(1,2);
//            System.out.println(position1);
//            Vector2d position2 = new Vector2d(-2,1);
//            System.out.println(position2);
//            System.out.println(position1.add(position2));
//
//            MapDirection direction=MapDirection.EAST;
//            System.out.println(direction.toString());
//            System.out.println(direction.next());
//            System.out.println(direction.previous());
//            System.out.println(direction.toUnitVector());
//
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//            return;
//        }

        Application.launch(SimulationApp.class, args);

//
//        Animal pet=new Animal();
//        System.out.println(pet.toString());
//
//        System.out.println(pet.toString());
//        List<Simulation> simulations = new ArrayList<>();
//        ConsoleMapDisplay observer=new ConsoleMapDisplay();
//        try {
//        List<MoveDirection> directions1 = OptionsParser.dirs(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        for (int i = 0; i < 1000; i++) {
//            AbstractWorldMap map;
//            if (i % 2 == 0) {
//                map = new RectangularMap(10,10);
//            } else {
//                map = new GrassField(10);
//            }
//            map.addObserver(observer);
//            Simulation simulation = new Simulation(positions,directions1,map);
//            simulations.add(simulation);
//        }
//
//            SimulationEngine engine = new SimulationEngine(simulations);
//            engine.runAsyncInThreadPool();
//            engine.awaitSimulationsEnd();
//
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//            return;
//        }


        System.out.println("system zakonczyl dzialanie");
    }

}

