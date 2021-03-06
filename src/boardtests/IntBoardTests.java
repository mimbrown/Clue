package boardtests;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import board.BoardCell;
import board.IntBoard;


public class IntBoardTests {
	private IntBoard board;
	@Before
	public void setupBoard(){
		board = new IntBoard();
	}

	@Test
	public void testAdjacencyTopLeft(){
		BoardCell cell = board.getCell(0,0);
		LinkedList<BoardCell> testList = board.getAdjList(cell);
		Assert.assertTrue(testList.contains(board.getCell(1,0)));
		Assert.assertTrue(testList.contains(board.getCell(0,1)));
		Assert.assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacencyTopRight(){
		BoardCell cell = board.getCell(0,3);
		LinkedList<BoardCell> testList = board.getAdjList(cell);
		Assert.assertTrue(testList.contains(board.getCell(0,2)));
		Assert.assertTrue(testList.contains(board.getCell(1,3)));
		Assert.assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacencyBottomLeft(){
		BoardCell cell = board.getCell(3,0);
		LinkedList<BoardCell> testList = board.getAdjList(cell);
		Assert.assertTrue(testList.contains(board.getCell(2,0)));
		Assert.assertTrue(testList.contains(board.getCell(3,1)));
		Assert.assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacencyBottomRight(){
		BoardCell cell = board.getCell(3,3);
		LinkedList<BoardCell> testList = board.getAdjList(cell);
		Assert.assertTrue(testList.contains(board.getCell(2,3)));
		Assert.assertTrue(testList.contains(board.getCell(3,2)));
		Assert.assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacencyMidish(){
		BoardCell cell = board.getCell(2,1);
		LinkedList<BoardCell> testList = board.getAdjList(cell);
		Assert.assertTrue(testList.contains(board.getCell(1,1)));
		Assert.assertTrue(testList.contains(board.getCell(3,1)));
		Assert.assertTrue(testList.contains(board.getCell(2,2)));
		Assert.assertTrue(testList.contains(board.getCell(2,0)));
		Assert.assertEquals(4, testList.size());
	}

	@Test
	public void testTargets0_3()
	{
		BoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 3);
		Set<BoardCell> targets = board.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(3, 0)));
		Assert.assertTrue(targets.contains(board.getCell(2, 1)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 2)));
		Assert.assertTrue(targets.contains(board.getCell(0, 3)));
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
	}
	@Test
	public void testTargets0_1_TopLeft()
	{
		BoardCell cell = board.getCell(0, 0);
		board.calcTargets(cell, 1);
		Set<BoardCell> targets = board.getTargets();
		Assert.assertEquals(2, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(1, 0)));
		Assert.assertTrue(targets.contains(board.getCell(0, 1)));
	}
	@Test
	public void testTargets0_1_TopRight()
	{
		BoardCell cell = board.getCell(0, 3);
		board.calcTargets(cell, 1);
		Set<BoardCell> targets = board.getTargets();
		Assert.assertEquals(2, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(1, 3)));
		Assert.assertTrue(targets.contains(board.getCell(0, 2)));
	}
	@Test
	public void testTargets0_1_BottomRight()
	{
		BoardCell cell = board.getCell(3, 3);
		board.calcTargets(cell, 1);
		Set<BoardCell> targets = board.getTargets();
		Assert.assertEquals(2, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(2, 3)));
		Assert.assertTrue(targets.contains(board.getCell(3, 2)));
	}
	@Test
	public void testTargets0_1_BottomLeft()
	{
		BoardCell cell = board.getCell(3, 0);
		board.calcTargets(cell, 1);
		Set<BoardCell> targets = board.getTargets();
		Assert.assertEquals(2, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(2, 0)));
		Assert.assertTrue(targets.contains(board.getCell(3, 1)));
	}
	@Test
	public void testTargets0_4()
	{
		BoardCell cell = board.getCell(1, 1);
		board.calcTargets(cell, 4);
		Set<BoardCell> targets = board.getTargets();
		Assert.assertEquals(8, targets.size());
		Assert.assertTrue(targets.contains(board.getCell(0, 0)));
		Assert.assertTrue(targets.contains(board.getCell(1, 1)));
		Assert.assertTrue(targets.contains(board.getCell(2, 0)));
		Assert.assertTrue(targets.contains(board.getCell(0, 2)));
		Assert.assertTrue(targets.contains(board.getCell(2, 2)));
		Assert.assertTrue(targets.contains(board.getCell(3, 3)));
		Assert.assertTrue(targets.contains(board.getCell(3, 1)));
		Assert.assertTrue(targets.contains(board.getCell(1, 3)));
	}


}
