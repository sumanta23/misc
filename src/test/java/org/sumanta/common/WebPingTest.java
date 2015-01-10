package org.sumanta.common;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import org.junit.Test;

public class WebPingTest {

	
	
	/**
	 * Test method for {@link org.sumanta.common.WebPing#ping(java.lang.String, int)}.
	 * @throws IOException 
	 */
	@Test(expected= ConnectException.class)
	public void testPingFail() throws IOException {
		assertFalse(WebPing.ping("127.0.0.1", 80));
	}
	
	@Test( expected= UnknownHostException.class)
	public void testPingSuccess() throws IOException {
		assertTrue(WebPing.ping("https://www.google.com", 80));
	}

}
