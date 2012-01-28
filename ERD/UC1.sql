#UC1 Welches Produkt wurde wie oft gekauft?
Select adbc.Produkt.Name, Count(*)
From adbc.Produkt, adbc.Warenkorb_has_Produkt
where adbc.Produkt.PRODUKT_ID = adbc.Warenkorb_has_Produkt.Produkt_PRODUKT_ID
Group by adbc.Produkt.Name;