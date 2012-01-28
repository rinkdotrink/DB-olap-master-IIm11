#BTREE Index auf primary keys

CREATE INDEX kunde_idx
    USING BTREE
    ON adbc.kunde (KUNDE_ID);
    
CREATE INDEX produkt_idx
    USING BTREE 
    ON adbc.produkt (PRODUKT_ID);
    
CREATE INDEX warenkorb_idx
    USING BTREE 
    ON adbc.warenkorb (WARENKORB_ID);
    
CREATE INDEX warenkorb_has_produkt_idx
    USING BTREE 
    ON adbc.warenkorb_has_produkt (WARENKORB_HAS_PRODUKT_ID);