package de.testdb;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.db.DBWriter;
import de.db.DataGenerator;
import de.db.DataGeneratorImpl;
import de.db.datamodel.Kunde;
import de.db.datamodel.Produkt;
import de.db.datamodel.Warenkorb;
import de.db.datamodel.WarenkorbProdukt;

public class TestDataGenerator {

	private DataGenerator classUnderTest;
	private DBWriter mock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		IMocksControl mockControl = createControl();
		mock = mockControl.createMock(DBWriter.class);
		classUnderTest = new DataGeneratorImpl(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerate() {
		long anzKunde = 5;
		long anzProdukte = 5;
		long anzWarenkoerbe = 3;
		long anzProdukteInWarenkorb = 2;

		Kunde kunde0 = new Kunde(0, "Customer0", 0);
		Kunde kunde1 = new Kunde(1, "Customer1", 1);
		Kunde kunde2 = new Kunde(2, "Customer2", 2);
		Kunde kunde3 = new Kunde(3, "Customer3", 3);
		Kunde kunde4 = new Kunde(4, "Customer4", 4);

		mock.write(kunde0);
		mock.write(kunde1);
		mock.write(kunde2);
		mock.write(kunde3);
		mock.write(kunde4);

		Produkt produkt0 = new Produkt(0, "Product0", 1);
		Produkt produkt1 = new Produkt(1, "Product1", 1);
		Produkt produkt2 = new Produkt(2, "Product2", 1);
		Produkt produkt3 = new Produkt(3, "Product3", 1);
		Produkt produkt4 = new Produkt(4, "Product4", 1);

		mock.write(produkt0);
		mock.write(produkt1);
		mock.write(produkt2);
		mock.write(produkt3);
		mock.write(produkt4);

		Warenkorb warenkorb0 = new Warenkorb(0, 0);
		Warenkorb warenkorb1 = new Warenkorb(1, 1);
		Warenkorb warenkorb2 = new Warenkorb(2, 2);

		Warenkorb warenkorb3 = new Warenkorb(3, 0);
		Warenkorb warenkorb4 = new Warenkorb(4, 1);
		Warenkorb warenkorb5 = new Warenkorb(5, 2);

		Warenkorb warenkorb6 = new Warenkorb(6, 0);
		Warenkorb warenkorb7 = new Warenkorb(7, 1);
		Warenkorb warenkorb8 = new Warenkorb(8, 2);

		Warenkorb warenkorb9 = new Warenkorb(9, 0);
		Warenkorb warenkorb10 = new Warenkorb(10, 1);
		Warenkorb warenkorb11 = new Warenkorb(11, 2);

		Warenkorb warenkorb12 = new Warenkorb(12, 0);
		Warenkorb warenkorb13 = new Warenkorb(13, 1);
		Warenkorb warenkorb14 = new Warenkorb(14, 2);

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

		WarenkorbProdukt warenkorbProdukt0 = new WarenkorbProdukt(0, 0, 0);
		WarenkorbProdukt warenkorbProdukt1 = new WarenkorbProdukt(1, 0, 1);
		WarenkorbProdukt warenkorbProdukt2 = new WarenkorbProdukt(2, 1, 2);
		WarenkorbProdukt warenkorbProdukt3 = new WarenkorbProdukt(3, 1, 3);
		WarenkorbProdukt warenkorbProdukt4 = new WarenkorbProdukt(4, 2, 4);
		WarenkorbProdukt warenkorbProdukt5 = new WarenkorbProdukt(5, 2, 0);
		WarenkorbProdukt warenkorbProdukt6 = new WarenkorbProdukt(6, 3, 1);
		WarenkorbProdukt warenkorbProdukt7 = new WarenkorbProdukt(7, 3, 2);
		WarenkorbProdukt warenkorbProdukt8 = new WarenkorbProdukt(8, 4, 3);
		WarenkorbProdukt warenkorbProdukt9 = new WarenkorbProdukt(9, 4, 4);
		WarenkorbProdukt warenkorbProdukt10 = new WarenkorbProdukt(10, 5, 0);
		WarenkorbProdukt warenkorbProdukt11 = new WarenkorbProdukt(11, 5, 1);
		WarenkorbProdukt warenkorbProdukt12 = new WarenkorbProdukt(12, 6, 2);
		WarenkorbProdukt warenkorbProdukt13 = new WarenkorbProdukt(13, 6, 3);
		WarenkorbProdukt warenkorbProdukt14 = new WarenkorbProdukt(14, 7, 4);
		WarenkorbProdukt warenkorbProdukt15 = new WarenkorbProdukt(15, 7, 0);
		WarenkorbProdukt warenkorbProdukt16 = new WarenkorbProdukt(16, 8, 1);
		WarenkorbProdukt warenkorbProdukt17 = new WarenkorbProdukt(17, 8, 2);
		WarenkorbProdukt warenkorbProdukt18 = new WarenkorbProdukt(18, 9, 3);
		WarenkorbProdukt warenkorbProdukt19 = new WarenkorbProdukt(19, 9, 4);
		WarenkorbProdukt warenkorbProdukt20 = new WarenkorbProdukt(20, 10, 0);
		WarenkorbProdukt warenkorbProdukt21 = new WarenkorbProdukt(21, 10, 1);
		WarenkorbProdukt warenkorbProdukt22 = new WarenkorbProdukt(22, 11, 2);
		WarenkorbProdukt warenkorbProdukt23 = new WarenkorbProdukt(23, 11, 3);
		WarenkorbProdukt warenkorbProdukt24 = new WarenkorbProdukt(24, 12, 4);
		WarenkorbProdukt warenkorbProdukt25 = new WarenkorbProdukt(25, 12, 0);
		WarenkorbProdukt warenkorbProdukt26 = new WarenkorbProdukt(26, 13, 1);
		WarenkorbProdukt warenkorbProdukt27 = new WarenkorbProdukt(27, 13, 2);
		WarenkorbProdukt warenkorbProdukt28 = new WarenkorbProdukt(28, 14, 3);
		WarenkorbProdukt warenkorbProdukt29 = new WarenkorbProdukt(29, 14, 4);

		mock.write(warenkorbProdukt0);
		mock.write(warenkorbProdukt1);
		mock.write(warenkorbProdukt2);
		mock.write(warenkorbProdukt3);
		mock.write(warenkorbProdukt4);
		mock.write(warenkorbProdukt5);
		mock.write(warenkorbProdukt6);
		mock.write(warenkorbProdukt7);
		mock.write(warenkorbProdukt8);
		mock.write(warenkorbProdukt9);
		mock.write(warenkorbProdukt10);
		mock.write(warenkorbProdukt11);
		mock.write(warenkorbProdukt12);
		mock.write(warenkorbProdukt13);
		mock.write(warenkorbProdukt14);
		mock.write(warenkorbProdukt15);
		mock.write(warenkorbProdukt16);
		mock.write(warenkorbProdukt17);
		mock.write(warenkorbProdukt18);
		mock.write(warenkorbProdukt19);
		mock.write(warenkorbProdukt20);
		mock.write(warenkorbProdukt21);
		mock.write(warenkorbProdukt22);
		mock.write(warenkorbProdukt23);
		mock.write(warenkorbProdukt24);
		mock.write(warenkorbProdukt25);
		mock.write(warenkorbProdukt26);
		mock.write(warenkorbProdukt27);
		mock.write(warenkorbProdukt28);
		mock.write(warenkorbProdukt29);

		replay(mock);

		classUnderTest.generate(anzKunde, anzProdukte, anzWarenkoerbe,
				anzProdukteInWarenkorb);

		verify(mock);

	}

}
