SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `ADBC` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `ADBC`;

CREATE  TABLE IF NOT EXISTS `ADBC`.`Kunde` (
  `KUNDE_ID` INT(11) NULL DEFAULT NULL ,
  `Name` VARCHAR(45) NULL DEFAULT NULL ,
  `Kundennummer` VARCHAR(45) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `ADBC`.`Warenkorb` (
  `WARENKORB_ID` INT(11) NULL DEFAULT NULL ,
  `Kunde_KUNDE_ID` INT(11) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `ADBC`.`Produkt` (
  `PRODUKT_ID` INT(11) NULL DEFAULT NULL ,
  `Name` VARCHAR(45) NULL DEFAULT NULL ,
  `Preis` INT(11) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE  TABLE IF NOT EXISTS `ADBC`.`Warenkorb_has_Produkt` (
  `Warenkorb_WARENKORB_ID` INT(11) NULL DEFAULT NULL ,
  `Produkt_PRODUKT_ID` INT(11) NULL DEFAULT NULL ,
  `WARENKORB_HAS_PRODUKT_ID` INT(11) NULL DEFAULT NULL ,
  `Datum` DATE NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci

    PARTITION BY RANGE COLUMNS(Datum)
    SUBPARTITION BY HASH( TO_DAYS(Datum) ) (
        PARTITION quartal1 VALUES LESS THAN ('2011-04-01') (
            SUBPARTITION s0,
            SUBPARTITION s1,
            SUBPARTITION s2,
            SUBPARTITION s3
        ),
        PARTITION quartal2 VALUES LESS THAN ('2011-07-01') (
            SUBPARTITION s4,
            SUBPARTITION s5,
            SUBPARTITION s6,
            SUBPARTITION s7
        ),
        PARTITION quartal3 VALUES LESS THAN ('2011-10-01') (
            SUBPARTITION s8,
            SUBPARTITION s9,
            SUBPARTITION s10,
            SUBPARTITION s11
        ),
        PARTITION quartal4 VALUES LESS THAN MAXVALUE (
            SUBPARTITION s12,
            SUBPARTITION s13,
            SUBPARTITION s14,
            SUBPARTITION s15
        )
    );


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
