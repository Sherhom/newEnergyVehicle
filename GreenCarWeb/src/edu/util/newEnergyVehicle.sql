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
  `driverNum` varchar(11) NOT NULL
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
  `carState` varchar(100) NOT NULL,
  `times` timestamp NOT NULL,
  `task` varchar(200) NOT NULL,
  `isBreakdown` int NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carLocation`;
CREATE TABLE `carLocation`(
  `carLId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `longtitude` double(8,3) default 0.00,
  `latitude` double(8,3) default 0.00,
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

--yukang test data
insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(001,'yefei','admin','admin','12345678912');
insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(002,'yefei2','admin1','admin1','12345678910');

insert into carInfo values('car001','BMW1',20.00,'2010-01-05','1');
insert into driverInfo values(1,'1','carTeam001','car001','jack01',1,'123456','normal');
insert into batteryInfo values('battery001','南孚','ab01','car001');
insert into carGuarantee values(1,'car001',6.00,'在桃花镇男子职业技术学院进行保养','2018-02-28');
insert into carMile values(1,500.00,1,1,0,1,'2018-02-28','car001');

insert into carInfo values('car002','qirui2',50.00,'2010-10-11','2');
insert into driverInfo values(2,'2','carTeam002','car002','tom02',1,'4548123','normal');
insert into batteryInfo values('battery002','快电','ab01','car002');
insert into carGuarantee values(2,'car002',6.00,'在合肥货车维修站进行保养','2018-03-03');
insert into carMile values(2,340.55,1,1,0,1,'2018-03-03','car002');





-- 2018-3-11

insert into carInfo values('car003','benz3',20.00,'2010-01-05','3');
insert into driverInfo values(3,'3','carTeam003','car003','jack03',1,'123456','captain');
insert into batteryInfo values('battery003','南孚','ab01','car003');
insert into carGuarantee values(3,'car003',6.00,'在桃花镇男子职业技术学院3号保养厂进行保养','2018-02-28');
insert into carMile values(3,500.00,1,1,0,1,'2018-02-28','car003');


insert into carInfo values('car004','changcheng4',50.00,'2010-10-11','4');
insert into driverInfo values(4,'4','carTeam004','car004','tom04',1,'4548123','normal');
insert into batteryInfo values('battery004','快电','ab01','car004');
insert into carGuarantee values(4,'car004',6.00,'在合肥货车维修站04号场地进行保养','2018-03-03');
insert into carMile values(4,340.55,1,1,0,1,'2018-03-03','car004');

insert into carInfo values('car005','dazhong5',20.00,'2010-01-05','5');
insert into driverInfo values(5,'5','carTeam005','car005','jack05',1,'123456','captain');
insert into batteryInfo values('battery005','南孚','ab01','car005');
insert into carGuarantee values(5,'car005',6.00,'在桃花镇男子职业技术学院5号场地进行保养','2018-02-28');
insert into carMile values(5,500.00,1,1,0,1,'2018-02-28','car005');

insert into carInfo values('car006','biaozhi6',50.00,'2010-10-11','6');
insert into driverInfo values(6,'6','carTeam006','car006','tom06',1,'4548123','normal');
insert into batteryInfo values('battery006','快电','ab01','car006');
insert into carGuarantee values(6,'car006',6.00,'在合肥货车维修站06号场地进行保养','2018-03-03');
insert into carMile values(6,340.55,1,1,0,1,'2018-03-03','car006');








insert into taskInfo values(1,'carTeam001','task001','2018-3-6 20:00:00','2018-3-13 20:00:00','2018-3-12 15:36:25',1,'为合肥工地大学运货');
insert into taskInfo values(2,'carTeam002','task002','2018-3-7 00:00:00','2018-3-15 20:00:00','2018-3-13 07:25:16',1,'为合肥女子学院的运货');

insert into carLocation values(1,'car001',116.364,39.993,'2018-3-10 12:50:05');
insert into carLocation values(2,'car002',115.000,38.000,'2018-3-10 13:16:17');
--hushuxiang test data
show DATABASES ;
SHOW  TABLES ;




desc carinfo;
desc carteaminfo;
DESC driverinfo;
DESC carcollision;
DESC carteaminfo;

SELECT * FROM carinfo;
SELECT * FROM carteaminfo;
SELECT * FROM driverinfo;

insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(001,'yefei','admin','admin','12345678912');
insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(002,'yefei2','admin1','admin1','12345678910');

INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (001,'hfut',20,001);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (002,'hfut2',30,002);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (003,'hfut2',30,003);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (004,'hfut3',35,004);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (005,'hfut3',35,005);
INSERT INTO carinfo(carNum, carBrand, carryingCapacity, driverNum) VALUE (006,'hfut4',40,006);


INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (1,1,1,1,"A",0,"12312233331","leader");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (2,2,2,2,"B",0,"12312233332","leader");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (3,3,2,3,"c",0,"12312233333","common");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (4,4,3,4,"d",1,"12312233334","leader");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (5,5,3,5,"e",1,"12312233335","common");
INSERT INTO driverinfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition) VALUE (6,6,1,6,"f",1,"12312233336","common");

INSERT INTO carteaminfo(motorcadeId, motorcadeNum, captainNum, motorcadeMount) VALUE (1,1,1,1);
INSERT INTO carteaminfo(motorcadeId, motorcadeNum, captainNum, motorcadeMount) VALUE (3,3,4,2);
INSERT INTO carteaminfo(motorcadeId, motorcadeNum, captainNum, motorcadeMount) VALUE (2,2,2,2);

