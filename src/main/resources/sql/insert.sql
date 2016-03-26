# Insert roles
INSERT INTO ROLE (ID, NAME, DESCRIPTION, VERSION)
	VALUES (1, 'R_ADMIN', 'Admin', 0);
INSERT INTO ROLE (ID, NAME, DESCRIPTION)
	VALUES (2, 'R_MANAGER', 'Manager');
INSERT INTO ROLE (ID, NAME, DESCRIPTION)
	VALUES (3, 'R_USER', 'User');

# Insert profiles
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (1, 'Ana', 'DIACONESCU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (2, 'Isabela', 'CONSTANTIN');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (3, 'Luiza', 'VOINEA');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (4, 'Beatrice', 'CRISTEA');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (5, 'Rodica', 'MOCANU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (6, 'Beatrice', 'GEORGESCU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (7, 'Bianca', 'MIHAI');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (8, 'Delia', 'PREDA');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (9, 'Delia', 'GHITA');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (10, 'Paula', 'TUDOR');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (11, 'Andrei', 'DINU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (12, 'Doina', 'ISPAS');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (13, 'Cristian', 'MIHAI');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (14, 'Clara', 'TUDOR');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (15, 'Ilinca', 'DIACONESCU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (16, 'Cosmin', 'CONSTANTIN');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (17, 'Emil', 'STEFAN');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (18, 'Mircea', 'DIACONU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (19, 'Georgeta', 'MOCANU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (20, 'Catalin', 'BARBU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (21, 'Silviu', 'POPESCU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (22, 'Mircea', 'POP');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (23, 'Aurel', 'GHITA');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (24, 'Laura', 'DUMITRESCU');
INSERT INTO PROFILE (ID, FIRSTNAME, LASTNAME)
    VALUES (25, 'Sergiu', 'FLORESCU');

# Insert users
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (1, 'ana.diaconescu@google.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 1, 1);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (2, 'isabela.constantin@aim.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 2, 2);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (3, 'luiza.voinea@fastmail.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 2, 3);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (4, 'beatrice.cristea@myspace.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 2, 4);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (5, 'rodica.mocanu@inbox.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 2, 5);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (6, 'beatrice.georgescu@aol.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 6);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (7, 'bianca.mihai@fanbox.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 7);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (8, 'delia.preda@fastmail.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 8);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (9, 'delia.ghita@myrealbox.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 9);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (10, 'paula.tudor@inbox.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 10);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (11, 'andrei.dinu@gmx.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 11);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (12, 'doina.ispas@lavabit.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 12);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (13, 'cristian.mihai@gmx.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 13);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (14, 'clara.tudor@aim.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 14);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (15, 'ilinca.diaconescu@yahoo.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 15);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (16, 'cosmin.constantin@live.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 16);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (17, 'emil.stefan@zapak.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 17);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (18, 'mircea.diaconu@hotmail.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 18);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (19, 'georgeta.mocanu@in.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 19);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (20, 'catalin.barbu@live.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 20);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (21, 'silviu.popescu@myrealbox.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 21);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (22, 'mircea.pop@bigstring.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 22);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (23, 'aurel.ghita@live.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 23);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (24, 'laura.dumitrescu@email.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 24);
INSERT INTO USER (ID, EMAIL, PASSWORD, ENABLED, ROLE_ID, PROFILE_ID)
    VALUES (25, 'sergiu.florescu@myspace.com', '$2a$10$ZaicZn7O8kK8/s/hJydTTuvxsObLoSfkU9Jn8VWOHZamwZpH2NLIe', b'1', 3, 25);