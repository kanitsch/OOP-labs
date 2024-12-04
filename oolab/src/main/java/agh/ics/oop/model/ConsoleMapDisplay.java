package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int oczymane=0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println(message);
        System.out.println(worldMap);
        oczymane++;
        System.out.println("number of occurred updates: "+oczymane+"\n");
    }
}
