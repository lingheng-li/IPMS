/*
Navicat MySQL Data Transfer

Source Server         : MyTest
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : ipms

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-09-12 15:04:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_car`
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ticketID` int(11) DEFAULT NULL COMMENT '月票号',
  `ownerInfo` varchar(255) DEFAULT NULL COMMENT '车主姓名',
  `car_id` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `due_month` varchar(255) DEFAULT NULL COMMENT '到期月份',
  `car_token` int(11) NOT NULL COMMENT '是否删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '2019090801', '李四', '鄂AUF901', '2019/05/31', '0');
INSERT INTO `t_car` VALUES ('2', '2019090807', '王五', '鄂A88888', '2019/09/28', '0');
INSERT INTO `t_car` VALUES ('3', '2019101000', 'jack', '鄂A22222', '2019/11/11', '0');
INSERT INTO `t_car` VALUES ('4', '2019112093', 'roce', '鄂AF5666', '2019/12/09', '0');
INSERT INTO `t_car` VALUES ('5', '2019123467', '史蒂夫', '鄂AUT345', '2019/10/10', '1');

-- ----------------------------
-- Table structure for `t_dailyincome`
-- ----------------------------
DROP TABLE IF EXISTS `t_dailyincome`;
CREATE TABLE `t_dailyincome` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `income` double NOT NULL COMMENT '收入',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_dailyincome
-- ----------------------------
INSERT INTO `t_dailyincome` VALUES ('1', '2019/09/11', '240');
INSERT INTO `t_dailyincome` VALUES ('2', '2019/09/10', '300');
INSERT INTO `t_dailyincome` VALUES ('3', '2019/09/09', '256');
INSERT INTO `t_dailyincome` VALUES ('4', '2019/09/12', '369.6726025');

-- ----------------------------
-- Table structure for `t_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `car_id` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `entertime` datetime DEFAULT NULL COMMENT '进入时间',
  `fee` varchar(255) DEFAULT NULL COMMENT '费用',
  `isover` int(255) DEFAULT NULL COMMENT '是否结算',
  `leavetime` datetime DEFAULT NULL COMMENT '离开时间',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `month_id` int(20) DEFAULT NULL COMMENT '关联的月票ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '关联的用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES ('1', '鄂AB8888', '2019-09-09 17:00:37', '135', '1', '2019-09-11 14:31:54', null, null, '2');
INSERT INTO `t_record` VALUES ('2', '鄂AB8888', '2019-09-05 09:04:26', '50', '1', '2019-09-06 17:04:45', null, null, '2');
INSERT INTO `t_record` VALUES ('3', '鄂AB6666', '2019-09-10 11:01:24', '81', '1', '2019-09-11 14:29:33', null, null, '3');
INSERT INTO `t_record` VALUES ('4', '鄂AB8866', '2019-09-10 11:01:43', '96.0', '1', '2019-09-11 19:05:06', null, null, '4');
INSERT INTO `t_record` VALUES ('6', '鄂BH586', '2019-09-11 11:34:59', '24.0', '1', '2019-09-11 19:38:07', null, null, '5');
INSERT INTO `t_record` VALUES ('7', '鄂AUF901', '2019-09-10 19:06:34', '72.0', '1', '2019-09-11 19:33:00', null, null, '1');
INSERT INTO `t_record` VALUES ('8', '鄂AF5666', '2019-09-11 14:04:14', '', '0', '2019-09-12 14:47:52', null, null, '5');
INSERT INTO `t_record` VALUES ('9', '鄂A22222', '2019-09-11 14:04:55', null, '0', null, null, null, '4');
INSERT INTO `t_record` VALUES ('10', '鄂AUF901', '2019-09-11 16:06:17', null, '0', null, null, null, '2');

-- ----------------------------
-- Table structure for `t_sys`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys`;
CREATE TABLE `t_sys` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parking_spaces` int(11) NOT NULL COMMENT '车位数',
  `day_income` double NOT NULL COMMENT '每天停车费用',
  `monthticket_fee` double NOT NULL COMMENT '月票费用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sys
-- ----------------------------
INSERT INTO `t_sys` VALUES ('1', '60', '3', '300');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `truename` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `access` int(11) NOT NULL COMMENT '用户权限',
  `usertoken` int(11) NOT NULL COMMENT '是否删除标志',
  `addtime` varchar(255) DEFAULT NULL COMMENT '添加时间',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '张三', '1', '0', null, '13649498');
INSERT INTO `t_user` VALUES ('2', '李四', '123456', '李四', '0', '0', null, '89463198');
INSERT INTO `t_user` VALUES ('3', '王五', '123456', '王五', '0', '1', null, '189446541');
INSERT INTO `t_user` VALUES ('4', 'jack', '123456', 'jack', '0', '0', null, '154646454');
INSERT INTO `t_user` VALUES ('5', 'roce', '123456', 'roce', '0', '0', null, '134674884');
INSERT INTO `t_user` VALUES ('6', 'socket', '123456', '史蒂夫', '0', '0', null, '168131131');
