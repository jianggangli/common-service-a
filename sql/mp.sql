/*
Navicat MySQL Data Transfer

Source Server         : 海尔_114.55.208.126
Source Server Version : 80020
Source Host           : 114.55.208.126:3306
Source Database       : mp

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-12-30 10:21:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commodity_order
-- ----------------------------
DROP TABLE IF EXISTS `commodity_order`;
CREATE TABLE `commodity_order` (
  `id` varchar(64) NOT NULL,
  `commodity_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品id',
  `order_no` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `version` bigint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity_order
-- ----------------------------
INSERT INTO `commodity_order` VALUES ('5527a9b8c5c87252c39ac39f69e4585b', '1234567', '1343843214041419776', '2020-12-29 08:56:10', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');
INSERT INTO `commodity_order` VALUES ('545a9ec77071aa2c76536e80351cdd81', '1234567', '1343843753600880640', '2020-12-29 08:58:17', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');
INSERT INTO `commodity_order` VALUES ('08871c02405b38aae0a90a614cdd97ed', '1234567', '1343845043441635328', '2020-12-29 09:03:21', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');
INSERT INTO `commodity_order` VALUES ('c13706019451c6874282bf53807862ab', '1234567', '1343900309088505856', '2020-12-29 12:42:57', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');

-- ----------------------------
-- Table structure for points
-- ----------------------------
DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `user_id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户id',
  `order_no` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '订单编号',
  `points` int NOT NULL COMMENT '积分',
  `remarks` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `version` bigint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of points
-- ----------------------------
INSERT INTO `points` VALUES ('85f76946d41954d466628d5ff1574cb3', 'jianggangli', '1343900309088505856', '990', '商品消费共【99.0】元，获得积分990', '2020-12-29 12:42:59', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');

-- ----------------------------
-- Table structure for transaction_log
-- ----------------------------
DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE `transaction_log` (
  `id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '事务ID',
  `transaction_id` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL,
  `business` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '业务标识',
  `foreign_key` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对应业务表中的主键',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `version` bigint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of transaction_log
-- ----------------------------
INSERT INTO `transaction_log` VALUES ('4a5fd771d0ea7c968f29c2d701f96655', '00000000000000000000000000000001000018B4AAC293D44FAA0000', 'order', '5527a9b8c5c87252c39ac39f69e4585b', '2020-12-29 08:56:10', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');
INSERT INTO `transaction_log` VALUES ('4be0fc79680b9814154a9c5721dc8940', '00000000000000000000000000000001000018B4AAC293DAF6E00000', 'order', '08871c02405b38aae0a90a614cdd97ed', '2020-12-29 09:03:21', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');
INSERT INTO `transaction_log` VALUES ('80538ef1698ead04af232a2262e51082', '00000000000000000000000000000001000018B4AAC293D645900000', 'order', '545a9ec77071aa2c76536e80351cdd81', '2020-12-29 08:58:17', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');
INSERT INTO `transaction_log` VALUES ('86bb5d47d64fc3ffddbc6c4750c9a468', '00000000000000000000000000000001000018B4AAC294A405350000', 'order', 'c13706019451c6874282bf53807862ab', '2020-12-29 12:42:58', 'SessionContextFacade.getSessionContext().getUserId()', null, null, '0', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `skill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `evaluate` varchar(255) DEFAULT NULL,
  `fraction` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `version` bigint DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('567ae160d5cce475dfcde2bca3fb4f4b', 'jianggangli', '23', '睡觉', 'jianggangli是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子', '60', '2020-12-07 20:23:10', '002', '2020-12-07 20:31:23', '002', '0', '27');
INSERT INTO `user` VALUES ('5ff0d7fdeaf065c060a7f8b56bf4ebf1', 'jianggangli', '18', '睡觉', 'jianggangli是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子', '60', '2020-12-07 21:53:25', '002', null, null, '0', '1');
INSERT INTO `user` VALUES ('6a034da0a58e6407e5f601469edcac28', 'papyrus', '18', 'JAVA', 'Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子', '58', '2020-12-07 21:53:25', '002', null, null, '0', '1');
INSERT INTO `user` VALUES ('ba08be72b212f38ef735f19479d1b704', 'papyrus', '18', 'JAVA', 'Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子', '58', '2020-12-07 20:23:10', '002', null, null, '0', '1');
