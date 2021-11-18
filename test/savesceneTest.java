import static org.junit.Assert.*;
import sample.SaveScene;

import org.junit.Test;

import sample.LoadScene;

public class savesceneTest {


	@Test
	public void saveSceneKonstruktorTest() {
		SaveScene scene = new SaveScene();
		Assert.assertNotNull(scene);
	}
	
	@Test
	public void getRootPaneTest() {
		SaveScene scene = new SaveScene();
		Assert.assertNotNull(scene.getRootPane());
	}

}
