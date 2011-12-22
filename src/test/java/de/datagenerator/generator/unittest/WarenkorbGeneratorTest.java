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
import de.datagenerator.datamodel.Warenkorb;
import de.datagenerator.dbwriter.DBWarenkorbWriter;
import de.datagenerator.generator.WarenkorbGenerator;

public class WarenkorbGeneratorTest {

	private WarenkorbGenerator classUnderTest;
	private DBWarenkorbWriter mock;	
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
		mock = mockControl.createMock(DBWarenkorbWriter.class);
		Creator creator = injector.getInstance(Creator.class);
		classUnderTest = new WarenkorbGenerator(creator,mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateWarenkorb_0_0() {
		long anzKunde = 0;
		long anzWarenkoerbe = 0;

		mock.close();

		replay(mock);
		classUnderTest.generateWarenkorb(anzKunde, anzWarenkoerbe);
		verify(mock);
	}

	@Test
	public final void testGenerateWarenkorb_1_1() {
		long anzKunde = 1;
		long anzWarenkoerbe = 1;

		FactoryMethodProduct warenkorb0 = new Warenkorb(0, 0);
		mock.write(warenkorb0);
		mock.close();

		replay(mock);
		classUnderTest.generateWarenkorb(anzKunde, anzWarenkoerbe);
		verify(mock);
	}

	@Test
	public final void testGenerateWarenkorb_4_2() {
		long anzKunde = 4;
		long anzWarenkoerbe = 2;

		FactoryMethodProduct warenkorb0 = new Warenkorb(0, 0);
		FactoryMethodProduct warenkorb1 = new Warenkorb(1, 0);
		FactoryMethodProduct warenkorb2 = new Warenkorb(2, 1);
		FactoryMethodProduct warenkorb3 = new Warenkorb(3, 1);
		FactoryMethodProduct warenkorb4 = new Warenkorb(4, 2);
		FactoryMethodProduct warenkorb5 = new Warenkorb(5, 2);
		FactoryMethodProduct warenkorb6 = new Warenkorb(6, 3);
		FactoryMethodProduct warenkorb7 = new Warenkorb(7, 3);

		mock.write(warenkorb0);
		mock.write(warenkorb1);
		mock.write(warenkorb2);
		mock.write(warenkorb3);
		mock.write(warenkorb4);
		mock.write(warenkorb5);
		mock.write(warenkorb6);
		mock.write(warenkorb7);
		mock.close();

		replay(mock);
		classUnderTest.generateWarenkorb(anzKunde, anzWarenkoerbe);
		verify(mock);
	}

	@Test
	public final void testGenerateWarenkorb_5_3() {
		long anzKunde = 5;
		long anzWarenkoerbe = 3;
		
		FactoryMethodProduct warenkorb0 = new Warenkorb(0, 0);
		FactoryMethodProduct warenkorb1 = new Warenkorb(1, 0);
		FactoryMethodProduct warenkorb2 = new Warenkorb(2, 0);
		FactoryMethodProduct warenkorb3 = new Warenkorb(3, 1);
		FactoryMethodProduct warenkorb4 = new Warenkorb(4, 1);
		FactoryMethodProduct warenkorb5 = new Warenkorb(5, 1);
		FactoryMethodProduct warenkorb6 = new Warenkorb(6, 2);
		FactoryMethodProduct warenkorb7 = new Warenkorb(7, 2);
		FactoryMethodProduct warenkorb8 = new Warenkorb(8, 2);
		FactoryMethodProduct warenkorb9 = new Warenkorb(9, 3);
		FactoryMethodProduct warenkorb10 = new Warenkorb(10, 3);
		FactoryMethodProduct warenkorb11 = new Warenkorb(11, 3);
		FactoryMethodProduct warenkorb12 = new Warenkorb(12, 4);
		FactoryMethodProduct warenkorb13 = new Warenkorb(13, 4);
		FactoryMethodProduct warenkorb14 = new Warenkorb(14, 4);

		mock.write(warenkorb0);
		mock.write(warenkorb1);
		mock.write(warenkorb2);
		mock.write(warenkorb3);
		mock.write(warenkorb4);
		mock.write(warenkorb5);
		mock.write(warenkorb6);
		mock.write(warenkorb7);
		mock.write(warenkorb8);
		mock.write(warenkorb9);
		mock.write(warenkorb10);
		mock.write(warenkorb11);
		mock.write(warenkorb12);
		mock.write(warenkorb13);
		mock.write(warenkorb14);
		mock.close();

		replay(mock);
		classUnderTest.generateWarenkorb(anzKunde, anzWarenkoerbe);
		verify(mock);
	}

}
