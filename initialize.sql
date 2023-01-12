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
('Russia',145934462),
('Germany',83783942),
('United Kingdom',67886011),
('France',65273511),
('Italy',60461826),
('Spain',46754778),
('Ukraine',43733762),
('Poland',37846611),
('Romania',19237691),
('Netherlands',17134872),
('Belgium',11589623),
('Czech Republic',10708981),
('Greece',10423054),
('Portugal',10196709),
('Sweden',10099265),
('Hungary',9660351),
('Belarus',9449323),
('Austria',9006398),
('Serbia',8737371),
('Switzerland',8654622),
('Bulgaria',6948445);