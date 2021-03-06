SELECT adbc.kunde.Name, SUM(adbc.produkt.Preis)
FROM adbc.kunde,adbc.Produkt, 
     adbc.Warenkorb, 
     adbc.Warenkorb_has_Produkt
WHERE produkt.PRODUKT_ID = 
      warenkorb_has_produkt.Produkt_PRODUKT_ID 
AND warenkorb_has_produkt.Warenkorb_WARENKORB_ID = 
		warenkorb.WARENKORB_ID
AND warenkorb.Kunde_KUNDE_ID = kunde.KUNDE_ID
AND ((warenkorb_has_produkt.Datum = '2011-01-01')
OR   (warenkorb_has_produkt.Datum = '2011-01-05')
OR   (warenkorb_has_produkt.Datum = '2011-01-09')    
OR   (warenkorb_has_produkt.Datum = '2011-02-02')
OR   (warenkorb_has_produkt.Datum = '2011-02-06')    
OR   (warenkorb_has_produkt.Datum = '2011-02-10')
OR   (warenkorb_has_produkt.Datum = '2011-03-10')
OR   (warenkorb_has_produkt.Datum = '2011-03-14')    
OR   (warenkorb_has_produkt.Datum = '2011-03-18'))      
GROUP BY adbc.kunde.Name;