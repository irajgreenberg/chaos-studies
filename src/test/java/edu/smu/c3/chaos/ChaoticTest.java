/** ChaoticTest.java
 * @author Yong Bakos
 * @since 0.0.1
 */
package edu.smu.c3.chaos;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;
import org.junit.*;

public class ChaoticTest {
	
	private Chaotic chaotic;
	
	@Before
	public void setup() {
		ChaosSketch sketch = new ChaosSketch();
		sketch.width = 500;
		sketch.height = 500;
		chaotic = new Chaotic(sketch);
	}
	
	@Test
	public void testUninitializedWidth() {
		ChaosSketch defaultSketch = new ChaosSketch();
		chaotic = new Chaotic(defaultSketch);
		assertEquals(ChaosSketch.DEFAULT_WIDTH, chaotic.width);
		assertEquals(defaultSketch.width, chaotic.width);
	}
	
	@Test
	public void testUninitializedHeight() {
		ChaosSketch defaultSketch = new ChaosSketch();
		chaotic = new Chaotic(defaultSketch);
		assertEquals(ChaosSketch.DEFAULT_HEIGHT, chaotic.height);
		assertEquals(defaultSketch.height, chaotic.height);
	}
	
	@Test
	public void widthValueShouldBeSimilarToButNotExactlyLikeDesiredWidth() {
		int desiredWidth = 1000;
		int chaoticWidth = chaotic.width(desiredWidth);
		assertNotEquals(desiredWidth, chaoticWidth);
		assertEquals(desiredWidth, chaoticWidth, chaotic.C_DIMENSION * desiredWidth);
	}
	
	@Test
	public void heightValueShouldBeSimilarToButNotExactlyLikeDesiredHeight() {
		int desiredHeight = 1000;
		int chaoticHeight = chaotic.height(desiredHeight);
		assertNotEquals(desiredHeight, chaoticHeight);
		assertEquals(desiredHeight, chaoticHeight, chaotic.C_DIMENSION * desiredHeight);
	}
	
}