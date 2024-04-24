package org.unibl.etf.javalangclasses;

import java.io.IOException;
import java.security.AccessControlException;

public class SecurityManagerTest {

	public static void main(String[] args) {
//		System.setProperty("java.home", "123456");
		System.out.println("java.home is : " + System.getProperty("java.home"));
		SecurityManager securityManager = new SecurityManager();
		System.setSecurityManager(securityManager);
		System.setProperty("java.home", "123456");
	}

}
