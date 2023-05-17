/*
 Navicat Premium Data Transfer

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 17/05/2023 20:13:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academic_student
-- ----------------------------
DROP TABLE IF EXISTS `academic_student`;
CREATE TABLE `academic_student`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_id` bigint NULL DEFAULT NULL,
  `academic_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `publish_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of academic_student
-- ----------------------------
INSERT INTO `academic_student` VALUES (1, 9, 'ABC Based on CBA', '2023-03-22');
INSERT INTO `academic_student` VALUES (2, 9, 'CBA Based on ABC', '2022-06-24');
INSERT INTO `academic_student` VALUES (3, 18, 'Title', '2023-02-13');
INSERT INTO `academic_student` VALUES (4, 18, 'Title2', '2022-11-01');
INSERT INTO `academic_student` VALUES (5, 19, 'ABC', '2023-01-10');

-- ----------------------------
-- Table structure for confirmation
-- ----------------------------
DROP TABLE IF EXISTS `confirmation`;
CREATE TABLE `confirmation`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `stu_id` bigint NULL DEFAULT NULL,
  `information_confirmation` tinyint NOT NULL DEFAULT 0,
  `information_confirmation_time` datetime NULL DEFAULT NULL,
  `course_confirmation` tinyint NOT NULL DEFAULT 0,
  `course_confirmation_time` datetime NULL DEFAULT NULL,
  `academic_confirmation` tinyint NOT NULL DEFAULT 0,
  `academic_confirmation_time` datetime NULL DEFAULT NULL,
  `dissertation_submitted` tinyint NOT NULL DEFAULT 0,
  `dissertation_submitted_time` datetime NULL DEFAULT NULL,
  `dissertation_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dissertation_keywords` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dissertation_abstract` varchar(2550) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of confirmation
-- ----------------------------
INSERT INTO `confirmation` VALUES (1, 9, 1, '2023-05-17 10:35:02', 1, '2023-05-17 11:53:57', 1, '2023-05-17 11:54:00', 1, '2023-05-17 11:54:34', 'ab', 'ss; sss; ssss', 'abstract');
INSERT INTO `confirmation` VALUES (2, 18, 1, '2023-05-10 10:57:00', 1, '2023-05-06 06:33:54', 0, NULL, 1, '2023-05-04 12:18:06', 'TEST', 'k1; k2; k3', 'testtest');
INSERT INTO `confirmation` VALUES (3, 19, 1, '2023-05-12 06:54:26', 1, '2023-05-16 06:26:22', 1, '2023-05-13 07:03:30', 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course_student
-- ----------------------------
DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `stu_id` bigint NULL DEFAULT NULL COMMENT '学生id',
  `course` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名',
  `credit` int NULL DEFAULT NULL COMMENT '学分',
  `course_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_student
-- ----------------------------
INSERT INTO `course_student` VALUES (1, 9, 'course1', 1, '2022-2023-1');
INSERT INTO `course_student` VALUES (2, 9, 'course2', 2, '2022-2023-2');
INSERT INTO `course_student` VALUES (3, 9, 'course3', 3, '2021-2022-1');
INSERT INTO `course_student` VALUES (4, 9, 'course4', 2, '2021-2022-2');
INSERT INTO `course_student` VALUES (5, 9, 'course5', 2, '2022-2023-1');
INSERT INTO `course_student` VALUES (6, 9, 'course6', 2, '2022-2023-1');
INSERT INTO `course_student` VALUES (7, 9, 'course7', 1, '2021-2022-2');
INSERT INTO `course_student` VALUES (8, 18, 'course1', 1, '2022-2023-1');
INSERT INTO `course_student` VALUES (9, 18, 'course2', 2, '2022-2023-2');
INSERT INTO `course_student` VALUES (10, 18, 'course5', 2, '2022-2023-1');
INSERT INTO `course_student` VALUES (11, 19, 'course2', 2, '2022-2023-2');
INSERT INTO `course_student` VALUES (12, 19, 'course5', 2, '2022-2023-1');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '系统日志id',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法',
  `duration` bigint NULL DEFAULT NULL COMMENT '持续时间',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法参数',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `create_time` datetime NULL DEFAULT NULL COMMENT '执行时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (9, 'com.example.demo.controller.CaptchaController.getRandomCode()', 398, 'uuid: 1.', '127.0.0.1', '2022-08-02 16:01:08');
INSERT INTO `sys_log` VALUES (10, 'com.example.demo.controller.CaptchaController.getRandomCode()', 108, 'uuid: 1 ', '127.0.0.1', '2022-08-02 16:02:11');
INSERT INTO `sys_log` VALUES (11, 'com.example.demo.controller.CaptchaController.getRandomCode()', 99, 'uuid: 1 ', '127.0.0.1', '2022-08-02 16:03:13');
INSERT INTO `sys_log` VALUES (12, 'com.example.demo.controller.UserController.login()', 133, 'loginDto: com.example.demo.dto.LoginDto@13d5d2f ', '127.0.0.1', '2022-08-02 16:03:29');
INSERT INTO `sys_log` VALUES (13, 'com.example.demo.controller.CaptchaController.getRandomCode()', 227, 'uuid: 1 ', '127.0.0.1', '2022-08-02 22:51:44');
INSERT INTO `sys_log` VALUES (14, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-02 22:54:33');
INSERT INTO `sys_log` VALUES (15, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-02 22:59:32');
INSERT INTO `sys_log` VALUES (16, 'com.example.demo.controller.CaptchaController.getRandomCode()', 150, 'uuid: 1 ', '127.0.0.1', '2022-08-02 23:03:09');
INSERT INTO `sys_log` VALUES (17, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-02 23:03:43');
INSERT INTO `sys_log` VALUES (18, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-02 23:08:18');
INSERT INTO `sys_log` VALUES (19, 'com.example.demo.controller.CaptchaController.getRandomCode()', 200, 'uuid: 1 ', '127.0.0.1', '2022-08-03 16:40:29');
INSERT INTO `sys_log` VALUES (20, 'com.example.demo.controller.CaptchaController.getRandomCode()', 170, 'uuid: 123 ', '127.0.0.1', '2022-08-04 14:25:28');
INSERT INTO `sys_log` VALUES (21, 'com.example.demo.controller.CaptchaController.getRandomCode()', 179, 'uuid: 1 ', '127.0.0.1', '2022-08-05 19:37:52');
INSERT INTO `sys_log` VALUES (22, 'com.example.demo.controller.CaptchaController.getRandomCode()', 163, 'uuid: 1 ', '127.0.0.1', '2022-08-05 19:51:02');
INSERT INTO `sys_log` VALUES (23, 'com.example.demo.controller.CaptchaController.getRandomCode()', 111, 'uuid: 1 ', '127.0.0.1', '2022-08-05 19:54:43');
INSERT INTO `sys_log` VALUES (24, 'com.example.demo.controller.CaptchaController.getRandomCode()', 112, 'uuid: 1 ', '127.0.0.1', '2022-08-05 19:57:30');
INSERT INTO `sys_log` VALUES (25, 'com.example.demo.controller.CaptchaController.getRandomCode()', 108, 'uuid: 1 ', '127.0.0.1', '2022-08-05 19:58:13');
INSERT INTO `sys_log` VALUES (26, 'com.example.demo.controller.CaptchaController.getRandomCode()', 110, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:02:41');
INSERT INTO `sys_log` VALUES (27, 'com.example.demo.controller.CaptchaController.getRandomCode()', 112, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:05:19');
INSERT INTO `sys_log` VALUES (28, 'com.example.demo.controller.CaptchaController.getRandomCode()', 121, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:06:52');
INSERT INTO `sys_log` VALUES (29, 'com.example.demo.controller.CaptchaController.getRandomCode()', 111, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:07:13');
INSERT INTO `sys_log` VALUES (30, 'com.example.demo.controller.CaptchaController.getRandomCode()', 562, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:10:28');
INSERT INTO `sys_log` VALUES (31, 'com.example.demo.controller.CaptchaController.getRandomCode()', 117, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:10:51');
INSERT INTO `sys_log` VALUES (32, 'com.example.demo.controller.CaptchaController.getRandomCode()', 115, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:11:14');
INSERT INTO `sys_log` VALUES (33, 'com.example.demo.controller.CaptchaController.getRandomCode()', 166, 'uuid: 1 ', '127.0.0.1', '2022-08-05 20:20:45');
INSERT INTO `sys_log` VALUES (34, 'com.example.demo.controller.CaptchaController.getRandomCode()', 113, 'uuid: 1 ', '127.0.0.1', '2022-08-05 21:29:22');
INSERT INTO `sys_log` VALUES (35, 'com.example.demo.controller.CaptchaController.getRandomCode()', 108, 'uuid: 1 ', '127.0.0.1', '2022-08-05 21:33:46');
INSERT INTO `sys_log` VALUES (36, 'com.example.demo.controller.CaptchaController.getRandomCode()', 25, 'uuid: 1 ', '127.0.0.1', '2022-08-05 21:35:07');
INSERT INTO `sys_log` VALUES (37, 'com.example.demo.controller.CaptchaController.getRandomCode()', 175, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:37:12');
INSERT INTO `sys_log` VALUES (38, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:37:17');
INSERT INTO `sys_log` VALUES (39, 'com.example.demo.controller.CaptchaController.getRandomCode()', 179, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:38:27');
INSERT INTO `sys_log` VALUES (40, 'com.example.demo.controller.CaptchaController.getRandomCode()', 102, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:45:16');
INSERT INTO `sys_log` VALUES (41, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:46:02');
INSERT INTO `sys_log` VALUES (42, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:46:18');
INSERT INTO `sys_log` VALUES (43, 'com.example.demo.controller.CaptchaController.getRandomCode()', 94, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:51:36');
INSERT INTO `sys_log` VALUES (44, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:51:41');
INSERT INTO `sys_log` VALUES (45, 'com.example.demo.controller.CaptchaController.getRandomCode()', 103, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:09');
INSERT INTO `sys_log` VALUES (46, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:10');
INSERT INTO `sys_log` VALUES (47, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:11');
INSERT INTO `sys_log` VALUES (48, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:18');
INSERT INTO `sys_log` VALUES (49, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:25');
INSERT INTO `sys_log` VALUES (50, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:25');
INSERT INTO `sys_log` VALUES (51, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:26');
INSERT INTO `sys_log` VALUES (52, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:52:28');
INSERT INTO `sys_log` VALUES (53, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:53:47');
INSERT INTO `sys_log` VALUES (54, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:53:48');
INSERT INTO `sys_log` VALUES (55, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:53:49');
INSERT INTO `sys_log` VALUES (56, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 14:53:54');
INSERT INTO `sys_log` VALUES (57, 'com.example.demo.controller.CaptchaController.getRandomCode()', 139, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:14:05');
INSERT INTO `sys_log` VALUES (58, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:14:06');
INSERT INTO `sys_log` VALUES (59, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:14:07');
INSERT INTO `sys_log` VALUES (60, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:14:12');
INSERT INTO `sys_log` VALUES (61, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:14:16');
INSERT INTO `sys_log` VALUES (62, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:14:20');
INSERT INTO `sys_log` VALUES (63, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:15:57');
INSERT INTO `sys_log` VALUES (64, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:15:58');
INSERT INTO `sys_log` VALUES (65, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:16:00');
INSERT INTO `sys_log` VALUES (66, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:16:01');
INSERT INTO `sys_log` VALUES (67, 'com.example.demo.controller.CaptchaController.getRandomCode()', 98, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:18:16');
INSERT INTO `sys_log` VALUES (68, 'com.example.demo.controller.CaptchaController.getRandomCode()', 95, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:19:02');
INSERT INTO `sys_log` VALUES (69, 'com.example.demo.controller.CaptchaController.getRandomCode()', 102, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:20:36');
INSERT INTO `sys_log` VALUES (70, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:21:11');
INSERT INTO `sys_log` VALUES (71, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:21:11');
INSERT INTO `sys_log` VALUES (72, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:21:11');
INSERT INTO `sys_log` VALUES (73, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:21:12');
INSERT INTO `sys_log` VALUES (74, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:22:45');
INSERT INTO `sys_log` VALUES (75, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:22:45');
INSERT INTO `sys_log` VALUES (76, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:22:46');
INSERT INTO `sys_log` VALUES (77, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:22:46');
INSERT INTO `sys_log` VALUES (78, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:24:22');
INSERT INTO `sys_log` VALUES (79, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:24:24');
INSERT INTO `sys_log` VALUES (80, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:24:24');
INSERT INTO `sys_log` VALUES (81, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:24:24');
INSERT INTO `sys_log` VALUES (82, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:25:53');
INSERT INTO `sys_log` VALUES (83, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:25:53');
INSERT INTO `sys_log` VALUES (84, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:25:54');
INSERT INTO `sys_log` VALUES (85, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:25:54');
INSERT INTO `sys_log` VALUES (86, 'com.example.demo.controller.CaptchaController.getRandomCode()', 103, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:29:34');
INSERT INTO `sys_log` VALUES (87, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:29:35');
INSERT INTO `sys_log` VALUES (88, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:29:36');
INSERT INTO `sys_log` VALUES (89, 'com.example.demo.controller.CaptchaController.getRandomCode()', 98, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:30:07');
INSERT INTO `sys_log` VALUES (90, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:30:08');
INSERT INTO `sys_log` VALUES (91, 'com.example.demo.controller.CaptchaController.getRandomCode()', 104, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:31:06');
INSERT INTO `sys_log` VALUES (92, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-09 18:31:07');
INSERT INTO `sys_log` VALUES (93, 'com.example.demo.controller.UserController.getUser()', 6, '', '127.0.0.1', '2022-08-09 18:31:56');
INSERT INTO `sys_log` VALUES (94, 'com.example.demo.controller.UserController.getUser()', 12, '', '127.0.0.1', '2022-08-09 18:38:26');
INSERT INTO `sys_log` VALUES (95, 'com.example.demo.controller.UserController.getUser()', 8, '', '127.0.0.1', '2022-08-09 18:38:33');
INSERT INTO `sys_log` VALUES (96, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:38:33');
INSERT INTO `sys_log` VALUES (97, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:38:33');
INSERT INTO `sys_log` VALUES (98, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:38:37');
INSERT INTO `sys_log` VALUES (99, 'com.example.demo.controller.UserController.getUser()', 7, '', '127.0.0.1', '2022-08-09 18:46:51');
INSERT INTO `sys_log` VALUES (100, 'com.example.demo.controller.UserController.getUser()', 6, '', '127.0.0.1', '2022-08-09 18:46:52');
INSERT INTO `sys_log` VALUES (101, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:46:52');
INSERT INTO `sys_log` VALUES (102, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:52');
INSERT INTO `sys_log` VALUES (103, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:46:53');
INSERT INTO `sys_log` VALUES (104, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:46:53');
INSERT INTO `sys_log` VALUES (105, 'com.example.demo.controller.UserController.getUser()', 4, '', '127.0.0.1', '2022-08-09 18:46:53');
INSERT INTO `sys_log` VALUES (106, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:46:56');
INSERT INTO `sys_log` VALUES (107, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:56');
INSERT INTO `sys_log` VALUES (108, 'com.example.demo.controller.UserController.getUser()', 1, '', '127.0.0.1', '2022-08-09 18:46:56');
INSERT INTO `sys_log` VALUES (109, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:57');
INSERT INTO `sys_log` VALUES (110, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:57');
INSERT INTO `sys_log` VALUES (111, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:57');
INSERT INTO `sys_log` VALUES (112, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:58');
INSERT INTO `sys_log` VALUES (113, 'com.example.demo.controller.UserController.getUser()', 1, '', '127.0.0.1', '2022-08-09 18:46:58');
INSERT INTO `sys_log` VALUES (114, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:46:58');
INSERT INTO `sys_log` VALUES (115, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:46:59');
INSERT INTO `sys_log` VALUES (116, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:00');
INSERT INTO `sys_log` VALUES (117, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:02');
INSERT INTO `sys_log` VALUES (118, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:02');
INSERT INTO `sys_log` VALUES (119, 'com.example.demo.controller.UserController.getUser()', 1, '', '127.0.0.1', '2022-08-09 18:47:02');
INSERT INTO `sys_log` VALUES (120, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:03');
INSERT INTO `sys_log` VALUES (121, 'com.example.demo.controller.UserController.getUser()', 1, '', '127.0.0.1', '2022-08-09 18:47:03');
INSERT INTO `sys_log` VALUES (122, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:03');
INSERT INTO `sys_log` VALUES (123, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:04');
INSERT INTO `sys_log` VALUES (124, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:47:04');
INSERT INTO `sys_log` VALUES (125, 'com.example.demo.controller.UserController.getUser()', 7, '', '127.0.0.1', '2022-08-09 18:47:33');
INSERT INTO `sys_log` VALUES (126, 'com.example.demo.controller.UserController.getUser()', 4, '', '127.0.0.1', '2022-08-09 18:47:34');
INSERT INTO `sys_log` VALUES (127, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:47:34');
INSERT INTO `sys_log` VALUES (128, 'com.example.demo.controller.UserController.getUser()', 4, '', '127.0.0.1', '2022-08-09 18:47:45');
INSERT INTO `sys_log` VALUES (129, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:45');
INSERT INTO `sys_log` VALUES (130, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2022-08-09 18:47:46');
INSERT INTO `sys_log` VALUES (131, 'com.example.demo.controller.UserController.getUser()', 2, '', '127.0.0.1', '2022-08-09 18:47:46');
INSERT INTO `sys_log` VALUES (132, 'com.example.demo.controller.CaptchaController.getRandomCode()', 167, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:20');
INSERT INTO `sys_log` VALUES (133, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:20');
INSERT INTO `sys_log` VALUES (134, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:23');
INSERT INTO `sys_log` VALUES (135, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:24');
INSERT INTO `sys_log` VALUES (136, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:24');
INSERT INTO `sys_log` VALUES (137, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:25');
INSERT INTO `sys_log` VALUES (138, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:26');
INSERT INTO `sys_log` VALUES (139, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:26');
INSERT INTO `sys_log` VALUES (140, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:26');
INSERT INTO `sys_log` VALUES (141, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:27');
INSERT INTO `sys_log` VALUES (142, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:27');
INSERT INTO `sys_log` VALUES (143, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:27');
INSERT INTO `sys_log` VALUES (144, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:28');
INSERT INTO `sys_log` VALUES (145, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:28');
INSERT INTO `sys_log` VALUES (146, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:28');
INSERT INTO `sys_log` VALUES (147, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:29');
INSERT INTO `sys_log` VALUES (148, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:29');
INSERT INTO `sys_log` VALUES (149, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:29');
INSERT INTO `sys_log` VALUES (150, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:30');
INSERT INTO `sys_log` VALUES (151, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:53');
INSERT INTO `sys_log` VALUES (152, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:54');
INSERT INTO `sys_log` VALUES (153, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:54');
INSERT INTO `sys_log` VALUES (154, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:54');
INSERT INTO `sys_log` VALUES (155, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:56');
INSERT INTO `sys_log` VALUES (156, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:57');
INSERT INTO `sys_log` VALUES (157, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:44:59');
INSERT INTO `sys_log` VALUES (158, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:01');
INSERT INTO `sys_log` VALUES (159, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:04');
INSERT INTO `sys_log` VALUES (160, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:07');
INSERT INTO `sys_log` VALUES (161, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:09');
INSERT INTO `sys_log` VALUES (162, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:11');
INSERT INTO `sys_log` VALUES (163, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:12');
INSERT INTO `sys_log` VALUES (164, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:12');
INSERT INTO `sys_log` VALUES (165, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:12');
INSERT INTO `sys_log` VALUES (166, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:13');
INSERT INTO `sys_log` VALUES (167, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:13');
INSERT INTO `sys_log` VALUES (168, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:13');
INSERT INTO `sys_log` VALUES (169, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:14');
INSERT INTO `sys_log` VALUES (170, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:15');
INSERT INTO `sys_log` VALUES (171, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:15');
INSERT INTO `sys_log` VALUES (172, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:15');
INSERT INTO `sys_log` VALUES (173, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:17');
INSERT INTO `sys_log` VALUES (174, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:18');
INSERT INTO `sys_log` VALUES (175, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:18');
INSERT INTO `sys_log` VALUES (176, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:21');
INSERT INTO `sys_log` VALUES (177, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:22');
INSERT INTO `sys_log` VALUES (178, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:24');
INSERT INTO `sys_log` VALUES (179, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:24');
INSERT INTO `sys_log` VALUES (180, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:26');
INSERT INTO `sys_log` VALUES (181, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:26');
INSERT INTO `sys_log` VALUES (182, 'com.example.demo.controller.CaptchaController.getRandomCode()', 2, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:27');
INSERT INTO `sys_log` VALUES (183, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:27');
INSERT INTO `sys_log` VALUES (184, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-08-11 15:45:29');
INSERT INTO `sys_log` VALUES (185, 'com.example.demo.controller.CaptchaController.getRandomCode()', 145, 'uuid: 1 ', '127.0.0.1', '2022-08-11 19:07:00');
INSERT INTO `sys_log` VALUES (186, 'com.example.demo.controller.CaptchaController.getRandomCode()', 185, 'uuid: 1 ', '127.0.0.1', '2022-08-11 19:19:52');
INSERT INTO `sys_log` VALUES (187, 'com.example.demo.controller.CaptchaController.getRandomCode()', 172, 'uuid: 1 ', '127.0.0.1', '2022-08-17 16:46:01');
INSERT INTO `sys_log` VALUES (188, 'com.example.demo.controller.CaptchaController.getRandomCode()', 104, 'uuid: 1 ', '127.0.0.1', '2022-08-17 16:47:02');
INSERT INTO `sys_log` VALUES (189, 'com.example.demo.controller.CaptchaController.getRandomCode()', 134, 'uuid: 1 ', '127.0.0.1', '2022-08-17 16:48:52');
INSERT INTO `sys_log` VALUES (190, 'com.example.demo.controller.CaptchaController.getRandomCode()', 101, 'uuid: 1 ', '127.0.0.1', '2022-08-17 16:55:17');
INSERT INTO `sys_log` VALUES (191, 'com.example.demo.controller.CaptchaController.getRandomCode()', 158, 'uuid: 1 ', '127.0.0.1', '2022-08-17 20:03:00');
INSERT INTO `sys_log` VALUES (192, 'com.example.demo.controller.CaptchaController.getRandomCode()', 190, 'uuid: 1 ', '127.0.0.1', '2022-08-31 15:37:36');
INSERT INTO `sys_log` VALUES (193, 'com.example.demo.controller.CaptchaController.getRandomCode()', 158, 'uuid: 1 ', '127.0.0.1', '2022-08-31 15:41:52');
INSERT INTO `sys_log` VALUES (194, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2022-08-31 15:41:56');
INSERT INTO `sys_log` VALUES (195, 'com.example.demo.controller.CaptchaController.getRandomCode()', 18584, 'uuid: 1 ', '127.0.0.1', '2022-08-31 15:42:35');
INSERT INTO `sys_log` VALUES (196, 'com.example.demo.controller.CaptchaController.getRandomCode()', 181, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:56:11');
INSERT INTO `sys_log` VALUES (197, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:56:22');
INSERT INTO `sys_log` VALUES (198, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:56:27');
INSERT INTO `sys_log` VALUES (199, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:57:42');
INSERT INTO `sys_log` VALUES (200, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:57:43');
INSERT INTO `sys_log` VALUES (201, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:58:11');
INSERT INTO `sys_log` VALUES (202, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-09-01 14:58:12');
INSERT INTO `sys_log` VALUES (203, 'com.example.demo.controller.CaptchaController.getRandomCode()', 110, 'uuid: 1 ', '127.0.0.1', '2022-09-01 15:02:14');
INSERT INTO `sys_log` VALUES (204, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2022-09-01 15:06:41');
INSERT INTO `sys_log` VALUES (205, 'com.example.demo.controller.UserController.getUser()', 5, '', '127.0.0.1', '2022-09-01 15:40:14');
INSERT INTO `sys_log` VALUES (206, 'com.example.demo.controller.CaptchaController.getRandomCode()', 224, 'uuid: 1 ', '127.0.0.1', '2022-10-17 20:48:02');
INSERT INTO `sys_log` VALUES (207, 'com.example.demo.controller.UserController.getUser()', 6, '', '127.0.0.1', '2022-10-17 20:49:22');
INSERT INTO `sys_log` VALUES (208, 'com.example.demo.controller.UserController.getUser()', 11, '', '127.0.0.1', '2022-10-18 09:35:09');
INSERT INTO `sys_log` VALUES (209, 'com.example.demo.controller.CaptchaController.getRandomCode()', 183, 'uuid: 123 ', '127.0.0.1', '2023-02-20 11:36:16');
INSERT INTO `sys_log` VALUES (210, 'com.example.demo.controller.UserController.getUser()', 7, '', '127.0.0.1', '2023-02-20 12:57:25');
INSERT INTO `sys_log` VALUES (211, 'com.example.demo.controller.UserController.getUser()', 10, '', '127.0.0.1', '2023-02-20 13:01:00');
INSERT INTO `sys_log` VALUES (212, 'com.example.demo.controller.UserController.getUser()', 10, '', '127.0.0.1', '2023-02-20 13:28:05');
INSERT INTO `sys_log` VALUES (213, 'com.example.demo.controller.UserController.getUser()', 11, '', '127.0.0.1', '2023-02-20 13:36:20');
INSERT INTO `sys_log` VALUES (214, 'com.example.demo.controller.CaptchaController.getRandomCode()', 189, 'uuid: 1 ', '127.0.0.1', '2023-02-23 19:00:02');
INSERT INTO `sys_log` VALUES (215, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-02-23 19:02:56');
INSERT INTO `sys_log` VALUES (216, 'com.example.demo.controller.CaptchaController.getRandomCode()', 140, 'uuid: 1 ', '127.0.0.1', '2023-04-29 03:22:45');
INSERT INTO `sys_log` VALUES (217, 'com.example.demo.controller.CaptchaController.getRandomCode()', 129, 'uuid: 1 ', '127.0.0.1', '2023-04-29 04:56:04');
INSERT INTO `sys_log` VALUES (218, 'com.example.demo.controller.CaptchaController.getRandomCode()', 146, 'uuid: 1 ', '127.0.0.1', '2023-04-29 05:08:17');
INSERT INTO `sys_log` VALUES (219, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 1 ', '58.198.176.171', '2023-04-29 05:14:26');
INSERT INTO `sys_log` VALUES (220, 'com.example.demo.controller.CaptchaController.getRandomCode()', 16, 'uuid: 1 ', '127.0.0.1', '2023-04-29 05:39:30');
INSERT INTO `sys_log` VALUES (221, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-04-29 05:39:47');
INSERT INTO `sys_log` VALUES (222, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-04-29 05:39:48');
INSERT INTO `sys_log` VALUES (223, 'com.example.demo.controller.CaptchaController.getRandomCode()', 108, 'uuid: 1 ', '127.0.0.1', '2023-04-29 06:16:26');
INSERT INTO `sys_log` VALUES (224, 'com.example.demo.controller.UserController.getUser()', 10, '', '127.0.0.1', '2023-04-29 06:25:42');
INSERT INTO `sys_log` VALUES (225, 'com.example.demo.controller.CaptchaController.getRandomCode()', 105, 'uuid: 1 ', '58.198.176.171', '2023-04-29 06:27:25');
INSERT INTO `sys_log` VALUES (226, 'com.example.demo.controller.CaptchaController.getRandomCode()', 96, 'uuid: aae47cb3-221f-41a8-a932-47e8fcf5bfb0 ', '172.31.222.184', '2023-04-29 06:32:39');
INSERT INTO `sys_log` VALUES (227, 'com.example.demo.controller.CaptchaController.getRandomCode()', 106, 'uuid: f972fb79-926f-4a47-8ffa-9d7a120f8a88 ', '172.31.222.184', '2023-04-29 06:39:28');
INSERT INTO `sys_log` VALUES (228, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 53e68261-ca56-4cfd-8b31-e513d27b741f ', '172.31.222.184', '2023-04-29 06:40:02');
INSERT INTO `sys_log` VALUES (229, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 29a9a60c-24f5-4b34-ae46-94e20234049f ', '172.31.222.184', '2023-04-29 06:40:56');
INSERT INTO `sys_log` VALUES (230, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: f829a7bc-268c-4f19-8443-c6ec7f9e4778 ', '172.31.222.184', '2023-04-29 06:41:00');
INSERT INTO `sys_log` VALUES (231, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 62e5bbe9-9c75-4365-b6e1-2ea4004eb3eb ', '172.31.222.184', '2023-04-29 06:41:11');
INSERT INTO `sys_log` VALUES (232, 'com.example.demo.controller.CaptchaController.getRandomCode()', 99, 'uuid: 28eb3cca-e97c-42d6-9709-f189a44d6916 ', '172.31.222.184', '2023-04-29 06:42:40');
INSERT INTO `sys_log` VALUES (233, 'com.example.demo.controller.CaptchaController.getRandomCode()', 103, 'uuid: fe7f2be3-7ec8-41c5-ba60-9b31d9e8004c ', '172.31.222.184', '2023-04-29 06:43:20');
INSERT INTO `sys_log` VALUES (234, 'com.example.demo.controller.CaptchaController.getRandomCode()', 111, 'uuid: 8ee151f9-509c-44d6-ae26-fce21badf3fd ', '172.31.222.184', '2023-04-29 06:46:59');
INSERT INTO `sys_log` VALUES (235, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 8ee151f9-509c-44d6-ae26-fce21badf3fd ', '172.31.222.184', '2023-04-29 06:47:14');
INSERT INTO `sys_log` VALUES (236, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: 6f5aff69-153c-4c20-8033-7d9441bb0fc3 ', '172.31.222.184', '2023-04-29 06:50:53');
INSERT INTO `sys_log` VALUES (237, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: cb0f991f-23c4-4705-b62a-e2c13f951974 ', '172.31.222.184', '2023-04-29 06:51:25');
INSERT INTO `sys_log` VALUES (238, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 123 ', '172.31.222.184', '2023-04-29 06:54:48');
INSERT INTO `sys_log` VALUES (239, 'com.example.demo.controller.CaptchaController.getRandomCode()', 102, 'uuid: 123 ', '172.31.222.184', '2023-04-29 06:55:57');
INSERT INTO `sys_log` VALUES (240, 'com.example.demo.controller.CaptchaController.getRandomCode()', 102, 'uuid: 123 ', '172.31.222.184', '2023-04-29 06:58:49');
INSERT INTO `sys_log` VALUES (241, 'com.example.demo.controller.CaptchaController.getRandomCode()', 97, 'uuid: 123 ', '172.31.222.184', '2023-04-29 07:01:34');
INSERT INTO `sys_log` VALUES (242, 'com.example.demo.controller.CaptchaController.getRandomCode()', 105, 'uuid: 07d07684-251a-4351-9eb5-00695f7698c0 ', '172.31.222.184', '2023-04-29 07:06:03');
INSERT INTO `sys_log` VALUES (243, 'com.example.demo.controller.CaptchaController.getRandomCode()', 16, 'uuid: e5b5d157-8235-4cc5-9844-d6dc97893a46 ', '172.31.222.184', '2023-04-29 07:10:01');
INSERT INTO `sys_log` VALUES (244, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 661217dc-ca4e-4c4f-b8fc-9e241a6a7973 ', '172.31.222.184', '2023-04-29 07:13:48');
INSERT INTO `sys_log` VALUES (245, 'com.example.demo.controller.CaptchaController.getRandomCode()', 15, 'uuid: 55d73af3-20b4-4301-8805-64789735db7a ', '172.31.222.184', '2023-04-29 07:16:42');
INSERT INTO `sys_log` VALUES (246, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 30bb31f7-1385-44c1-9977-e9285821621d ', '172.31.222.184', '2023-04-29 07:17:16');
INSERT INTO `sys_log` VALUES (247, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: d5921872-5104-49ac-a6d5-1c97013a4966 ', '172.31.222.184', '2023-04-29 07:17:24');
INSERT INTO `sys_log` VALUES (248, 'com.example.demo.controller.CaptchaController.getRandomCode()', 15, 'uuid: b7b23438-31f2-4f3c-b300-0a1f00500a0d ', '172.31.222.184', '2023-04-29 07:17:36');
INSERT INTO `sys_log` VALUES (249, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: dc8ffe65-f827-46e9-869c-ff7816ebb700 ', '172.31.222.184', '2023-04-29 07:18:29');
INSERT INTO `sys_log` VALUES (250, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: d0618c12-9a68-4684-9f3d-43ecf112e4af ', '172.31.222.184', '2023-04-29 07:18:51');
INSERT INTO `sys_log` VALUES (251, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: bf8d9180-3aca-4aa6-a065-dd4fc7d36879 ', '172.31.222.184', '2023-04-29 07:20:40');
INSERT INTO `sys_log` VALUES (252, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 4fe079bb-335a-4ca0-a2a4-d9a507bd430a ', '172.31.222.184', '2023-04-29 07:20:40');
INSERT INTO `sys_log` VALUES (253, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 475487d9-9acf-41d8-8e06-0a3d4f7164ac ', '172.31.222.184', '2023-04-29 07:20:48');
INSERT INTO `sys_log` VALUES (254, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 2d0a9892-902b-4c5e-93f5-388981d8d235 ', '172.31.222.184', '2023-04-29 07:21:12');
INSERT INTO `sys_log` VALUES (255, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 34ea895c-6388-47e4-b57e-680a24a86f79 ', '172.31.222.184', '2023-04-29 07:21:44');
INSERT INTO `sys_log` VALUES (256, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: abbfeb8f-411a-4f89-a696-e5828ee3f187 ', '172.31.222.184', '2023-04-29 07:22:09');
INSERT INTO `sys_log` VALUES (257, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 912fa7b6-e6a4-4e7f-8835-8c5d1b8b4a9c ', '172.31.222.184', '2023-04-29 07:22:27');
INSERT INTO `sys_log` VALUES (258, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: c00a0b8f-87e5-4a94-bbb9-3f8d69812101 ', '172.31.222.184', '2023-04-29 07:22:43');
INSERT INTO `sys_log` VALUES (259, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: e2d4a7de-9166-48ce-bd52-df4d6eac3b0b ', '172.31.222.184', '2023-04-29 07:22:50');
INSERT INTO `sys_log` VALUES (260, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: b5700f6c-9724-4222-820c-93aa5341e120 ', '172.31.222.184', '2023-04-29 07:22:59');
INSERT INTO `sys_log` VALUES (261, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 8ac9e55f-6308-4a0e-992c-361d5fb377d6 ', '172.31.222.184', '2023-04-29 07:23:25');
INSERT INTO `sys_log` VALUES (262, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 43c7cab2-2629-4d0f-83ad-1465efeebde4 ', '172.31.222.184', '2023-04-29 07:23:37');
INSERT INTO `sys_log` VALUES (263, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 263817f0-a020-4a87-bfaf-a6e562a948ed ', '172.31.222.184', '2023-04-29 07:27:11');
INSERT INTO `sys_log` VALUES (264, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 95fcc634-aec2-4d6f-8c5e-6cd93175889a ', '172.31.222.184', '2023-04-29 07:27:46');
INSERT INTO `sys_log` VALUES (265, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 443b3e0a-1fcf-4107-99e8-62abb0277962 ', '172.31.222.184', '2023-04-29 07:29:34');
INSERT INTO `sys_log` VALUES (266, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: c941a94c-123c-48fe-bf10-e9166e56af5a ', '172.31.222.184', '2023-04-29 07:29:36');
INSERT INTO `sys_log` VALUES (267, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: addb9d75-064d-4cf6-9986-1f28c21bf682 ', '172.31.222.184', '2023-04-29 07:29:53');
INSERT INTO `sys_log` VALUES (268, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 2d06afed-d7ef-4c81-aab6-694040718aca ', '172.31.222.184', '2023-04-29 07:30:00');
INSERT INTO `sys_log` VALUES (269, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 2882c4ea-b677-468d-b9f2-d28574c3a28c ', '172.31.222.184', '2023-04-29 07:30:02');
INSERT INTO `sys_log` VALUES (270, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 041404d9-456d-4a44-92fe-5941bd737d4c ', '172.31.222.184', '2023-04-29 07:30:04');
INSERT INTO `sys_log` VALUES (271, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 0a16bc97-7eb9-44de-ba4e-a72e7fff8756 ', '172.31.222.184', '2023-04-29 07:30:05');
INSERT INTO `sys_log` VALUES (272, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 04e51bee-6c7a-420c-b701-a6e3e9894d47 ', '172.31.222.184', '2023-04-29 07:30:17');
INSERT INTO `sys_log` VALUES (273, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 7ea49adb-49a7-4331-9a42-132d8d33387b ', '172.31.222.184', '2023-04-29 07:30:19');
INSERT INTO `sys_log` VALUES (274, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: a62ad3ff-818b-45df-9742-14eac40cfbfe ', '172.31.222.184', '2023-04-29 07:30:20');
INSERT INTO `sys_log` VALUES (275, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: eab1d123-73dc-4849-9d01-beed97a7e160 ', '172.31.222.184', '2023-04-29 07:31:08');
INSERT INTO `sys_log` VALUES (276, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 3f76ceb1-dc51-49fd-8fdf-8693d1ac024f ', '172.31.222.184', '2023-04-29 07:31:08');
INSERT INTO `sys_log` VALUES (277, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: e90d78b6-5121-4d84-8a64-856783bfae85 ', '172.31.222.184', '2023-04-29 07:31:09');
INSERT INTO `sys_log` VALUES (278, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 8e2a96a0-e87b-4d7e-a636-0456d963aed7 ', '172.31.222.184', '2023-04-29 07:31:10');
INSERT INTO `sys_log` VALUES (279, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 8d9e9b8c-b13f-453e-bb46-a4fe7fbcb8b0 ', '172.31.222.184', '2023-04-29 07:31:11');
INSERT INTO `sys_log` VALUES (280, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 72fb61b9-68d2-40b6-98f2-2f6d99a45da6 ', '172.31.222.184', '2023-04-29 07:31:18');
INSERT INTO `sys_log` VALUES (281, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 1dadcb5b-3fe8-4e72-aa6e-7c76f3ec87a3 ', '172.31.222.184', '2023-04-29 07:32:40');
INSERT INTO `sys_log` VALUES (282, 'com.example.demo.controller.CaptchaController.getRandomCode()', 3, 'uuid: fc16aaa3-c3ac-49c0-85f5-21f70d063f1b ', '172.31.222.184', '2023-04-29 07:32:42');
INSERT INTO `sys_log` VALUES (283, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: b9723540-3984-4722-ab1b-fe6ba1af01c4 ', '172.31.222.184', '2023-04-29 07:34:54');
INSERT INTO `sys_log` VALUES (284, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 8a1623c9-ec24-4a20-80f5-e1f6a385bf31 ', '172.31.222.184', '2023-04-29 07:34:57');
INSERT INTO `sys_log` VALUES (285, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 3a6a57d6-8679-4daf-9912-aeb8b3f0e0c2 ', '172.31.222.184', '2023-04-29 07:35:39');
INSERT INTO `sys_log` VALUES (286, 'com.example.demo.controller.CaptchaController.getRandomCode()', 25, 'uuid: 7c86487e-0e69-4372-a2fa-14fdd3c17cc4 ', '172.31.222.184', '2023-04-29 07:35:39');
INSERT INTO `sys_log` VALUES (287, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 65b88098-0d32-493c-a896-ec3dad0b9d04 ', '172.31.222.184', '2023-04-29 07:35:41');
INSERT INTO `sys_log` VALUES (288, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: b1692cfc-980e-4847-b680-e74bb86e6bf3 ', '172.31.222.184', '2023-04-29 07:35:43');
INSERT INTO `sys_log` VALUES (289, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 139c0256-4459-4627-94ed-49ee1f61861f ', '172.31.222.184', '2023-04-29 07:36:52');
INSERT INTO `sys_log` VALUES (290, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: b85451f6-98f7-4424-993a-d004ebda5776 ', '172.31.222.184', '2023-04-29 07:36:53');
INSERT INTO `sys_log` VALUES (291, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: aa76d0c0-f14e-4c23-9f38-6bb8904b96ac ', '172.31.222.184', '2023-04-29 07:36:57');
INSERT INTO `sys_log` VALUES (292, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 4eb73959-d4be-4d7a-a38a-a908d293b62f ', '172.31.222.184', '2023-04-29 07:37:23');
INSERT INTO `sys_log` VALUES (293, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 52b6a9c4-327d-49d1-9744-73a6444a84b8 ', '172.31.222.184', '2023-04-29 07:38:00');
INSERT INTO `sys_log` VALUES (294, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: aecd1d44-b9cc-488c-8362-2cdc1176ebf3 ', '172.31.222.184', '2023-04-29 07:38:35');
INSERT INTO `sys_log` VALUES (295, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 98bb8f06-f10e-4b2d-a0b2-eeb09b660359 ', '172.31.222.184', '2023-04-29 07:39:08');
INSERT INTO `sys_log` VALUES (296, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 14e9a0c9-1140-416b-bdac-a941e5fdd734 ', '172.31.222.184', '2023-04-29 07:39:08');
INSERT INTO `sys_log` VALUES (297, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 28f1f4d6-4222-4c6e-be1a-5cb58c338b40 ', '172.31.222.184', '2023-04-29 07:39:25');
INSERT INTO `sys_log` VALUES (298, 'com.example.demo.controller.CaptchaController.getRandomCode()', 100, 'uuid: 7cd64b21-1bf4-46a7-b63e-4bdca9304d62 ', '172.31.222.184', '2023-04-29 07:40:07');
INSERT INTO `sys_log` VALUES (299, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 34d3e9db-ce83-4dfb-91c3-bc0efd9e49c5 ', '172.31.222.184', '2023-04-29 07:40:09');
INSERT INTO `sys_log` VALUES (300, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 32eb1a4a-349a-487a-bb2b-320eead217d6 ', '172.31.222.184', '2023-04-29 07:40:10');
INSERT INTO `sys_log` VALUES (301, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 63c0c7ad-8211-49d8-a904-5f384e99887b ', '172.31.222.184', '2023-04-29 07:40:11');
INSERT INTO `sys_log` VALUES (302, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 98b392d4-d9f4-4eb4-bcb9-3b5360996bc0 ', '172.31.222.184', '2023-04-29 07:40:12');
INSERT INTO `sys_log` VALUES (303, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: d4f36146-0ec1-43e0-996e-71b00cc28f29 ', '172.31.222.184', '2023-04-29 07:40:40');
INSERT INTO `sys_log` VALUES (304, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: 4cd275ea-f0f3-4711-9ce8-af002102094a ', '172.31.222.184', '2023-04-29 07:41:19');
INSERT INTO `sys_log` VALUES (305, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 3a6f5b75-b642-4888-8051-022b5a646224 ', '172.31.222.184', '2023-04-29 07:41:25');
INSERT INTO `sys_log` VALUES (306, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 92b21cc1-85f0-4b04-a7c6-e3ab8310bc73 ', '172.31.222.184', '2023-04-29 07:41:26');
INSERT INTO `sys_log` VALUES (307, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: c6b3ba10-b540-433e-9278-d7b076e3b57b ', '172.31.222.184', '2023-04-29 07:41:27');
INSERT INTO `sys_log` VALUES (308, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: c271dc0c-6b2e-4251-90c0-4df562d0a572 ', '172.31.222.184', '2023-04-29 07:41:31');
INSERT INTO `sys_log` VALUES (309, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 3efc0133-d540-440d-b4b6-c3a4f2c0adca ', '172.31.222.184', '2023-04-29 07:41:32');
INSERT INTO `sys_log` VALUES (310, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 50dc5137-515f-460a-9ce5-4b68d8dfcac6 ', '172.31.222.184', '2023-04-29 07:41:32');
INSERT INTO `sys_log` VALUES (311, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 741d1002-9aab-400e-a496-107bca354b3f ', '172.31.222.184', '2023-04-29 07:41:34');
INSERT INTO `sys_log` VALUES (312, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: ea472e5c-e243-4bff-945c-a5855212d0e9 ', '172.31.222.184', '2023-04-29 07:41:58');
INSERT INTO `sys_log` VALUES (313, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: da667eb4-d6ad-440e-8b6a-215d1351878e ', '172.31.222.184', '2023-04-29 07:45:20');
INSERT INTO `sys_log` VALUES (314, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: d9728ae0-75c8-4666-b0b2-3293f1ce32f1 ', '172.31.222.184', '2023-04-29 07:45:42');
INSERT INTO `sys_log` VALUES (315, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid:  ', '127.0.0.1', '2023-04-29 07:51:03');
INSERT INTO `sys_log` VALUES (316, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid:  ', '127.0.0.1', '2023-04-29 07:51:35');
INSERT INTO `sys_log` VALUES (317, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid:  ', '127.0.0.1', '2023-04-29 07:53:39');
INSERT INTO `sys_log` VALUES (318, 'com.example.demo.controller.CaptchaController.getRandomCode()', 27797, 'uuid:  ', '127.0.0.1', '2023-04-29 07:54:14');
INSERT INTO `sys_log` VALUES (319, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid:  ', '127.0.0.1', '2023-04-29 08:01:51');
INSERT INTO `sys_log` VALUES (320, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid:  ', '127.0.0.1', '2023-04-29 08:02:44');
INSERT INTO `sys_log` VALUES (321, 'com.example.demo.controller.CaptchaController.getRandomCode()', 120, 'uuid: \"\" ', '127.0.0.1', '2023-04-29 08:02:49');
INSERT INTO `sys_log` VALUES (322, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 1 ', '127.0.0.1', '2023-04-29 08:04:21');
INSERT INTO `sys_log` VALUES (323, 'com.example.demo.controller.UserController.getUser()', 8, '', '127.0.0.1', '2023-04-29 08:17:44');
INSERT INTO `sys_log` VALUES (324, 'com.example.demo.controller.UserController.getUser()', 10, '', '127.0.0.1', '2023-04-29 08:51:23');
INSERT INTO `sys_log` VALUES (325, 'com.example.demo.controller.UserController.getUser()', 10, '', '127.0.0.1', '2023-04-29 09:17:09');
INSERT INTO `sys_log` VALUES (326, 'com.example.demo.controller.UserController.getUser()', 4, '', '127.0.0.1', '2023-04-29 11:15:12');
INSERT INTO `sys_log` VALUES (327, 'com.example.demo.controller.CaptchaController.getRandomCode()', 161, 'uuid: 1 ', '127.0.0.1', '2023-04-30 12:16:16');
INSERT INTO `sys_log` VALUES (328, 'com.example.demo.controller.CaptchaController.getRandomCode()', 156, 'uuid: 1 ', '127.0.0.1', '2023-05-01 04:51:51');
INSERT INTO `sys_log` VALUES (329, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-01 04:51:58');
INSERT INTO `sys_log` VALUES (330, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 1 ', '127.0.0.1', '2023-05-01 04:53:38');
INSERT INTO `sys_log` VALUES (331, 'com.example.demo.controller.CaptchaController.getRandomCode()', 139, 'uuid: 1 ', '127.0.0.1', '2023-05-01 06:51:59');
INSERT INTO `sys_log` VALUES (332, 'com.example.demo.controller.CaptchaController.getRandomCode()', 117, 'uuid: 1 ', '127.0.0.1', '2023-05-01 06:52:34');
INSERT INTO `sys_log` VALUES (333, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 1 ', '127.0.0.1', '2023-05-01 06:53:00');
INSERT INTO `sys_log` VALUES (334, 'com.example.demo.controller.UserController.getUser()', 3, '', '127.0.0.1', '2023-05-01 06:53:03');
INSERT INTO `sys_log` VALUES (335, 'com.example.demo.controller.CaptchaController.getRandomCode()', 182, 'uuid: 52eebd77-6e84-4639-a022-fb12802348f3 ', '172.31.222.184', '2023-05-01 08:42:35');
INSERT INTO `sys_log` VALUES (336, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: c816149d-f419-4fa3-b832-fd3ec82506ac ', '172.31.222.184', '2023-05-01 08:45:14');
INSERT INTO `sys_log` VALUES (337, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 6e43dcb8-eb17-48cf-a1e0-2c94a9d43cb6 ', '172.31.222.184', '2023-05-01 08:45:15');
INSERT INTO `sys_log` VALUES (338, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: c8df7766-acc2-43d8-a1f7-a019e40c0b0c ', '172.31.222.184', '2023-05-01 08:47:43');
INSERT INTO `sys_log` VALUES (339, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 29015f38-8264-489c-bce1-5f4e67371b27 ', '172.31.222.184', '2023-05-01 08:49:15');
INSERT INTO `sys_log` VALUES (340, 'com.example.demo.controller.CaptchaController.getRandomCode()', 15, 'uuid: 6e158c77-cdca-4afc-8c01-5b120416f023 ', '172.31.222.184', '2023-05-01 08:49:18');
INSERT INTO `sys_log` VALUES (341, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 915928ea-da29-4926-a667-24f67fff848d ', '172.31.222.184', '2023-05-01 08:49:26');
INSERT INTO `sys_log` VALUES (342, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 20082588-1ad4-4e1c-85e7-e3b85ea4ccbd ', '172.31.222.184', '2023-05-01 08:49:27');
INSERT INTO `sys_log` VALUES (343, 'com.example.demo.controller.CaptchaController.getRandomCode()', 108, 'uuid: fa15a30d-af63-44b8-9dbb-8d9852f2cdf9 ', '172.31.222.184', '2023-05-01 08:54:26');
INSERT INTO `sys_log` VALUES (344, 'com.example.demo.controller.CaptchaController.getRandomCode()', 16, 'uuid: b401f553-dd1d-431f-9c20-3570020484c0 ', '172.31.222.184', '2023-05-01 08:54:51');
INSERT INTO `sys_log` VALUES (345, 'com.example.demo.controller.CaptchaController.getRandomCode()', 109, 'uuid: 566a67f1-e845-4cba-abd1-7f3db517808f ', '172.31.222.184', '2023-05-01 08:57:58');
INSERT INTO `sys_log` VALUES (346, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 566a67f1-e845-4cba-abd1-7f3db517808f ', '172.31.222.184', '2023-05-01 08:58:02');
INSERT INTO `sys_log` VALUES (347, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 05ac145a-3371-4632-84e0-9493cd9db04e ', '172.31.222.184', '2023-05-01 08:58:14');
INSERT INTO `sys_log` VALUES (348, 'com.example.demo.controller.CaptchaController.getRandomCode()', 110, 'uuid: c192a052-0772-4835-9438-61f8f5eff1e4 ', '172.31.222.184', '2023-05-01 08:58:57');
INSERT INTO `sys_log` VALUES (349, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: ab0290a0-9894-4d91-b37c-89af1a6ad0bb ', '172.31.222.184', '2023-05-01 08:59:47');
INSERT INTO `sys_log` VALUES (350, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: e561b2fe-7a17-4db3-8ce6-36d91505148b ', '172.31.222.184', '2023-05-01 09:00:48');
INSERT INTO `sys_log` VALUES (351, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: ce93ee68-1b7e-4872-b2ae-d84546a69d1c ', '172.31.222.184', '2023-05-01 09:01:37');
INSERT INTO `sys_log` VALUES (352, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 6feade30-4962-47c9-b6f3-bc3480cb2932 ', '172.31.222.184', '2023-05-01 09:03:10');
INSERT INTO `sys_log` VALUES (353, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: db3fa89f-16d6-4438-b1cb-bd775d55c421 ', '172.31.222.184', '2023-05-01 09:03:11');
INSERT INTO `sys_log` VALUES (354, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: c8f8cba6-e2ea-41ce-8163-f3545bbca4e7 ', '172.31.222.184', '2023-05-01 09:03:18');
INSERT INTO `sys_log` VALUES (355, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: a2942dc7-1cb2-4398-9902-5e39258ab020 ', '172.31.222.184', '2023-05-01 09:03:39');
INSERT INTO `sys_log` VALUES (356, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: d01fb724-4239-4062-bd7c-e05233002093 ', '172.31.222.184', '2023-05-01 09:03:41');
INSERT INTO `sys_log` VALUES (357, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: c8189d24-e792-48a2-9db1-874f980f6aaa ', '172.31.222.184', '2023-05-01 09:03:43');
INSERT INTO `sys_log` VALUES (358, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: bbac46fe-6ba1-4cdd-a361-1497a3ae69ab ', '172.31.222.184', '2023-05-01 09:03:45');
INSERT INTO `sys_log` VALUES (359, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 7304b011-2f84-403d-bdbc-44053bceec13 ', '172.31.222.184', '2023-05-01 09:08:06');
INSERT INTO `sys_log` VALUES (360, 'com.example.demo.controller.CaptchaController.getRandomCode()', 15, 'uuid: e9d6d5c8-6669-4dfd-8a98-c17a431cdf5c ', '172.31.222.184', '2023-05-01 09:09:52');
INSERT INTO `sys_log` VALUES (361, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: ac8931a1-5c7f-490c-ac75-d22ce59fbbb4 ', '172.31.222.184', '2023-05-01 09:16:29');
INSERT INTO `sys_log` VALUES (362, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: c1b12e4f-301f-43b5-87a4-86d50a7181cf ', '172.31.222.184', '2023-05-01 09:16:59');
INSERT INTO `sys_log` VALUES (363, 'com.example.demo.controller.CaptchaController.getRandomCode()', 113, 'uuid: 6f6f0936-5ded-47b1-9357-e45b0edbfab2 ', '172.31.222.184', '2023-05-01 09:23:24');
INSERT INTO `sys_log` VALUES (364, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: d15dd964-102e-4a01-8ef3-5b26785d9b5c ', '172.31.222.184', '2023-05-01 09:23:49');
INSERT INTO `sys_log` VALUES (365, 'com.example.demo.controller.CaptchaController.getRandomCode()', 16, 'uuid: 0e89181a-eb5b-44df-a3b4-506efe096f86 ', '172.31.222.184', '2023-05-01 09:24:15');
INSERT INTO `sys_log` VALUES (366, 'com.example.demo.controller.CaptchaController.getRandomCode()', 16, 'uuid: 7976456b-8308-41d3-a38d-b9fff8fda168 ', '172.31.222.184', '2023-05-01 09:25:26');
INSERT INTO `sys_log` VALUES (367, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 4e82b34c-838a-45f6-b659-a4e6d47aa5fc ', '172.31.222.184', '2023-05-01 09:25:27');
INSERT INTO `sys_log` VALUES (368, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: c765f45c-597b-448d-831c-6e1eea435ea5 ', '172.31.222.184', '2023-05-01 09:25:29');
INSERT INTO `sys_log` VALUES (369, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: abf520f4-a79e-407c-912a-42d56b0950eb ', '172.31.222.184', '2023-05-01 09:25:41');
INSERT INTO `sys_log` VALUES (370, 'com.example.demo.controller.CaptchaController.getRandomCode()', 203, 'uuid: 3d8df47b-d2f7-4340-97ff-b9eb0eb9364c ', '172.31.222.184', '2023-05-01 11:33:30');
INSERT INTO `sys_log` VALUES (371, 'com.example.demo.controller.CaptchaController.getRandomCode()', 231, 'uuid: 2050981c-f0a0-45f8-baac-1e49c3bfe35b ', '58.198.176.171', '2023-05-02 08:27:01');
INSERT INTO `sys_log` VALUES (372, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 2371ba57-f7a2-4f45-b7b8-4ca06599f2cc ', '58.198.176.171', '2023-05-02 08:27:14');
INSERT INTO `sys_log` VALUES (373, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 80fdbc42-981e-4237-bba4-f2930243af29 ', '58.198.176.171', '2023-05-02 08:27:22');
INSERT INTO `sys_log` VALUES (374, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: 4be95fda-4815-4d12-afb4-dc22fe78354d ', '172.20.158.254', '2023-05-02 09:30:37');
INSERT INTO `sys_log` VALUES (375, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: b8b1a4ee-e8dd-48fb-a9df-a725f62ceb25 ', '172.20.159.5', '2023-05-02 13:59:17');
INSERT INTO `sys_log` VALUES (376, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 23643544-e635-465c-8814-d249e0d02941 ', '172.20.159.5', '2023-05-02 14:03:11');
INSERT INTO `sys_log` VALUES (377, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 63d06bbb-bda6-4849-b311-6a164a9cdf01 ', '172.20.159.5', '2023-05-02 14:03:30');
INSERT INTO `sys_log` VALUES (378, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 7d344da8-e0c3-4b19-8b0d-bacefd693235 ', '172.20.159.5', '2023-05-02 14:03:31');
INSERT INTO `sys_log` VALUES (379, 'com.example.demo.controller.CaptchaController.getRandomCode()', 221, 'uuid: adb45d3e-907c-4565-af83-5dc58feac3e2 ', '172.20.159.37', '2023-05-03 05:22:24');
INSERT INTO `sys_log` VALUES (380, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 96ae5e92-0fbb-434c-8655-2b1bdb5ff92d ', '172.20.159.37', '2023-05-03 05:22:30');
INSERT INTO `sys_log` VALUES (381, 'com.example.demo.controller.CaptchaController.getRandomCode()', 243, 'uuid: 1e6b8684-6aa1-4b07-bf5a-ea3173bf048a ', '172.20.144.141', '2023-05-06 04:54:55');
INSERT INTO `sys_log` VALUES (382, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: d0d8aba4-4b62-49d1-b7e8-56da58840ee2 ', '172.20.144.141', '2023-05-06 04:54:57');
INSERT INTO `sys_log` VALUES (383, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 39fc5e4a-244b-4ed3-a2b9-955e9c025630 ', '172.20.144.141', '2023-05-06 04:55:13');
INSERT INTO `sys_log` VALUES (384, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 34307948-e1d7-4186-9f4d-b4a859b7dac4 ', '172.20.144.141', '2023-05-06 04:55:15');
INSERT INTO `sys_log` VALUES (385, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: c2004ffb-95ec-464e-b4c6-31ab778a5781 ', '172.20.144.141', '2023-05-06 06:36:55');
INSERT INTO `sys_log` VALUES (386, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 7bbad84a-186f-474d-9d74-beb1a9949d9b ', '172.20.144.141', '2023-05-06 06:44:29');
INSERT INTO `sys_log` VALUES (387, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: a16e7cc6-63fe-4f12-a78b-71ca458dcb2c ', '172.20.144.141', '2023-05-06 06:44:39');
INSERT INTO `sys_log` VALUES (388, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 3e53357f-1fdf-4cab-b71d-6237e2f30a70 ', '172.20.144.141', '2023-05-06 06:44:39');
INSERT INTO `sys_log` VALUES (389, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 000e3790-294e-4ae0-9258-7cb8ec62fb84 ', '172.20.144.141', '2023-05-06 06:50:02');
INSERT INTO `sys_log` VALUES (390, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: a7dbf348-5149-4166-a423-04d7ffd1e7c6 ', '172.20.144.141', '2023-05-06 06:50:10');
INSERT INTO `sys_log` VALUES (391, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: d925467c-f8c7-4f82-bb09-7c95b39aabe2 ', '172.20.144.141', '2023-05-06 06:50:25');
INSERT INTO `sys_log` VALUES (392, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: b5ffc008-8f10-4b2e-b6c8-aaefe2c3f914 ', '172.20.144.141', '2023-05-06 06:52:15');
INSERT INTO `sys_log` VALUES (393, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 5e6e2e84-dde0-449e-bbf1-c16e7add085b ', '172.20.144.141', '2023-05-06 06:53:48');
INSERT INTO `sys_log` VALUES (394, 'com.example.demo.controller.CaptchaController.getRandomCode()', 224, 'uuid: 486613dc-a986-4f69-b3ad-58d6c2ca78cb ', '172.30.212.58', '2023-05-10 10:41:44');
INSERT INTO `sys_log` VALUES (395, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: c14bab35-3828-430f-bc5f-06da36eb9666 ', '172.30.212.58', '2023-05-10 10:51:19');
INSERT INTO `sys_log` VALUES (396, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 331181d9-1742-49e4-b64e-56fabeea032d ', '172.30.212.58', '2023-05-10 10:55:42');
INSERT INTO `sys_log` VALUES (397, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: cf4358fa-577f-4fc9-a7e4-7bc0514a0ca6 ', '172.30.212.58', '2023-05-10 10:55:48');
INSERT INTO `sys_log` VALUES (398, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 652c6bce-5776-4be8-92fb-d303d8a725e2 ', '172.30.212.58', '2023-05-10 10:55:51');
INSERT INTO `sys_log` VALUES (399, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 04ffde7f-23ad-4953-9ab1-97eb8bb7502e ', '172.30.212.58', '2023-05-10 10:55:53');
INSERT INTO `sys_log` VALUES (400, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 493b4296-0529-459a-9cc9-dd68d1f23498 ', '172.30.212.58', '2023-05-10 10:56:08');
INSERT INTO `sys_log` VALUES (401, 'com.example.demo.controller.CaptchaController.getRandomCode()', 17, 'uuid: 04c73162-a75d-4f41-bb1b-0eb8706abe39 ', '58.198.176.171', '2023-05-10 11:45:25');
INSERT INTO `sys_log` VALUES (402, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:28');
INSERT INTO `sys_log` VALUES (403, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:45');
INSERT INTO `sys_log` VALUES (404, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:50');
INSERT INTO `sys_log` VALUES (405, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:50');
INSERT INTO `sys_log` VALUES (406, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:51');
INSERT INTO `sys_log` VALUES (407, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:56');
INSERT INTO `sys_log` VALUES (408, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:50:56');
INSERT INTO `sys_log` VALUES (409, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:01');
INSERT INTO `sys_log` VALUES (410, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:02');
INSERT INTO `sys_log` VALUES (411, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:02');
INSERT INTO `sys_log` VALUES (412, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:02');
INSERT INTO `sys_log` VALUES (413, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:03');
INSERT INTO `sys_log` VALUES (414, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:07');
INSERT INTO `sys_log` VALUES (415, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:11');
INSERT INTO `sys_log` VALUES (416, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:12');
INSERT INTO `sys_log` VALUES (417, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:13');
INSERT INTO `sys_log` VALUES (418, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:16');
INSERT INTO `sys_log` VALUES (419, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:32');
INSERT INTO `sys_log` VALUES (420, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:37');
INSERT INTO `sys_log` VALUES (421, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:37');
INSERT INTO `sys_log` VALUES (422, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:37');
INSERT INTO `sys_log` VALUES (423, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:38');
INSERT INTO `sys_log` VALUES (424, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:38');
INSERT INTO `sys_log` VALUES (425, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:38');
INSERT INTO `sys_log` VALUES (426, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:38');
INSERT INTO `sys_log` VALUES (427, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:38');
INSERT INTO `sys_log` VALUES (428, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:51:38');
INSERT INTO `sys_log` VALUES (429, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:16');
INSERT INTO `sys_log` VALUES (430, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:16');
INSERT INTO `sys_log` VALUES (431, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:18');
INSERT INTO `sys_log` VALUES (432, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:18');
INSERT INTO `sys_log` VALUES (433, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:18');
INSERT INTO `sys_log` VALUES (434, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:22');
INSERT INTO `sys_log` VALUES (435, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:22');
INSERT INTO `sys_log` VALUES (436, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:22');
INSERT INTO `sys_log` VALUES (437, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:45');
INSERT INTO `sys_log` VALUES (438, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:45');
INSERT INTO `sys_log` VALUES (439, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:45');
INSERT INTO `sys_log` VALUES (440, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:45');
INSERT INTO `sys_log` VALUES (441, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:46');
INSERT INTO `sys_log` VALUES (442, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:46');
INSERT INTO `sys_log` VALUES (443, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:46');
INSERT INTO `sys_log` VALUES (444, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:46');
INSERT INTO `sys_log` VALUES (445, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 1 ', '127.0.0.1', '2023-05-10 11:52:46');
INSERT INTO `sys_log` VALUES (446, 'com.example.demo.controller.CaptchaController.getRandomCode()', 21, 'uuid: cbbbe016-58f4-4377-a5f4-fe81b369403b ', '172.20.146.94', '2023-05-11 03:19:58');
INSERT INTO `sys_log` VALUES (447, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 978a7265-dfbf-470b-b684-589cc12a61d3 ', '172.20.146.94', '2023-05-11 03:20:13');
INSERT INTO `sys_log` VALUES (448, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 2cabc8f1-2012-4813-92d5-5ea25520d44f ', '172.20.146.94', '2023-05-11 03:20:14');
INSERT INTO `sys_log` VALUES (449, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: e3892751-9929-438f-9d38-00b35cb6807e ', '172.20.146.94', '2023-05-11 03:20:19');
INSERT INTO `sys_log` VALUES (450, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 5d5f97b0-bb43-44c2-b5c2-5bdf37239d2d ', '172.20.146.94', '2023-05-11 03:20:24');
INSERT INTO `sys_log` VALUES (451, 'com.example.demo.controller.CaptchaController.getRandomCode()', 184, 'uuid: a ', '172.31.159.233', '2023-05-12 02:16:46');
INSERT INTO `sys_log` VALUES (452, 'com.example.demo.controller.CaptchaController.getRandomCode()', 142, 'uuid: 11daabb3-6426-481d-a23b-071653cfe033 ', '127.0.0.1', '2023-05-12 06:58:59');
INSERT INTO `sys_log` VALUES (453, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 89b04949-ba6f-4b56-b087-783aa5b4e7f5 ', '127.0.0.1', '2023-05-12 06:59:04');
INSERT INTO `sys_log` VALUES (454, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: a91b1279-573c-4c79-9de1-e52f106f96a7 ', '127.0.0.1', '2023-05-12 06:59:05');
INSERT INTO `sys_log` VALUES (455, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 71f7bae4-71b9-4495-86b7-1532f9ed98ff ', '127.0.0.1', '2023-05-12 06:59:05');
INSERT INTO `sys_log` VALUES (456, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 5ebfb79b-138e-4040-be7b-e5e4cf55b4e0 ', '127.0.0.1', '2023-05-12 06:59:05');
INSERT INTO `sys_log` VALUES (457, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 26815a1a-f7be-4d5f-af95-24bed13fc503 ', '127.0.0.1', '2023-05-12 06:59:05');
INSERT INTO `sys_log` VALUES (458, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: bfd166aa-eab0-4454-ada1-f0f07a06d2a2 ', '127.0.0.1', '2023-05-12 06:59:06');
INSERT INTO `sys_log` VALUES (459, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: d3924e81-acff-4da3-afc1-4c1c87c69ef5 ', '127.0.0.1', '2023-05-12 06:59:06');
INSERT INTO `sys_log` VALUES (460, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: ff233a40-31de-457f-b728-6fd36cbeaace ', '127.0.0.1', '2023-05-12 06:59:06');
INSERT INTO `sys_log` VALUES (461, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 744383de-ddf6-494f-b744-4f06824db751 ', '127.0.0.1', '2023-05-12 06:59:07');
INSERT INTO `sys_log` VALUES (462, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 4abeab20-08a9-46e5-9611-abf730285d17 ', '127.0.0.1', '2023-05-12 06:59:07');
INSERT INTO `sys_log` VALUES (463, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: d486d833-8779-4f6f-bb29-12bcf0076a05 ', '127.0.0.1', '2023-05-12 06:59:08');
INSERT INTO `sys_log` VALUES (464, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: b4ce364c-ea05-4568-9e27-43e6c23be589 ', '127.0.0.1', '2023-05-12 06:59:08');
INSERT INTO `sys_log` VALUES (465, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 6e5dda68-ad02-4a15-b4bf-0581498e16be ', '127.0.0.1', '2023-05-12 06:59:09');
INSERT INTO `sys_log` VALUES (466, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 3a0ec2c8-3ce4-44c9-9a22-52cd6463837b ', '127.0.0.1', '2023-05-12 06:59:09');
INSERT INTO `sys_log` VALUES (467, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: d30b272f-0274-4f0a-a41b-0624eb665d79 ', '127.0.0.1', '2023-05-12 06:59:09');
INSERT INTO `sys_log` VALUES (468, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 6bbf8794-9b1d-4f34-9394-ca0232f95e14 ', '127.0.0.1', '2023-05-12 06:59:10');
INSERT INTO `sys_log` VALUES (469, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 7b5e5a25-7cc0-4fec-a2dc-eae783c6d2fd ', '127.0.0.1', '2023-05-12 06:59:10');
INSERT INTO `sys_log` VALUES (470, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: b29e4fd6-3b05-44d1-a286-9cb9c589be8b ', '127.0.0.1', '2023-05-12 06:59:11');
INSERT INTO `sys_log` VALUES (471, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: eef931d2-98bd-40eb-936f-f66188689207 ', '127.0.0.1', '2023-05-12 07:00:36');
INSERT INTO `sys_log` VALUES (472, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: 77a059d1-8322-4d02-a8df-990bca492880 ', '127.0.0.1', '2023-05-12 07:00:36');
INSERT INTO `sys_log` VALUES (473, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 8cfb82a4-fdd2-47e0-9a7d-ff99e103bc01 ', '127.0.0.1', '2023-05-12 07:00:36');
INSERT INTO `sys_log` VALUES (474, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 908d1bb4-60bc-4bee-a9bd-0e6e007ad010 ', '127.0.0.1', '2023-05-12 07:00:37');
INSERT INTO `sys_log` VALUES (475, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 7749b488-021c-4ffd-941f-faefee1021fc ', '127.0.0.1', '2023-05-12 07:00:37');
INSERT INTO `sys_log` VALUES (476, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 5c043124-98ba-4a69-8365-37ae3f68d90e ', '127.0.0.1', '2023-05-12 07:00:38');
INSERT INTO `sys_log` VALUES (477, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 89f685fb-4252-4347-b32a-a104c592891a ', '127.0.0.1', '2023-05-12 07:00:38');
INSERT INTO `sys_log` VALUES (478, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 18440434-f51b-4bc6-9360-e4dd60079379 ', '127.0.0.1', '2023-05-12 07:00:39');
INSERT INTO `sys_log` VALUES (479, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: f8fe5d17-8966-4654-9504-5a14f12050d4 ', '127.0.0.1', '2023-05-12 07:00:39');
INSERT INTO `sys_log` VALUES (480, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: dccc90cd-5a8f-4b4e-9a23-a417b88db577 ', '127.0.0.1', '2023-05-12 07:00:39');
INSERT INTO `sys_log` VALUES (481, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: e5081371-503c-402a-8951-cce194cc7552 ', '127.0.0.1', '2023-05-12 07:00:39');
INSERT INTO `sys_log` VALUES (482, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 85553816-7b82-4b3e-a16e-f277d56ca081 ', '127.0.0.1', '2023-05-12 07:00:40');
INSERT INTO `sys_log` VALUES (483, 'com.example.demo.controller.CaptchaController.getRandomCode()', 12, 'uuid: 58f5e965-e911-4a18-8af5-1bd73254d028 ', '127.0.0.1', '2023-05-12 07:00:40');
INSERT INTO `sys_log` VALUES (484, 'com.example.demo.controller.CaptchaController.getRandomCode()', 106, 'uuid: 918be902-6ae8-4ac1-91c5-b66032d49ee0 ', '127.0.0.1', '2023-05-12 07:03:07');
INSERT INTO `sys_log` VALUES (485, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: f36d5484-b0a7-4976-844c-7529a1527778 ', '127.0.0.1', '2023-05-12 07:03:08');
INSERT INTO `sys_log` VALUES (486, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 135c443c-260b-4838-afe7-b050a1feceb8 ', '127.0.0.1', '2023-05-12 07:03:09');
INSERT INTO `sys_log` VALUES (487, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 2d86d7bf-857c-4d2e-8417-16271bfb9483 ', '127.0.0.1', '2023-05-12 07:03:09');
INSERT INTO `sys_log` VALUES (488, 'com.example.demo.controller.CaptchaController.getRandomCode()', 110, 'uuid: 89438f28-a59a-4331-ae2f-bb3aa7be5a6a ', '127.0.0.1', '2023-05-12 07:03:49');
INSERT INTO `sys_log` VALUES (489, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 03e051a6-ecd4-4c49-bde0-20fb22ccd124 ', '127.0.0.1', '2023-05-12 07:03:50');
INSERT INTO `sys_log` VALUES (490, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 5b7c7759-0f19-42b6-a453-d5e7bb718ce3 ', '127.0.0.1', '2023-05-12 07:03:50');
INSERT INTO `sys_log` VALUES (491, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 185be8c5-457b-4290-9614-18516000c1c5 ', '127.0.0.1', '2023-05-12 07:03:51');
INSERT INTO `sys_log` VALUES (492, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 9f4f81e7-00a7-4d25-8ee9-dd7fdbb64773 ', '127.0.0.1', '2023-05-12 07:03:51');
INSERT INTO `sys_log` VALUES (493, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 2b06e865-93c7-4298-8c99-eaf2dc94056e ', '127.0.0.1', '2023-05-12 07:03:51');
INSERT INTO `sys_log` VALUES (494, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: b566ac76-b2d6-44c1-a7f2-e42d6c2b4559 ', '127.0.0.1', '2023-05-12 07:03:51');
INSERT INTO `sys_log` VALUES (495, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 4f2ee1ff-f500-49e3-a52c-af028b78e267 ', '127.0.0.1', '2023-05-12 07:04:15');
INSERT INTO `sys_log` VALUES (496, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 8dee2b05-349e-4c44-b460-b9cfd366e1b7 ', '127.0.0.1', '2023-05-12 07:05:07');
INSERT INTO `sys_log` VALUES (497, 'com.example.demo.controller.CaptchaController.getRandomCode()', 106, 'uuid: 495de907-dc3f-47d7-83aa-3ab2b3b175b1 ', '127.0.0.1', '2023-05-12 07:07:18');
INSERT INTO `sys_log` VALUES (498, 'com.example.demo.controller.CaptchaController.getRandomCode()', 117, 'uuid: f2745fd4-41fa-4520-aa3a-126dfc9980b9 ', '127.0.0.1', '2023-05-12 07:38:01');
INSERT INTO `sys_log` VALUES (499, 'com.example.demo.controller.CaptchaController.getRandomCode()', 208, 'uuid: fbb66cfc-d637-4c8a-92db-337de1bcdfd6 ', '127.0.0.1', '2023-05-12 08:09:24');
INSERT INTO `sys_log` VALUES (500, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 84f470b0-3eda-4465-9fba-0ac9d431f43f ', '127.0.0.1', '2023-05-12 08:09:38');
INSERT INTO `sys_log` VALUES (501, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: a828367f-b541-4844-8200-01ff638da0e1 ', '127.0.0.1', '2023-05-12 08:09:45');
INSERT INTO `sys_log` VALUES (502, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 201db3f6-6d60-41e6-b469-ecc68be9011e ', '127.0.0.1', '2023-05-12 08:10:23');
INSERT INTO `sys_log` VALUES (503, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: fb37dc10-8341-449f-90da-4a3bc38fa892 ', '127.0.0.1', '2023-05-12 08:10:27');
INSERT INTO `sys_log` VALUES (504, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: f1ff1269-c192-4118-bd3f-b77454acd3b6 ', '127.0.0.1', '2023-05-12 08:10:28');
INSERT INTO `sys_log` VALUES (505, 'com.example.demo.controller.CaptchaController.getRandomCode()', 198, 'uuid: 96766c34-1d0c-4eb0-a168-80a60884b405 ', '127.0.0.1', '2023-05-12 08:12:48');
INSERT INTO `sys_log` VALUES (506, 'com.example.demo.controller.CaptchaController.getRandomCode()', 197, 'uuid: 59574 ', '172.31.159.233', '2023-05-12 08:30:11');
INSERT INTO `sys_log` VALUES (507, 'com.example.demo.controller.CaptchaController.getRandomCode()', 197, 'uuid: 421 ', '172.31.159.233', '2023-05-12 08:30:11');
INSERT INTO `sys_log` VALUES (508, 'com.example.demo.controller.CaptchaController.getRandomCode()', 197, 'uuid: 59574 ', '172.31.159.233', '2023-05-12 08:30:11');
INSERT INTO `sys_log` VALUES (509, 'com.example.demo.controller.CaptchaController.getRandomCode()', 197, 'uuid: 41589 ', '172.31.159.233', '2023-05-12 08:30:11');
INSERT INTO `sys_log` VALUES (510, 'com.example.demo.controller.CaptchaController.getRandomCode()', 197, 'uuid: 421 ', '172.31.159.233', '2023-05-12 08:30:11');
INSERT INTO `sys_log` VALUES (511, 'com.example.demo.controller.CaptchaController.getRandomCode()', 179, 'uuid: 50141 ', '172.31.159.233', '2023-05-12 08:39:39');
INSERT INTO `sys_log` VALUES (512, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:44:31');
INSERT INTO `sys_log` VALUES (513, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:44:31');
INSERT INTO `sys_log` VALUES (514, 'com.example.demo.controller.CaptchaController.getRandomCode()', 15, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:45:37');
INSERT INTO `sys_log` VALUES (515, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:45:53');
INSERT INTO `sys_log` VALUES (516, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:46:10');
INSERT INTO `sys_log` VALUES (517, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:46:17');
INSERT INTO `sys_log` VALUES (518, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: d1c2206b-eca3-482d-861b-49b2ca2f19f3 ', '127.0.0.1', '2023-05-12 08:48:15');
INSERT INTO `sys_log` VALUES (519, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: d236497b-9c74-494c-89ca-11be0fd034ac ', '127.0.0.1', '2023-05-12 08:48:22');
INSERT INTO `sys_log` VALUES (520, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: d9a94f0a-426e-46da-a060-d4a8661cd216 ', '127.0.0.1', '2023-05-12 08:48:22');
INSERT INTO `sys_log` VALUES (521, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 5aef7fb3-2992-44ec-a0dc-4d10114c5c4a ', '127.0.0.1', '2023-05-12 08:48:40');
INSERT INTO `sys_log` VALUES (522, 'com.example.demo.controller.CaptchaController.getRandomCode()', 199, 'uuid: 50a280bb-4f43-4c86-a809-aae17c6c9768 ', '127.0.0.1', '2023-05-12 08:49:40');
INSERT INTO `sys_log` VALUES (523, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 08:56:06');
INSERT INTO `sys_log` VALUES (524, 'com.example.demo.controller.CaptchaController.getRandomCode()', 40, 'uuid: 44113 ', '172.31.159.233', '2023-05-12 09:17:51');
INSERT INTO `sys_log` VALUES (525, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 6432 ', '172.31.159.233', '2023-05-12 09:18:48');
INSERT INTO `sys_log` VALUES (526, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 6432 ', '172.31.159.233', '2023-05-12 09:18:57');
INSERT INTO `sys_log` VALUES (527, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 26451 ', '172.31.159.233', '2023-05-12 09:22:10');
INSERT INTO `sys_log` VALUES (528, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 18079 ', '172.31.159.233', '2023-05-12 09:23:05');
INSERT INTO `sys_log` VALUES (529, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 18079 ', '172.31.159.233', '2023-05-12 09:23:05');
INSERT INTO `sys_log` VALUES (530, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 202 ', '172.31.159.233', '2023-05-12 09:23:39');
INSERT INTO `sys_log` VALUES (531, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 202 ', '172.31.159.233', '2023-05-12 09:23:39');
INSERT INTO `sys_log` VALUES (532, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 53472 ', '172.31.159.233', '2023-05-12 09:25:49');
INSERT INTO `sys_log` VALUES (533, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 11340 ', '172.31.159.233', '2023-05-12 09:28:43');
INSERT INTO `sys_log` VALUES (534, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 33671 ', '172.31.159.233', '2023-05-12 09:29:04');
INSERT INTO `sys_log` VALUES (535, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 9764 ', '172.31.159.233', '2023-05-12 09:29:56');
INSERT INTO `sys_log` VALUES (536, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 9764 ', '172.31.159.233', '2023-05-12 09:29:56');
INSERT INTO `sys_log` VALUES (537, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 14351 ', '172.31.159.233', '2023-05-12 09:31:24');
INSERT INTO `sys_log` VALUES (538, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 50287 ', '172.31.159.233', '2023-05-12 09:33:23');
INSERT INTO `sys_log` VALUES (539, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 50287 ', '172.31.159.233', '2023-05-12 09:33:23');
INSERT INTO `sys_log` VALUES (540, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 5916 ', '172.31.159.233', '2023-05-12 09:33:55');
INSERT INTO `sys_log` VALUES (541, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 5916 ', '172.31.159.233', '2023-05-12 09:33:55');
INSERT INTO `sys_log` VALUES (542, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 63409 ', '172.31.159.233', '2023-05-12 09:34:40');
INSERT INTO `sys_log` VALUES (543, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 63409 ', '172.31.159.233', '2023-05-12 09:34:40');
INSERT INTO `sys_log` VALUES (544, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 39785 ', '172.31.159.233', '2023-05-12 09:35:36');
INSERT INTO `sys_log` VALUES (545, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 39785 ', '172.31.159.233', '2023-05-12 09:35:36');
INSERT INTO `sys_log` VALUES (546, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 16097 ', '172.31.159.233', '2023-05-12 09:36:41');
INSERT INTO `sys_log` VALUES (547, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 16097 ', '172.31.159.233', '2023-05-12 09:36:41');
INSERT INTO `sys_log` VALUES (548, 'com.example.demo.controller.CaptchaController.getRandomCode()', 176, 'uuid: a7a5fd34-868c-4c35-8d62-b21e0cd25649 ', '127.0.0.1', '2023-05-12 10:08:24');
INSERT INTO `sys_log` VALUES (549, 'com.example.demo.controller.CaptchaController.getRandomCode()', 189, 'uuid: 0fd67a8c-1f5e-4b3f-a750-5ecbc4bc354a ', '127.0.0.1', '2023-05-12 10:09:41');
INSERT INTO `sys_log` VALUES (550, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 586261e8-dc85-4c37-999a-7e876ab6d638 ', '127.0.0.1', '2023-05-12 10:10:49');
INSERT INTO `sys_log` VALUES (551, 'com.example.demo.controller.CaptchaController.getRandomCode()', 219, 'uuid: 13c71916-8134-46e7-ad12-aad257f01b37 ', '127.0.0.1', '2023-05-12 10:11:32');
INSERT INTO `sys_log` VALUES (552, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: c1a40358-ca60-4d80-811d-8f40a19517fe ', '127.0.0.1', '2023-05-12 10:11:42');
INSERT INTO `sys_log` VALUES (553, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: e1d06d74-143f-4837-bd59-f2d8f264f89d ', '127.0.0.1', '2023-05-12 10:12:56');
INSERT INTO `sys_log` VALUES (554, 'com.example.demo.controller.CaptchaController.getRandomCode()', 258, 'uuid: 24628 ', '172.31.159.233', '2023-05-12 11:51:53');
INSERT INTO `sys_log` VALUES (555, 'com.example.demo.controller.CaptchaController.getRandomCode()', 13, 'uuid: 24628 ', '172.31.159.233', '2023-05-12 11:52:44');
INSERT INTO `sys_log` VALUES (556, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 24628 ', '172.31.159.233', '2023-05-12 11:52:46');
INSERT INTO `sys_log` VALUES (557, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 33127 ', '172.31.159.233', '2023-05-12 11:53:21');
INSERT INTO `sys_log` VALUES (558, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 33127 ', '172.31.159.233', '2023-05-12 11:53:22');
INSERT INTO `sys_log` VALUES (559, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 49723 ', '172.31.159.233', '2023-05-12 11:54:07');
INSERT INTO `sys_log` VALUES (560, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 49723 ', '172.31.159.233', '2023-05-12 11:54:08');
INSERT INTO `sys_log` VALUES (561, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:54:42');
INSERT INTO `sys_log` VALUES (562, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:54:43');
INSERT INTO `sys_log` VALUES (563, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:54:47');
INSERT INTO `sys_log` VALUES (564, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:24');
INSERT INTO `sys_log` VALUES (565, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:24');
INSERT INTO `sys_log` VALUES (566, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:30');
INSERT INTO `sys_log` VALUES (567, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:30');
INSERT INTO `sys_log` VALUES (568, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:41');
INSERT INTO `sys_log` VALUES (569, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:41');
INSERT INTO `sys_log` VALUES (570, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:55:45');
INSERT INTO `sys_log` VALUES (571, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:56:02');
INSERT INTO `sys_log` VALUES (572, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:56:02');
INSERT INTO `sys_log` VALUES (573, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:56:26');
INSERT INTO `sys_log` VALUES (574, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:56:26');
INSERT INTO `sys_log` VALUES (575, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:08');
INSERT INTO `sys_log` VALUES (576, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:08');
INSERT INTO `sys_log` VALUES (577, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:21');
INSERT INTO `sys_log` VALUES (578, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:21');
INSERT INTO `sys_log` VALUES (579, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:29');
INSERT INTO `sys_log` VALUES (580, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:29');
INSERT INTO `sys_log` VALUES (581, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:37');
INSERT INTO `sys_log` VALUES (582, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:37');
INSERT INTO `sys_log` VALUES (583, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:49');
INSERT INTO `sys_log` VALUES (584, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:57:49');
INSERT INTO `sys_log` VALUES (585, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:58:15');
INSERT INTO `sys_log` VALUES (586, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:58:15');
INSERT INTO `sys_log` VALUES (587, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:58:38');
INSERT INTO `sys_log` VALUES (588, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:58:41');
INSERT INTO `sys_log` VALUES (589, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:59:07');
INSERT INTO `sys_log` VALUES (590, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:59:08');
INSERT INTO `sys_log` VALUES (591, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:59:11');
INSERT INTO `sys_log` VALUES (592, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:59:32');
INSERT INTO `sys_log` VALUES (593, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:59:34');
INSERT INTO `sys_log` VALUES (594, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 25797 ', '172.31.159.233', '2023-05-12 11:59:35');
INSERT INTO `sys_log` VALUES (595, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 27316 ', '172.31.159.233', '2023-05-12 12:10:44');
INSERT INTO `sys_log` VALUES (596, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 27316 ', '172.31.159.233', '2023-05-12 12:12:02');
INSERT INTO `sys_log` VALUES (597, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 27316 ', '172.31.159.233', '2023-05-12 12:12:13');
INSERT INTO `sys_log` VALUES (598, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 27316 ', '172.31.159.233', '2023-05-12 12:16:26');
INSERT INTO `sys_log` VALUES (599, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 14293 ', '172.31.159.233', '2023-05-12 12:16:56');
INSERT INTO `sys_log` VALUES (600, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 14293 ', '172.31.159.233', '2023-05-12 12:16:56');
INSERT INTO `sys_log` VALUES (601, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 14293 ', '172.31.159.233', '2023-05-12 12:18:33');
INSERT INTO `sys_log` VALUES (602, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 14293 ', '172.31.159.233', '2023-05-12 12:18:58');
INSERT INTO `sys_log` VALUES (603, 'com.example.demo.controller.CaptchaController.getRandomCode()', 38, 'uuid: 49807 ', '172.31.159.233', '2023-05-12 13:07:50');
INSERT INTO `sys_log` VALUES (604, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 40721 ', '172.31.159.233', '2023-05-12 13:07:50');
INSERT INTO `sys_log` VALUES (605, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 63547 ', '172.31.159.233', '2023-05-12 13:07:59');
INSERT INTO `sys_log` VALUES (606, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 63547 ', '172.31.159.233', '2023-05-12 13:07:59');
INSERT INTO `sys_log` VALUES (607, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 35808 ', '172.31.159.233', '2023-05-12 13:08:19');
INSERT INTO `sys_log` VALUES (608, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 61376 ', '172.31.159.233', '2023-05-12 13:09:13');
INSERT INTO `sys_log` VALUES (609, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 61376 ', '172.31.159.233', '2023-05-12 13:09:13');
INSERT INTO `sys_log` VALUES (610, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 18425 ', '172.31.159.233', '2023-05-12 13:10:06');
INSERT INTO `sys_log` VALUES (611, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 18425 ', '172.31.159.233', '2023-05-12 13:10:06');
INSERT INTO `sys_log` VALUES (612, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 29287 ', '172.31.159.233', '2023-05-12 13:11:31');
INSERT INTO `sys_log` VALUES (613, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 15552 ', '172.31.159.233', '2023-05-12 13:13:04');
INSERT INTO `sys_log` VALUES (614, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 62809 ', '172.31.159.233', '2023-05-12 13:14:14');
INSERT INTO `sys_log` VALUES (615, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 34889 ', '172.31.159.233', '2023-05-12 13:15:11');
INSERT INTO `sys_log` VALUES (616, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 64203 ', '172.31.159.233', '2023-05-12 13:17:01');
INSERT INTO `sys_log` VALUES (617, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 15388 ', '172.31.159.233', '2023-05-12 13:36:13');
INSERT INTO `sys_log` VALUES (618, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: 32967 ', '172.31.159.233', '2023-05-12 13:37:12');
INSERT INTO `sys_log` VALUES (619, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 42644 ', '172.31.159.233', '2023-05-12 13:38:09');
INSERT INTO `sys_log` VALUES (620, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 46433 ', '172.31.159.233', '2023-05-12 13:41:30');
INSERT INTO `sys_log` VALUES (621, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 58450 ', '172.31.159.233', '2023-05-12 13:42:24');
INSERT INTO `sys_log` VALUES (622, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 58450 ', '172.31.159.233', '2023-05-12 13:42:24');
INSERT INTO `sys_log` VALUES (623, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 45743 ', '172.31.159.233', '2023-05-12 13:45:54');
INSERT INTO `sys_log` VALUES (624, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 51567 ', '172.31.159.233', '2023-05-12 13:46:50');
INSERT INTO `sys_log` VALUES (625, 'com.example.demo.controller.CaptchaController.getRandomCode()', 252, 'uuid: 13034 ', '172.31.159.233', '2023-05-13 06:19:58');
INSERT INTO `sys_log` VALUES (626, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 13034 ', '172.31.159.233', '2023-05-13 06:20:23');
INSERT INTO `sys_log` VALUES (627, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 49785 ', '172.31.159.233', '2023-05-13 06:26:12');
INSERT INTO `sys_log` VALUES (628, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 32663 ', '172.31.159.233', '2023-05-13 06:28:32');
INSERT INTO `sys_log` VALUES (629, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 11559 ', '172.31.159.233', '2023-05-13 06:29:31');
INSERT INTO `sys_log` VALUES (630, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 11559 ', '172.31.159.233', '2023-05-13 06:29:31');
INSERT INTO `sys_log` VALUES (631, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 35850 ', '172.31.159.233', '2023-05-13 06:30:19');
INSERT INTO `sys_log` VALUES (632, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 18868 ', '172.31.159.233', '2023-05-13 06:30:33');
INSERT INTO `sys_log` VALUES (633, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 29424 ', '172.31.159.233', '2023-05-13 06:30:44');
INSERT INTO `sys_log` VALUES (634, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 33460 ', '172.31.159.233', '2023-05-13 06:31:11');
INSERT INTO `sys_log` VALUES (635, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 3891 ', '172.31.159.233', '2023-05-13 06:31:27');
INSERT INTO `sys_log` VALUES (636, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 47923 ', '172.31.159.233', '2023-05-13 06:31:56');
INSERT INTO `sys_log` VALUES (637, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 53916 ', '172.31.159.233', '2023-05-13 06:32:46');
INSERT INTO `sys_log` VALUES (638, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 7815 ', '172.31.159.233', '2023-05-13 06:33:40');
INSERT INTO `sys_log` VALUES (639, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 38975 ', '172.31.159.233', '2023-05-13 06:35:36');
INSERT INTO `sys_log` VALUES (640, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 30623 ', '172.31.159.233', '2023-05-13 06:37:48');
INSERT INTO `sys_log` VALUES (641, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: 2084 ', '172.31.159.233', '2023-05-13 06:39:10');
INSERT INTO `sys_log` VALUES (642, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 2084 ', '172.31.159.233', '2023-05-13 06:39:10');
INSERT INTO `sys_log` VALUES (643, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 38754 ', '172.31.159.233', '2023-05-13 06:51:18');
INSERT INTO `sys_log` VALUES (644, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 11970 ', '172.31.159.233', '2023-05-13 06:58:06');
INSERT INTO `sys_log` VALUES (645, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 33186 ', '172.31.159.233', '2023-05-13 06:58:27');
INSERT INTO `sys_log` VALUES (646, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 33186 ', '172.31.159.233', '2023-05-13 06:58:27');
INSERT INTO `sys_log` VALUES (647, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 28754 ', '172.31.159.233', '2023-05-13 06:58:45');
INSERT INTO `sys_log` VALUES (648, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 28754 ', '172.31.159.233', '2023-05-13 06:58:45');
INSERT INTO `sys_log` VALUES (649, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 65417 ', '172.31.159.233', '2023-05-13 06:59:47');
INSERT INTO `sys_log` VALUES (650, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 65417 ', '172.31.159.233', '2023-05-13 07:02:56');
INSERT INTO `sys_log` VALUES (651, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 49848 ', '172.31.159.233', '2023-05-13 07:03:14');
INSERT INTO `sys_log` VALUES (652, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 49848 ', '172.31.159.233', '2023-05-13 07:03:14');
INSERT INTO `sys_log` VALUES (653, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 8112 ', '172.31.159.233', '2023-05-13 07:03:40');
INSERT INTO `sys_log` VALUES (654, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 8112 ', '172.31.159.233', '2023-05-13 07:03:40');
INSERT INTO `sys_log` VALUES (655, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 8112 ', '172.31.159.233', '2023-05-13 07:04:34');
INSERT INTO `sys_log` VALUES (656, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 8112 ', '172.31.159.233', '2023-05-13 07:04:54');
INSERT INTO `sys_log` VALUES (657, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 8112 ', '172.31.159.233', '2023-05-13 07:05:10');
INSERT INTO `sys_log` VALUES (658, 'com.example.demo.controller.CaptchaController.getRandomCode()', 53, 'uuid: 55516 ', '172.31.159.233', '2023-05-14 02:21:14');
INSERT INTO `sys_log` VALUES (659, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 7675 ', '172.31.159.233', '2023-05-14 02:21:41');
INSERT INTO `sys_log` VALUES (660, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 50374 ', '172.31.159.233', '2023-05-14 02:22:20');
INSERT INTO `sys_log` VALUES (661, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 12826 ', '172.31.159.233', '2023-05-14 02:22:57');
INSERT INTO `sys_log` VALUES (662, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 12826 ', '172.31.159.233', '2023-05-14 02:22:58');
INSERT INTO `sys_log` VALUES (663, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 12826 ', '172.31.159.233', '2023-05-14 02:23:28');
INSERT INTO `sys_log` VALUES (664, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: 10705 ', '172.31.159.233', '2023-05-14 02:24:15');
INSERT INTO `sys_log` VALUES (665, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 10705 ', '172.31.159.233', '2023-05-14 02:24:16');
INSERT INTO `sys_log` VALUES (666, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 10705 ', '172.31.159.233', '2023-05-14 02:24:42');
INSERT INTO `sys_log` VALUES (667, 'com.example.demo.controller.CaptchaController.getRandomCode()', 4, 'uuid: 63758 ', '172.31.159.233', '2023-05-14 02:24:53');
INSERT INTO `sys_log` VALUES (668, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 63758 ', '172.31.159.233', '2023-05-14 02:24:53');
INSERT INTO `sys_log` VALUES (669, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 63758 ', '172.31.159.233', '2023-05-14 02:24:56');
INSERT INTO `sys_log` VALUES (670, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 62582 ', '172.31.159.233', '2023-05-14 02:25:32');
INSERT INTO `sys_log` VALUES (671, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 62582 ', '172.31.159.233', '2023-05-14 02:25:32');
INSERT INTO `sys_log` VALUES (672, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: 62582 ', '172.31.159.233', '2023-05-14 02:25:38');
INSERT INTO `sys_log` VALUES (673, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 30373 ', '172.31.159.233', '2023-05-14 02:26:34');
INSERT INTO `sys_log` VALUES (674, 'com.example.demo.controller.CaptchaController.getRandomCode()', 5, 'uuid: 30373 ', '172.31.159.233', '2023-05-14 02:26:36');
INSERT INTO `sys_log` VALUES (675, 'com.example.demo.controller.CaptchaController.getRandomCode()', 231, 'uuid: 56762 ', '172.31.159.233', '2023-05-14 08:30:50');
INSERT INTO `sys_log` VALUES (676, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: 5326 ', '172.31.159.233', '2023-05-14 08:33:19');
INSERT INTO `sys_log` VALUES (677, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 5326 ', '172.31.159.233', '2023-05-14 08:33:53');
INSERT INTO `sys_log` VALUES (678, 'com.example.demo.controller.CaptchaController.getRandomCode()', 58, 'uuid: 23358 ', '172.30.131.32', '2023-05-16 06:25:18');
INSERT INTO `sys_log` VALUES (679, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 23358 ', '172.30.131.32', '2023-05-16 06:26:32');
INSERT INTO `sys_log` VALUES (680, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 23358 ', '172.30.131.32', '2023-05-16 06:26:37');
INSERT INTO `sys_log` VALUES (681, 'com.example.demo.controller.CaptchaController.getRandomCode()', 287, 'uuid: 189df9f5-667a-41b0-8802-8b3b6d2295df ', '127.0.0.1', '2023-05-17 09:39:29');
INSERT INTO `sys_log` VALUES (682, 'com.example.demo.controller.CaptchaController.getRandomCode()', 45, 'uuid: aa938508-6b7d-4059-9aa8-76dc39182496 ', '127.0.0.1', '2023-05-17 09:52:16');
INSERT INTO `sys_log` VALUES (683, 'com.example.demo.controller.CaptchaController.getRandomCode()', 403, 'uuid: 51cce693-8df6-4f93-ade2-8251b843bccc ', '127.0.0.1', '2023-05-17 10:02:22');
INSERT INTO `sys_log` VALUES (684, 'com.example.demo.controller.CaptchaController.getRandomCode()', 250, 'uuid: a88f2807-0810-4f87-8b66-9228499dd5fe ', '127.0.0.1', '2023-05-17 10:24:13');
INSERT INTO `sys_log` VALUES (685, 'com.example.demo.controller.CaptchaController.getRandomCode()', 10, 'uuid: ea67bb28-03d3-4c5f-84c6-1fa9e3364d61 ', '127.0.0.1', '2023-05-17 10:24:18');
INSERT INTO `sys_log` VALUES (686, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 7e81fb3b-d839-44e5-8611-facf8fb02e86 ', '127.0.0.1', '2023-05-17 10:29:56');
INSERT INTO `sys_log` VALUES (687, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 5f798955-4680-4bc7-a33d-9c92aa729236 ', '127.0.0.1', '2023-05-17 10:30:57');
INSERT INTO `sys_log` VALUES (688, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: bf63efc7-f53f-419c-af9c-50c4bb26ede6 ', '127.0.0.1', '2023-05-17 10:34:41');
INSERT INTO `sys_log` VALUES (689, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 501dd206-6210-478b-a8c2-47b3bb2d66d2 ', '127.0.0.1', '2023-05-17 10:34:49');
INSERT INTO `sys_log` VALUES (690, 'com.example.demo.controller.CaptchaController.getRandomCode()', 57, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:26');
INSERT INTO `sys_log` VALUES (691, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:28');
INSERT INTO `sys_log` VALUES (692, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:29');
INSERT INTO `sys_log` VALUES (693, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:29');
INSERT INTO `sys_log` VALUES (694, 'com.example.demo.controller.CaptchaController.getRandomCode()', 9, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:30');
INSERT INTO `sys_log` VALUES (695, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:30');
INSERT INTO `sys_log` VALUES (696, 'com.example.demo.controller.CaptchaController.getRandomCode()', 6, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:30');
INSERT INTO `sys_log` VALUES (697, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:30');
INSERT INTO `sys_log` VALUES (698, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:30');
INSERT INTO `sys_log` VALUES (699, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:30');
INSERT INTO `sys_log` VALUES (700, 'com.example.demo.controller.CaptchaController.getRandomCode()', 8, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:16:31');
INSERT INTO `sys_log` VALUES (701, 'com.example.demo.controller.CaptchaController.getRandomCode()', 14, 'uuid: 14e5a448-6281-407f-a463-98a79ff1025f ', '127.0.0.1', '2023-05-17 11:24:12');
INSERT INTO `sys_log` VALUES (702, 'com.example.demo.controller.CaptchaController.getRandomCode()', 11, 'uuid: 82a10954-fadc-47d6-b9f5-159f81b25e47 ', '127.0.0.1', '2023-05-17 11:25:56');
INSERT INTO `sys_log` VALUES (703, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: 2f57f6e0-f7ef-417f-a6e8-a30d69a4367e ', '127.0.0.1', '2023-05-17 11:26:08');
INSERT INTO `sys_log` VALUES (704, 'com.example.demo.controller.CaptchaController.getRandomCode()', 15, 'uuid: 1 ', '127.0.0.1', '2023-05-17 11:35:14');
INSERT INTO `sys_log` VALUES (705, 'com.example.demo.controller.CaptchaController.getRandomCode()', 19, 'uuid: 6e315d6e-a361-4d6c-b726-210a5426c834 ', '127.0.0.1', '2023-05-17 11:52:33');
INSERT INTO `sys_log` VALUES (706, 'com.example.demo.controller.CaptchaController.getRandomCode()', 7, 'uuid: b6495e4b-f267-469c-bfda-21e8cbd96468 ', '127.0.0.1', '2023-05-17 11:53:21');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `status` tinyint NOT NULL COMMENT '状态：0锁定，1有效',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `create_time` datetime NULL DEFAULT NULL COMMENT '账号创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '账号修改时间',
  `sex` tinyint NULL DEFAULT NULL COMMENT '性别：0男，1女',
  `permission` tinyint NOT NULL COMMENT '权限：0管理员，1教师，2家长',
  `birth` date NULL DEFAULT NULL COMMENT '生日',
  `enroll_time` date NULL DEFAULT NULL COMMENT '入学（职）时间',
  `graduate_time` date NULL DEFAULT NULL COMMENT '预计毕业时间（学生）',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院系',
  `institute` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系所',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (9, '51255902052', '$2a$10$GZ32o0skk3hOUCWVqJyVIOgRzxXYbttWxsjYG.ToovNqmB4G4igK6', 1, 'Ze Lin', 'ze_lin@stu.ecnu.edu.cn', 'https://cdn.pixabay.com/photo/2023/03/28/19/55/lake-7884049_960_720.jpg', '19858123456', '2013-11-13 00:10:41', '2005-10-14 21:38:32', 1, 0, '2017-01-18', '2022-09-01', '2025-06-30', 'Information Technology', 'Software Engineering Institute');
INSERT INTO `user_info` VALUES (14, '110', '$2a$10$ALfqITSCcDYN3.BYWn1//O177PQOdtAdzSvMCfHN3eLjrAdPor2AG', 1, 'Teacher1', 'teacher1@sei.ecnu.edu.cn', 'https://media.istockphoto.com/id/1299625114/nl/foto/hiawassee-georgi%C3%AB-het-landschap-van-de-v-s-met-het-meer-van-chatuge-in-vroege-herfst.jpg?b=1&s=170667a&w=0&k=20&c=TGMXfTYUGEdqRPMen5l7KGU-cyvJ4ngJSAX_IiqZ1qc=', '123123', '2021-08-18 05:29:23', '2015-05-06 19:43:49', 0, 1, '2003-05-20', '2009-03-18', NULL, 'Information Technology', 'School of Computer Science and Technology');
INSERT INTO `user_info` VALUES (18, '51255902042', '$2a$10$YJTTiNVvXTBbAbML.vbtD.bTwB9LvagBqMzFmW6uAnehdo0Y0/Nl2', 1, 'Jianxun Wang', '51255902042@stu.ecnu.edu.cn', 'https://media.istockphoto.com/id/1299625114/nl/foto/hiawassee-georgi%C3%AB-het-landschap-van-de-v-s-met-het-meer-van-chatuge-in-vroege-herfst.jpg?b=1&s=170667a&w=0&k=20&c=TGMXfTYUGEdqRPMen5l7KGU-cyvJ4ngJSAX_IiqZ1qc=', '18958123456', NULL, NULL, 1, 0, '2016-11-01', '2022-09-02', '2025-06-30', 'Information Technology', 'Software Engineering Institute');
INSERT INTO `user_info` VALUES (19, '51255902015', '$2a$10$2Rjd6sEfdSMIb6syhreXy.IOgNd9ORSU/hDnBzEDqkaq26RbC8ney', 1, 'Benchi Ma', '51255902015@stu.ecnu.edu.cn', 'https://alifei04.cfp.cn/creative/vcg/veer/1600water/veer-303764513.jpg', '13659191993', NULL, NULL, 1, 0, '1998-02-04', '2022-09-02', '2025-06-30', 'Information Technology', 'Software Engineering Institute');

-- ----------------------------
-- Table structure for user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户登录记录id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
  `ip_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址所对应的地区',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  `browser_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器类型',
  `operating_system` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录平台',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_login_log
-- ----------------------------
INSERT INTO `user_login_log` VALUES (1, NULL, '127.0.0.1', NULL, '2022-08-02 22:51:55', 'Unknown', NULL, 'Unknown');
INSERT INTO `user_login_log` VALUES (2, NULL, '127.0.0.1', NULL, '2022-08-02 22:54:42', 'Chrome', NULL, 'Windows');
INSERT INTO `user_login_log` VALUES (3, NULL, '192.168.10.101', NULL, '2022-08-02 22:59:42', 'Safari', NULL, 'iPhone');
INSERT INTO `user_login_log` VALUES (4, NULL, '192.168.10.101', NULL, '2022-08-02 23:03:24', 'Safari', 'iPhone', 'iPhone');
INSERT INTO `user_login_log` VALUES (5, NULL, '127.0.0.1', NULL, '2022-08-02 23:03:50', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (6, NULL, '192.168.10.101', NULL, '2022-08-02 23:08:34', 'Safari', 'iPhone', 'iPhone');
INSERT INTO `user_login_log` VALUES (7, NULL, '127.0.0.1', NULL, '2022-08-03 16:40:44', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (8, NULL, '127.0.0.1', NULL, '2022-08-03 21:30:02', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (9, NULL, '127.0.0.1', NULL, '2022-08-03 21:30:49', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (10, NULL, '127.0.0.1', NULL, '2022-08-03 21:34:20', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (11, NULL, '127.0.0.1', NULL, '2022-08-03 21:35:01', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (12, NULL, '127.0.0.1', NULL, '2022-08-03 21:35:52', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (13, NULL, '127.0.0.1', NULL, '2022-08-03 21:48:39', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (14, 4, '127.0.0.1', NULL, '2022-08-03 21:54:12', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (15, 4, '127.0.0.1', NULL, '2022-08-03 23:00:11', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (16, 4, '127.0.0.1', NULL, '2022-08-05 22:17:41', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (17, 4, '127.0.0.1', NULL, '2022-08-11 19:20:11', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (18, 4, '127.0.0.1', NULL, '2022-08-11 19:39:59', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (19, 4, '127.0.0.1', NULL, '2022-08-11 19:40:28', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (20, 4, '127.0.0.1', NULL, '2022-08-11 19:42:03', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (21, 4, '127.0.0.1', NULL, '2022-09-01 15:39:09', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (22, 4, '127.0.0.1', NULL, '2022-10-17 20:49:14', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (23, 4, '127.0.0.1', NULL, '2023-02-20 11:37:37', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (24, 2, '127.0.0.1', NULL, '2023-02-23 19:02:19', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (25, 3, '127.0.0.1', NULL, '2023-02-23 19:03:29', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (26, 4, '127.0.0.1', NULL, '2023-02-23 19:03:45', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (27, 6, '127.0.0.1', NULL, '2023-02-23 19:03:57', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (28, 7, '127.0.0.1', NULL, '2023-02-23 19:04:07', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (29, 8, '127.0.0.1', NULL, '2023-02-23 19:04:36', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (30, 9, '127.0.0.1', NULL, '2023-02-23 19:04:48', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (31, 10, '127.0.0.1', NULL, '2023-02-23 19:05:09', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (32, 9, '127.0.0.1', NULL, '2023-04-29 04:56:50', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (33, 9, '127.0.0.1', NULL, '2023-04-29 06:17:12', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (34, 9, '172.31.222.184', NULL, '2023-04-29 08:07:14', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (35, 9, '127.0.0.1', NULL, '2023-04-29 08:08:28', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (36, 9, '172.31.222.184', NULL, '2023-04-29 08:30:38', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (37, 9, '127.0.0.1', NULL, '2023-04-29 08:34:42', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (38, 9, '172.31.222.184', NULL, '2023-04-29 09:29:38', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (39, 9, '172.31.222.184', NULL, '2023-04-29 10:21:05', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (40, 18, '127.0.0.1', NULL, '2023-05-01 04:53:54', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (41, 9, '172.31.222.184', NULL, '2023-05-01 11:33:56', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (42, 9, '58.198.176.171', NULL, '2023-05-02 08:27:29', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (43, 18, '172.20.159.5', NULL, '2023-05-02 14:03:36', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (44, 18, '172.20.159.37', NULL, '2023-05-03 05:22:51', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (45, 18, '172.20.144.141', NULL, '2023-05-06 04:55:20', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (46, 18, '172.20.144.141', NULL, '2023-05-06 06:37:06', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (47, 18, '172.20.144.141', NULL, '2023-05-06 06:44:45', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (48, 18, '172.20.144.141', NULL, '2023-05-06 06:50:16', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (49, 18, '172.30.212.58', NULL, '2023-05-10 10:56:26', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (50, 18, '172.20.146.94', NULL, '2023-05-11 03:20:32', 'MSEdge', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (51, 9, '127.0.0.1', NULL, '2023-05-12 07:04:04', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (52, 9, '127.0.0.1', NULL, '2023-05-12 07:04:45', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (53, 9, '127.0.0.1', NULL, '2023-05-12 07:07:51', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (54, 9, '127.0.0.1', NULL, '2023-05-12 07:38:11', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (55, 9, '127.0.0.1', NULL, '2023-05-12 08:09:50', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (56, 9, '127.0.0.1', NULL, '2023-05-12 08:10:40', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (57, 9, '127.0.0.1', NULL, '2023-05-12 08:12:58', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (58, 18, '127.0.0.1', NULL, '2023-05-12 08:48:43', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (59, 9, '127.0.0.1', NULL, '2023-05-12 08:49:50', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (60, 19, '172.31.159.233', NULL, '2023-05-12 09:31:39', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (61, 19, '172.31.159.233', NULL, '2023-05-12 09:33:32', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (62, 19, '172.31.159.233', NULL, '2023-05-12 09:33:58', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (63, 19, '172.31.159.233', NULL, '2023-05-12 09:34:48', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (64, 19, '172.31.159.233', NULL, '2023-05-12 09:35:46', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (65, 19, '172.31.159.233', NULL, '2023-05-12 09:36:44', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (66, 9, '127.0.0.1', NULL, '2023-05-12 10:08:33', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (67, 9, '127.0.0.1', NULL, '2023-05-12 10:09:51', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (68, 18, '127.0.0.1', NULL, '2023-05-12 10:10:59', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (69, 9, '127.0.0.1', NULL, '2023-05-12 10:11:50', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (70, 18, '127.0.0.1', NULL, '2023-05-12 10:13:09', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (71, 19, '172.31.159.233', NULL, '2023-05-12 12:10:50', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (72, 19, '172.31.159.233', NULL, '2023-05-12 12:17:04', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (73, 19, '172.31.159.233', NULL, '2023-05-12 12:18:40', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (74, 19, '172.31.159.233', NULL, '2023-05-12 12:19:02', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (75, 19, '172.31.159.233', NULL, '2023-05-12 13:08:25', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (76, 19, '172.31.159.233', NULL, '2023-05-12 13:09:22', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (77, 19, '172.31.159.233', NULL, '2023-05-12 13:10:12', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (78, 19, '172.31.159.233', NULL, '2023-05-12 13:11:35', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (79, 19, '172.31.159.233', NULL, '2023-05-12 13:13:09', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (80, 19, '172.31.159.233', NULL, '2023-05-12 13:14:20', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (81, 19, '172.31.159.233', NULL, '2023-05-12 13:15:16', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (82, 19, '172.31.159.233', NULL, '2023-05-12 13:17:06', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (83, 19, '172.31.159.233', NULL, '2023-05-12 13:36:17', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (84, 19, '172.31.159.233', NULL, '2023-05-12 13:37:17', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (85, 19, '172.31.159.233', NULL, '2023-05-12 13:38:14', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (86, 19, '172.31.159.233', NULL, '2023-05-12 13:41:34', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (87, 19, '172.31.159.233', NULL, '2023-05-12 13:42:53', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (88, 19, '172.31.159.233', NULL, '2023-05-12 13:45:58', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (89, 19, '172.31.159.233', NULL, '2023-05-12 13:46:55', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (90, 19, '172.31.159.233', NULL, '2023-05-13 06:20:03', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (91, 19, '172.31.159.233', NULL, '2023-05-13 06:20:27', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (92, 19, '172.31.159.233', NULL, '2023-05-13 06:26:24', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (93, 19, '172.31.159.233', NULL, '2023-05-13 06:28:40', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (94, 19, '172.31.159.233', NULL, '2023-05-13 06:29:35', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (95, 19, '172.31.159.233', NULL, '2023-05-13 06:30:23', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (96, 19, '172.31.159.233', NULL, '2023-05-13 06:30:49', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (97, 19, '172.31.159.233', NULL, '2023-05-13 06:31:30', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (98, 19, '172.31.159.233', NULL, '2023-05-13 06:31:59', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (99, 19, '172.31.159.233', NULL, '2023-05-13 06:32:53', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (100, 19, '172.31.159.233', NULL, '2023-05-13 06:33:43', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (101, 19, '172.31.159.233', NULL, '2023-05-13 06:35:47', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (102, 19, '172.31.159.233', NULL, '2023-05-13 06:38:04', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (103, 19, '172.31.159.233', NULL, '2023-05-13 06:39:15', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (104, 19, '172.31.159.233', NULL, '2023-05-13 06:51:23', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (105, 19, '172.31.159.233', NULL, '2023-05-13 06:58:30', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (106, 19, '172.31.159.233', NULL, '2023-05-13 06:58:49', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (107, 19, '172.31.159.233', NULL, '2023-05-13 07:03:18', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (108, 19, '172.31.159.233', NULL, '2023-05-14 02:27:03', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (109, 19, '172.31.159.233', NULL, '2023-05-14 08:33:24', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (110, 19, '172.30.131.32', NULL, '2023-05-16 06:26:04', 'Unknown', 'Unknown', 'Unknown');
INSERT INTO `user_login_log` VALUES (111, 9, '127.0.0.1', NULL, '2023-05-17 09:52:36', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (112, 9, '127.0.0.1', NULL, '2023-05-17 10:30:09', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (113, 9, '127.0.0.1', NULL, '2023-05-17 10:34:57', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (114, 9, '127.0.0.1', NULL, '2023-05-17 11:26:13', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');
INSERT INTO `user_login_log` VALUES (115, 9, '127.0.0.1', NULL, '2023-05-17 11:53:38', 'Chrome', 'Windows 10 or Windows Server 2016', 'Windows');

SET FOREIGN_KEY_CHECKS = 1;
