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
import de.datagenerator.dbwriter.IDBWriter;
import de.datagenerator.generator.WKorbProduktGenerator;

public class WarenkorbProduktGeneratorTest {

   private WKorbProduktGenerator classUnderTest;
   private IDBWriter mock;
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
         * anzProdukteInWarenkorb, anzProdukte, anzProdukteInWarenkorb);

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
         * anzProdukteInWarenkorb, anzProdukte, anzProdukteInWarenkorb);
      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_4_5_2_1() {
      long anzKunde = 4;
      long anzProdukte = 5;
      long anzWarenkoerbe = 2;
      long anzProdukteInWarenkorb = 1;

      Product warenkorbProdukt0 = new WKorbProdukt(0, 0, 0);
      Product warenkorbProdukt1 = new WKorbProdukt(1, 1, 1);
      Product warenkorbProdukt2 = new WKorbProdukt(2, 2, 2);
      Product warenkorbProdukt3 = new WKorbProdukt(3, 3, 3);
      Product warenkorbProdukt4 = new WKorbProdukt(4, 4, 4);
      Product warenkorbProdukt5 = new WKorbProdukt(5, 5, 0);
      Product warenkorbProdukt6 = new WKorbProdukt(6, 6, 1);
      Product warenkorbProdukt7 = new WKorbProdukt(7, 7, 2);

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
         * anzProdukteInWarenkorb, anzProdukte, anzProdukteInWarenkorb);
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
         * anzProdukteInWarenkorb, anzProdukte, anzProdukteInWarenkorb);
      verify(mock);
   }
   
   @Test
   public final void testGenerateProdukteInWarenkorb_5_5_3_3() {
      long anzKunde = 5;
      long anzProdukte = 5;
      long anzWarenkoerbe = 3;
      long anzProdukteInWarenkorb = 3;

      Product warenkorbProdukt0 = new WKorbProdukt(0, 0, 0);
      Product warenkorbProdukt1 = new WKorbProdukt(1, 0, 1);
      Product warenkorbProdukt2 = new WKorbProdukt(2, 0, 2);
      Product warenkorbProdukt3 = new WKorbProdukt(3, 1, 3);
      Product warenkorbProdukt4 = new WKorbProdukt(4, 1, 4);
      Product warenkorbProdukt5 = new WKorbProdukt(5, 1, 0);
      Product warenkorbProdukt6 = new WKorbProdukt(6, 2, 1);
      Product warenkorbProdukt7 = new WKorbProdukt(7, 2, 2);
      Product warenkorbProdukt8 = new WKorbProdukt(8, 2, 3);
      Product warenkorbProdukt9 = new WKorbProdukt(9, 3, 4);
      Product warenkorbProdukt10 = new WKorbProdukt(10, 3, 0);
      Product warenkorbProdukt11 = new WKorbProdukt(11, 3, 1);
      Product warenkorbProdukt12 = new WKorbProdukt(12, 4, 2);
      Product warenkorbProdukt13 = new WKorbProdukt(13, 4, 3);
      Product warenkorbProdukt14 = new WKorbProdukt(14, 4, 4);
      Product warenkorbProdukt15 = new WKorbProdukt(15, 5, 0);
      Product warenkorbProdukt16 = new WKorbProdukt(16, 5, 1);
      Product warenkorbProdukt17 = new WKorbProdukt(17, 5, 2);
      Product warenkorbProdukt18 = new WKorbProdukt(18, 6, 3);
      Product warenkorbProdukt19 = new WKorbProdukt(19, 6, 4);
      Product warenkorbProdukt20 = new WKorbProdukt(20, 6, 0);
      Product warenkorbProdukt21 = new WKorbProdukt(21, 7, 1);
      Product warenkorbProdukt22 = new WKorbProdukt(22, 7, 2);
      Product warenkorbProdukt23 = new WKorbProdukt(23, 7, 3);
      Product warenkorbProdukt24 = new WKorbProdukt(24, 8, 4);
      Product warenkorbProdukt25 = new WKorbProdukt(25, 8, 0);
      Product warenkorbProdukt26 = new WKorbProdukt(26, 8, 1);
      Product warenkorbProdukt27 = new WKorbProdukt(27, 9, 2);
      Product warenkorbProdukt28 = new WKorbProdukt(28, 9, 3);
      Product warenkorbProdukt29 = new WKorbProdukt(29, 9, 4);
      Product warenkorbProdukt30 = new WKorbProdukt(30, 10, 0);
      Product warenkorbProdukt31 = new WKorbProdukt(31, 10, 1);
      Product warenkorbProdukt32 = new WKorbProdukt(32, 10, 2);
      Product warenkorbProdukt33 = new WKorbProdukt(33, 11, 3);
      Product warenkorbProdukt34 = new WKorbProdukt(34, 11, 4);
      Product warenkorbProdukt35 = new WKorbProdukt(35, 11, 0);
      Product warenkorbProdukt36 = new WKorbProdukt(36, 12, 1);
      Product warenkorbProdukt37 = new WKorbProdukt(37, 12, 2);
      Product warenkorbProdukt38 = new WKorbProdukt(38, 12, 3);
      Product warenkorbProdukt39 = new WKorbProdukt(39, 13, 4);
      Product warenkorbProdukt40 = new WKorbProdukt(40, 13, 0);
      Product warenkorbProdukt41 = new WKorbProdukt(41, 13, 1);
      Product warenkorbProdukt42 = new WKorbProdukt(42, 14, 2);
      Product warenkorbProdukt43 = new WKorbProdukt(43, 14, 3);
      Product warenkorbProdukt44 = new WKorbProdukt(44, 14, 4);
      

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
      mock.write(warenkorbProdukt30);
      mock.write(warenkorbProdukt31);
      mock.write(warenkorbProdukt32);
      mock.write(warenkorbProdukt33);
      mock.write(warenkorbProdukt34);
      mock.write(warenkorbProdukt35);
      mock.write(warenkorbProdukt36);
      mock.write(warenkorbProdukt37);
      mock.write(warenkorbProdukt38);
      mock.write(warenkorbProdukt39);
      mock.write(warenkorbProdukt40);
      mock.write(warenkorbProdukt41);
      mock.write(warenkorbProdukt42);
      mock.write(warenkorbProdukt43);
      mock.write(warenkorbProdukt44);
      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWKorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukte, anzProdukteInWarenkorb);
      verify(mock);
   }

}
