/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 25/01/2021 10:55:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Board_info
-- ----------------------------
DROP TABLE IF EXISTS `Board_info`;
CREATE TABLE `Board_info`  (
  `Board_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '桌游编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '桌游名称',
  `Category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别',
  `PlayerCount` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '游玩人数',
  `Introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `StoreLocation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储位置',
  `state` smallint(6) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`Board_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Board_info
-- ----------------------------
INSERT INTO `Board_info` VALUES (0, '示例桌游', '某个类别', '1-1958', '玩法示例', '西图的某个角落', 1);

-- ----------------------------
-- Table structure for lend_list
-- ----------------------------
DROP TABLE IF EXISTS `lend_list`;
CREATE TABLE `lend_list`  (
  `sernum` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `Board_id` bigint(20) NOT NULL COMMENT '桌游编号',
  `Player_id` int(11) NOT NULL COMMENT '玩家ID',
  `lend_date` datetime NULL DEFAULT NULL COMMENT '借出时间',
  `back_date` datetime NULL DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`sernum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2023051601 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lend_list
-- ----------------------------
INSERT INTO `lend_list` VALUES (1970010101, 0, 0, '1970-01-01 21:55:00','1970-01-01 23:30:00');
-- ----------------------------
-- Table structure for Player_info
-- ----------------------------
DROP TABLE IF EXISTS `Player_info`;
CREATE TABLE `Player_info`  (
  `Player_id` int(11) NOT NULL COMMENT '玩家ID',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `telcode` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  PRIMARY KEY (`Player_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Player_info
-- ----------------------------
INSERT INTO `Player_info` VALUES (0, '用户0','男','11122223333');
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user', '123456', 'user');
INSERT INTO `user` VALUES ('admin', '111111', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
