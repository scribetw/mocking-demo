package com.potix.demo.mocking;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

public class SimpleClassTest {
	@Injectable
	private SimpleService service;

	@Tested
	private SimpleClass testClass;

	@Test
	public void isLucky() {
		new Expectations() {{
			// when called service.generateLuckyNumber(), return 7
			service.generateLuckyNumber(); result = 7;
		}};

		Assert.assertTrue("You aren't lucky!", testClass.isLucky());
	}

	@Test
	public void isUnlucky() {
		new Expectations() {{
			service.generateLuckyNumber(); result = 666;
		}};

		Assert.assertFalse(testClass.isLucky());
	}

	@Test
	public void iamAlwaysLucky() {
		new MockUp<SimpleClass>() {
			@Mock private int getLuckyNumber() {
				return 666;
			}
		};

		new Expectations() {{
			service.generateLuckyNumber(); result = 666;
		}};

		Assert.assertTrue(testClass.isLucky());
	}
}
