/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.14-log : Database - ipms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ipms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ipms`;

/*Table structure for table `t_car` */

DROP TABLE IF EXISTS `t_car`;

CREATE TABLE `t_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cartoken` int(11) NOT NULL COMMENT '是否删除标志',
  `car_id` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `ownerInfo` varchar(255) DEFAULT NULL COMMENT '车主姓名',
  `due_month` varchar(255) DEFAULT NULL COMMENT '到期月份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_car` */

/*Table structure for table `t_dailyincome` */

DROP TABLE IF EXISTS `t_dailyincome`;

CREATE TABLE `t_dailyincome` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `income` double NOT NULL COMMENT '收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dailyincome` */

/*Table structure for table `t_record` */

DROP TABLE IF EXISTS `t_record`;

CREATE TABLE `t_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `car_id` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `entertime` datetime DEFAULT NULL COMMENT '进入时间',
  `fee` varchar(255) DEFAULT NULL COMMENT '费用',
  `isover` varchar(255) DEFAULT NULL COMMENT '是否结算',
  `leavetime` datetime DEFAULT NULL COMMENT '离开时间',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `month_id` bigint(20) DEFAULT NULL COMMENT '关联的月票ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '关联的用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_record` */

/*Table structure for table `t_sys` */

DROP TABLE IF EXISTS `t_sys`;

CREATE TABLE `t_sys` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parking_spaces` int(11) NOT NULL COMMENT '车位数',
  `day_income` double NOT NULL COMMENT '每天停车费用',
  `freeprkingtime` int(11) NOT NULL COMMENT '免费停车时间',
  `monthticket_fee` double NOT NULL COMMENT '月票费用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `access` int(11) NOT NULL COMMENT '用户权限',
  `truename` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `usertoken` int(11) NOT NULL COMMENT '是否删除标志',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
