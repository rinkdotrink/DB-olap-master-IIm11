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
import de.datagenerator.datamodel.WKorb;
import de.datagenerator.dbwriter.DBWKorbWriter;
import de.datagenerator.dbwriter.IDBWriter;
import de.datagenerator.generator.WKorbGenerator;

public class WarenkorbGeneratorTest {

   private WKorbGenerator classUnderTest;
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
      mock = mockControl.createMock(DBWKorbWriter.class);
      Creator creator = injector.getInstance(Creator.class);
      classUnderTest = new WKorbGenerator(creator, mock);
   }

   @After
   public void tearDown()
      throws Exception {
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

      Product warenkorb0 = new WKorb(0, 0);
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

      Product warenkorb0 = new WKorb(0, 0);
      Product warenkorb1 = new WKorb(1, 0);
      Product warenkorb2 = new WKorb(2, 1);
      Product warenkorb3 = new WKorb(3, 1);
      Product warenkorb4 = new WKorb(4, 2);
      Product warenkorb5 = new WKorb(5, 2);
      Product warenkorb6 = new WKorb(6, 3);
      Product warenkorb7 = new WKorb(7, 3);

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

      Product warenkorb0 = new WKorb(0, 0);
      Product warenkorb1 = new WKorb(1, 0);
      Product warenkorb2 = new WKorb(2, 0);
      Product warenkorb3 = new WKorb(3, 1);
      Product warenkorb4 = new WKorb(4, 1);
      Product warenkorb5 = new WKorb(5, 1);
      Product warenkorb6 = new WKorb(6, 2);
      Product warenkorb7 = new WKorb(7, 2);
      Product warenkorb8 = new WKorb(8, 2);
      Product warenkorb9 = new WKorb(9, 3);
      Product warenkorb10 = new WKorb(10, 3);
      Product warenkorb11 = new WKorb(11, 3);
      Product warenkorb12 = new WKorb(12, 4);
      Product warenkorb13 = new WKorb(13, 4);
      Product warenkorb14 = new WKorb(14, 4);

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
