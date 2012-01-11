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
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.WKorbProdukt;
import de.datagenerator.dbwriter.DBWKorbProduktWriter;
import de.datagenerator.generator.WKorbProduktGenerator;

public class WarenkorbProduktGeneratorTest {

   private WKorbProduktGenerator classUnderTest;
   private DBWKorbProduktWriter mock;
   private Injector injector = Guice.createInjector(new DBModule());

   @BeforeClass
   public static void setUpBeforeClass()
      throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass()
      throws Exception {
   }

   @Before
   public void setUp()
      throws Exception {
      IMocksControl mockControl = createControl();
      mock = mockControl.createMock(DBWKorbProduktWriter.class);
      Creator creator = injector.getInstance(Creator.class);
      classUnderTest = new WKorbProduktGenerator(creator, mock);

   }

   @After
   public void tearDown()
      throws Exception {
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_0_0_0_0() {
      long anzKunde = 0;
      long anzProdukte = 0;
      long anzWarenkoerbe = 0;
      long anzProdukteInWarenkorb = 0;

      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWKorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukte);

      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_1_5_1_1() {
      long anzKunde = 1;
      long anzProdukte = 5;
      long anzWarenkoerbe = 1;
      long anzProdukteInWarenkorb = 1;

      Product warenkorbProdukt0 = new WKorbProdukt(0, 0, 0);
      mock.write(warenkorbProdukt0);
      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWKorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukte);
      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_4_5_2_1() {
      long anzKunde = 4;
      long anzProdukte = 5;
      long anzWarenkoerbe = 2;
      long anzProdukteInWarenkorb = 1;

      Product warenkorbProdukt0 = new WKorbProdukt(0, 0, 0);
      Product warenkorbProdukt1 = new WKorbProdukt(1, 0, 1);
      Product warenkorbProdukt2 = new WKorbProdukt(2, 1, 2);
      Product warenkorbProdukt3 = new WKorbProdukt(3, 1, 3);
      Product warenkorbProdukt4 = new WKorbProdukt(4, 2, 4);
      Product warenkorbProdukt5 = new WKorbProdukt(5, 2, 0);
      Product warenkorbProdukt6 = new WKorbProdukt(6, 3, 1);
      Product warenkorbProdukt7 = new WKorbProdukt(7, 3, 2);

      mock.write(warenkorbProdukt0);
      mock.write(warenkorbProdukt1);
      mock.write(warenkorbProdukt2);
      mock.write(warenkorbProdukt3);
      mock.write(warenkorbProdukt4);
      mock.write(warenkorbProdukt5);
      mock.write(warenkorbProdukt6);
      mock.write(warenkorbProdukt7);
      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWKorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukte);
      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_5_5_3_2() {
      long anzKunde = 5;
      long anzProdukte = 5;
      long anzWarenkoerbe = 3;
      long anzProdukteInWarenkorb = 2;

      Product warenkorbProdukt0 = new WKorbProdukt(0, 0, 0);
      Product warenkorbProdukt1 = new WKorbProdukt(1, 0, 1);
      Product warenkorbProdukt2 = new WKorbProdukt(2, 1, 2);
      Product warenkorbProdukt3 = new WKorbProdukt(3, 1, 3);
      Product warenkorbProdukt4 = new WKorbProdukt(4, 2, 4);
      Product warenkorbProdukt5 = new WKorbProdukt(5, 2, 0);
      Product warenkorbProdukt6 = new WKorbProdukt(6, 3, 1);
      Product warenkorbProdukt7 = new WKorbProdukt(7, 3, 2);
      Product warenkorbProdukt8 = new WKorbProdukt(8, 4, 3);
      Product warenkorbProdukt9 = new WKorbProdukt(9, 4, 4);
      Product warenkorbProdukt10 = new WKorbProdukt(10, 5, 0);
      Product warenkorbProdukt11 = new WKorbProdukt(11, 5, 1);
      Product warenkorbProdukt12 = new WKorbProdukt(12, 6, 2);
      Product warenkorbProdukt13 = new WKorbProdukt(13, 6, 3);
      Product warenkorbProdukt14 = new WKorbProdukt(14, 7, 4);
      Product warenkorbProdukt15 = new WKorbProdukt(15, 7, 0);
      Product warenkorbProdukt16 = new WKorbProdukt(16, 8, 1);
      Product warenkorbProdukt17 = new WKorbProdukt(17, 8, 2);
      Product warenkorbProdukt18 = new WKorbProdukt(18, 9, 3);
      Product warenkorbProdukt19 = new WKorbProdukt(19, 9, 4);
      Product warenkorbProdukt20 = new WKorbProdukt(20, 10, 0);
      Product warenkorbProdukt21 = new WKorbProdukt(21, 10, 1);
      Product warenkorbProdukt22 = new WKorbProdukt(22, 11, 2);
      Product warenkorbProdukt23 = new WKorbProdukt(23, 11, 3);
      Product warenkorbProdukt24 = new WKorbProdukt(24, 12, 4);
      Product warenkorbProdukt25 = new WKorbProdukt(25, 12, 0);
      Product warenkorbProdukt26 = new WKorbProdukt(26, 13, 1);
      Product warenkorbProdukt27 = new WKorbProdukt(27, 13, 2);
      Product warenkorbProdukt28 = new WKorbProdukt(28, 14, 3);
      Product warenkorbProdukt29 = new WKorbProdukt(29, 14, 4);

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
      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWKorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukte);
      verify(mock);
   }

}
