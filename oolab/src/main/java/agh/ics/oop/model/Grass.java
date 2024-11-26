package agh.ics.oop.model;

public class Grass implements WorldElement{
    private final Vector2d location;
    public Grass(Vector2d position) {
        this.location = position;
    }
    public Vector2d getLocation() {
        return location;
    }

    public String toString() {
        return "*";
    }
}
