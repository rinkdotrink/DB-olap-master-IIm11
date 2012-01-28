#UC2 Wieviel Umsatz wurde von wem in bestimmtem Zeitraum generiert?
SELECT adbc.kunde.Name, SUM(adbc.produkt.Preis)
FROM adbc.kunde,adbc.Produkt, adbc.Warenkorb, adbc.Warenkorb_has_Produkt
WHERE produkt.PRODUKT_ID = warenkorb_has_produkt.Produkt_PRODUKT_ID 
    AND warenkorb_has_produkt.Warenkorb_WARENKORB_ID = warenkorb.WARENKORB_ID
    AND warenkorb.Kunde_KUNDE_ID = kunde.KUNDE_ID
    AND warenkorb_has_produkt.Datum BETWEEN '2011-01-01' AND '2011-03-01'
Group by adbc.kunde.Name;
