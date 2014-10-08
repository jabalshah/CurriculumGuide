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

CREATE TABLE `curriculum_guide`.`registration` (
  `idregistration` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `course_id` VARCHAR(8) NOT NULL,
  `semester` INT NOT NULL,
  `grade` VARCHAR(2) NULL,
  `satisfies` VARCHAR(50) NULL,
  PRIMARY KEY (`idregistration`));