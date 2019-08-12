/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : ssh_root

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-13 00:23:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '苹果', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('2', '香蕉', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('3', '芒果', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('4', '西瓜', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('5', '番茄', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('6', '土豆', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('7', '榴莲', '13800138001', '北京', '测试');
