package hazi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import sample.InGameScene;
import sample.Cell;

import org.junit.Assert;
import org.junit.Test;

public class ingamesceneTest {

	@Test
	public void inGameSceneKonstruktorTest() {
		InGameScene scene = new InGameScene();
		Assert.assertNotNull(scene);
	}
	
	@Test
	public void getRootPaneTest() {
		InGameScene scene = new InGameScene();
		Assert.assertNotNull(scene.getRootPane());
	}
	
	@Test
	public void inGameSceneKonstruktor2Test() {
		ArrayList<ArrayList<Cell>> list = new ArrayList<ArrayList<Cell>>();
		ArrayList<Cell> cellList= new ArrayList<Cell>();
		cellList.add(new Cell(5,5));
		list.add(cellList);
		InGameScene scene = new InGameScene(list);
		Assert.assertNotNull(scene);
		Assert.assertArrayEquals(list, scene.grid);
	}

}
