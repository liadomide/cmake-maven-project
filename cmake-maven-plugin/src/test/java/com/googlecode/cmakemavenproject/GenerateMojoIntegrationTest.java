package com.googlecode.cmakemavenproject;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import org.apache.maven.it.Verifier;

import org.junit.Test;

/**
 * A test of <code>GenerateMojo</code>.
 * 
 * @author Kevin S. Clarke <ksclarke@gmail.com>
 */
public class GenerateMojoIntegrationTest extends CMakeMojoIntegrationTest {

	/**
	 * Tests the generation of a very simple &quot;Hello World&quot; project.
	 * 
	 * @throws Exception If the test fails as a result of an exception
	 */
	@Test
	public void testGenerateHelloWorld() throws Exception {
		Verifier verifier = getVerifier("hello-world-test");
		
		verifier.displayStreamBuffers(); // We want to see test's System.out
		verifier.executeGoal("process-sources"); // Tests source generation
		verifier.resetStreams(); // Sets the System.out and System.err back

		verifier.verifyErrorFreeLog();
	}

}
