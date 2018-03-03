-- MySQL dump 10.10
--
-- Host: localhost    Database: nev
-- ------------------------------------------------------
-- Server version	5.0.18-nt

drop database IF EXISTS nev;
create database nev;
use nev;

--
-- 说明：
--Id只是区分不同的记录
--Num才是真正的编号
--

DROP TABLE IF EXISTS `carInfo`;
CREATE TABLE `carInfo`(
  `carNum` varchar(11) PRIMARY KEY NOT NULL,
  `carBrand` varchar(20) NOT NULL,
  `carryingCapacity` double(5,2) default 0.00,
  `dateManu` timestamp NOT NULL,
  `driverNum` int(11) NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `batteryInfo`;
CREATE TABLE `batteryInfo`(
  `batteryNum`  varchar(11) PRIMARY KEY NOT NULL,
  `batteryBrand` varchar(20) NOT NULL,
  `batteryVersion` varchar(20) NOT NULL,
  `carNum` varchar(11) NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carStatus`;
CREATE TABLE `carStatus`(
  `carSId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `carLoca` varchar(100) NOT NULL,
  `times` timestamp NOT NULL,
  `task` varchar(200) NOT NULL,
  `isBreakdown` int NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carLocation`;
CREATE TABLE `carLocation`(
  `carLId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `carLoca` varchar(100) NOT NULL,
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carMile`;
CREATE TABLE `carMile`(
  `carMId` int(11) PRIMARY KEY auto_increment,
  `totalMile` double(8,2) default 0.00,
  `isCarLock` int NOT NULL,
  `isSeatLock` int NOT NULL,
  `isSafetyBelt` int NOT NULL,
  `isHandBraking` int NOT NULL,
  `times` timestamp NOT NULL,
  `carNum` varchar(11) NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carSpeed`;
CREATE TABLE `carSpeed`(
  `carSId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `waterTem` double(5,1) default 0.0,
  `engineTem` double(5,1) default 0.0,
  `revSpeed` double(5,1) default 0.0,
  `driSpeed` double(5,1) default 0.0,
  `gear` varchar(2) NOT NULL,
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carWarning`;
CREATE TABLE `carWarning`(
  `carWId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `isAlarm` int NOT NULL,
  `alarmDes` varchar(1000),
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `batteryWarning`;
CREATE TABLE `batteryWarning`(
  `batteryId` int(11) PRIMARY KEY auto_increment,
  `batteryNum` varchar(11) NOT NULL,
  `bmsWarn` int NOT NULL,
  `warnDes` varchar(1000),
  `times` timestamp NOT NULL,
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `batteryStatus`;
CREATE TABLE `batteryStatus`(
  `batteryId` int(11) PRIMARY KEY auto_increment,
  `batteryNum` varchar(11) NOT NULL,
  `batteryTem` double(5,2) default 0.00,
  `totalVoltage` double(5,2) default 0.00,
  `levelAlarm` int NOT NULL,
  `isUse` int NOT NULL,
  `current` double(5,2) default 0.00,
  `soc` double(5,2) default 0.00,
  `extremeData` double(5,2) default 0.00,
  `temData` double(5,2) default 0.00,
  `MonomerV` double(5,2) default 0.00,
  `times` timestamp NOT NULL,
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carPeccancy`;
CREATE TABLE `carPeccancy`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `peccancyDes` varchar(1000),
  `times` timestamp NOT NULL,
  `types` varchar(100) NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carCollision`;
CREATE TABLE `carCollision`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `collRank` int NOT NULL,
  `limitValue` double(5,2) default 0.00,
  `actualValue` double(5,2) default 0.00,
  `collAngle` double(5,2) default 0.00,
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carOverSpeed`;
CREATE TABLE `carOverSpeed`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `limitSpeed` double(5,2) default 0.00,
  `maxSpeed` double(5,2) default 0.00,
  `statusIdent` int NOT NULL,
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carOverLoad`;
CREATE TABLE `carOverLoad`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `limitLoad` double(5,2) default 0.00,
  `actulLoad` double(5,2) default 0.00,
  `ident` int NOT NULL,
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carGuarantee`;
CREATE TABLE `carGuarantee`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `mainPeriod` double(5,2) default 0.00,
  `mainDes` varchar(1000) NOT NULL,
  `times` timestamp NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carSoc`;
CREATE TABLE `carSoc`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `limitValue` double(5,2) default 0.00,
  `soc` double(5,2) default 0.00,
  `statusIdent` int NOT NULL,
  `times` timestamp NOT NULL,
  `batteryNum` varchar(11) NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum),
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `batteryFailure`;
CREATE TABLE `batteryFailure`(
  `batteryId` int(11) PRIMARY KEY auto_increment,
  `batteryNum` varchar(11) NOT NULL,
  `failureDes` varchar(11) NOT NULL,
  `times` timestamp NOT NULL,
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `taskInfo`;
CREATE TABLE `taskInfo`(
  `taskId` int(11) PRIMARY KEY auto_increment,
  `motorcadeNum` varchar(11) NOT NULL,
  `taskNum` varchar(11) NOT NULL,
  `commitTime` timestamp NOT NULL,
  `endTime` timestamp NOT NULL,
  `finishTime` timestamp NOT NULL,
  `finishStatus` int NOT NULL,
  `taskDes` varchar(1000)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `driverInfo`;
CREATE TABLE `driverInfo`(
  `driverId` int(11) PRIMARY KEY auto_increment,
  `driverNum` varchar(11) NOT NULL,
  `motorcadeNum` varchar(11) NOT NULL,
  `carNum` varchar(11) NOT NULL,
  `driverName` varchar(20) NOT NULL,
  `driverSex` int NOT NULL,
  `driverPhone` varchar(20) NOT NULL,
  `driverPosition` varchar(50) NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carTeamInfo`;
CREATE TABLE `carTeamInfo`(
  `motorcadeId` int(11) PRIMARY KEY auto_increment,
  `motorcadeNum` varchar(11) NOT NULL,
  `captainNum` varchar(11) NOT NULL,
  `motorcadeMount` int NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `adminInfo`;
CREATE TABLE `adminInfo`(
  `adminId` int(11) PRIMARY KEY auto_increment,
  `adminNum` varchar(11) NOT NULL,
  `adminName` varchar(20) NOT NULL,
  `adminAccount` varchar(20) NOT NULL,
  `adminPass` varchar(20) NOT NULL,
  `adminPhone` varchar(20) NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `companyInfo`;
CREATE TABLE `companyInfo`(
  `companyId` int(11) PRIMARY KEY auto_increment,
  `companyNum` varchar(11) NOT NULL,
  `companyName` varchar(20) NOT NULL,
  `companyInfo` varchar(1000) NOT NULL,
  `compantPhone` varchar(20) NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(001,'yefei','admin','admin','12345678912');
insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(002,'yefei2','admin1','admin1','12345678910');

insert into carInfo values('car001','大众',20.00,'2010-01-05',1);
insert into driverInfo values(1,1,'carTeam001','car001','jack01',1,'123456','hefei');
insert into batteryInfo values('battery001','南孚','ab01','car001');
insert into carGuarantee values(1,'car001',6.00,'在桃花镇男子职业技术学院进行保养','2018-02-28');
insert into carMile values(1,500.00,1,1,0,1,'2018-02-28','car001');

--hushuxiang test data
desc carinfo;
desc carteaminfo;
DESC driverinfo;
DESC carcollision;
DESC carteaminfo;

SELECT * FROM carinfo;
SELECT * FROM carteaminfo;
SELECT * FROM driverinfo;
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (001,'hfut',20,001);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (002,'hfut2',30,002);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (003,'hfut2',30,003);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (004,'hfut3',35,004);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (005,'hfut3',35,005);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (006,'hfut4',40,006);

INSERT INTO carteaminfo (motorcadeNum, captainNum, motorcadeMount) VALUES (001,001,);

INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (1,1,1,1,"A",0,"12312233331","leader");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (2,2,2,2,"B",0,"12312233332","leader");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (3,3,2,3,"c",0,"12312233333","common");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (4,4,3,4,"d",1,"12312233334","leader");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (5,5,3,5,"e",1,"12312233335","common");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (6,6,1,6,"f",1,"12312233336","common");

