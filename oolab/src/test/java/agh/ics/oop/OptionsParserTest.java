package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class OptionsParserTest {
    @Test
    public void dirsTest(){
        String[] args= {"f", "f", "g", "b", "l", "r", "fg"};
        List<MoveDirection> solved = Arrays.asList(
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT
        );
        assertEquals(solved, OptionsParser.dirs(args));

    }
    @Test
    public void emptyArgs(){
        String[] args= {};
        List<MoveDirection> solved= new ArrayList<>();
        assertEquals(solved, OptionsParser.dirs(args));
    }


}