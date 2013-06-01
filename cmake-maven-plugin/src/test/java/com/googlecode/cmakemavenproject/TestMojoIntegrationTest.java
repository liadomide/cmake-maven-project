package com.googlecode.cmakemavenproject;

import org.apache.maven.it.Verifier;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMojoIntegrationTest extends CMakeMojoIntegrationTest {

	@Test
	public void testGenerateHelloWorld() throws Exception {
		Verifier verifier = getVerifier("/hello-world-test");

		verifier.addCliOption("-Plinux");
		//verifier.executeGoal("compile");

		// verifier.verifyErrorFreeLog();
		// verifier.resetStreams();
	}

}
