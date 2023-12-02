import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import sudoku.AlsInSolutionStep;
import sudoku.Candidate;
import sudoku.Chain;
import sudoku.ClipboardMode;
import sudoku.SolutionStep;
import sudoku.SolutionType;
import sudoku.Sudoku;


class HodokuTest {

	
	
	//for line 141
	@Test
	void node4Test() {
		
		ClipboardMode mode = ClipboardMode.LIBRARY;
		SolutionStep step = null;
		
		Sudoku test = new Sudoku();
		
		String text = test.getSudoku(mode, step);
		
		assertEquals(text , ":0000:x:.................................................................................:::");
	}
	
	//lines 153-155
	@Test
	void node10_11_131Test() {
		
		List<Integer> values = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
		}};
		
		Candidate cand1 = new Candidate(1,1);
		Candidate cand2 = new Candidate(2,2);
		Candidate cand3 = new Candidate(3,3);
		
		List<Candidate> cands = new ArrayList<Candidate>() {{
			add(cand1);
			add(cand2);
			add(cand3);
		}};
		
		ClipboardMode mode = ClipboardMode.LIBRARY;
		
		Sudoku test = new Sudoku();
		
		SolutionStep step = new SolutionStep(SolutionType.NICE_LOOP); //nice_loop is for line 355-356 and lines 153-155 so true is returned in if statements
		
		step.setCandidatesToDelete(cands);
		
		step.setValues(values);
		
		step.setIsSiamese(true);
		
		step.clone();

		String text = test.getSudoku(mode,(SolutionStep) step.clone());
		assertEquals(text , ":xxxx:123:.................................................................................::112 213 314::-1");
		
	}
	
	//covers nodes 20,27,28,29,30,31,32,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,54,55,62,63,64,65,69,70,72,73,77,78,79,80,81,82,83,84,85,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109 (lines 184-312)
	@Test
	void candFishTest2() {
		
		int [] chanar1 = {1, 2, 3};
		int [] chanar2 = {4, 5, 6};
		
		Chain chain1 = new Chain(0, 2, chanar1);
		Chain chain2 = new Chain(0, 2, chanar2);
		
		List<Chain> chains = new ArrayList<Chain>() {{
			add(chain1);
			add(chain2);
		}};
		
		List<Integer> values = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
		}};
		
		List<Integer> indices = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
		}};
		
		Candidate cand1 = new Candidate(1,1);
		Candidate cand2 = new Candidate(2,2);
		Candidate cand3 = new Candidate(3,3);
		
		List<Candidate> cands = new ArrayList<Candidate>() {{
			add(cand1);
			add(cand2);
			add(cand3);
		}};
		
		ClipboardMode mode = ClipboardMode.PM_GRID_WITH_STEP;
		
		Sudoku test = new Sudoku();
		
		SolutionStep step = new SolutionStep(SolutionType.MUTANT_SQUIRMBAG);
		
		step.setFins(cands);
		step.setEndoFins(cands);
		
		step.setChains(chains);
		
		step.setCandidatesToDelete(cands); //for lines 264-268
		
		step.setValues(values);
		
		step.setIndices(indices);
		
		step.clone();
		
		AlsInSolutionStep als = new AlsInSolutionStep();
		AlsInSolutionStep als2 = new AlsInSolutionStep();
		
		als.setCandidates(values);
		als.setIndices(indices);
		
		als2.setCandidates(values);
		als2.setIndices(indices);
		
		List<AlsInSolutionStep> alses = new ArrayList<AlsInSolutionStep>() {{
			add(als);
			add(als2);
		}};


		String text = test.getSudoku(mode,(SolutionStep) step.clone());
		assertEquals(text , ".---------.---------.---------.\r\n"
				+ "| *  @  @ | @  .  . | .  .  . |\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ ":---------+---------+---------:\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ ":---------+---------+---------:\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ "| .  .  . | .  .  . | .  .  . |\r\n"
				+ "'---------'---------'---------'\r\n"
				+ "Mutant Squirmbag: 1   fr1c2 fr1c3 fr1c4 efr1c2 efr1c3 efr1c4 => r1c2<>1, r1c3<>2, r1c4<>3");
		
	}
	
	//for lines 144, 145 and 161 (path 6,7,8,9,10 is infeasible as there is no fish and candtodelinlibraryformat types)
	@Test
	void node7_15_16Test() {
		
		List<Integer> values = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
		}};
		

		ClipboardMode mode = ClipboardMode.LIBRARY;
		
		Sudoku test = new Sudoku();
		
		SolutionStep step = new SolutionStep(SolutionType.MUTANT_SQUIRMBAG);
		
		step.setValues(values);
		
		step.setIsSiamese(true);
		
		step.clone();

		String text = test.getSudoku(mode,(SolutionStep) step.clone());
		assertEquals(text , ":03531:123:.................................................................................::::");
		
	}
	 
}
