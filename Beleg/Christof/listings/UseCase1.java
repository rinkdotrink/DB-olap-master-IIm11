SELECT adbc.Produkt.Name, COUNT(*)
FROM adbc.Produkt, adbc.Warenkorb_has_Produkt
WHERE adbc.Produkt.PRODUKT_ID = 
      adbc.Warenkorb_has_Produkt.Produkt_PRODUKT_ID
GROUP BY adbc.Produkt.Name;