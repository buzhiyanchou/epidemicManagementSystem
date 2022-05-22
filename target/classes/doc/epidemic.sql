/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : epidemic

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 22/05/2022 22:41:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '区域名称',
  `area_type` int(2) NULL DEFAULT 1 COMMENT '区域类型1：防控区；2封控区',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '区域' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '朝阳区', 1, '2022-04-25 08:59:07', NULL, 'dio', NULL);
INSERT INTO `area` VALUES (2, '朝月区', 1, '2022-04-25 08:59:43', NULL, 'dio', NULL);
INSERT INTO `area` VALUES (5, '测试区', 1, '2022-04-25 09:46:32', NULL, 'dio', NULL);

-- ----------------------------
-- Table structure for churuxinxi
-- ----------------------------
DROP TABLE IF EXISTS `churuxinxi`;
CREATE TABLE `churuxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `churuleixing` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出入类型',
  `churubiaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出入标题',
  `churutupian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出入图片',
  `churucishu` int(11) NULL DEFAULT NULL COMMENT '出入次数',
  `xingchengshangbao` datetime(0) NULL DEFAULT NULL COMMENT '行程上报',
  `churushuoming` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '出入说明',
  `yonghuming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `xingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `zhuzhi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1646893939921 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of churuxinxi
-- ----------------------------
INSERT INTO `churuxinxi` VALUES (21, '2022-03-10 14:25:23', '出', '出入标题1', 'upload/churuxinxi_churutupian1.jpg', 1, '2022-03-10 14:25:23', '出入说明1', '用户名1', '姓名1', '13823888881', '住址1', '是', '收到', 1);
INSERT INTO `churuxinxi` VALUES (22, '2022-03-10 14:25:23', '出', '出入标题2', 'upload/churuxinxi_churutupian2.jpg', 2, '2022-03-10 14:25:23', '出入说明2', '用户名2', '姓名2', '13823888882', '住址2', '是', '', 2);
INSERT INTO `churuxinxi` VALUES (23, '2022-03-10 14:25:23', '出', '出入标题3', 'upload/churuxinxi_churutupian3.jpg', 3, '2022-03-10 14:25:23', '出入说明3', '用户名3', '姓名3', '13823888883', '住址3', '是', '', 3);
INSERT INTO `churuxinxi` VALUES (24, '2022-03-10 14:25:23', '出', '出入标题4', 'upload/churuxinxi_churutupian4.jpg', 4, '2022-03-10 14:25:23', '出入说明4', '用户名4', '姓名4', '13823888884', '住址4', '是', '', 4);
INSERT INTO `churuxinxi` VALUES (25, '2022-03-10 14:25:23', '出', '出入标题5', 'upload/churuxinxi_churutupian5.jpg', 5, '2022-03-10 14:25:23', '出入说明5', '用户名5', '姓名5', '13823888885', '住址5', '是', '', 5);
INSERT INTO `churuxinxi` VALUES (26, '2022-03-10 14:25:23', '出', '出入标题6', 'upload/churuxinxi_churutupian6.jpg', 6, '2022-03-10 14:25:23', '出入说明6', '用户名6', '姓名6', '13823888886', '住址6', '是', '', 6);
INSERT INTO `churuxinxi` VALUES (1646893939920, '2022-03-10 14:32:19', '入', '111', 'upload/1646893936642.jpg', 1, '2022-03-10 14:32:41', '1111111111111', '001', '小李', '13498789811', '1132', '是', '1', 1646893886397);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/1646894133356.png');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/picture2.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/picture3.jpg');

-- ----------------------------
-- Table structure for epidemiclog
-- ----------------------------
DROP TABLE IF EXISTS `epidemiclog`;
CREATE TABLE `epidemiclog`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of epidemiclog
-- ----------------------------

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_id` bigint(20) NULL DEFAULT NULL COMMENT '区域号',
  `floor_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '楼栋号',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '楼栋' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of floor
-- ----------------------------
INSERT INTO `floor` VALUES (1, 1, '潮汐楼', '2022-04-25 11:08:03', NULL, 'dio', NULL);
INSERT INTO `floor` VALUES (2, 1, '朝阳楼', '2022-04-25 11:09:50', NULL, 'dio', NULL);
INSERT INTO `floor` VALUES (3, 1, '测试楼8', '2022-04-25 00:00:00', '2022-04-25 11:35:41', 'dio', 'dio');
INSERT INTO `floor` VALUES (6, 2, '测', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for foreign_personnel
-- ----------------------------
DROP TABLE IF EXISTS `foreign_personnel`;
CREATE TABLE `foreign_personnel`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `health_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '健康码图片',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `remark` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '外来人员报备' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of foreign_personnel
-- ----------------------------

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) NULL DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `isdone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1646893922469 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '社区交流' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES (51, '2022-03-10 14:25:23', '帖子标题1', '<p>帖子内容1  这里可删改查用户发布的帖子</p>', 0, 1, '用户名1', '开放');
INSERT INTO `forum` VALUES (53, '2022-03-10 14:25:23', '帖子标题3', '帖子内容3', 0, 3, '用户名3', '开放');
INSERT INTO `forum` VALUES (54, '2022-03-10 14:25:23', '帖子标题4', '帖子内容4', 0, 4, '用户名4', '开放');
INSERT INTO `forum` VALUES (55, '2022-03-10 14:25:23', '帖子标题5', '帖子内容5', 0, 5, '用户名5', '开放');
INSERT INTO `forum` VALUES (56, '2022-03-10 14:25:23', '帖子标题6', '帖子内容6', 0, 6, '用户名6', '开放');
INSERT INTO `forum` VALUES (1646893917882, '2022-03-10 14:31:57', '111111111', '111', 0, 1646893886397, '001', '开放');
INSERT INTO `forum` VALUES (1646893922468, '2022-03-10 14:32:02', NULL, '1212', 1646893917882, 1646893886397, '001', NULL);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_type_id` bigint(20) NULL DEFAULT NULL,
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `describe` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '描述',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `inventory` int(10) NULL DEFAULT NULL COMMENT '库存',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 2, '蜀道香 川味嗨辣牛肉', 'upload/1650946674620.jpg', '蜀道香 川味嗨辣牛肉500g 5种口味 零食大礼包 蜀道香 川味嗨辣牛肉500g5种口味 零食大礼包 蜀道香 川味嗨辣牛肉500g 5种口味 零食大礼包', 36.90, 100, '2022-04-26 00:00:00', '2022-04-26 12:19:37', 'dio', 'dio');
INSERT INTO `goods` VALUES (2, 3, '水果礼盒', 'upload/1650946876690.jpg', '大渠庄园水果礼盒 新鲜水果礼盒组合大礼包春节礼品送客户团购年货礼盒大礼包 238型', 198.00, 200, '2022-04-26 12:21:19', NULL, 'dio', NULL);
INSERT INTO `goods` VALUES (3, 1, '方便面蔬菜包', 'upload/1650947094183.jpg', '凡农人家脱水蔬菜干泡面伴侣方便面蔬菜包户外煮汤配菜青菜胡萝卜风干干菜500g', 39.80, 250, '2022-04-26 12:24:56', NULL, 'dio', NULL);
INSERT INTO `goods` VALUES (4, 1, '西红柿蛋花汤', 'upload/1650947318635.jpg', '苏伯 西红柿蛋花汤 小包冻干蔬菜速食汤 冲泡即食 8g*10', 25.50, 500, '2022-04-26 00:00:00', '2022-04-26 12:28:41', 'dio', 'dio');
INSERT INTO `goods` VALUES (5, 1, '蔬菜包混合装', 'upload/1650947462664.jpg', '凡农人家万年青脱水蔬菜白菜干莴笋干菜下饭菜干萝卜条干货果蔬菜包混合装', 98.80, 120, '2022-04-26 12:31:33', NULL, 'dio', NULL);
INSERT INTO `goods` VALUES (6, 1, '苏伯 礼盒', 'upload/1650956900123.jpg', '苏伯 礼盒 蛋花汤 6口味（紫菜、番茄、小白菜、裙带、菠菜、鲜蔬芙蓉）冻干速食汤 冲泡即食8g*18', 33.00, 0, '2022-04-26 00:00:00', '2022-04-26 15:11:52', 'dio', 'dio');

-- ----------------------------
-- Table structure for goods_appointment
-- ----------------------------
DROP TABLE IF EXISTS `goods_appointment`;
CREATE TABLE `goods_appointment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yonghu_id` bigint(20) NULL DEFAULT NULL,
  `goods_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `goods_cart`;
CREATE TABLE `goods_cart`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yonghu_id` bigint(20) NULL DEFAULT NULL,
  `goods_id` bigint(20) NULL DEFAULT NULL,
  `goods_num` int(10) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_cart
-- ----------------------------
INSERT INTO `goods_cart` VALUES (7, 11, 3, 1, '2022-04-29 23:36:18');

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单号',
  `yonghu_id` bigint(20) NULL DEFAULT NULL,
  `goods_id` bigint(20) NULL DEFAULT NULL,
  `goods_num` int(10) NULL DEFAULT NULL COMMENT '商品数',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价',
  `goods_status` int(2) NULL DEFAULT 0 COMMENT '订单状态 0发货中，1已收货 2退货中 3已退货',
  `goods_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单地址',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_order
-- ----------------------------
INSERT INTO `goods_order` VALUES (5, 'e83bb931-dc2e-4606-bea2-5535935792f2', 11, 5, 1, 98.80, 3, '朝阳区 潮汐楼 S626', '2022-04-26 12:31:33');
INSERT INTO `goods_order` VALUES (6, 'e83bb931-dc2e-4606-bea2-5535935792f2', 11, 5, 1, 98.80, 1, '朝阳区 潮汐楼 S626', '2022-04-26 12:31:33');

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES (1, '蔬菜包', '2022-04-26 11:42:27', NULL, 'dio', NULL);
INSERT INTO `goods_type` VALUES (2, '肉类包', '2022-04-26 11:43:28', NULL, 'dio', NULL);
INSERT INTO `goods_type` VALUES (3, '水果包', '2022-04-26 00:00:00', '2022-04-26 11:43:48', 'dio', 'dio');
INSERT INTO `goods_type` VALUES (4, '生活用品', '2022-04-26 11:43:58', NULL, 'dio', NULL);

-- ----------------------------
-- Table structure for jiankangxinxi
-- ----------------------------
DROP TABLE IF EXISTS `jiankangxinxi`;
CREATE TABLE `jiankangxinxi`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `shangbaobiaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上报标题',
  `shangbaotupian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报图片',
  `gerentiwen` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个人体温',
  `shentizhuangkuang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身体状况',
  `fengxiandiqu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '风险地区',
  `shangbaoneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '上报内容',
  `shangbaoriqi` date NULL DEFAULT NULL COMMENT '上报日期',
  `yonghuming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `shouji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `zhuzhi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1646893976148 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '健康信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jiankangxinxi
-- ----------------------------
INSERT INTO `jiankangxinxi` VALUES (41, '2022-03-10 14:25:23', '上报标题1', 'upload/jiankangxinxi_shangbaotupian1.jpg', '个人体温1', '正常', '去过', '上报内容1', '2022-03-10', '用户名1', '13823888881', '住址1', '是', '收到', 1);
INSERT INTO `jiankangxinxi` VALUES (42, '2022-03-10 14:25:23', '上报标题2', 'upload/jiankangxinxi_shangbaotupian2.jpg', '个人体温2', '正常', '去过', '上报内容2', '2022-03-10', '用户名2', '13823888882', '住址2', '是', '', 2);
INSERT INTO `jiankangxinxi` VALUES (43, '2022-03-10 14:25:23', '上报标题3', 'upload/jiankangxinxi_shangbaotupian3.jpg', '个人体温3', '正常', '去过', '上报内容3', '2022-03-10', '用户名3', '13823888883', '住址3', '是', '', 3);
INSERT INTO `jiankangxinxi` VALUES (44, '2022-03-10 14:25:23', '上报标题4', 'upload/jiankangxinxi_shangbaotupian4.jpg', '个人体温4', '正常', '去过', '上报内容4', '2022-03-10', '用户名4', '13823888884', '住址4', '是', '', 4);
INSERT INTO `jiankangxinxi` VALUES (45, '2022-03-10 14:25:23', '上报标题5', 'upload/jiankangxinxi_shangbaotupian5.jpg', '个人体温5', '正常', '去过', '上报内容5', '2022-03-10', '用户名5', '13823888885', '住址5', '是', '', 5);
INSERT INTO `jiankangxinxi` VALUES (46, '2022-03-10 14:25:23', '上报标题6', 'upload/jiankangxinxi_shangbaotupian6.jpg', '个人体温6', '正常', '去过', '上报内容6', '2022-03-10', '用户名6', '13823888886', '住址6', '是', '', 6);
INSERT INTO `jiankangxinxi` VALUES (1646893976147, '2022-03-10 14:32:56', '111', 'upload/1646893967187.png', '36.5°', '正常', '未去过', '1212', '2022-03-10', '001', '13498789811', '1132', '是', '1', 1646893886397);

-- ----------------------------
-- Table structure for location_info
-- ----------------------------
DROP TABLE IF EXISTS `location_info`;
CREATE TABLE `location_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yonghu_id` bigint(20) NULL DEFAULT NULL,
  `temperature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '当天体温',
  `symptom` int(2) NULL DEFAULT NULL COMMENT '症状：0：无异常，1发烧， 2咳嗽， 3乏力， 呼吸困难',
  `is_hospitalize` int(2) NULL DEFAULT NULL COMMENT '是否就医:0 未就医， 1已就医',
  `insulate_status` int(2) NULL DEFAULT NULL COMMENT '隔离情况 0未隔离：1已被隔离',
  `new_contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最新接触',
  `location_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '定位',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '定位填报信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of location_info
-- ----------------------------
INSERT INTO `location_info` VALUES (3, 11, '37', 0, 0, 0, '无', '重庆市', '2022-04-25 21:39:21');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1646894118263 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (61, '2022-03-10 14:25:23', '有梦想，就要努力去实现', '不管你想要怎样的生活，你都要去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。', 'upload/news_picture1.jpg', '<p>不管你想要怎样的生活，你都要<img src=\"http://localhost:8080/ssm63nhz/upload/1646893840978.jpg\">去努力争取，不多尝试一些事情怎么知道自己适合什么、不适合什么呢?</p><p>你说你喜欢读书，让我给你列书单，你还问我哪里有那么多时间看书;你说自己梦想的职业是广告文案，问我如何成为一个文案，应该具备哪些素质;你说你计划晨跑，但总是因为学习、工作辛苦或者身体不舒服第二天起不了床;你说你一直梦想一个人去长途旅行，但是没钱，父母觉得危险。其实，我已经厌倦了你这样说说而已的把戏，我觉得就算我告诉你如何去做，你也不会照做，因为你根本什么都不做。</p><p>真正有行动力的人不需要别人告诉他如何做，因为他已经在做了。就算碰到问题，他也会自己想办法，自己动手去解决或者主动寻求可以帮助他的人，而不是等着别人为自己解决问题。</p><p>首先要学习独立思考。花一点时间想一下自己喜欢什么，梦想是什么，不要别人说想环游世界，你就说你的梦想是环游世界。</p><p>很多人说现实束缚了自己，其实在这个世界上，我们一直都可以有很多选择，生活的决定权也—直都在自己手上，只是我们缺乏行动力而已。</p><p>如果你觉得安于现状是你想要的，那选择安于现状就会让你幸福和满足;如果你不甘平庸，选择一条改变、进取和奋斗的道路，在这个追求的过程中，你也一样会感到快乐。所谓的成功，即是按照自己想要的生活方式生活。最糟糕的状态，莫过于当你想要选择一条不甘平庸、改变、进取和奋斗的道路时，却以一种安于现状的方式生活，最后抱怨自己没有得到想要的人生。</p><p>因为喜欢，你不是在苦苦坚持，也因为喜欢，你愿意投入时间、精力，长久以往，获得成功就是自然而然的事情。</p>');
INSERT INTO `news` VALUES (62, '2022-03-10 14:25:23', '又是一年毕业季', '又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。', 'upload/news_picture2.jpg', '<p>又是一年毕业季，感慨万千，还记的自己刚进学校那时候的情景，我拖着沉重的行李箱站在偌大的教学楼前面，感叹自己未来的日子即将在这个陌生的校园里度过，而如今斗转星移，浮光掠影，弹指之间，那些青葱岁月如同白驹过隙般悄然从指缝溜走。</p><p>过去的种种在胸口交集纠结，像打翻的五味瓶，甜蜜，酸楚，苦涩，一并涌上心头。一直都是晚会的忠实参与者，无论是台前还是幕后，忽然间，角色转变，那种感觉确实难以用语言表达。</p><p>	过去的三年，总是默默地期盼着这个好雨时节，因为这时候，会有灿烂的阳光，会有满目的百花争艳，会有香甜的冰激凌，这是个毕业的季节，当时不经世事的我们会殷切地期待学校那一大堆的活动，期待穿上绚丽的演出服或者礼仪服，站在大礼堂镁光灯下尽情挥洒我们的澎拜的激情。</p><p>百感交集，隔岸观火与身临其境的感觉竟是如此不同。从来没想过一场晚会送走的是我们自己的时候会是怎样的感情，毕业就真的意味着结束吗?倔强的我们不愿意承认，谢谢学弟学妹们慷慨的将这次的主题定为“我们在这里”。我知道，这可能是他们对我们这些过来人的尊敬和施舍。</p><p>没有为这场晚会排练、奔波，没有为班级、学生会、文学院出点力，还真有点不习惯，百般无奈中，用“工作忙”个万能的借口来搪塞自己，欺骗别人。其实自己心里明白，那只是在逃避，只是不愿面对繁华落幕后的萧条和落寞。大四了，大家各奔东西，想凑齐班上的人真的是难上加难，敏燕从越南回来，刚落地就匆匆回了学校，那么恋家的人也启程回来了，睿睿学姐也是从家赶来跟我们团圆。大家—如既往的寒暄、打趣、调侃对方，似乎一切又回到了当初的单纯美好。</p><p>看着舞台上活泼可爱的学弟学妹们，如同一群机灵的小精灵，清澈的眼神，稚嫩的肢体，轻快地步伐，用他们那热情洋溢的舞姿渲染着在场的每一个人，我知道，我不应该羡慕嫉妒他们，不应该顾自怜惜逝去的青春，不应该感叹夕阳无限好，曾经，我们也拥有过，曾经，我们也年轻过，曾经，我们也灿烂过。我深深地告诉自己，人生的每个阶段都是美的，年轻有年轻的活力，成熟也有成熟的魅力。多—份稳重、淡然、优雅，也是漫漫时光掠影遗留下的.珍贵赏赐。</p>');
INSERT INTO `news` VALUES (63, '2022-03-10 14:25:23', '挫折路上，坚持常在心间', '回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。', 'upload/news_picture3.jpg', '<p>回头看看，你会不会发现，曾经的你在这里摔倒过;回头看看，你是否发现，一次次地重复着，却从没爬起过。而如今，让我们把视线转向前方，那一道道金色的弧线，是流星飞逝的痕迹，或是成功运行的轨道。今天的你，是否要扬帆起航，让幸福来敲门?</p><p>清晨的太阳撒向大地，神奇的宇宙赋予它神奇的色彩，大自然沐浴着春光，世界因太阳的照射而精彩，林中百鸟啾啾，河水轻轻流淌，汇成清宁的山间小调。</p><p>是的，面对道途上那无情的嘲讽，面对步伐中那重复的摔跤，面对激流与硬石之间猛烈的碰撞，我们必须选择那富于阴雨，却最终见到彩虹的荆棘路。也许，经历了那暴风雨的洗礼，我们便会变得自信，幸福也随之而来。</p><p>司马迁屡遭羞辱，却依然在狱中撰写《史记》，作为一名史学家，不因王权而极度赞赏，也不因卑微而极度批判，然而他在坚持自己操守的同时，却依然要受统治阶级的阻碍，他似乎无权选择自己的本职。但是，他不顾于此，只是在面对道途的阻隔之时，他依然选择了走下去的信念。终于一部开山巨作《史记》诞生，为后人留下一份馈赠，也许在他完成毕生的杰作之时，他微微地笑了，没有什么比梦想实现更快乐的了......</p><p>	或许正如“长风破浪会有时，直挂云帆济沧海”一般，欣欣然地走向看似深渊的崎岖路，而在一番耕耘之后，便会发现这里另有一番天地。也许这就是困难与快乐的交融。</p><p>也许在形形色色的社会中，我们常能看到一份坚持，一份自信，但这里却还有一类人。这类人在暴风雨来临之际，只会闪躲，从未懂得这也是一种历炼，这何尝不是一份快乐。在阴暗的角落里，总是独自在哭，带着伤愁，看不到一点希望。</p><p>我们不能堕落于此，而要像海燕那般，在苍茫的大海上，高傲地飞翔，任何事物都无法阻挡，任何事都是幸福快乐的。</p>');
INSERT INTO `news` VALUES (64, '2022-03-10 14:25:23', '挫折是另一个生命的开端', '当遇到挫折或失败，你是看见失败还是看见机会?挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。', 'upload/news_picture4.jpg', '<p>当遇到挫折或失败，你是看见失败还是看见机会?</p><p>挫折是我们每个人成长的必经之路，它不是你想有就有，想没有就没有的。有句名言说的好，如果你想一生摆脱苦难，你就得是神或者是死尸。这句话形象地说明了挫折是伴随着人生的，是谁都逃不掉的。</p><p>人生在世，从古到今，不分天子平民，机遇虽有不同，但总不免有身陷困境或遭遇难题之处，这时候唯有通权达变，才能使人转危为安，甚至反败为胜。</p><p>大部分的人，一生当中，最痛苦的经验是失去所爱的人，其次是丢掉一份工作。其实，经得起考验的人，就算是被开除也不会惊慌，要学会面对。</p><p>	“塞翁失马，焉知非福。”人生的道路，并不是每一步都迈向成功，这就是追求的意义。我们还要认识到一点，挫折作为一种情绪状态和一种个人体验，各人的耐受性是大不相同的，有的人经历了一次次挫折，就能够坚忍不拔，百折不挠;有的人稍遇挫折便意志消沉，一蹶不振。所以，挫折感是一种主观感受，因为人的目的和需要不同，成功标准不同，所以同一种活动对于不同的人可能会造成不同的挫折感受。</p><p>凡事皆以平常心来看待，对于生命顺逆不要太执著。能够“破我执”是很高层的人生境界。</p><p>人事的艰难就是一种考验。就像—支剑要有磨刀来磨，剑才会利:一块璞玉要有粗石来磨，才会发出耀眼的光芒。我们能够做到的，只是如何减少、避免那些由于自身的原因所造成的挫折，而在遇到痛苦和挫折之后，则力求化解痛苦，争取幸福。我们要知道，痛苦和挫折是双重性的，它既是我们人生中难以完全避免的，也是我们在争取成功时，不可缺少的一种动力。因为我认为，推动我们奋斗的力量，不仅仅是对成功的渴望，还有为摆脱痛苦和挫折而进行的奋斗。</p>');
INSERT INTO `news` VALUES (65, '2022-03-10 14:25:23', '你要去相信，没有到不了的明天', '有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。', 'upload/news_picture5.jpg', '<p>有梦想就去努力，因为在这一辈子里面，现在不去勇敢的努力，也许就再也没有机会了。你要去相信，一定要相信，没有到不了的明天。不要被命运打败，让自己变得更强大。</p><p>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心址笑着的时候闪过一丝落寞。</p><p>	不管你现在是在图书馆里背着怎么也看不进去的英语单词，还是你现在迷茫地看不清未来的方向不知道要往哪走。</p><p>不管你现在是在努力着去实现梦想却没能拉近与梦想的距离，还是你已经慢慢地找不到自己的梦想了。</p><p>你都要去相信，没有到不了的明天。</p><p>	有的时候你的梦想太大，别人说你的梦想根本不可能实现;有的时候你的梦想又太小，又有人说你胸无大志;有的时候你对死党说着将来要去环游世界的梦想，却换来他的不屑一顾，于是你再也不提自己的梦想;有的时候你突然说起将来要开个小店的愿望，却发现你讲述的那个人，并没有听到你在说什么。</p><p>不过又能怎么样呢，未来始终是自己的，梦想始终是自己的，没有人会来帮你实现它。</p><p>也许很多时候我们只是需要朋友的一句鼓励，一句安慰，却也得不到。但是相信我，世界上还有很多人，只是想要和你说说话。</p><p>因为我们都一样。一样的被人说成固执，一样的在追逐他们眼里根本不在意的东西。</p><p>所以，又有什么关系呢，别人始终不是你、不能懂你的心情，你又何必多去解释呢。这个世界会来阻止你，困难也会接踵而至，其实真正关键的只有自己，有没有那个倔强。</p><p>这个世界上没有不带伤的人，真正能治愈自己的，只有自己。</p>');
INSERT INTO `news` VALUES (66, '2022-03-10 14:25:23', '离开是一种痛苦，是一种勇气，但同样也是一个考验，是一个新的开端', '无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。', 'upload/news_picture6.jpg', '<p>无穷无尽是离愁，天涯海角遍寻思。当离别在即之时，当面对着相濡以沫兄弟般的朋友时，当面对着经历了四年的磨合而形成的真挚友谊之时，我内心激动无语，说一声再见，道一声珍重都很难出口。回想自己四年大学的风风雨雨，回想我们曾经共同经历的岁月流年，我感谢大家的相扶相依，感谢朋友们的莫大支持与帮助。虽然舍不得，但离别的脚步却不因我们的挚情而停滞。离别的确是一种痛苦，但同样也是我们走入社会，走向新环境、新领域的一个开端，希望大家在以后新的工作岗位上能够确定自己的新起点，坚持不懈，向着更新、更高的目标前进，因为人生最美好的东西永远都在最前方!</p><p>忆往昔峥嵘岁月，看今朝潮起潮落，望未来任重而道远。作为新时代的我们，就应在失败时，能拼搏奋起，去谱写人生的辉煌。在成功时，亦能居安思危，不沉湎于一时的荣耀、鲜花和掌声中，时时刻刻怀着一颗积极寻找自己新的奶酪的心，处变不惊、成败不渝，始终踏着自己坚实的步伐，从零开始，不断向前迈进，这样才能在这风起云涌、变幻莫测的社会大潮中成为真正的弄潮儿!</p>');
INSERT INTO `news` VALUES (1646894118262, '2022-03-10 14:35:18', 'AA', 'AA', 'upload/1646894114114.jpg', '<p><img src=\"http://localhost:8080/ssm63nhz/upload/1646894117128.jpg\"></p>');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `floor_id` bigint(20) NULL DEFAULT NULL,
  `room_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '房间号',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '房间' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, 1, '6278', '2022-04-25 00:00:00', '2022-04-25 12:24:06', 'dio', 'dio');
INSERT INTO `room` VALUES (2, 1, 'S626', '2022-04-25 12:24:25', NULL, 'dio', NULL);
INSERT INTO `room` VALUES (6, 1, 'P7273', '2022-04-25 13:28:49', NULL, 'dio', NULL);

-- ----------------------------
-- Table structure for supplies
-- ----------------------------
DROP TABLE IF EXISTS `supplies`;
CREATE TABLE `supplies`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '物资名称',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图片',
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '描述',
  `inventory` int(10) NULL DEFAULT NULL COMMENT '库存',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '防疫物资' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplies
-- ----------------------------
INSERT INTO `supplies` VALUES (6, '医用防护隔离服', 'upload/1650941402191.jpg', '一次性医用隔离衣反穿式加厚手术衣手术服防尘服医用防护隔离服均码', 997, '2022-04-26 10:50:04', NULL, 'dio', NULL);
INSERT INTO `supplies` VALUES (7, '医用外科口罩', 'upload/1650941502044.jpg', '医用外科口罩50只/盒 三层防护含熔喷层防细菌花粉 细菌过滤率大于95% 抽取式盒装设计', 997, '2022-04-26 10:51:49', NULL, 'dio', NULL);
INSERT INTO `supplies` VALUES (8, '医用体温枪', 'upload/1650941537806.jpg', '医用体温枪额温枪体温计电子测温枪家用婴儿红外线温度计', 997, '2022-04-26 10:52:19', NULL, 'dio', NULL);

-- ----------------------------
-- Table structure for supplies_yonghu
-- ----------------------------
DROP TABLE IF EXISTS `supplies_yonghu`;
CREATE TABLE `supplies_yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `supplies_id` bigint(20) NULL DEFAULT NULL,
  `yonghu_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `subscribe_count` int(10) NULL DEFAULT 1 COMMENT '预约次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '社区物资和用户关联中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplies_yonghu
-- ----------------------------
INSERT INTO `supplies_yonghu` VALUES (10, 6, 11, '2022-04-26 11:01:19', 2);
INSERT INTO `supplies_yonghu` VALUES (11, 7, 11, '2022-04-26 11:01:19', 2);
INSERT INTO `supplies_yonghu` VALUES (12, 8, 11, '2022-04-26 11:01:19', 2);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '新增时间',
  `expiratedtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'abo', 'users', '管理员', 'umy7lfneuh7h6opvvxxeu0llp6e77ej1', '2022-03-10 14:29:00', '2022-04-24 20:07:28');
INSERT INTO `token` VALUES (2, 1646893886397, '001', 'yonghu', '用户', '97ij8h900w1x3v049qg45mrvajcei71z', '2022-03-10 14:31:29', '2022-03-10 15:31:30');
INSERT INTO `token` VALUES (3, 11, '用户名1', 'yonghu', '用户', 'k8uwffs8imziftwj1rwayir6qjgksfck', '2022-03-10 14:33:04', '2022-04-30 01:53:00');
INSERT INTO `token` VALUES (4, 3, 'dio', 'users', '总管理员', '90bmfeuejenkcjr2rtxrtjd6222jy7r4', '2022-04-24 20:19:19', '2022-04-30 01:55:00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '新增时间',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `code` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '授权码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'abo', 'abo', '管理员', '2022-03-10 14:25:23', NULL, NULL);
INSERT INTO `users` VALUES (3, 'dio', 'dio', '总管理员', '2022-04-24 20:18:09', '18375741257', '123456789');
INSERT INTO `users` VALUES (6, 'jojo', 'jojo', '管理员', '2022-04-24 21:33:08', '18375741256', '');

-- ----------------------------
-- Table structure for yiqingshangbao
-- ----------------------------
DROP TABLE IF EXISTS `yiqingshangbao`;
CREATE TABLE `yiqingshangbao`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `tupian` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `shangbaoneirong` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上报内容',
  `shangbaoriqi` date NULL DEFAULT NULL COMMENT '上报日期',
  `yonghuming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `shouji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1646893952447 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '疫情上报' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yiqingshangbao
-- ----------------------------
INSERT INTO `yiqingshangbao` VALUES (31, '2022-03-10 14:25:23', '标题1', 'upload/1646893785346.jpg', '上报内容1', '2022-03-10', '用户名1', '13823888881', '是', '收到 会跟进核实', 1);
INSERT INTO `yiqingshangbao` VALUES (32, '2022-03-10 14:25:23', '标题2', 'upload/1646893792613.jpg', '上报内容2', '2022-03-10', '用户名2', '13823888882', '是', '', 2);
INSERT INTO `yiqingshangbao` VALUES (33, '2022-03-10 14:25:23', '标题3', 'upload/1646893799233.jpg', '上报内容3', '2022-03-10', '用户名3', '13823888883', '是', '', 3);
INSERT INTO `yiqingshangbao` VALUES (34, '2022-03-10 14:25:23', '标题4', 'upload/1646893820549.jpg', '上报内容4', '2022-03-10', '用户名4', '13823888884', '是', '', 4);
INSERT INTO `yiqingshangbao` VALUES (1646893952446, '2022-03-10 14:32:31', '11212', 'upload/1646893950397.jpg', '1212', '2022-03-10', '001', '13498789811', '是', '1', 1646893886397);

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `yonghuming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `xingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `shouji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `zhuzhi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `status` tinyint(50) NOT NULL COMMENT '1正常 2确诊 3无症状感染者 ',
  `back_status` tinyint(50) NOT NULL COMMENT '1未隔离 2隔离 3已治愈',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yonghuming`(`yonghuming`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1650887719196 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (11, '2022-03-10 14:25:23', '123', '123', '姓名1', '男', 'upload/yonghu_touxiang1.jpg', '13823888881', '住址1', 0, 0);
INSERT INTO `yonghu` VALUES (12, '2022-03-10 14:25:23', '用户名2', '123456', '姓名2', '男', 'upload/yonghu_touxiang2.jpg', '13823888882', '住址2', 0, 0);
INSERT INTO `yonghu` VALUES (13, '2022-03-10 14:25:23', '用户名3', '123456', '姓名3', '女', 'upload/yonghu_touxiang3.jpg', '13823888883', '住址3', 0, 0);
INSERT INTO `yonghu` VALUES (14, '2022-03-10 14:25:23', '用户名4', '123456', '姓名4', '男', 'upload/yonghu_touxiang4.jpg', '13823888884', '住址4', 0, 0);
INSERT INTO `yonghu` VALUES (15, '2022-03-10 14:25:23', '用户名5', '123456', '姓名5', '男', 'upload/yonghu_touxiang5.jpg', '13823888885', '住址5', 0, 0);
INSERT INTO `yonghu` VALUES (16, '2022-03-10 14:25:23', '用户名6', '123456', '姓名6', '男', 'upload/yonghu_touxiang6.jpg', '13823888886', '住址6', 0, 0);
INSERT INTO `yonghu` VALUES (1646893886397, '2022-03-10 14:31:26', '001', '001', '小李', '女', 'upload/1646893895426.jpg', '13498789811', '1132', 0, 0);

-- ----------------------------
-- Table structure for yonghu_addr
-- ----------------------------
DROP TABLE IF EXISTS `yonghu_addr`;
CREATE TABLE `yonghu_addr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yonghu_id` bigint(20) NULL DEFAULT NULL,
  `area_id` bigint(20) NULL DEFAULT NULL,
  `floor_id` bigint(20) NULL DEFAULT NULL,
  `room_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu_addr
-- ----------------------------
INSERT INTO `yonghu_addr` VALUES (4, 11, 1, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
