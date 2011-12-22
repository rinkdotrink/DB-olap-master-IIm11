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
import de.datagenerator.datamodel.Kunde;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.generator.KundenGenerator;

public class KundenGeneratorTest {

	private KundenGenerator classUnderTest;
	private DBKundeWriter mock;
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
		mock = mockControl.createMock(DBKundeWriter.class);
		Creator creator = injector.getInstance(Creator.class);
		classUnderTest = new KundenGenerator(creator,mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateKunden_0() {
		long anzKunde = 0;
				
		mock.close();
		replay(mock);
		classUnderTest.generateKunden(anzKunde);
		verify(mock);
	}

	@Test
	public final void testGenerateKunden_1() {
		long anzKunde = 1;
				
		FactoryMethodProduct kunde0 = new Kunde(0, "Customer0", 0);
		mock.write(kunde0);
		mock.close();
		replay(mock);
		classUnderTest.generateKunden(anzKunde);
		verify(mock);
	}

	@Test
	public final void testGenerateKunden_4() {
		long anzKunde = 4;
		
		FactoryMethodProduct kunde0 = new Kunde(0, "Customer0", 0);
		FactoryMethodProduct kunde1 = new Kunde(1, "Customer1", 1);
		FactoryMethodProduct kunde2 = new Kunde(2, "Customer2", 2);
		FactoryMethodProduct kunde3 = new Kunde(3, "Customer3", 3);

		mock.write(kunde0);
		mock.write(kunde1);
		mock.write(kunde2);
		mock.write(kunde3);
		mock.close();

		replay(mock);
		classUnderTest.generateKunden(anzKunde);
		verify(mock);
	}

	@Test
	public final void testGenerateKunden_5() {
		long anzKunde = 5;
		
		FactoryMethodProduct kunde0 = new Kunde(0, "Customer0", 0);
		FactoryMethodProduct kunde1 = new Kunde(1, "Customer1", 1);
		FactoryMethodProduct kunde2 = new Kunde(2, "Customer2", 2);
		FactoryMethodProduct kunde3 = new Kunde(3, "Customer3", 3);
		FactoryMethodProduct kunde4 = new Kunde(4, "Customer4", 4);

		mock.write(kunde0);
		mock.write(kunde1);
		mock.write(kunde2);
		mock.write(kunde3);
		mock.write(kunde4);
		mock.close();

		replay(mock);
		classUnderTest.generateKunden(anzKunde);
		verify(mock);
	}

}
