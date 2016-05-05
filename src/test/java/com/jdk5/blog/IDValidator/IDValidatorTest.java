package com.jdk5.blog.IDValidator;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class IDValidatorTest extends TestCase {
	IDValidator validator = new IDValidator();

	/**
	 * Rigourous Test :-)
	 */
	public void test() {
		assertEquals(false, validator.isValid("152103198909218022"));
		
		String id15 = validator.makeID(true);
		System.out.println(id15);
		System.out.println(validator.getInfo(id15));
		assertTrue(validator.isValid(id15));
		String id18 = validator.makeID(false);
		System.out.println(id18);
		System.out.println(validator.getInfo(id18));
		assertTrue(validator.isValid(id18));
	}
}
