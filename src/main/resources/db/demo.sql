/*
 Navicat Premium Data Transfer

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 23/02/2023 19:06:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 216 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (2, 'username', '$2a$10$gmHIRYeuRSSJI5CXjqK9ee8HhDVz2/GnlGC3ppn1oNUhnilIRWsp2', 1, NULL, NULL, NULL, '123', NULL, NULL, NULL, 0, NULL);
INSERT INTO `user_info` VALUES (3, 'username3', '$2a$10$1KJucC8e4e44La3KHqfHY.93CcvXZ0qeU1gocFgAObqIk7Onh8zJK', 1, NULL, NULL, NULL, '1', NULL, NULL, NULL, 0, NULL);
INSERT INTO `user_info` VALUES (4, 'username4', '$2a$10$wf9AU.E54fJUXdnSdpMCrecqfkZ/NzxSC.qr2gSF.1rLX2pwoZ1pK', 0, NULL, NULL, NULL, '1', NULL, NULL, NULL, 0, NULL);
INSERT INTO `user_info` VALUES (6, 'username6', '$2a$10$6RqTiAq19JfkO8z.BGkEW.Ik1OF7hgLQXa7UUtEYWd9kVWjlTn1z6', 1, NULL, NULL, NULL, '1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `user_info` VALUES (7, 'username7', '$2a$10$2lvmfKboD7gEyKnqEvlliurt8qyCuBkENIjLjSAb5vxAUmqDBIN3S', 1, NULL, NULL, NULL, '1', NULL, NULL, NULL, 1, NULL);
INSERT INTO `user_info` VALUES (8, 'Jacqueline Reed', '$2a$10$gmHIRYeuRSSJI5CXjqK9ee8HhDVz2/GnlGC3ppn1oNUhnilIRWsp2', 0, 'Jacqueline Reed', 'jacqueline619@gmail.com', 'eZibuNtv3i', '123', '2020-07-21 22:30:13', '2020-10-18 14:14:24', 1, 1, '2015-06-21');
INSERT INTO `user_info` VALUES (9, 'Lei Lan', '$2a$10$ALfqITSCcDYN3.BYWn1//O177PQOdtAdzSvMCfHN3eLjrAdPor2AG', 0, 'Lei Lan', 'lelan@outlook.com', 'oNXcVV5eW3', '123123', '2013-11-13 00:10:41', '2005-10-14 21:38:32', 0, 1, '2017-01-18');
INSERT INTO `user_info` VALUES (10, 'Lo Kwok Yin', '$2a$10$wf9AU.E54fJUXdnSdpMCrecqfkZ/NzxSC.qr2gSF.1rLX2pwoZ1pK', 1, 'Lo Kwok Yin', 'kwokyinlo125@mail.com', 'zK5n4NpY28', '1', '2001-12-06 03:08:16', '2001-05-05 02:59:44', 1, 0, '2004-01-15');
INSERT INTO `user_info` VALUES (11, 'Man Wai Han', '$2a$10$6RqTiAq19JfkO8z.BGkEW.Ik1OF7hgLQXa7UUtEYWd9kVWjlTn1z6', 1, 'Man Wai Han', 'whman@outlook.com', '0TzsXjZKLV', '1', '2005-01-15 07:33:42', '2015-03-10 23:29:39', 1, 0, '2012-01-18');
INSERT INTO `user_info` VALUES (12, 'Zhang Yunxi', '$2a$10$2lvmfKboD7gEyKnqEvlliurt8qyCuBkENIjLjSAb5vxAUmqDBIN3S', 0, 'Zhang Yunxi', 'zyun46@gmail.com', 'BD6lt0URNk', '1', '2010-03-27 11:31:48', '2012-07-12 21:52:52', 0, 1, '2006-06-19');
INSERT INTO `user_info` VALUES (13, 'Fu Shihan', '$2a$10$gmHIRYeuRSSJI5CXjqK9ee8HhDVz2/GnlGC3ppn1oNUhnilIRWsp2', 0, 'Fu Shihan', 'shfu40@gmail.com', '8WN2R9urAu', '123', '2016-01-20 07:32:51', '2000-01-14 01:54:49', 1, 0, '2011-05-29');
INSERT INTO `user_info` VALUES (14, 'Monica Kelley', '$2a$10$ALfqITSCcDYN3.BYWn1//O177PQOdtAdzSvMCfHN3eLjrAdPor2AG', 1, 'Monica Kelley', 'monicakelley68@icloud.com', 'hnPfpNYTgV', '123123', '2021-08-18 05:29:23', '2015-05-06 19:43:49', 0, 0, '2003-05-20');
INSERT INTO `user_info` VALUES (15, 'Yamazaki Daisuke', '$2a$10$wf9AU.E54fJUXdnSdpMCrecqfkZ/NzxSC.qr2gSF.1rLX2pwoZ1pK', 0, 'Yamazaki Daisuke', 'yamazakidais4@gmail.com', 'nDdvIkS4a6', '1', '2009-07-22 23:58:52', '2012-06-18 13:20:05', 1, 1, '2014-05-21');
INSERT INTO `user_info` VALUES (16, 'Au Wing Fat', '$2a$10$6RqTiAq19JfkO8z.BGkEW.Ik1OF7hgLQXa7UUtEYWd9kVWjlTn1z6', 0, 'Au Wing Fat', 'wingfat428@yahoo.com', 'WiThSXDSqj', '1', '2000-06-10 03:31:10', '2008-12-12 14:24:20', 1, 1, '2016-09-20');
INSERT INTO `user_info` VALUES (17, 'Kwan Wai Yee', '$2a$10$2lvmfKboD7gEyKnqEvlliurt8qyCuBkENIjLjSAb5vxAUmqDBIN3S', 1, 'Kwan Wai Yee', 'wykwan15@icloud.com', 'k3eCn4mlcz', '1', '2006-09-22 13:30:43', '2012-10-23 05:50:59', 0, 1, '2019-03-24');

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
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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

SET FOREIGN_KEY_CHECKS = 1;
