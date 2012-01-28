#####
#UNIQUE Hash Index auf primary keys

CREATE UNIQUE INDEX kunde_idx
    USING HASH
    ON adbc.kunde (KUNDE_ID);
    
CREATE UNIQUE INDEX produkt_idx
    USING HASH
    ON adbc.produkt (PRODUKT_ID);
    
CREATE UNIQUE INDEX warenkorb_idx
    USING HASH
    ON adbc.warenkorb (WARENKORB_ID);
    
CREATE INDEX warenkorb_has_produkt_idx
    USING HASH
    ON adbc.warenkorb_has_produkt (WARENKORB_HAS_PRODUKT_ID);

