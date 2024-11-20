package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grass;
//    private final Map<Vector2d, Animal> animals;

    public GrassField(int numberOfGrass) {
        this.grass = new HashMap<>();
//        Random rand = new Random();
//        for (int i = 0; i < numberOfGrass; i++) {
//            Vector2d position;
//            do {
//                position = new Vector2d(rand.nextInt((int) sqrt(10 * numberOfGrass)), rand.nextInt((int) sqrt(10 * numberOfGrass)));
//            } while (isOccupied(position));
//            Grass newGrass = new Grass(position);
//            grass.put(position, newGrass);
        int maxWidth=(int)(sqrt(numberOfGrass*10));
        int maxHeight=(int)(sqrt(numberOfGrass*10));
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, numberOfGrass);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grass.put(grassPosition, new Grass(grassPosition));
        }

    }

//    @Override
//    public boolean place(Animal animal) {
//        if (canMoveTo(animal.getLocation())) {
//            animals.put(animal.getLocation(), animal);
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public void move(Animal animal, MoveDirection direction) {
//        Vector2d oldPosition = animal.getLocation();
//        animal.move(direction, this);
//        animals.remove(oldPosition);
//        animals.put(animal.getLocation(), animal);
//    }

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        return animals.containsKey(position) || grass.containsKey(position);
//    }

    @Override
    public WorldElement objectAt(Vector2d position) {

        if (super.objectAt(position)!=null){
            return super.objectAt(position);
        }
        return grass.get(position);
    }

//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        return !animals.containsKey(position);
//    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        Vector2d lowerLeft = lowerLeft();
        Vector2d upperRight = upperRight();
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

    private Vector2d upperRight() {
        if (grass.isEmpty() && animals.isEmpty()) {
            return new Vector2d(0, 0);
        }
        Vector2d upper = null;
        for (Vector2d position : grass.keySet()) {
            if (upper == null) {
                upper = position;
            } else {
                upper = upper.upperRight(position);
            }
        }
        for (Vector2d position : animals.keySet()) {
            if (upper == null) {
                upper = position;
            } else {
                upper = upper.upperRight(position);
            }
        }
        return upper;
    }

    private Vector2d lowerLeft() {
        if (grass.isEmpty() && animals.isEmpty()) {
            return new Vector2d(0, 0);
        }
        Vector2d lower = null;
        for (Vector2d position : grass.keySet()) {
            if (lower == null) {
                lower = position;
            } else {
                lower = lower.lowerLeft(position);
            }
        }
        for (Vector2d position : animals.keySet()) {
            if (lower == null) {
                lower = position;
            } else {
                lower = lower.lowerLeft(position);
            }
        }
        return lower;
    }
    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements=super.getElements();
        elements.addAll(grass.values());
        return elements;
    }
}
