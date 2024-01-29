-- Active: 1694812751035@@127.0.0.1@3306@lessons

###Inserts:

INSERT INTO player VAlUES (10,"dedddd",20,"Somewhere");
INSERT INTO player(name,point,description) VAlUES ("did",22,"Somedhere");
INSERT INTO player(description,point,name) VAlUES ("did",22,"Somedhere");

INSERT INTO user VALUES (120,"ded",10);
INSERT INTO user VALUES (12,"Did",1);
INSERT INTO user VALUES (40,"Some",12);

###Update:
UPDATE player SET point = 1000;
UPDATE player SET point = 500 WHERE name LIKE '%m%';

###Delete:
DELETE FROM user WHERE player_id = 1;