package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
	@Test
	public void testUtilIstErstesHalbjahr() {
		assertTrue(Util.istErstesHalbjahr(6));
		assertFalse(Util.istErstesHalbjahr(7));
	}
}
