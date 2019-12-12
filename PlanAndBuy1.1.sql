--
-- File generated with SQLiteStudio v3.2.1 on tor. dec. 12 12:18:15 2019
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
                            8416.7998046875,
                            1
                        );

INSERT INTO BankAccount (
                            AccountID,
                            Balance,
                            ProfileID
                        )
                        VALUES (
                            11,
                            10403.4501953125,
                            2
                        );


-- Table: Customer
DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
    CustomerName STRING PRIMARY KEY
);

INSERT INTO Customer (
                         CustomerName
                     )
                     VALUES (
                         'Bjarne'
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

INSERT INTO Item (
                     ItemID,
                     Price,
                     ItemBrand,
                     ItemType,
                     ItemName,
                     ItemQuantity
                 )
                 VALUES (
                     '2,0',
                     10.5,
                     'Arla',
                     'Mælk',
                     'Skummetmælk',
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
                     '2,1',
                     11.75,
                     'Løgismose',
                     'Mælk',
                     'Sødmælk',
                     20
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
                     '3,0',
                     30.5,
                     'Landlyst',
                     'Oksekød',
                     'Hakket Oksekød',
                     21
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
                     '3,1',
                     80.0,
                     'Danish Crown',
                     'Oksekød',
                     'Okse Mørbrad',
                     17
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
                     '4,0',
                     15.0,
                     'Urtekram',
                     'Bønner',
                     'Kidney Bønner',
                     1
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
                     '4,1',
                     17.75,
                     'Bonduelle',
                     'Bønner',
                     'Sorte Bønner',
                     2
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
                     '5,0',
                     11.95,
                     'Levevis',
                     'Bær',
                     'Jordbær',
                     4
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
                     '5,1',
                     12.5,
                     'Levevis',
                     'Bær',
                     'Blåbær',
                     3
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

INSERT INTO ItemCategory (
                             ItemType,
                             ItemCategoryID,
                             ItemCategoryName
                         )
                         VALUES (
                             'Mælk',
                             2,
                             'Mejeri'
                         );

INSERT INTO ItemCategory (
                             ItemType,
                             ItemCategoryID,
                             ItemCategoryName
                         )
                         VALUES (
                             'Oksekød',
                             3,
                             'Kød'
                         );

INSERT INTO ItemCategory (
                             ItemType,
                             ItemCategoryID,
                             ItemCategoryName
                         )
                         VALUES (
                             'Bønner',
                             4,
                             'Konserves'
                         );

INSERT INTO ItemCategory (
                             ItemType,
                             ItemCategoryID,
                             ItemCategoryName
                         )
                         VALUES (
                             'Svinekød',
                             3,
                             'Kød'
                         );

INSERT INTO ItemCategory (
                             ItemType,
                             ItemCategoryID,
                             ItemCategoryName
                         )
                         VALUES (
                             'Bær',
                             5,
                             'Frost'
                         );


-- Table: Profile
DROP TABLE IF EXISTS Profile;

CREATE TABLE Profile (
    ProfileID    INT    PRIMARY KEY,
    StoreName    STRING REFERENCES Store (StoreName) ON DELETE CASCADE
                                                     ON UPDATE CASCADE
                                                     MATCH SIMPLE,
    CustomerName STRING REFERENCES Customer (CustomerName) ON DELETE CASCADE
                                                           ON UPDATE CASCADE
                                                           MATCH SIMPLE
);

INSERT INTO Profile (
                        ProfileID,
                        StoreName,
                        CustomerName
                    )
                    VALUES (
                        2,
                        'Netto Roskilde',
                        NULL
                    );

INSERT INTO Profile (
                        ProfileID,
                        StoreName,
                        CustomerName
                    )
                    VALUES (
                        1,
                        NULL,
                        'Bjarne'
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
