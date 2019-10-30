CREATE TABLE `crs_profile_schema`.`CRS_CUSTOMER` (
  `CUSTOMER_ID` BIGINT NOT NULL,
  `CUSTOMER_NAME` VARCHAR(45) NULL,
  `CUSTOMER_AGE` TINYINT(4) NULL,
  `CUSTOMER_GENDER` ENUM('MALE', 'FEMALE') NULL,
  `CUSTOMER_PHONE` VARCHAR(10) NULL,
  `CUSTOMER_ADDRESS` VARCHAR(145) NULL,
  `CUSTOMER_LIECENCE` VARCHAR(25) NULL,
  `CUSTOMER_PAN` VARCHAR(10) NULL,
  `CUSTOMER_ADHAAR` VARCHAR(16) NULL,
  `CUSTOMER_REG_DATE` DATETIME NULL,
  PRIMARY KEY (`CUSTOMER_ID`));

ALTER TABLE `crs_profile_schema`.`CRS_CUSTOMER` 
ADD COLUMN `CUSTOMER_EMAIL` VARCHAR(45) NULL AFTER `CUSTOMER_PHONE`;

CREATE TABLE `crs_profile_schema`.`CRS_VENDOR` (
  `VENDOR_ID` BIGINT NOT NULL,
  `VENDOR_NAME` VARCHAR(45) NULL,
  `VENDOR_AGE` TINYINT(4) NULL,
  `VENDOR_GENDER` ENUM('MALE', 'FEMALE') NULL,
  `VENDOR_PHONE` VARCHAR(45) NULL,
  `VENDOR_ADDRESS` VARCHAR(140) NULL,
  `VENDOR_PAN` VARCHAR(10) NULL,
  `VENDOR_ADHAAR` VARCHAR(16) NULL,
  `VENDOR_REG_DATE` DATETIME NULL,
  `VENDOR_GSTN` VARCHAR(45) NULL,
  PRIMARY KEY (`VENDOR_ID`));

ALTER TABLE `crs_profile_schema`.`CRS_VENDOR` 
ADD COLUMN `VENDOR_CREATED_BY` VARCHAR(45) NULL AFTER `VENDOR_GSTN`;

ALTER TABLE `crs_profile_schema`.`CRS_VENDOR` 
ADD COLUMN `VENDOR_EMAIL` VARCHAR(45) NULL AFTER `VENDOR_PHONE`;


CREATE TABLE `crs_profile_schema`.`CRS_CITIES` (
  `CITY_ID` INT NOT NULL AUTO_INCREMENT,
  `CITY_NAME` VARCHAR(45) NULL,
  `CITY_CREATED_ON` DATETIME NULL,
  PRIMARY KEY (`CITY_ID`));

CREATE TABLE `crs_profile_schema`.`CRS_LOCATONS` (
  `LOCATION_ID` INT NOT NULL AUTO_INCREMENT,
  `LOCATION_NAME` VARCHAR(45) NULL,
  `CITY_ID` INT NULL,
  PRIMARY KEY (`LOCATION_ID`),
  INDEX `fk_CRS_LOCATONS_1_idx` (`CITY_ID` ASC),
  CONSTRAINT `fk_CRS_LOCATONS_1`
    FOREIGN KEY (`CITY_ID`)
    REFERENCES `crs_profile_schema`.`CRS_CITIES` (`CITY_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `crs_profile_schema`.`CRS_LOCATONS` 
ADD COLUMN `LOCATION_CREATED_ON` DATETIME NULL AFTER `CITY_ID`;

CREATE TABLE `crs_profile_schema`.`CRS_CARS` (
  `CAR_ID` INT NOT NULL AUTO_INCREMENT,
  `CAR_MODEL_NAME` VARCHAR(45) NULL,
  `CAR_TYPE` VARCHAR(45) NULL,
  `CAR_REG_NUMBER` VARCHAR(45) NULL,
  `CAR_SEATS` INT NULL,
  `CAR_ACTIVE` BIT NULL,
  `CAR_PRICE_PER_DAY` INT NULL,
  `CAR_COLOR` VARCHAR(45) NULL,
  `CAR_VENDOR_ID` BIGINT NULL,
  `CAR_LOCATION_ID` INT NULL,
  `CAR_REG_ON` DATETIME NULL,
  PRIMARY KEY (`CAR_ID`),
  INDEX `fk_CRS_CAR_TYPES_1_idx` (`CAR_VENDOR_ID` ASC),
  INDEX `fk_CRS_CAR_TYPES_2_idx` (`CAR_LOCATION_ID` ASC),
  CONSTRAINT `fk_CRS_CAR_TYPES_1`
    FOREIGN KEY (`CAR_VENDOR_ID`)
    REFERENCES `crs_profile_schema`.`CRS_VENDOR` (`VENDOR_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CRS_CAR_TYPES_2`
    FOREIGN KEY (`CAR_LOCATION_ID`)
    REFERENCES `crs_profile_schema`.`CRS_LOCATONS` (`LOCATION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



