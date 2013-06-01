package com.googlecode.cmakemavenproject;

import java.io.File;
import java.io.IOException;

import java.util.Properties;

import org.apache.maven.it.VerificationException;
import org.apache.maven.it.Verifier;

import org.apache.maven.it.util.ResourceExtractor;

/**
 * An abstract test class that handles <code>Verifier</code> configuration.
 * 
 * @author Kevin S. Clarke <ksclarke@gmail.com>
 */
public abstract class CMakeMojoIntegrationTest {

	private static final String SETTINGS = "/settings.xml";
	private static final String CLEAN_PLUGIN_PATH = "/org/apache/maven/plugins/maven-clean-plugin";

	/**
	 * Returns a <code>Verifier</code> that has been configured to use the test
	 * repository along with the test project that was passed in as a variable.
	 * 
	 * @param testName The CMake Maven project to test
	 * @return A configured <code>Verifier</code>
	 * @throws IOException If there is a problem with configuration.
	 * @throws VerificationException If there is a problem with verification.
	 */
	protected Verifier getVerifier(String testName) throws IOException,
			VerificationException
	{
		Class<? extends CMakeMojoIntegrationTest> c = getClass();
		String name = testName.startsWith("/") ? testName : "/" + testName;
		File config = ResourceExtractor.simpleExtractResources(c, SETTINGS);
		File test = ResourceExtractor.simpleExtractResources(c, name);
		String settings = config.getAbsolutePath();

		// Construct a verifier that will run our integration tests
		Verifier verifier = new Verifier(test.getAbsolutePath(), settings);
		String cleanPluginPath = verifier.localRepo + CLEAN_PLUGIN_PATH;
		Properties properties = verifier.getVerifierProperties();

		// use.mavenRepoLocal instructs forked tests to use the local repo
		properties.setProperty("use.mavenRepoLocal", "true");

		verifier.setAutoclean(true); // Set so clean is run before the tests

		// If we have the clean plugin, the Maven jars are already installed
		if (new File(cleanPluginPath).exists()) {
			verifier.addCliOption("-o"); // offline saves unnecessary checks
		}

		return verifier;
	}

}
