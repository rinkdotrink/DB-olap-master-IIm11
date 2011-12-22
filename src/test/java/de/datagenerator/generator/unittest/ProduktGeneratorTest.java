package de.datagenerator.generator.unittest;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Produkt;
import de.datagenerator.dbwriter.DBProduktWriter;
import de.datagenerator.generator.ProduktGenerator;

public class ProduktGeneratorTest {

	private ProduktGenerator classUnderTest;
	private DBProduktWriter mock;
	private Injector injector = Guice.createInjector(new DBModule());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(DBProduktWriter.class);
		Creator creator = injector.getInstance(Creator.class);
		classUnderTest = new ProduktGenerator(creator,mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateProdukte_0() {
		long anzProdukte = 0;

		mock.close();
		replay(mock);
		classUnderTest.generateProdukte(anzProdukte);
		verify(mock);
	}

	@Test
	public final void testGenerateProdukte_1() {

		long anzProdukte = 1;

		FactoryMethodProduct produkt0 = new Produkt(0, "Product0", 1);
		mock.write(produkt0);
		mock.close();

		replay(mock);
		classUnderTest.generateProdukte(anzProdukte);
		verify(mock);

	}

	@Test
	public final void testGenerateProdukte_4() {
		long anzProdukte = 4;

		FactoryMethodProduct produkt0 = new Produkt(0, "Product0", 1);
		FactoryMethodProduct produkt1 = new Produkt(1, "Product1", 1);
		FactoryMethodProduct produkt2 = new Produkt(2, "Product2", 1);
		FactoryMethodProduct produkt3 = new Produkt(3, "Product3", 1);

		mock.write(produkt0);
		mock.write(produkt1);
		mock.write(produkt2);
		mock.write(produkt3);
		mock.close();

		replay(mock);
		classUnderTest.generateProdukte(anzProdukte);
		verify(mock);
	}

	@Test
	public final void testGenerateProdukte_5() {
		long anzProdukte = 5;

		FactoryMethodProduct produkt0 = new Produkt(0, "Product0", 1);
		FactoryMethodProduct produkt1 = new Produkt(1, "Product1", 1);
		FactoryMethodProduct produkt2 = new Produkt(2, "Product2", 1);
		FactoryMethodProduct produkt3 = new Produkt(3, "Product3", 1);
		FactoryMethodProduct produkt4 = new Produkt(4, "Product4", 1);

		mock.write(produkt0);
		mock.write(produkt1);
		mock.write(produkt2);
		mock.write(produkt3);
		mock.write(produkt4);
		mock.close();

		replay(mock);
		classUnderTest.generateProdukte(anzProdukte);
		verify(mock);
	}

}
