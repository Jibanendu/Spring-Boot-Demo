DROP DATABASE IF EXISTS springbootdb;
CREATE DATABASE springbootdb; 
USE springbootdb;

DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
  employeeId int(11) unsigned NOT NULL AUTO_INCREMENT,
  employeeName varchar(20) DEFAULT NULL,
  salary double DEFAULT NULL,
  departmentCode int(11),
  PRIMARY KEY (employeeId)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
