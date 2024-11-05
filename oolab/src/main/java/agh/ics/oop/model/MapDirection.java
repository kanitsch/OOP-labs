package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        return switch(this) {
            case NORTH -> "Polnoc";
            case SOUTH -> "Poludnie";
            case EAST -> "Wschod";
            case WEST -> "Zachod";
        };
    }

    public MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public MapDirection previous(){
        return switch (this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }

    public Vector2d toUnitVector(){
        int x=switch (this){
            case NORTH, SOUTH -> 0;
            case EAST -> 1;
            case WEST -> -1;
        };
        int y=switch(this){
            case EAST, WEST -> 0;
            case NORTH -> 1;
            case SOUTH -> -1;
        };
        return new Vector2d(x,y);
    }
}
