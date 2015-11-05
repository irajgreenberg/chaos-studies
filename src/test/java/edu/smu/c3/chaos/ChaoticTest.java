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
		chaotic = new Chaotic();
	}
	
	@Test
	public void testWidth() {
		int width = 1000;
		assertEquals(width, chaotic.width(width), chaotic.C_DIMENSION * width);
	}
	
	@Test
	public void testHeight() {
		int height = 1000;
		assertEquals(height, chaotic.width(height), chaotic.C_DIMENSION * height);
	}
	
}