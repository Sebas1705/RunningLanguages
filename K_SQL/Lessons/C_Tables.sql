-- Active: 1694812751035@@127.0.0.1@3306@lessons

###Create table:
CREATE Table player (
    id_player BIGINT AUTO_INCREMENT,
    name VARCHAR(120) UNIQUE NOT NULL,
    point INTEGER NOT NULL,
    PRIMARY KEY (id_player) ,
    CONSTRAINT Name_not_a_first CHECK (point >= 0)
);

###Drop table:
DROP TABLE player;

###Alter table:
--Add:
ALTER TABLE player
ADD surname VARCHAR(20) NOT NULL;
--Rename:
ALTER TABLE player
RENAME COLUMN surname TO description;
--Modify;
ALTER TABLE player
MODIFY COLUMN point Int;
--DROP:
ALTER TABLE player
DROP COLUMN description;


###Relation:
CREATE TABLE user (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(120) NOT NULL UNIQUE,
    player_id BIGINT NOT NULL,
    CONSTRAINT user_name_not_null CHECK (user_name IS NOT NULL), #Rule
    FOREIGN KEY (player_id) REFERENCES player(id_player) ON DELETE CASCADE #FOREIGN KEY REFERENCES
)