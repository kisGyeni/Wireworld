import static org.junit.Assert.*;
import sample.MenuScene;

import org.junit.Test;

import sample.SaveScene;

public class menusceneTest {


	@Test
	public void menuSceneKonstruktorTest() {
		MenuScene scene = new MenuScene();
		Assert.assertNotNull(scene);
	}
	
	@Test
	public void getRootPaneTest() {
		MenuScene scene = new MenuScene();
		Assert.assertNotNull(scene.getRootPane());
	}

}
