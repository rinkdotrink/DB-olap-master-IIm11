#####
# Hash Index auf primary keys und foreign key

CREATE INDEX kunde_idx
    USING HASH
    ON adbc.kunde (KUNDE_ID);
    
CREATE INDEX produkt_idx
    USING HASH
    ON adbc.produkt (PRODUKT_ID);
    
CREATE INDEX warenkorb_idx
    USING HASH
    ON adbc.warenkorb (WARENKORB_ID);
    
CREATE INDEX warenkorb_kunde_idx
    USING HASH
    ON adbc.warenkorb (Kunde_KUNDE_ID);
    
CREATE INDEX warenkorb_has_produkt_idx
    USING HASH
    ON adbc.warenkorb_has_produkt (WARENKORB_HAS_PRODUKT_ID);
    
CREATE INDEX warenkorb_has_produkt_Warenkorb_WARENKORB_ID_idx
    USING HASH
    ON adbc.warenkorb_has_produkt (Warenkorb_WARENKORB_ID);

CREATE INDEX warenkorb_has_produkt_Produkt_PRODUKT_ID_idx
    USING HASH
    ON adbc.warenkorb_has_produkt (Produkt_PRODUKT_ID);