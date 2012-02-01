EXPLAIN PARTITIONS
#UC3 Wie viele Kunden haben in bestimmten Zeitraum bestellt?
SELECT Count(DISTINCT(adbc.kunde.KUNDE_ID))
FROM adbc.Kunde, adbc.Warenkorb, adbc.warenkorb_has_produkt
WHERE warenkorb.Kunde_KUNDE_ID = kunde.KUNDE_ID
AND warenkorb.WARENKORB_ID = warenkorb_has_produkt.Warenkorb_WARENKORB_ID
    AND warenkorb_has_produkt.Datum = '2011-01-01';
