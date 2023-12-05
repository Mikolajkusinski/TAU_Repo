import org.example.MazeGame;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;


public class GameTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testMoveLeft() {
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.moveLeft();
        String capturedOutput = systemOutRule.getLog();
        assertEquals("Wrong direction, choose another way!", capturedOutput.trim());
    }

    @Test
    public void testMoveRight() {
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.moveRight();
        assertEquals(1, mazeGame.getPlayerCol());
    }

    @Test
    public void testMoveUp() {
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.moveUp();
        String capturedOutput = systemOutRule.getLog();
        assertTrue(capturedOutput.contains("Wrong direction, choose another way!"));
    }

    @Test
    public void testMoveDown() {
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.moveDown();
        assertEquals(1, mazeGame.getPlayerRow());
    }

    @Test
    public void testGameWin() {
        systemInMock.provideText("\nR\nR\nR\nR\nD\nD\nD\nD\n");
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.playGame(); // Assuming the correct sequence of moves to reach the destination
        String capturedOutput = systemOutRule.getLog();
        String[] lines = capturedOutput.split(System.lineSeparator());
        assertTrue( capturedOutput.contains("Congratulations! You reached the destination!"));
    }

    @Test
    public void testGameQuit() {
        systemInMock.provideText("Q\n");
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.playGame();
        String capturedOutput = systemOutRule.getLog();
        assertTrue(capturedOutput.contains("Game Over. Quitting..."));
    }

}
