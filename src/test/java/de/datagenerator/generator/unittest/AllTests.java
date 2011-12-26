package de.datagenerator.generator.unittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ KundenGeneratorTest.class, ProduktGeneratorTest.class,
   WarenkorbGeneratorTest.class, WarenkorbProduktGeneratorTest.class })
public class AllTests {

}
