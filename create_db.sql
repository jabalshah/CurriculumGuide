drop DATABASE IF exists curriculum_guide;

create database curriculum_guide;

use curriculum_guide;

CREATE TABLE `curriculum_guide`.`userlogininfo` (
  `username` VARCHAR(20) NOT NULL,
  `userpassword` VARCHAR(150) NOT NULL,
  `questioncode` VARCHAR(4) NOT NULL,
  `answer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`));