SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tbl_department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tbl_department` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tbl_department` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tbl_employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tbl_employee` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tbl_employee` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `department_id` INT UNSIGNED NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `gender` ENUM('M', 'F') NULL,
  PRIMARY KEY (`id`),
  INDEX `department_id_idx` (`department_id` ASC),
  CONSTRAINT `department`
    FOREIGN KEY (`department_id`)
    REFERENCES `mydb`.`tbl_department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tbl_salary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tbl_salary` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tbl_salary` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL,
  `bonus_amount` DOUBLE NULL,
  `overtime_amount` DOUBLE NULL,
  `employee_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee` (`employee_id` ASC),
  CONSTRAINT `fk_employee_to_salary`
    FOREIGN KEY (`employee_id`)
    REFERENCES `mydb`.`tbl_employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tbl_designation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tbl_designation` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tbl_designation` (
  `id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NULL,
  `status` ENUM('PERMANENT', 'TERMINATED','TEMPORARY','TRAINEE') NULL,
  `employee_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_designation_tbl_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_employee_to_designation`
    FOREIGN KEY (`employee_id`)
    REFERENCES `mydb`.`tbl_employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
