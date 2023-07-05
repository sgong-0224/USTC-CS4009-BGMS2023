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
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Board_info
-- ----------------------------
INSERT INTO `Board_info` VALUES (1, '示例桌游1', '类别1', '2-4', '简介1：你说的对，但是「桌游1」是由「Null」自主研发的一款全新开放世界冒险游戏。游戏发生在一个被称作「NullPtrException」的幻想世界，在这里，被神选中的人将被授予「Bug」，导引崩溃之力。你将扮演一位名为「Debugger」的神秘角色在自由的旅行中邂逅性格各异、能力独特的同伴们，和他们一起击败强敌，找回失散的亲人——同时，逐步发掘「锟斤拷」的真相。', '存储位置1', 1);
INSERT INTO `Board_info` VALUES (2, '示例桌游2', '类别1', '4-6', '简介2：这里本来有玩法说明，但是指针不见了。', '存储位置2', 1);
INSERT INTO `Board_info` VALUES (3, '示例桌游3', '类别3', '6', '简介3：这个桌游的玩法下次再来探索吧。', '存储位置3', 1);
INSERT INTO `Board_info` VALUES (4, '示例桌游4', '类别2', '8', '简介4：前面忘了，中间忘了，后面忘了。', '存储位置2', 1);
INSERT INTO `Board_info` VALUES (5, '示例桌游5', '类别4', '4', '简介5：众所周知，NaN不小于，不大于，也不等于任何值。', '存储位置2', 1);
INSERT INTO `Board_info` VALUES (6, '示例桌游6', '类别4', '2-6', '简介6：Time Limit Exceeded.', '存储位置3', 1);
INSERT INTO `Board_info` VALUES (7, '示例桌游7', '类别2', '4', '简介7：Tip:要获得一串随机字符串，只需要让新手退出Vim。', '存储位置3', 1);
INSERT INTO `Board_info` VALUES (8, '示例桌游8', '类别1', '2', '简介8：编不下去了', '存储位置1', 1);

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
  `State` smallint(3) NULL DEFAULT NULL COMMENT '是否归还:1-是,0-否',
  PRIMARY KEY (`sernum`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lend_list
-- ----------------------------
INSERT INTO `lend_list` VALUES (1, 1, 'user', '2023-01-01 07:50','2023-01-02 13:30',1);
INSERT INTO `lend_list` VALUES (2, 3, 'user2', '2023-01-01 07:53','2023-01-03 13:30',1);
INSERT INTO `lend_list` VALUES (3, 2, 'user4', '2023-01-02 07:56','2023-01-02 12:28',1);
INSERT INTO `lend_list` VALUES (4, 4, 'user3', '2023-01-02 08:50','2023-01-02 13:30',1);
INSERT INTO `lend_list` VALUES (5, 2, 'user', '2023-01-02 14:50','2023-01-15 10:30',1);
INSERT INTO `lend_list` VALUES (6, 4, 'user4', '2023-01-03 07:50','2023-01-05 13:30',1);
INSERT INTO `lend_list` VALUES (7, 6, 'user3', '2023-01-03 09:50','2023-01-04 12:10',1);
INSERT INTO `lend_list` VALUES (8, 6, 'user2', '2023-01-04 13:50','2023-01-12 13:30',1);
INSERT INTO `lend_list` VALUES (9, 2, 'user', '2023-01-16 17:50','2023-01-20 21:30',1);

-- ----------------------------
-- Table structure for Player_info
-- ----------------------------
DROP TABLE IF EXISTS `Player_info`;
CREATE TABLE `Player_info`  (
  `Player_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `telcode` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  PRIMARY KEY (`Player_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Player_info
-- ----------------------------
INSERT INTO `Player_info` VALUES ('user', '用户0','11122223333');
INSERT INTO `Player_info` VALUES ('user2', 'Alice','10022334514');
INSERT INTO `Player_info` VALUES ('user3', 'Bob','14511458899');
INSERT INTO `Player_info` VALUES ('user4', '用户4','10098765432');
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
INSERT INTO `user` VALUES ('user', '{bcrypt}$2a$08$KphcodzHiApjYSc3liaBcOUFLdcW.BPFOKeog7s/4OzXhGSPAoq7S', 'user');
INSERT INTO `user` VALUES ('user2', '{bcrypt}$2a$08$ccs922899elj0buc8qMv6u1zEeT.7Q/9SPEsgSv8wYNk1vocrcLxu', 'user');
INSERT INTO `user` VALUES ('user3', '{bcrypt}$2a$08$DZ4GPrti8oQ3L/uzaEF/sevenhwG4eD59d1FHtsR5Tr7j0qkIf5R2', 'user');
INSERT INTO `user` VALUES ('user4', '{bcrypt}$2a$08$06Kh9HIAu2MbbJZN8GQoleE8C1.EwLhEur1csrFdd0aA7H1ymay9O', 'user');
INSERT INTO `user` VALUES ('admin', '{bcrypt}$2a$08$tYtH6LBr1gdz4XFuolWACeCTBOe6lL7I1OHpHNz./a4uUwH0pIZ.2', 'admin');

-- ----------------------------
-- Table structure for Notification
-- ----------------------------
DROP TABLE IF EXISTS `Notification`;
CREATE TABLE `Notification`  (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知编号',
  `Player_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `sernum` bigint(20) NOT NULL COMMENT '借用记录流水号',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Notification
-- ----------------------------


SET FOREIGN_KEY_CHECKS = 1;
