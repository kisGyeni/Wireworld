import static org.junit.Assert.*;

import sample.Cell;
import sample.CellType;

import org.junit.Test;

public class cellTest {

	@Test
	public void cellKonstruktorTest() {
		Cell cell= new Cell(5,5);
		Assert.assertNotNull(cell);
		Assert.assertEquals(CellType.WIRE, cell.brush);
		Assert.assertEquals(false, cell.cycleMode);
	}
	
	@Test
	public void createCellTest() {
		Cell cell= new Cell(5,5);
		cell.createCellAt(5, 5);
		Assert.assertEquals(CellType.WIRE, cell.brush);
		Assert.assertEquals(false, cell.cycleMode);
	}
	
	@Test
	public void makeToColorTest() {
		Cell cell= new Cell(5,5);
		cell.makeToColor(CellType.HEAD);
		Assert.assertEquals(CellType.HEAD, cell.brush);
	}	

}
