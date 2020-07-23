/*
 Navicat Premium Data Transfer

 Source Server         : wsl
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3307
 Source Schema         : m_search

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 20/07/2020 20:29:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '电影名称',
  `rate` float NULL DEFAULT NULL COMMENT '评分',
  `rate_num` int(11) NULL DEFAULT NULL COMMENT '评分人数',
  `star5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '5星人数百分比',
  `star4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '4星人数百分比',
  `star3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '3星人数百分比',
  `star2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '2星人数百分比',
  `star1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1星人数百分比',
  `short_post_num` int(11) NULL DEFAULT NULL COMMENT '短评数量',
  `post_num` int(11) NULL DEFAULT NULL COMMENT '影评数量',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `director` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '导演',
  `writer` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '编剧',
  `actor` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '主演',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '语言',
  `online_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上映日期',
  `length` int(11) NULL DEFAULT NULL COMMENT '片长',
  `db_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '豆瓣url',
  `mv_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '官方url',
  `imdb_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'imdb网址',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '海报图片url',
  `brief` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '简介',
  `total_rate` int(11) NULL DEFAULT NULL COMMENT '总分(评分*评价人数)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 424405 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
