-- Prepopulate Products
INSERT INTO PRODUCT (ID, NAME, CATEGORY, SUB_CATEGORY, BRAND) VALUES
                                                                  (1, 'Breadfast Classic Millefeuille Cup', 'Bakeries & Pastries', 'Millefeuille & Profiterole', 'Breadfast'),
                                                                  (2, 'Bic Evolution Black Pencil (12 Pens)', 'Stationery & Games', 'Pencils', 'Bic'),
                                                                  (3, 'iLock 3 Outlet Wall Plug (3500W)', 'Home', 'Cables & Plugs', 'iLock'),
                                                                  (4, 'Breadfast Mini Croissants', 'Bakeries & Pastries', 'Croissants', 'Breadfast'),
                                                                  (5, 'Bic Cristal Original Ballpoint Pen (10 Pens)', 'Stationery & Games', 'Pens', 'Bic'),
                                                                  (6, 'iLock Surge Protector Power Strip', 'Home', 'Cables & Plugs', 'iLock');

-- Prepopulate Users
INSERT INTO USER (ID, NAME, EMAIL) VALUES
                                       (1, 'Ahmed', 'ahmed@example.com'),
                                       (2, 'Mohamed', 'mohamed@example.com');

-- Prepopulate User Preferences for Ahmed
INSERT INTO USER_PREFERENCES (USER_ID, PREFERENCE_TYPE, PREFERENCES) VALUES
                                                                         (1, 'subCategories', 'Millefeuille & Profiterole,Cables & Plugs'),
                                                                         (1, 'brands', 'Breadfast');

-- Prepopulate User Preferences for Mohamed
INSERT INTO USER_PREFERENCES (USER_ID, PREFERENCE_TYPE, PREFERENCES) VALUES
                                                                         (2, 'subCategories', 'Croissants,Pencils,Cables & Plugs'),
                                                                         (2, 'brands', 'Bic,iLock');

-- Prepopulate Purchase History for Ahmed
INSERT INTO PURCHASE_HISTORY (USER_ID, PRODUCT_ID, DATE) VALUES
                                                             (1, 1, '2024-05-01'),
                                                             (1, 3, '2024-04-15'),
                                                             (1, 1, '2024-04-10');

-- Prepopulate Purchase History for Mohamed
INSERT INTO PURCHASE_HISTORY (USER_ID, PRODUCT_ID, DATE) VALUES
                                                             (2, 2, '2024-04-20'),
                                                             (2, 4, '2024-04-10'),
                                                             (2, 4, '2024-04-09'),
                                                             (2, 4, '2024-04-08');