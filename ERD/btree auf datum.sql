######
#btree Index auf warenkorb_Datum
CREATE INDEX warenkorb_has_produkt_Datum_idx USING BTREE ON adbc.warenkorb_has_produkt (Datum);
    
#  drop index warenkorb_has_produkt_Datum_idx ON adbc.warenkorb_has_produkt;