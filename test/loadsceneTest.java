import static org.junit.Assert.*;
import sample.LoadScene;

import org.junit.Test;

public class loadsceneTest {

	@Test
	public void loadSceneKonstruktorTest() {
		LoadScene scene = new LoadScene();
		Assert.assertNotNull(scene);
	}
	
	@Test
	public void getRootPaneTest() {
		LoadScene scene = new LoadScene();
		Assert.assertNotNull(scene.getRootPane());
	}
}
