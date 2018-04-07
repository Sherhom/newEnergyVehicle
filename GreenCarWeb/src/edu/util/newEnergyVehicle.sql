-- MySQL dump 10.10
--
-- Host: localhost    Database: nev
-- ------------------------------------------------------
-- Server version   5.0.18-nt

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
  `isBreakdown` int NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carLocation`;
CREATE TABLE `carLocation`(
  `carLId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `longtitude` double(8,3) default 0.00,
  `latitude` double(8,3) default 0.00,
  `times` timestamp NOT NULL
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
  `carNum` varchar(11) NOT NULL
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
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carWarning`;
CREATE TABLE `carWarning`(
  `carWId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `isAlarm` int NOT NULL,
  `alarmDes` varchar(1000),
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `batteryWarning`;
CREATE TABLE `batteryWarning`(
  `batteryId` int(11) PRIMARY KEY auto_increment,
  `batteryNum` varchar(11) NOT NULL,
  `bmsWarn` int NOT NULL,
  `warnDes` varchar(1000),
  `times` timestamp NOT NULL
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
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carPeccancy`;
CREATE TABLE `carPeccancy`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `peccancyDes` varchar(1000),
  `times` timestamp NOT NULL,
  `types` varchar(100) NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carCollision`;
CREATE TABLE `carCollision`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `collRank` int NOT NULL,
  `limitValue` double(5,2) default 0.00,
  `actualValue` double(5,2) default 0.00,
  `collAngle` double(5,2) default 0.00,
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carOverSpeed`;
CREATE TABLE `carOverSpeed`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `limitSpeed` double(5,2) default 0.00,
  `maxSpeed` double(5,2) default 0.00,
  `statusIdent` int NOT NULL,
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carOverLoad`;
CREATE TABLE `carOverLoad`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `limitLoad` double(5,2) default 0.00,
  `actulLoad` double(5,2) default 0.00,
  `ident` int NOT NULL,
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carGuarantee`;
CREATE TABLE `carGuarantee`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `mainPeriod` double(5,2) default 0.00,
  `mainDes` varchar(1000) NOT NULL,
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `carSoc`;
CREATE TABLE `carSoc`(
  `carId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `limitValue` double(5,2) default 0.00,
  `soc` double(5,2) default 0.00,
  `statusIdent` int NOT NULL,
  `times` timestamp NOT NULL,
  `batteryNum` varchar(11) NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `batteryFailure`;
CREATE TABLE `batteryFailure`(
  `batteryId` int(11) PRIMARY KEY auto_increment,
  `batteryNum` varchar(11) NOT NULL,
  `failureDes` varchar(11) NOT NULL,
  `times` timestamp NOT NULL
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
  `taskDes` varchar(1000),
  `driverNum` varchar(11) NOT NULL,
  `workMileage` double(5,2) default 0.00,
  `moveDuration` double(5,2) default 0.00,
  `workDuration` double(5,2) default 0.00
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

DROP TABLE IF EXISTS `carPathHistory`;
CREATE TABLE `carPathHistory`(
  `carLId` int(11) PRIMARY KEY auto_increment,
  `carNum` varchar(11) NOT NULL,
  `longtitude` double(8,3) default 0.00,
  `latitude` double(8,3) default 0.00,
  `times` timestamp NOT NULL
)DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(001,'yefei','admin','admin','12345678912');
insert into adminInfo(adminNum,adminName,adminAccount,adminPass,adminPhone) values(2,'yefei2','admin1','admin1','12345678910');

DESC carInfo;
DESC driverInfo;
DESC carTeamInfo;
DESC taskInfo;

SELECT * FROM carTeamInfo;
SELECT * FROM driverInfo;


insert into carInfo values('1','BMW1',20.00,'2010-01-05','1');
insert into driverInfo(driverId, driverNum, motorcadeNum, carNum, driverName, driverSex, driverPhone, driverPosition)
values(1,'1','1','1','jack01',1,'123456','normal');

insert into batteryInfo values('1','南孚','ab01','1');
insert into carGuarantee values(1,'1',6.00,'在桃花镇男子职业技术学院进行保养','2018-02-28');
insert into carMile values(1,500.00,1,1,0,1,'2018-02-28','1');

INSERT INTO carTeamInfo (motorcadeId, motorcadeNum, captainNum, motorcadeMount) VALUES (1,"1","1",1);
INSERT INTO carTeamInfo(motorcadeId, motorcadeNum, captainNum, motorcadeMount) VALUE (2,"2","2",2);
INSERT INTO carTeamInfo(motorcadeId, motorcadeNum, captainNum, motorcadeMount) VALUE (3,"3","3",2);


insert into carInfo values('2','qirui2',50.00,'2010-10-11','2');
insert into driverInfo values(2,'2','2','2','tom02',1,'4548123','normal');
insert into batteryInfo values('2','快电','ab01','2');
insert into carGuarantee values(2,'2',6.00,'在合肥货车维修站进行保养','2018-03-03');
insert into carMile values(2,340.55,1,1,0,1,'2018-03-03','2');

insert into carInfo values('3','benz3',20.00,'2010-01-05','3');
insert into driverInfo values(3,'3','3','3','jack03',1,'123456','captain');
insert into batteryInfo values('3','南孚','ab01','3');
insert into carGuarantee values(3,'3',6.00,'在桃花镇男子职业技术学院3号保养厂进行保养','2018-02-28');
insert into carMile values(3,500.00,1,1,0,1,'2018-02-28','3');


insert into carInfo values('4','changcheng4',50.00,'2010-10-11','4');
insert into driverInfo values(4,'4','4','4','tom04',1,'4548123','normal');
insert into batteryInfo values('4','快电','ab01','4');
insert into carGuarantee values(4,'4',6.00,'在合肥货车维修站04号场地进行保养','2018-03-03');
insert into carMile values(4,340.55,1,1,0,1,'2018-03-03','4');

insert into carInfo values('5','dazhong5',20.00,'2010-01-05','5');
insert into driverInfo values(5,'5','5','5','jack05',1,'123456','captain');
insert into batteryInfo values('5','南孚','ab01','5');
insert into carGuarantee values(5,'5',6.00,'在桃花镇男子职业技术学院5号场地进行保养','2018-02-28');
insert into carMile values(5,500.00,1,1,0,1,'2018-02-28','5');

insert into carInfo values('6','biaozhi6',50.00,'2010-10-11','6');
insert into driverInfo values(6,'6','6','6','tom06',1,'4548123','normal');
insert into batteryInfo values('6','快电','ab01','6');
insert into carGuarantee values(6,'6',6.00,'在合肥货车维修站06号场地进行保养','2018-03-03');
insert into carMile values(6,340.55,1,1,0,1,'2018-03-03','6');

insert into carLocation values(1,'1',116.364,39.993,'2018-3-10 12:50:05');
insert into carLocation values(2,'2',115.000,38.000,'2018-3-10 13:16:17');


insert into carCollision values(1,'1',5,63.7,76.5,37.5,'2018-3-12 14:40:12');
insert into carCollision values(2,'2',6,63.7,89.3,62.25,'2018-3-13 15:35:05');

insert into carOverSpeed values(1,'3',60.0,75.38,1,'2018-3-9 08:15:30');
insert into carOverSpeed values(2,'4',60.0,69.35,1,'2018-3-9 11:30:27');

insert into carOverLoad values(1,'5',30.0,31.92,1,'2018-3-11 07:55:03');
insert into carOverLoad values(2,'6',30.0,35.58,1,'2018-3-13 09:10:48');


insert into taskInfo values(1,'1','task001','2018-3-5 07:05:31','2018-3-7 08:00:00','2018-3-7 05:17:31',1,'为湖北省运苹果','1',545.95,11.25,41.48);
insert into taskInfo values(2,'2','task002','2018-3-8 11:34:58','2018-3-9 12:00:00','2018-3-9 09:15:48',1,'为江西省运桃子','2',340.67,7.85,22.19);
insert into taskInfo values(3,'3','task003','2018-3-10 13:55:03','2018-3-13 14:00:00','2018-3-13 08:50:17',1,'为北京市运香蕉','3',890.12,23.18,65.05);



insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380955 ,39.913349,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380876 ,39.913348,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380776 ,39.913346,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380687 ,39.913344,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380657 ,39.913344,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380488 ,39.913341,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380488 ,39.913341,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380349 ,39.913348,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.38014 ,39.913344,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.379981 ,39.913342,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.379435 ,39.913342,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.379276 ,39.913339,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378849 ,39.913331,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378848 ,39.913331,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378301 ,39.913571,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378272 ,39.91377,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378202 ,39.914189,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378141 ,39.914867,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378141 ,39.914867,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.37827 ,39.91484,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.378787 ,39.914879,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.379185 ,39.914907,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380158 ,39.914984,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380427 ,39.914999,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380427 ,39.914999,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380447 ,39.91463,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380488 ,39.913341,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380498 ,39.913101,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380677 ,39.913114,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380677 ,39.913114,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.380886 ,39.913108,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.381045 ,39.913111,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.381373 ,39.913127,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.381462 ,39.913128,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.381641 ,39.913131,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.38183 ,39.913145,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.381979 ,39.913147,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.382407 ,39.913165,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.383112 ,39.913187,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.384106 ,39.913204,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.384514 ,39.913211,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.385827 ,39.913233,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.385877 ,39.913233,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.386364 ,39.913231,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.386513 ,39.913234,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.388134 ,39.913249,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.388214 ,39.91324,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.388433 ,39.913243,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.388831 ,39.913249,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.388911 ,39.91325,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.389239 ,39.913245,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.389567 ,39.91326,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.390254 ,39.913299,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.394606 ,39.913453,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.394646 ,39.913463,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.395214 ,39.913499,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.395602 ,39.913503,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.397227 ,39.913588,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.397446 ,39.91359,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.398045 ,39.913614,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.398165 ,39.913615,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.398713 ,39.913659,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.399292 ,39.913663,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.399332 ,39.913664,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.399391 ,39.913664,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.40009 ,39.913708,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.400699 ,39.913702,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.400848 ,39.913703,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.400988 ,39.913703,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.401887 ,39.913708,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.402136 ,39.913709,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.402796 ,39.913731,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.402955 ,39.913742,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.403994 ,39.913774,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.405004 ,39.913816,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.405833 ,39.913847,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.405833 ,39.913847,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.406363 ,39.913867,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.406733 ,39.913887,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.406763 ,39.913887,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.409434 ,39.914012,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.409775 ,39.914031,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.410195 ,39.91405,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.410466 ,39.914059,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.410506 ,39.914069,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.411167 ,39.914096,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.411337 ,39.914095,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.411998 ,39.914132,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.412128 ,39.914131,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.412629 ,39.914148,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.412699 ,39.914148,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.41291 ,39.914157,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.41323 ,39.914165,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.413301 ,39.914164,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.413471 ,39.914183,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.413902 ,39.91419,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.413942 ,39.9142,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.416148 ,39.914212,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.41678 ,39.914216,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.417352 ,39.914241,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.417633 ,39.914248,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.417753 ,39.914257,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.417833 ,39.914256,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.417864 ,39.914256,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.418054 ,39.914264,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.418345 ,39.914271,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.418436 ,39.91427,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.418626 ,39.914278,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.419038 ,39.914283,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.419158 ,39.914272,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.421026 ,39.91431,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.421287 ,39.914316,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.421699 ,39.914331,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.4219 ,39.914338,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.422563 ,39.91436,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.422563 ,39.914359,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.422655 ,39.912488,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.422665 ,39.912358,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.422665 ,39.912358,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.423258 ,39.91238,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.42379 ,39.912402,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424283 ,39.912425,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424494 ,39.912432,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424745 ,39.912479,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424745 ,39.912479,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424664 ,39.91303,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424644 ,39.91342,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424624 ,39.91364,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424614 ,39.91396,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424563 ,39.914401,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424543 ,39.914571,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424282 ,39.914575,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424281 ,39.914575,"2018-3-5 07:05:31");
insert into carPathHistory(carNum,longtitude,latitude,times) values(1,116.424281 ,39.914575,"2018-3-5 07:05:31");
