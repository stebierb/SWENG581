package sudoku;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import generator.SudokuGenerator;
import generator.SudokuGeneratorFactory;
import solver.SudokuSolver;
import solver.SudokuSolverFactory;
import generator.BackgroundGenerator;




class SudokuGeneratorUnitTests {

	//We are testing the BackgroundGenerator.generate() method
	//This method appears to have two different outputs depending on the number of arguments supplied
	//If dlg is supplied, it returns a Sudoku2 object
	//If dlg is not supplied, it returns a String object
	//DifficultyType can be EASY, MEDIUM, HARD, UNFAIR, EXTREME
	//GameMode can be LEARNING, PLAYING, PRACTICING
	//MaxScore appears to be a required dependency to generate a puzzle. If it is not supplied, the method appears to time out after 10 seconds and return null
	//This MaxScore behavior is probably a bug or at least oversight. When DifficultyType is set, MaxScore should also be set if they are 1:1 mapped.
	//Testing as if this is expected behavior, but would raise this issue to the dev team
	
	@Mock
	private SudokuGeneratorFactory sudokuGeneratorFactory;

	@Mock
	private GenerateSudokuProgressDialog generateSudokuProgressDialog;



	@BeforeEach
	void setUp() throws Exception {
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
    @Test
    public void testGenerate() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EASY; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PLAYING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(1000);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	String testsudoku = testsgenerator.generate(testlevel, testgamemode);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof String);
    	assertEquals(testsudoku.length(), 81);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EASY_PLAYING_absent_800() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EASY; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PLAYING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(800);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	String testsudoku = testsgenerator.generate(testlevel, testgamemode);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof String);
    	assertEquals(testsudoku.length(), 81);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EASY_PRACTICING_absent_800() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EASY; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PRACTISING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(800);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	String testsudoku = testsgenerator.generate(testlevel, testgamemode);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof String);
    	assertEquals(testsudoku.length(), 81);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EXTREME_PRACTICING_absent_800() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EXTREME; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PRACTISING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(800);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	String testsudoku = testsgenerator.generate(testlevel, testgamemode);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof String);
    	assertEquals(testsudoku.length(), 81);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EASY_LEARNING_absent_2147483647() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EASY; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.LEARNING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(2147483647);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	String testsudoku = testsgenerator.generate(testlevel, testgamemode);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof String);
    	assertEquals(testsudoku.length(), 81);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EXTREME_LEARNING_absent_2147483647() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EXTREME; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.LEARNING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(2147483647);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	String testsudoku = testsgenerator.generate(testlevel, testgamemode);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof String);
    	assertEquals(testsudoku.length(), 81);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EXTREME_LEARNING_null_800() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EXTREME; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.LEARNING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(800);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	Sudoku2 testsudoku = testsgenerator.generate(testlevel, testgamemode, null);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof Sudoku2);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EXTREME_PLAYING_null_800() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EXTREME; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PLAYING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(800);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	Sudoku2 testsudoku = testsgenerator.generate(testlevel, testgamemode, null);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof Sudoku2);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EASY_LEARNING_null_2147483647() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EASY; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.LEARNING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(2147483647);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	Sudoku2 testsudoku = testsgenerator.generate(testlevel, testgamemode, null);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof Sudoku2);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EXTREME_PLAYING_null_2147483647() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EXTREME; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PLAYING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(2147483647);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	Sudoku2 testsudoku = testsgenerator.generate(testlevel, testgamemode, null);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof Sudoku2);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EASY_PRACTICING_null_2147483647() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EASY; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PRACTISING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(2147483647);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	Sudoku2 testsudoku = testsgenerator.generate(testlevel, testgamemode, null);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof Sudoku2);
    	
        // assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGenerate_EXTREME_PRACTICING_null_2147483647() {	//testing output format for expected response format

    	DifficultyType difftest = DifficultyType.EXTREME; //EASY, MEDIUM, HARD, UNFAIR, EXTREME
    	DifficultyLevel testlevel = new DifficultyLevel();
    	
    	GameMode testgamemode = GameMode.PRACTISING;
    	
    	testlevel.setType(difftest);
    	testlevel.setMaxScore(2147483647);
    	
    	BackgroundGenerator testsgenerator =  new BackgroundGenerator();

    	Sudoku2 testsudoku = testsgenerator.generate(testlevel, testgamemode, null);
    	System.out.println(testsudoku);
    	
    	assertTrue(testsudoku instanceof Sudoku2);
    	
        // assertEquals(expectedResult, result);
    }
    
		

}
