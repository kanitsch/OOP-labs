package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        //given
        MapDirection w=MapDirection.WEST;
        MapDirection e=MapDirection.EAST;
        MapDirection n=MapDirection.NORTH;
        MapDirection s=MapDirection.SOUTH;

        //when
        MapDirection wNext=w.next();
        MapDirection eNext=e.next();
        MapDirection nNext=n.next();
        MapDirection sNext=s.next();

        //then
        assertEquals(MapDirection.NORTH,wNext);
        assertEquals(MapDirection.SOUTH,eNext);
        assertEquals(MapDirection.EAST,nNext);
        assertEquals(MapDirection.WEST,sNext);

    }

    @Test
    void previous() {
        //given
        MapDirection w=MapDirection.WEST;
        MapDirection e=MapDirection.EAST;
        MapDirection n=MapDirection.NORTH;
        MapDirection s=MapDirection.SOUTH;

        //when
        MapDirection wPrev=w.previous();
        MapDirection ePrev=e.previous();
        MapDirection nPrev=n.previous();
        MapDirection sPrev=s.previous();

        //then
        assertEquals(MapDirection.SOUTH,wPrev);
        assertEquals(MapDirection.NORTH,ePrev);
        assertEquals(MapDirection.WEST,nPrev);
        assertEquals(MapDirection.EAST,sPrev);
    }



}