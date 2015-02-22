package com.microtripit.mandrillapp.lutung.util;

import junit.framework.Assert;

import org.junit.Test;

public class AllowingStartingWithUnderscoreStrategyTest {

	AllowingStartingWithUnderscoreStrategy strategy = new AllowingStartingWithUnderscoreStrategy(); 
	
	@Test
	public void test01(){
		Assert.assertEquals("_id", strategy.translate("_id"));
		Assert.assertEquals("message_id", strategy.translate("messageId"));
	}
	
}
