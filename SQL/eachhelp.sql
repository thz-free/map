/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - othrerhlep
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`otherhelp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `otherhelp`;

/*Table structure for table `addressinfo` */

DROP TABLE IF EXISTS `addressinfo`;

CREATE TABLE `addressinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address` varchar(100) DEFAULT NULL COMMENT '收货地址',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `laction` varchar(100) DEFAULT NULL COMMENT '大概地址',
  `username` varchar(10) DEFAULT NULL COMMENT '姓名',
  `userid` int(11) DEFAULT NULL COMMENT '外键',
  `orederid` int(11) DEFAULT NULL COMMENT '地址关联外键',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `orederid` (`orederid`),
  CONSTRAINT `addressinfo_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`),
  CONSTRAINT `addressinfo_ibfk_2` FOREIGN KEY (`orederid`) REFERENCES `orderinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `addressinfo` */

/*Table structure for table `dbinfo` */

DROP TABLE IF EXISTS `dbinfo`;

CREATE TABLE `dbinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dbaffairs` varchar(200) DEFAULT NULL COMMENT '代办事件',
  `dbaddress` varchar(300) DEFAULT NULL COMMENT '代办地址',
  `dbtime` varchar(100) DEFAULT NULL COMMENT '代办时间',
  `dbinfo_id` int(11) DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`),
  KEY `dbinfo_id` (`dbinfo_id`),
  CONSTRAINT `dbinfo_ibfk_1` FOREIGN KEY (`dbinfo_id`) REFERENCES `orderinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dbinfo` */

/*Table structure for table `dginfo` */

DROP TABLE IF EXISTS `dginfo`;

CREATE TABLE `dginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `buyThings` varchar(500) DEFAULT NULL COMMENT '购买的物品',
  `buyaddress` varchar(200) DEFAULT NULL COMMENT '购买的地址',
  `dginfo_id` int(11) DEFAULT NULL COMMENT '外键唯一',
  PRIMARY KEY (`id`),
  KEY `dginfo_id` (`dginfo_id`),
  CONSTRAINT `dginfo_ibfk_1` FOREIGN KEY (`dginfo_id`) REFERENCES `orderinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dginfo` */

/*Table structure for table `dninfo` */

DROP TABLE IF EXISTS `dninfo`;

CREATE TABLE `dninfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `image` varchar(32) DEFAULT NULL COMMENT '存储图片',
  `kdAddress` varchar(200) DEFAULT NULL COMMENT '快递所在地',
  `dninfo_id` int(11) NOT NULL COMMENT '外键',
  PRIMARY KEY (`id`),
  KEY `dninfo_id` (`dninfo_id`),
  CONSTRAINT `dninfo_ibfk_1` FOREIGN KEY (`dninfo_id`) REFERENCES `orderinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dninfo` */

/*Table structure for table `orderinfo` */

DROP TABLE IF EXISTS `orderinfo`;

CREATE TABLE `orderinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` int(11) DEFAULT NULL COMMENT '1.代拿，2.代购,3.代办',
  `title` varchar(100) DEFAULT NULL COMMENT '列表主题',
  `state` tinyint(1) DEFAULT NULL COMMENT 'false 为未抢 ',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orderinfo_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderinfo` */

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,

  `wxphone` varchar(30) DEFAULT NULL COMMENT '微信手机号',
  `username` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `studentcode` varchar(30) DEFAULT NULL COMMENT '学生卡号',
  `isregister` tinyint(1) DEFAULT NULL COMMENT 'true 为注册，false为未注册',
  `userphone` varchar(30) DEFAULT NULL COMMENT '下单微信手机',
 
  `isdaina` tinyint(1) NOT NULL COMMENT 'true 代拿',
  `grabcounts` int(11) DEFAULT NULL COMMENT '抢单次数',
  `putcounts` int(11) DEFAULT NULL COMMENT '发布次数',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
