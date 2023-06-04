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
  `State` smallint(3) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`Board_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Board_info
-- ----------------------------
INSERT INTO `Board_info` VALUES (0, '示例桌游', '某个类别', '1-1958', '玩法示例', '存储位置', 1);

-- ----------------------------
-- Table structure for lend_list
-- ----------------------------
DROP TABLE IF EXISTS `lend_list`;
CREATE TABLE `lend_list`  (
  `sernum` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `Board_id` bigint(20) NOT NULL COMMENT '桌游编号',
  `Player_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `lend_date` varchar(23) NULL DEFAULT NULL COMMENT '借出时间',
  `back_date` varchar(23) NULL DEFAULT NULL COMMENT '归还时间',
  `State` smallint(3) NULL DEFAULT NULL COMMENT '是否归还:1是0否',
  PRIMARY KEY (`sernum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lend_list
-- ----------------------------
INSERT INTO `lend_list` VALUES (0, 1, 'user', '1970-01-01T21:55','1970-01-01T23:30',1);
-- ----------------------------
-- Table structure for Player_info
-- ----------------------------
DROP TABLE IF EXISTS `Player_info`;
CREATE TABLE `Player_info`  (
  `Player_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `telcode` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  PRIMARY KEY (`Player_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Player_info
-- ----------------------------
INSERT INTO `Player_info` VALUES ('user', '用户0','11122223333');
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user', 'userpass', 'user');
INSERT INTO `user` VALUES ('admin', 'useradmin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
