package agh.ics.oop.model;

import javax.swing.text.Position;
import java.util.Iterator;
import java.util.List;

public class PositionIterator implements Iterator<Vector2d> {
    private final Iterator<Vector2d> iterator;
    private List<Vector2d> positions;
    public PositionIterator(List<Vector2d> positions) {
        this.iterator = positions.iterator();
        this.positions = positions;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Vector2d next() {
        return iterator.next();
    }
}

