drop DATABASE IF exists curriculum_guide;

create database curriculum_guide;

use curriculum_guide;

CREATE TABLE `curriculum_guide`.`userlogininfo` (
  `username` VARCHAR(20) NOT NULL,
  `userpassword` VARCHAR(150) NOT NULL,
  `questioncode` VARCHAR(4) NOT NULL,
  `answer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`));

ALTER TABLE `curriculum_guide`.`userlogininfo` 
ADD COLUMN `confirmation_code` INT NOT NULL AFTER `answer`,
ADD COLUMN `confirmation_status` VARCHAR(5) NOT NULL DEFAULT 'false' AFTER `confirmation_code`;