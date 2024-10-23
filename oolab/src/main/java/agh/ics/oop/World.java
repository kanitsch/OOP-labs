package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void run(MoveDirection[] directions) {
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
        MoveDirection[] directions = OptionsParser.dirs(args);

        run(directions);
        System.out.println("system zakonczyl dzialanie");
    }

}

