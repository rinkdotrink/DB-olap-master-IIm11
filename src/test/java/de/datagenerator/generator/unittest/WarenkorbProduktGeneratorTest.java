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
import de.datagenerator.datamodel.WarenkorbProdukt;
import de.datagenerator.dbwriter.DBWarenkorbProduktWriter;
import de.datagenerator.generator.WarenkorbProduktGenerator;

public class WarenkorbProduktGeneratorTest {

   private WarenkorbProduktGenerator classUnderTest;

   private DBWarenkorbProduktWriter mock;

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
      mock = mockControl.createMock(DBWarenkorbProduktWriter.class);
      Creator creator = injector.getInstance(Creator.class);
      classUnderTest = new WarenkorbProduktGenerator(creator, mock);

   }

   @After
   public void tearDown()
      throws Exception {
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_0_0_0() {
      long anzKunde = 0;
      long anzWarenkoerbe = 0;
      long anzProdukteInWarenkorb = 0;
      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWarenkorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukteInWarenkorb);

      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_1_1_1() {
      long anzKunde = 1;
      long anzWarenkoerbe = 1;
      long anzProdukteInWarenkorb = 1;

      FactoryMethodProduct warenkorbProdukt0 = new WarenkorbProdukt(0, 0, 0);
      mock.write(warenkorbProdukt0);
      mock.close();

      replay(mock);
      classUnderTest.generateProdukteInWarenkorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukteInWarenkorb);
      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_4_2_1() {
      long anzKunde = 4;
      long anzWarenkoerbe = 2;
      long anzProdukteInWarenkorb = 1;

      FactoryMethodProduct warenkorbProdukt0 = new WarenkorbProdukt(0, 0, 0);
      FactoryMethodProduct warenkorbProdukt1 = new WarenkorbProdukt(1, 1, 1);
      FactoryMethodProduct warenkorbProdukt2 = new WarenkorbProdukt(2, 2, 2);
      FactoryMethodProduct warenkorbProdukt3 = new WarenkorbProdukt(3, 3, 3);
      FactoryMethodProduct warenkorbProdukt4 = new WarenkorbProdukt(4, 4, 0);
      FactoryMethodProduct warenkorbProdukt5 = new WarenkorbProdukt(5, 5, 1);
      FactoryMethodProduct warenkorbProdukt6 = new WarenkorbProdukt(6, 6, 2);
      FactoryMethodProduct warenkorbProdukt7 = new WarenkorbProdukt(7, 7, 3);

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
      classUnderTest.generateProdukteInWarenkorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukteInWarenkorb);
      verify(mock);
   }

   @Test
   public final void testGenerateProdukteInWarenkorb_5_3_2() {
      long anzKunde = 5;
      long anzWarenkoerbe = 3;
      long anzProdukteInWarenkorb = 2;

      FactoryMethodProduct warenkorbProdukt0 = new WarenkorbProdukt(0, 0, 0);
      FactoryMethodProduct warenkorbProdukt1 = new WarenkorbProdukt(1, 0, 1);
      FactoryMethodProduct warenkorbProdukt2 = new WarenkorbProdukt(2, 1, 2);
      FactoryMethodProduct warenkorbProdukt3 = new WarenkorbProdukt(3, 1, 3);
      FactoryMethodProduct warenkorbProdukt4 = new WarenkorbProdukt(4, 2, 4);
      FactoryMethodProduct warenkorbProdukt5 = new WarenkorbProdukt(5, 2, 0);
      FactoryMethodProduct warenkorbProdukt6 = new WarenkorbProdukt(6, 3, 1);
      FactoryMethodProduct warenkorbProdukt7 = new WarenkorbProdukt(7, 3, 2);
      FactoryMethodProduct warenkorbProdukt8 = new WarenkorbProdukt(8, 4, 3);
      FactoryMethodProduct warenkorbProdukt9 = new WarenkorbProdukt(9, 4, 4);
      FactoryMethodProduct warenkorbProdukt10 = new WarenkorbProdukt(10, 5, 0);
      FactoryMethodProduct warenkorbProdukt11 = new WarenkorbProdukt(11, 5, 1);
      FactoryMethodProduct warenkorbProdukt12 = new WarenkorbProdukt(12, 6, 2);
      FactoryMethodProduct warenkorbProdukt13 = new WarenkorbProdukt(13, 6, 3);
      FactoryMethodProduct warenkorbProdukt14 = new WarenkorbProdukt(14, 7, 4);
      FactoryMethodProduct warenkorbProdukt15 = new WarenkorbProdukt(15, 7, 0);
      FactoryMethodProduct warenkorbProdukt16 = new WarenkorbProdukt(16, 8, 1);
      FactoryMethodProduct warenkorbProdukt17 = new WarenkorbProdukt(17, 8, 2);
      FactoryMethodProduct warenkorbProdukt18 = new WarenkorbProdukt(18, 9, 3);
      FactoryMethodProduct warenkorbProdukt19 = new WarenkorbProdukt(19, 9, 4);
      FactoryMethodProduct warenkorbProdukt20 = new WarenkorbProdukt(20, 10, 0);
      FactoryMethodProduct warenkorbProdukt21 = new WarenkorbProdukt(21, 10, 1);
      FactoryMethodProduct warenkorbProdukt22 = new WarenkorbProdukt(22, 11, 2);
      FactoryMethodProduct warenkorbProdukt23 = new WarenkorbProdukt(23, 11, 3);
      FactoryMethodProduct warenkorbProdukt24 = new WarenkorbProdukt(24, 12, 4);
      FactoryMethodProduct warenkorbProdukt25 = new WarenkorbProdukt(25, 12, 0);
      FactoryMethodProduct warenkorbProdukt26 = new WarenkorbProdukt(26, 13, 1);
      FactoryMethodProduct warenkorbProdukt27 = new WarenkorbProdukt(27, 13, 2);
      FactoryMethodProduct warenkorbProdukt28 = new WarenkorbProdukt(28, 14, 3);
      FactoryMethodProduct warenkorbProdukt29 = new WarenkorbProdukt(29, 14, 4);

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
      classUnderTest.generateProdukteInWarenkorb(anzKunde * anzWarenkoerbe
         * anzProdukteInWarenkorb, anzProdukteInWarenkorb);
      verify(mock);
   }

}
