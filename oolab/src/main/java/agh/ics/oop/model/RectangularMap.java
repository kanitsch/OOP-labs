package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;
    public  RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public Map<Vector2d,Animal> getAnimals() {
        return animals;
    }

//    public String toString(){
//        MapVisualizer map = new MapVisualizer(this);
//        return map.draw(new Vector2d(0,0), new Vector2d(width,height));
//    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.getX()>width || position.getY()>height
                || position.getX()<0 || position.getY()<0)
        {
            return false;
        }
        return !isOccupied(position);
    }

    @Override
    public Boundary getCurrentBounds(){
        return new Boundary(new Vector2d(0,0), new Vector2d(width,height));
    }
}
