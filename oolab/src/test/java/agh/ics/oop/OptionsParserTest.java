package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    public void dirsTest(){
        String[] args= {"f", "f", "g", "b", "l", "r", "fg"};
        MoveDirection[] solved={MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT};

        assertArrayEquals(solved, OptionsParser.dirs(args));
    }


}