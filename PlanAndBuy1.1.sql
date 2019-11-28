--
-- File generated with SQLiteStudio v3.2.1 on tor. nov. 28 09:13:21 2019
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: BankAccount
DROP TABLE IF EXISTS BankAccount;

CREATE TABLE BankAccount (
    AccountID INT   PRIMARY KEY,
    Balance   FLOAT,
    ProfileID INT   REFERENCES Profile (ProfileID) 
);

INSERT INTO BankAccount (
                            AccountID,
                            Balance,
                            ProfileID
                        )
                        VALUES (
                            12,
                            10000.0,
                            1
                        );


-- Table: Customer
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    CustomerName STRING PRIMARY KEY,
    ProfileID    INT    REFERENCES Profile (ProfileID) 
);

INSERT INTO Customer (
                         CustomerName,
                         ProfileID
                     )
                     VALUES (
                         'Bjarne',
                         1
                     );


-- Table: Item
DROP TABLE IF EXISTS Item;

CREATE TABLE Item (
    ItemID       FLOAT  PRIMARY KEY,
    Price        FLOAT,
    ItemBrand    STRING,
    ItemType     STRING REFERENCES ItemCategory (ItemType) ON DELETE CASCADE
                                                           ON UPDATE CASCADE,
    ItemName     STRING,
    ItemQuantity INT
);

INSERT INTO Item (
                     ItemID,
                     Price,
                     ItemBrand,
                     ItemType,
                     ItemName,
                     ItemQuantity
                 )
                 VALUES (
                     '1,0',
                     15.75,
                     'Kohberg',
                     'Rugbrød',
                     'Herkules',
                     10
                 );

INSERT INTO Item (
                     ItemID,
                     Price,
                     ItemBrand,
                     ItemType,
                     ItemName,
                     ItemQuantity
                 )
                 VALUES (
                     '1,1',
                     16.0,
                     'Schulstad',
                     'Rugbrød',
                     'Kernegodt',
                     15
                 );


-- Table: ItemCategory
DROP TABLE IF EXISTS ItemCategory;

CREATE TABLE ItemCategory (
    ItemType         STRING PRIMARY KEY,
    ItemCategoryID   INT,
    ItemCategoryName STRING
);

INSERT INTO ItemCategory (
                             ItemType,
                             ItemCategoryID,
                             ItemCategoryName
                         )
                         VALUES (
                             'Rugbrød',
                             1,
                             'Brød'
                         );


-- Table: Profile
DROP TABLE IF EXISTS Profile;

CREATE TABLE Profile (
    ProfileID INT PRIMARY KEY
);

INSERT INTO Profile (
                        ProfileID
                    )
                    VALUES (
                        2
                    );

INSERT INTO Profile (
                        ProfileID
                    )
                    VALUES (
                        1
                    );


-- Table: Store
DROP TABLE IF EXISTS Store;

CREATE TABLE Store (
    StoreName STRING PRIMARY KEY,
    ItemID    FLOAT  REFERENCES Item (ItemID) 
);

INSERT INTO Store (
                      StoreName,
                      ItemID
                  )
                  VALUES (
                      'Netto Roskilde',
                      '1,0'
                  );


-- Table: Transactions
DROP TABLE IF EXISTS Transactions;

CREATE TABLE Transactions (
    TransactionAmount FLOAT,
    AccountID         INT   REFERENCES BankAccount (AccountID),
    TransID           INT   PRIMARY KEY
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
