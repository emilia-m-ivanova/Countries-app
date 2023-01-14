CREATE SCHEMA country_app;
USE country_app;
CREATE TABLE users(
`id` INT NOT NULL PRIMARY KEY,
`username` VARCHAR(256) NOT NULL,
`password` VARCHAR(256) NOT NULL,
`role` VARCHAR(50) NOT NULL
);

CREATE TABLE countries(
`id` INT NOT NULL PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`population` INT
);
INSERT INTO countries VALUES
(1,'Russia',145934462),
(2,'Germany',83783942),
(3,'United Kingdom',67886011),
(4,'France',65273511),
(5,'Italy',60461826),
(6,'Spain',46754778),
(7,'Ukraine',43733762),
(8,'Poland',37846611),
(9,'Romania',19237691),
(10,'Netherlands',17134872),
(11,'Belgium',11589623),
(12,'Czech Republic',10708981),
(13,'Greece',10423054),
(14,'Portugal',10196709),
(15,'Sweden',10099265),
(16,'Hungary',9660351),
(17,'Belarus',9449323),
(18,'Austria',9006398),
(19,'Serbia',8737371),
(20,'Switzerland',8654622),
(21,'Bulgaria',6948445);

CREATE TABLE users_seq(`next_val` BIGINT);

INSERT INTO users_seq VALUES
(101);