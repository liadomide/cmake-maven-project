package com.googlecode.cmakemavenproject;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.apache.maven.artifact.factory.DefaultArtifactFactory;
import org.sonatype.aether.impl.internal.DefaultArtifactResolver;

/**
 * JUnit suite that tests the integration of <code>GenerateMojo</code>,
 * <code>CompileMojo</code>, and <code>TestMojo</code>. Instead of having one
 * massive integration test that does it all, this JUnit suite pulls together
 * three distinct, but interdependent, integration tests in a specific order.
 * 
 * @author Kevin S. Clarke <ksclarke@gmail.com>
 */
@RunWith(Suite.class)
@SuiteClasses({ GenerateMojoIntegrationTest.class,
		CompileMojoIntegrationTest.class, TestMojoIntegrationTest.class })
public class CMakeMojoIntegrationSuite {}
