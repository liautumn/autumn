-- MySQL dump 10.13  Distrib 5.7.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: autumn
-- ------------------------------------------------------
-- Server version	5.7.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '部门id',
  `parent_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '部门名称',
  `order_num` int(11) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 DEFAULT '0' COMMENT '是否停用（0是 1否）',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES ('100','0','0','AUTUMN科技',1,'autumn','16638808906','1060590974@qq.com','1','1','admin','2023-05-25 03:10:49','admin','2023-08-01 15:27:45'),('101','100','0,100','深圳总公司',1,'autumn',NULL,NULL,'1','1','admin','2023-05-25 03:10:49','admin','2023-07-22 17:36:37'),('102','100','0,100','长沙分公司',2,'autumn',NULL,NULL,'1','1','admin','2023-05-25 03:10:49','',NULL),('103','101','0,100,101','研发部门',2,'autumn',NULL,NULL,'1','0','admin','2023-05-25 03:10:49','admin','2023-07-22 17:33:12'),('104','101','0,100,101','市场部门',2,'autumn',NULL,NULL,'1','1','admin','2023-05-25 03:10:49','',NULL),('105','101','0,100,101','测试部门',3,'1',NULL,NULL,'1','1','admin','2023-05-25 03:10:50','admin','2023-07-22 17:36:58'),('106','101','0,100,101','财务部门',4,'autumn',NULL,NULL,'1','0','admin','2023-05-25 03:10:50','',NULL),('107','101','0,100,101','运维部门',5,'autumn',NULL,NULL,'1','1','admin','2023-05-25 03:10:50','',NULL),('108','102','0,100,102','市场部门',1,'autumn',NULL,NULL,'1','1','admin','2023-05-25 03:10:50','',NULL),('109','102','0,100,102','财务部门',2,'autumn',NULL,NULL,'1','0','admin','2023-05-25 03:10:50','',NULL);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_data` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典数据表ID',
  `parent_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '父节点ID',
  `dict_type_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典类型表ID',
  `dict_label` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据标签',
  `dict_value` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据键值',
  `dict_sort` int(11) DEFAULT NULL COMMENT '显示排序',
  `dict_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据类型',
  `css_class` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '样式属性',
  `echo_class` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '回显样式',
  `is_default` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '是否默认（0是 1否）',
  `status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '是否停用（0是 1否）',
  `remark` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES ('1668438545397800961','0','1667436790484566018','男','0',1,'sex','1','1','1','1','1','1','admin','2023-06-13 10:02:02','admin','2023-06-13 10:03:37'),('1668438662158835714','0','1667436790484566018','女','1',2,'sex','2','1','1','1','1','1','admin','2023-06-13 10:02:30','admin','2023-06-13 10:03:32'),('1668438753632411649','0','1667436134579306497','是','0',1,'whether','1','1','1','1','1','1','admin','2023-06-13 10:02:52','',NULL),('1668438845705773058','0','1667436134579306497','否','1',2,'whether','1','1','1','1','1','1','admin','2023-06-13 10:03:14','',NULL),('1668604213654315009','0','1667436790484566018','未知','2',3,'sex','1','1','1','1','1','1','admin','2023-06-13 21:00:20','',NULL),('1670251704228040706','0','1667436790484566018','1','1',1,'1','1','1','1','1','1','0','admin','2023-06-18 10:06:53','',NULL),('1670977651247972354','0','1670977553487134722','目录','0',1,'menuType','1','1','1','1','1','1','admin','2023-06-20 10:11:32','admin','2023-06-28 20:05:02'),('1670977776024322049','0','1670977553487134722','菜单','1',2,'menuType','1','1','1','1','1','1','admin','2023-06-20 10:12:02','admin','2023-06-29 20:01:30'),('1670977839270232065','0','1670977553487134722','按钮','2',3,'menuType','1','1','1','1','1','1','admin','2023-06-20 10:12:17','admin','2023-06-28 20:05:05'),('1678701515277156354','0','1678701354673061890','啊','1',1,'treeTest',NULL,NULL,'1','1',NULL,'1','admin','2023-07-11 17:43:25','admin','2023-07-15 04:08:57'),('1678701663038291970','1678701515277156354','1678701354673061890','的','2',1,'treeTest',NULL,'','1','1',NULL,'0','admin','2023-07-11 17:44:00','',NULL),('1678701741060734978','0','1678701354673061890','是','3',2,'treeTest',NULL,NULL,'1','1',NULL,'0','admin','2023-07-11 17:44:19','',NULL),('1683051098312663042','0','1678701354673061890','1','1',1,'treeTest','1','1','1','1','1','0','admin','2023-07-23 17:47:06','',NULL),('1683058587573788674','0','1678701354673061890','1','1',1,'treeTest','1','1','1','1','1','0','admin','2023-07-23 18:16:52','',NULL),('1683062596162396161','0','1678701354673061890','1','1',1,'treeTest','2','1','1','1','1','0','admin','2023-07-23 18:32:47','admin','2023-07-23 18:33:00');
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_type` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '字典类型表ID',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否停用（0是 1否）',
  `remark` text CHARACTER SET utf8mb4 COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '修改者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES ('1667436134579306497','是否','whether','1','是否状态','1','admin','2023-06-10 15:38:49','',NULL),('1667436790484566018','性别','sex','1','性别','1','admin','2023-06-10 15:41:25','admin','2023-07-10 01:05:55'),('1670628857507483649','树形结构','treeTest','1',NULL,'0','admin','2023-06-19 11:05:33','',NULL),('1670977553487134722','菜单类型','menuType','1','菜单类型','1','admin','2023-06-20 10:11:09','admin','2023-07-10 01:06:08'),('1678701354673061890','测试树','treeTest','1','2','1','admin','2023-07-11 17:42:46','admin','2023-07-23 18:33:14');
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_files`
--

DROP TABLE IF EXISTS `sys_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_files` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT 'ID',
  `file_name_before` text CHARACTER SET utf8mb4 COMMENT '上传前文件名称',
  `file_name_after` text CHARACTER SET utf8mb4 COMMENT '上传后文件名称',
  `file_size` varchar(50) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '文件大小',
  `upload_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '上传者',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文件上传记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_files`
--

LOCK TABLES `sys_files` WRITE;
/*!40000 ALTER TABLE `sys_files` DISABLE KEYS */;
INSERT INTO `sys_files` VALUES ('1668084718983237633','微信图片_20230508153714.jpg','20230612103603-12c64c9f-ca16-493e-aff5-be3dad4c76ac.jpg','32999','','1','admin','2023-06-12 10:36:03','',NULL),('1668087615028514817','微信图片_20230508153714.jpg','20230612104733-14eac28a-04b4-4eda-af0c-2d9639e237dd.jpg','32999','','1','admin','2023-06-12 10:47:34','',NULL),('1668087884785176577','微信图片_20230508153714.jpg','20230612104837-fe6b605e-65c1-4e89-9813-fa2462df5330.jpg','32999','','1','admin','2023-06-12 10:48:38','',NULL),('1668089565182742530','微信图片_20230508153714.jpg','20230612105517-10657c6e-eb84-47a7-ad51-d20ceeb1e9ab.jpg','32999','','1','admin','2023-06-12 10:55:19','',NULL),('1668193515395375105','微信图片_20230508153714.jpg','20230612174822-a2905462-48ab-4f4e-9667-591e71f0d2c2.jpg','32999','','1','admin','2023-06-12 17:48:22','',NULL),('1669308637372538881','微信图片_20230319201222.jpg','20230615193927-a2ec142f-06de-438a-b329-e03218b08df0.jpg','58561','','1','admin','2023-06-15 19:39:28','',NULL),('1669309038633213953','11.png','20230615194103-dbe986e3-9ca3-4316-8110-5fb3ea9fa992.png','74994','','1','admin','2023-06-15 19:41:04','',NULL),('1669333665178722305','11.png','20230615211854-727b192a-7988-448c-b921-ec02bdd3904a.png','74994','','1','admin','2023-06-15 21:18:55','',NULL),('1669334040443101185','11.png','20230615212024-985abd54-cdda-42bb-92c9-35d7a5f582c8.png','74994','','1','admin','2023-06-15 21:20:25','',NULL),('1669334128859029506','微信图片_20230319201222.jpg','20230615212045-65a51ccf-5351-40c9-baae-9555f7616f68.jpg','58561','','1','admin','2023-06-15 21:20:46','',NULL),('1669334533915549697','11.png','20230615212222-6c0852bc-c84d-4bad-bb2b-ba0ad594abf5.png','74994','','1','admin','2023-06-15 21:22:22','',NULL),('1669334934794543106','11.png','20230615212357-1780b993-2a1d-47f4-97e6-18aec41cb8fd.png','74994','','1','admin','2023-06-15 21:23:58','',NULL),('1669335165925859330','11.png','20230615212452-f947bc39-b56e-4d3b-8821-dc29646464de.png','74994','','1','admin','2023-06-15 21:24:53','',NULL),('1669335592654348290','11.png','20230615212634-10f2e032-e9d1-4c38-93f8-a58861cd367c.png','74994','','1','admin','2023-06-15 21:26:35','',NULL),('1669343290036854785','11.png','20230615215709-e129e59a-ecdd-4167-b9ae-38c6ed813904.png','74994','','1','admin','2023-06-15 21:57:10','',NULL),('1669344627516514306','11.png','20230615220228-c0afe1cd-bcb9-4c39-b2e4-2c3655be0d24.png','74994','','1','admin','2023-06-15 22:02:29','',NULL),('1669345283262390273','微信图片_20230319201222.jpg','20230615220504-8cf1e226-a9e4-4b55-9d43-7f914e3aad28.jpg','58561','','1','admin','2023-06-15 22:05:05','',NULL),('1669346895259246593','微信图片_20230319201222.jpg','20230615221129-70bdc869-8fc9-4d09-a0fc-be898677bbf2.jpg','58561','','1','admin','2023-06-15 22:11:29','',NULL),('1669347065254387714','微信图片_20230319201222.jpg','20230615221209-022fdb0e-c3e9-488c-b758-190a8c1a01ca.jpg','58561','','1','admin','2023-06-15 22:12:10','',NULL),('1669349023138717697','11.png','20230615221956-1949ab59-29da-4eeb-aa0c-322fbdf61693.png','74994','','1','admin','2023-06-15 22:19:57','',NULL),('1669349261060612098','11.png','20230615222053-f790d8d3-a2a5-4f5c-9950-339361137c53.png','74994','','1','admin','2023-06-15 22:20:54','',NULL),('1669349474261278721','11.png','20230615222144-a32d590d-e998-417d-83ca-b61861ed6cfb.png','74994','','1','admin','2023-06-15 22:21:44','',NULL),('1669352833475158018','阿里巴巴代码规范(java).jpg','20230615223505-29275f0c-7ec3-44ad-937e-7730c27cf9eb.jpg','265434','','1','admin','2023-06-15 22:35:05','',NULL),('1669353099196899330','11.png','20230615223608-ffda8266-e12e-406f-af98-473d47bd0542.png','74994','','1','admin','2023-06-15 22:36:09','',NULL),('1669353435248730113','11.png','20230615223728-3b1675b9-4d88-488d-adbb-6b57ad1b8da1.png','74994','','1','admin','2023-06-15 22:37:29','',NULL),('1669353702270705665','微信图片_20230319201222.jpg','20230615223832-f1355448-51c4-4820-be52-4780dbf045d5.jpg','58561','','1','admin','2023-06-15 22:38:32','',NULL),('1669353926770827265','英特尔.jpeg','20230615223925-c12c51c6-fdb1-4bdb-a3a2-13c0da8a81a9.jpeg','503989','','1','admin','2023-06-15 22:39:26','',NULL),('1669354262818463746','微信图片_20230319201222.jpg','20230615224045-ccbcd251-5a4d-4143-be51-cbdbd9469e7b.jpg','58561','','1','admin','2023-06-15 22:40:46','',NULL),('1669355327215378433','阿里巴巴代码规范(java).jpg','20230615224459-dca81e64-83ee-4baf-b8ff-2876bbdf5f3b.jpg','265434','','1','admin','2023-06-15 22:45:00','',NULL),('1669355619138936834','阿里巴巴代码规范(java).jpg','20230615224609-27f8cdc0-b0a5-4f1d-99d8-259a86911827.jpg','265434','','1','admin','2023-06-15 22:46:09','',NULL),('1669689771524734978','微信图片_20230319201222.jpg','20230616205357-436fdfd9-85e2-4174-8fe4-c9730849093a.jpg','58561','','1','admin','2023-06-16 20:53:58','',NULL),('1669689813300002818','微信图片_20230319201222.jpg','20230616205407-642f202c-9bd0-4242-9989-4be3ebde467f.jpg','58561','','1','admin','2023-06-16 20:54:07','',NULL),('1669690043944779777','微信图片_20230319201222.jpg','20230616205502-c0ac2b1a-8db7-494c-9cc5-c44ae3027f82.jpg','58561','','1','admin','2023-06-16 20:55:02','',NULL),('1669690234391347201','微信图片_20230319201222.jpg','20230616205547-2966e615-b9bd-4188-a411-881adcf6e72d.jpg','58561','','1','admin','2023-06-16 20:55:48','',NULL),('1669690304616579074','11.png','20230616205604-016273cb-ff18-4e27-9a4a-94520ad5e6b2.png','74994','','1','admin','2023-06-16 20:56:05','',NULL),('1669692642479685633','11.png','20230616210521-8599a830-3201-4bb7-9253-a10101eb2dd7.png','74994','','1','admin','2023-06-16 21:05:22','',NULL),('1669692878711275522','11.png','20230616210618-6e00c297-6967-4b68-97b3-3cbb4f8d6762.png','74994','','1','admin','2023-06-16 21:06:18','',NULL),('1669694280439283713','11.png','20230616211152-16210ef9-228d-4f37-ad3c-cdae9a8a5661.png','74994','','1','admin','2023-06-16 21:11:53','',NULL),('1669694290983763970','微信图片_20230319201222.jpg','20230616211154-d50bf823-ad19-42a2-a67b-b04e386feacb.jpg','58561','','1','admin','2023-06-16 21:11:55','',NULL),('1669694302996250626','英特尔.jpeg','20230616211157-c71968f0-13de-4cb7-af0d-57b04eb0d8ba.jpeg','503989','','1','admin','2023-06-16 21:11:58','',NULL),('1669694334071848962','mmexport1665824551746.jpg','20230616211205-53e2f77a-11fe-4b84-8aee-7d8acd00e25d.jpg','587938','','1','admin','2023-06-16 21:12:05','',NULL),('1669694344532443138','阿里巴巴代码规范(java).jpg','20230616211207-0cffc2e5-253e-4ebb-a29c-1e9aa6b7932d.jpg','265434','','1','admin','2023-06-16 21:12:08','',NULL),('1669698469244551170','英特尔.jpeg','20230616212831-9e8aa038-86b5-4648-9ed2-97d7c659840e.jpeg','503989','','1','admin','2023-06-16 21:28:31','',NULL),('1669698501913985025','11.png','20230616212838-d57c7d24-9ed2-4389-aa2c-6073527a4c15.png','74994','','1','admin','2023-06-16 21:28:39','',NULL),('1669698708177272834','阿里巴巴代码规范(java).jpg','20230616212928-ebf757cc-30dd-47b6-a6a3-b33c03c316c1.jpg','265434','','1','admin','2023-06-16 21:29:28','',NULL),('1669698755736485890','阿里巴巴代码规范(java).jpg','20230616212939-2f7a0cff-797b-4b17-bc17-aec025bc0a29.jpg','265434','','1','admin','2023-06-16 21:29:40','',NULL),('1669698944345948162','英特尔.jpeg','20230616213024-3630c4a8-c3c0-4459-b24d-e393f75bffb2.jpeg','503989','','1','admin','2023-06-16 21:30:24','',NULL),('1669699337759080449','英特尔.jpeg','20230616213158-914613d0-6a4d-4480-aae5-3a1e4b9ac7fe.jpeg','503989','','1','admin','2023-06-16 21:31:58','',NULL),('1669699600913907714','英特尔.jpeg','20230616213300-94085b6c-dee0-4803-94aa-736d0837fdc6.jpeg','503989','','1','admin','2023-06-16 21:33:01','',NULL),('1669699666718343169','英特尔.jpeg','20230616213316-2c956118-c9a5-4887-aaea-aedc301505d1.jpeg','503989','','1','admin','2023-06-16 21:33:17','',NULL),('1669700071414153217','11.png','20230616213453-70c2e361-9b18-4030-be58-7a56c49c353b.png','74994','','1','admin','2023-06-16 21:34:53','',NULL),('1669701561033801730','阿里巴巴代码规范(java).jpg','20230616214048-8800b126-8a67-44a2-9ca2-8dcb759e1b39.jpg','265434','','1','admin','2023-06-16 21:40:48','',NULL),('1669702218939744258','英特尔.jpeg','20230616214325-0e5b1599-d592-49b3-aa8e-854ad8715a85.jpeg','503989','','1','admin','2023-06-16 21:43:25','',NULL),('1669702453338423297','mmexport1665824551746.jpg','20230616214420-66564b26-e0d2-4490-85a7-664482610c70.jpg','587938','','1','admin','2023-06-16 21:44:21','',NULL),('1669703241339092993','英特尔.jpeg','20230616214728-7175a566-2385-42ad-ba50-31565bf45a05.jpeg','503989','','1','admin','2023-06-16 21:47:29','',NULL),('1669703915686707201','英特尔.jpeg','20230616215009-b1ff2819-96b0-4096-909e-7f994d8f78c5.jpeg','503989','','1','admin','2023-06-16 21:50:10','',NULL),('1669705312008257538','阿里巴巴代码规范(java).jpg','20230616215542-2c351749-a084-4498-a094-7c762ff31494.jpg','265434','','1','admin','2023-06-16 21:55:43','',NULL),('1669890577137979393','微信图片_20230319201222.jpg','20230617101153-2f2f29da-4e9d-40ee-ae02-71a0d9c83b5a.jpg','58561','','1','admin','2023-06-17 10:11:53','',NULL),('1669893431068250114','微信图片_20230319201222.jpg','20230617102313-2acbd378-f25c-40b1-98e9-0debce0c1b39.jpg','58561','','1','admin','2023-06-17 10:23:14','',NULL),('1669893926998560770','微信图片_20230319201222.jpg','20230617102511-07798bd4-0458-4f88-a74d-022c1af0d95a.jpg','58561','','1','admin','2023-06-17 10:25:12','',NULL),('1669895585648660481','11.png','20230617103147-58003ac6-7771-4459-8309-fc843e336ed8.png','74994','admin','1','admin','2023-06-17 10:31:47','',NULL),('1669896188173012994','11.png','20230617103411-73334999-6420-43a0-bced-2274d473705f.png','74994','admin','1','admin','2023-06-17 10:34:11','',NULL),('1669897122777190402','微信图片_20230319201222.jpg','20230617103753-72b09a4b-343e-48ce-af3a-0957a61cc61b.jpg','58561','admin','1','admin','2023-06-17 10:37:54','',NULL),('1669902847075209218','微信图片_20230319201222.jpg','20230617110038-280c743b-89dd-4866-aad5-8ce8a8fdb1ae.jpg','58561','admin','1','admin','2023-06-17 11:00:39','',NULL),('1669903119356841986','微信图片_20230319201222.jpg','20230617110143-1038a385-317f-481c-ac12-3543e6d0e2df.jpg','58561','admin','1','admin','2023-06-17 11:01:44','',NULL),('1669910819163656194','11.png','20230617113219-b6c69de3-d416-43fc-814f-444145ff1c94.png','74994','admin','1','admin','2023-06-17 11:32:19','',NULL),('1669910983764922370','11.png','20230617113258-3d5c4c5a-80e5-4ef0-ac51-feb7deba1737.png','74994','admin','1','admin','2023-06-17 11:32:59','',NULL),('1669918249280917505','微信图片_20230319201222.jpg','20230617120150-b9e79278-0872-4b28-b68d-618b18f40ebb.jpg','58561','admin','1','admin','2023-06-17 12:01:51','',NULL),('1669919382774796289','11.png','20230617120621-ded84539-d2c1-412d-8b1e-f2a41f0756cd.png','74994','admin','1','admin','2023-06-17 12:06:21','',NULL),('1669919660097982466','微信图片_20230319201222.jpg','20230617120727-93898cf2-88d8-49fb-bc4e-7873a797abf9.jpg','58561','admin','1','admin','2023-06-17 12:07:27','',NULL),('1669925469318074370','11.png','20230617123032-3921232b-3a6d-48e8-9227-cb76097868d4.png','74994','admin','1','admin','2023-06-17 12:30:32','',NULL),('1669925872998862849','11.png','20230617123208-a7138085-f476-4e80-a97a-487f30eb9fbb.png','74994','admin','1','admin','2023-06-17 12:32:09','',NULL),('1669925930242723842','微信图片_20230319201222.jpg','20230617123222-158e2bd9-da9b-41ea-a6cd-9f79b1532c7f.jpg','58561','admin','1','admin','2023-06-17 12:32:22','',NULL),('1669926515629150209','11.png','20230617123441-136aedb7-e94e-4a4d-bbbe-0a6168c94099.png','74994','admin','1','admin','2023-06-17 12:34:42','',NULL),('1669926731312844801','微信图片_20230319201222.jpg','20230617123533-14738c60-7af9-42c0-bd9c-55591037dfd3.jpg','58561','admin','1','admin','2023-06-17 12:35:33','',NULL),('1669936278169505793','11.png','20230617131329-a714e83a-9176-4b86-b918-8d2b60171d79.png','74994','admin','1','admin','2023-06-17 13:13:29','',NULL),('1669940409231790081','微信图片_20230319201222.jpg','20230617132954-b4e475dd-9f2d-4848-a9ec-b5d0702974dc.jpg','58561','admin','1','admin','2023-06-17 13:29:54','',NULL),('1669940454370889729','微信图片_20230319201222.jpg','20230617133004-16209a97-6fca-4443-8aef-8ceaaa389239.jpg','58561','admin','1','admin','2023-06-17 13:30:05','',NULL),('1669940905979990018','11.png','20230617133152-ff024ddb-08b5-4861-ab28-829c450c11ba.png','74994','admin','1','admin','2023-06-17 13:31:53','',NULL),('1669944888073179138','11.png','20230617134741-7104274e-9c39-4b01-b367-032be4d0d06f.png','74994','admin','1','admin','2023-06-17 13:47:42','',NULL),('1669948900151447553','微信图片_20230319201222.jpg','20230617140338-a767c0cb-797e-4ad2-844a-c8d3fc537971.jpg','58561','admin','1','admin','2023-06-17 14:03:39','',NULL),('1669999230985752578','英特尔.jpeg','20230617172338-f452374e-dbb8-4203-82df-088bc6d8eb00.jpeg','503989','admin','1','admin','2023-06-17 17:23:38','',NULL),('1670000609255018497','微信图片_20230319201222.jpg','20230617172906-ee455610-7c3a-44d6-9083-b8a61edad4db.jpg','58561','admin','1','admin','2023-06-17 17:29:07','',NULL),('1670005186494779393','11.png','20230617174718-0e9ae8c7-1798-4ed8-9407-7d65712d717b.png','74994','admin','1','admin','2023-06-17 17:47:18','',NULL),('1670010766718455810','微信图片_20230319201222.jpg','20230617180928-a6386bc0-26ff-4eca-9217-24e630e1b5f9.jpg','58561','admin','1','admin','2023-06-17 18:09:29','',NULL),('1670019537507246081','阿里巴巴代码规范(java).jpg','20230617184419-7c74c3a7-a6a0-4212-aa73-af5d7a6deda4.jpg','265434','admin','1','admin','2023-06-17 18:44:20','',NULL),('1670038291658125314','微信图片_20230319201222.jpg','20230617195851-07e28110-968a-4f6b-9d52-25026e34be39.jpg','58561','admin','1','admin','2023-06-17 19:58:51','',NULL),('1670038548009791489','微信图片_20230319201222.jpg','20230617195952-460429c7-39f8-48aa-b530-1e83e6d271fe.jpg','58561','admin','1','admin','2023-06-17 19:59:52','',NULL),('1670047392119205889','11.png','20230617203500-0f75931d-db29-45d0-861d-1c09fd504545.png','74994','admin','1','admin','2023-06-17 20:35:01','',NULL),('1670049359683989506','微信图片_20230319201222.jpg','20230617204222-b069ce37-b3f2-4af5-b623-502cdebdd9f5.jpg','58561','admin','1','admin','2023-06-17 20:42:50','',NULL),('1670242541154459650','微信图片_20230319201222.jpg','20230618093027-9e3664e5-ac34-46ca-b154-a0debdb6d36f.jpg','58561','admin','1','admin','2023-06-18 09:30:28','',NULL),('1670265258385711105','微信图片_20230319201222.jpg','20230618110044-4abfd6d3-b455-4d85-aad7-e01d26f7ce7f.jpg','58561','admin','1','admin','2023-06-18 11:00:44','',NULL),('1670265334009012225','11.png','20230618110102-c9ad9648-a419-4701-8778-4fbe1f1e1ac0.png','74994','admin','1','admin','2023-06-18 11:01:02','',NULL),('1670265458969911298','-2d8e28d0ac34c6e8.jpg','20230618110132-d8dd3d14-8074-4c13-96af-fa521a9c605f.jpg','89251','admin','1','admin','2023-06-18 11:01:32','',NULL),('1670410277912363009','微信图片_20230319201222.jpg','20230618123659-646f585b-71ab-46d0-b958-a2b73449c36b.jpg','58561','admin','1','admin','2023-06-18 12:37:00','',NULL),('1670410356681392130','微信图片_20230319201222.jpg','20230618123718-d8e4a4d9-7416-4c0c-9909-fb91a426b73d.jpg','58561','admin','1','admin','2023-06-18 12:37:18','',NULL),('1670414489236848642','-2d8e28d0ac34c6e8.jpg','20230618125343-74d2cf14-0514-4c2a-9490-2398c08673f3.jpg','89251','admin','1','admin','2023-06-18 12:53:44','',NULL),('1670414775670063106','-2d8e28d0ac34c6e8.jpg','20230618125451-4e1be713-2741-4283-a3bf-3386f6e8eb25.jpg','89251','admin','1','admin','2023-06-18 12:54:52','',NULL),('1670416584375582721','微信图片_20230319201222.jpg','20230618130203-7c49caf0-34b7-4d87-bacb-926d9090a1e6.jpg','58561','admin','1','admin','2023-06-18 13:02:03','',NULL),('1670416860146876417','微信图片_20230319201222.jpg','20230618130308-653556ad-8005-4ecc-baf9-b54b765ca8b0.jpg','58561','admin','1','admin','2023-06-18 13:03:09','',NULL),('1670416923019493377','11.png','20230618130323-a38ae7a0-72a4-476d-95a5-df7dc44759b3.png','74994','admin','1','admin','2023-06-18 13:03:24','',NULL),('1670417013733900290','11.png','20230618130345-2acf067c-baac-4925-9c0a-ae03f91f2bf5.png','74994','admin','1','admin','2023-06-18 13:03:46','',NULL),('1670418557065805825','avatar.gif','20230618130953-b3744d92-a559-4a99-a765-e45ec0007789.gif','6334','admin','1','admin','2023-06-18 13:09:54','',NULL),('1670633859340939266','微信图片_20230319201222.jpg','20230619112525-8b8d7f60-9734-49e0-aa71-85de26937369.jpg','58561','admin','1','admin','2023-06-19 11:25:26','',NULL),('1670634044649484290','11.png','20230619112609-cccd5fe6-1d1c-4f9c-bf1e-b0bb517ebcc6.png','74994','admin','1','admin','2023-06-19 11:26:10','',NULL),('1670634406928297986','微信图片_20230319201222.jpg','20230619112736-3a48b791-41fb-42ec-ac07-052b78500300.jpg','58561','admin','1','admin','2023-06-19 11:27:36','',NULL),('1670634446367338497','11.png','20230619112745-0bd74f75-11ee-4991-bafb-e85452798c4f.png','74994','admin','1','admin','2023-06-19 11:27:46','',NULL),('1670635159080251394','微信图片_20230319201222.jpg','20230619113035-dd25ae0d-2762-4a1c-84c2-45cb8dab5623.jpg','58561','admin','1','admin','2023-06-19 11:30:35','',NULL),('1670635181318451201','微信图片_20230319201222.jpg','20230619113040-88255020-c809-4012-a330-a6ab8ba4c3b0.jpg','58561','admin','1','admin','2023-06-19 11:30:41','',NULL),('1670635182547382274','11.png','20230619113041-0f01fb83-566e-44e2-b8ed-a04d07c5adae.png','74994','admin','1','admin','2023-06-19 11:30:41','',NULL),('1670635289493745666','微信图片_20230319201222.jpg','20230619113106-754cdb15-3182-4ec5-b699-42475a9ea7bb.jpg','58561','admin','1','admin','2023-06-19 11:31:07','',NULL),('1670635290798174210','11.png','20230619113106-5959d525-037f-4e95-9637-a183560721b0.png','74994','admin','1','admin','2023-06-19 11:31:07','',NULL),('1670635583157940225','微信图片_20230319201222.jpg','20230619113216-86d06b44-9b94-455b-9df4-345e320fc3fa.jpg','58561','admin','1','admin','2023-06-19 11:32:17','',NULL),('1670636418084483074','微信图片_20230319201222.jpg','20230619113535-8b012d16-2571-4b81-a55d-4e8037f1a8c9.jpg','58561','admin','1','admin','2023-06-19 11:35:36','',NULL),('1670636419435048962','11.png','20230619113535-7acc0c2d-bf3e-40a8-bc45-0e9af74d0c86.png','74994','admin','1','admin','2023-06-19 11:35:36','',NULL),('1670636448677736449','微信图片_20230319201222.jpg','20230619113542-9b15b19d-760f-4f6c-886e-30f53b955463.jpg','58561','admin','1','admin','2023-06-19 11:35:43','',NULL),('1670636459733921794','11.png','20230619113545-52c95884-c305-442f-900a-e166ce64594c.png','74994','admin','1','admin','2023-06-19 11:35:46','',NULL),('1670636487055618050','阿里巴巴代码规范(java).jpg','20230619113552-69378dd7-17f3-4727-a82c-049b2ed36201.jpg','265434','admin','1','admin','2023-06-19 11:35:52','',NULL),('1670666536328736769','微信图片_20230319201222.jpg','20230619133516-2d64d5d3-ddd8-45dd-8d72-f5d4e7373ff9.jpg','58561','admin','1','admin','2023-06-19 13:35:16','',NULL),('1670729963847835649','微信图片_20230319201222.jpg','20230619174718-65b1769d-622b-4c0b-8a3f-fb69abef7ab7.jpg','58561','admin','1','admin','2023-06-19 17:47:19','',NULL),('1670730383039160321','11.png','20230619174858-70cbef37-8e30-4b3e-b72a-bcbfe058c25f.png','74994','admin','1','admin','2023-06-19 17:48:59','',NULL),('1670730432901046273','微信图片_20230319201222.jpg','20230619174910-6c8f1dac-49b3-4121-b677-6993fc262cca.jpg','58561','admin','1','admin','2023-06-19 17:49:11','',NULL),('1670730961446264834','微信图片_20230319201222.jpg','20230619175116-1219ac29-e7af-4be6-8b71-e296cf29adfc.jpg','58561','admin','1','admin','2023-06-19 17:51:17','',NULL),('1670731152190627842','11.png','20230619175201-8b8aa4be-c6ce-4b14-9a9f-940e2dd883c9.png','74994','admin','1','admin','2023-06-19 17:52:02','',NULL),('1676571729323986946','2023-7-3_23-17-02.png','20230705124024-26c7a8b9-35fd-4650-8fe3-a3a88a8a9118.png','217409','admin','1','admin','2023-07-05 12:40:24','',NULL),('1676585526921572354','2023-7-3_23-42-15.png','20230705133513-69824624-39d8-49cd-ab2a-0324b996b2e5.png','238378','admin','1','admin','2023-07-05 13:35:14','',NULL),('1677340375032909825','微信图片_20230319201222.jpg','20230707233443-18f03b90-1301-440f-934f-fd053032c307.jpg','58561','admin','1','admin','2023-07-07 23:34:44','',NULL),('1677704801657339906','微信图片_20230319201222.jpg','20230708234249-8ecd2b5c-0881-4e08-8d10-b816440d3536.jpg','58561','admin','1','admin','2023-07-08 23:42:50','',NULL),('1677975178551758849','11.png','20230709173712-c5c7cd50-e453-4dd9-a92e-3fff8c8d8874.png','74994','admin','1','admin','2023-07-09 17:37:13','',NULL),('1678369066366017537','logo.png','20230710194222-bf6902d8-033c-4841-9946-34b77950e31d.png','22430','','1','test1','2023-07-10 19:42:23','',NULL),('1678369539135381506','logo.png','20230710194415-b6a6ee3e-e095-4267-a189-77d2f5ce9089.png','22430','','1','test1','2023-07-10 19:44:15','',NULL),('1679439134864736258','-2d8e28d0ac34c6e8.jpg','20230713183426-734aff2d-213d-4610-a7a9-2d502e677d70.jpg','89251','','1','test2','2023-07-13 18:34:27','',NULL),('1679439293644308482','-2d8e28d0ac34c6e8.jpg','20230713183504-a3328f32-f656-4c90-af16-ee6271716d4a.jpg','89251','','1','test2','2023-07-13 18:35:05','',NULL),('1679439360031752193','-2d8e28d0ac34c6e8.jpg','20230713183520-374f8cc4-0576-427c-b99e-3bee86c1eada.jpg','89251','','1','test2','2023-07-13 18:35:21','',NULL),('1679827831056052226','-2d8e28d0ac34c6e8.jpg','20230714121859-d01eb6fb-8f8e-42e7-8248-3e7299797993.jpg','89251','admin','1','admin','2023-07-14 12:18:59','',NULL),('1679878008152338434','-2d8e28d0ac34c6e8.jpg','20230714153822-ae0b72a3-5f1f-456a-8b94-fe5d6e1ea9a4.jpg','89251','admin','1','admin','2023-07-14 15:38:22','',NULL),('1680071309859602433','-2d8e28d0ac34c6e8.jpg','20230715122629-c7389fb4-f1ec-4a6e-bbfb-79ce96b4c82a.jpg','89251','admin','1','test1','2023-07-15 12:26:29','',NULL),('1682607479906693121','微信图片_20230319201222.jpg','20230722122419-8d2a712c-3524-47e8-9dcb-41844cf5780c.jpg','58561','admin','1','admin','2023-07-22 12:24:19','',NULL),('1682770375273906177','微信图片_20230319201222.jpg','20230722231136-1de36f0d-9a58-4899-92c4-93babb3fb656.jpg','58561','admin','1','admin','2023-07-22 23:11:36','',NULL),('1682771621602951169','微信图片_20230319201222.jpg','20230722231633-70936240-44ca-464c-8a72-8baa27fd290a.jpg','58561','admin','1','admin','2023-07-22 23:16:34','',NULL),('1682772156552871937','微信图片_20230319201222.jpg','20230722231841-c7303320-103f-43ee-8134-a4c7025114cb.jpg','58561','admin','1','admin','2023-07-22 23:18:41','',NULL),('1682773226800840705','微信图片_20230319201222.jpg','20230722232256-081b2bbb-fd7b-4d16-930e-201f5717b167.jpg','58561','admin','1','admin','2023-07-22 23:22:56','',NULL),('1682774098700173314','微信图片_20230319201222.jpg','20230722232624-77df90c9-c7e0-456f-bced-2da26a20729d.jpg','58561','admin','1','admin','2023-07-22 23:26:24','',NULL),('1682775200485113857','微信图片_20230319201222.jpg','20230722233046-50d30e26-b142-47f9-925c-ed260b40a1ac.jpg','58561','admin','1','admin','2023-07-22 23:30:47','',NULL),('1682777037657374721','微信图片_20230319201222.jpg','20230722233804-22c7f3c7-4d29-44b8-a9dc-30e013581878.jpg','58561','admin','1','admin','2023-07-22 23:38:05','',NULL),('1682778631799078913','微信图片_20230319201222.jpg','20230722234424-60404f28-08df-4bab-8485-197431933f15.jpg','58561','admin','1','admin','2023-07-22 23:44:25','',NULL),('1682797545096527874','logo.png','20230722165934-679c0340-58dc-45e3-8a7e-968017e70191.png','6095','admin','1','admin','2023-07-22 16:59:34','',NULL),('1682959040605913090','微信图片_20230319201222.jpg','20230723034117-6d9f5d3e-7d11-4a6b-8ccd-f17ce3a140a8.jpg','58561','admin','1','admin','2023-07-23 03:41:18','',NULL),('1685542084790755330','-2d8e28d0ac34c6e8.jpg','20230730144523-6c7ec17e-20b3-4853-8ff3-2c4b20c23ebe.jpg','89251','admin','1','admin','2023-07-30 14:45:24','',NULL),('1703058648846946306','111.jpg','20230916224957-b35c33d6-04e4-4601-a9e3-c853906b14bb.jpg','58561','admin','1','admin','2023-09-16 22:49:58','',NULL),('1703063041218564098','111.jpg','20230916230725-0acd2fae-e82c-4551-816a-fc5112c0a79f.jpg','58561','admin','1','admin','2023-09-16 23:07:25','',NULL),('1703646143217209345','111.jpg','20230918134427-b08587a0-fa11-462c-8893-5fcc5eef4f35.jpg','58561','admin','1','admin','2023-09-18 13:44:27','',NULL);
/*!40000 ALTER TABLE `sys_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '菜单ID',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `path` varchar(200) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '路由地址',
  `name` varchar(50) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '路由 name (对应页面组件 name, 可用作 KeepAlive 缓存标识 && 按钮权限筛选)',
  `redirect` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '重定向地址',
  `component` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(100) CHARACTER SET utf8mb4 DEFAULT '#' COMMENT '菜单图标',
  `title` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '菜单名称',
  `active_menu` varchar(200) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '当前路由为详情页时，需要高亮的菜单',
  `is_link` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_hide` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否隐藏（0是 1否）',
  `is_full` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否全屏显示（0是 1否）',
  `is_affix` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否固定页（0是 1否）',
  `is_keep_alive` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否缓存（0是 1否）',
  `order_num` int(11) DEFAULT '0' COMMENT '显示顺序',
  `menu_type` char(1) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '菜单类型（0目录 1菜单 2按钮）',
  `status` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '是否停用（0是 1否）',
  `perms` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '权限标识',
  `query` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '路由参数',
  `remark` varchar(500) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1667422132092543798',0,'/home1','home1',NULL,'/home/index','HomeFilled','首页',NULL,'1','1','1','0','1',1,'1','1','select',NULL,'','1','admin','2023-06-09 20:52:29','admin','2023-09-18 13:05:02'),('1667422148022546434',1678066335860428464,'/system/dictType','dictType',NULL,'/system/dictManage/dictTypeList','Reading','字典管理',NULL,'1','1','1','1','1',6,'1','1','select',NULL,'','1','admin','2023-06-10 14:43:14','admin','2023-09-21 16:01:54'),('1668556011188789249',1667422148022546434,'/system/dictData','dictData',NULL,'/system/dictManage/dictDataList','List','字典数据','/system/dictManage','1','0','1','1','1',1,'1','1','select',NULL,'','1','admin','2023-06-13 17:48:48','admin','2023-09-21 16:08:31'),('1670616474226077697',1678066335860428464,'/system/post','post',NULL,'/system/postManage/postList','UserFilled','岗位管理',NULL,'1','1','1','1','1',4,'1','1','select',NULL,NULL,'1','admin','2023-06-19 02:16:21','admin','2023-09-18 12:33:24'),('1677957250817298433',1678066335860428464,'/system/dept','dept',NULL,'/system/deptManage/deptList','Paperclip','部门管理',NULL,'1','1','1','1','1',3,'1','1','select',NULL,NULL,'1','admin','2023-07-09 16:25:58','admin','2023-09-18 12:33:22'),('1678006039665987585',1678066335860428464,'/system/role','role','','/system/roleManage/roleList','Coin','角色管理','','1','1','1','1','1',2,'1','1','select','','','1','admin','2023-07-09 19:39:50','admin','2023-09-18 12:33:20'),('1678012482444087298',0,'/home2','home2','','/dashboard/dataVisualize/index','HomeFilled','首页','','1','1','1','0','1',1,'1','0','select','','','1','admin','2023-07-09 20:05:26','admin','2023-09-18 13:07:17'),('1678066335860275039',1678066335860428464,'/system/menu','menu',NULL,'/system/menuManage/menuList','Menu','菜单管理',NULL,'1','1','1','1','0',5,'1','1','select',NULL,'','1','admin','2023-06-09 20:52:29','admin','2023-09-18 12:33:26'),('1678066335860428464',0,'/system','system','/system/menuManage',NULL,'Tools','系统管理',NULL,'1','1','1','1','1',4,'0','1',NULL,NULL,'','1','admin','2023-06-09 20:52:29','admin','2023-09-18 12:33:08'),('1678307116735078401',1678066335860428464,'/system/user','user','','/system/userManage/userList','User','用户管理','','1','1','1','1','1',1,'1','1','select','','用户管理','1','admin','2023-07-10 15:36:13','admin','2023-09-18 12:33:18'),('1678398942359973890',1670616474226077697,'','','','','','新增','','1','0','1','1','1',1,'2','1','insert','','新增','1','admin','2023-07-10 21:41:06','',NULL),('1678399119275716609',1670616474226077697,'','','','','','修改','','1','0','1','1','1',1,'2','1','update','','修改','1','admin','2023-07-10 21:41:48','',NULL),('1678399182903308290',1670616474226077697,'','','','','','删除','','1','0','1','1','1',1,'2','1','delete','','删除','1','admin','2023-07-10 21:42:03','admin','2023-07-11 23:42:30'),('1678422776597311489',1670616474226077697,'','','','','','查看','','1','0','1','1','1',1,'2','1','view','','查看','1','admin','2023-07-10 23:15:48','',NULL),('1678422864635752449',1670616474226077697,'','','','','','导入','','1','0','1','1','1',1,'2','1','import','','导入','1','admin','2023-07-10 23:16:09','',NULL),('1678422925436383233',1670616474226077697,'','','','','','导出','','1','0','1','1','1',1,'2','1','export','','导出','1','admin','2023-07-10 23:16:24','',NULL),('1679345212180234241',1678066335860275039,'','','','','','新增','','1','0','1','1','1',1,'2','1','insert','','新增','1','admin','2023-07-13 12:21:14','',NULL),('1679345282590015490',1678066335860275039,'','','','','','删除','','1','0','1','1','1',2,'2','1','delete','','删除','1','admin','2023-07-13 12:21:31','admin','2023-07-13 12:24:39'),('1679345333726969858',1678066335860275039,'','','','','','修改','','1','0','1','1','1',3,'2','1','update','','修改','1','admin','2023-07-13 12:21:43','admin','2023-07-13 12:24:44'),('1679345479235764226',1678066335860275039,'','','','','','查看','','1','0','1','1','1',4,'2','1','view','','查看','1','admin','2023-07-13 12:22:18','admin','2023-07-13 12:24:48'),('1679345532985769986',1678066335860275039,'','','','','','导入','','1','0','1','1','1',5,'2','1','import','','导入','1','admin','2023-07-13 12:22:30','admin','2023-07-13 12:25:10'),('1679345583506161666',1678066335860275039,'','','','','','导出','','1','0','1','1','1',6,'2','1','export','','导出','1','admin','2023-07-13 12:22:43','admin','2023-07-13 12:25:14'),('1679345903166652417',1667422148022546434,'','','','','','新增','','1','0','1','1','1',2,'2','1','insert','','新增','1','admin','2023-07-13 12:23:59','admin','2023-07-13 12:24:17'),('1679346372555407361',1667422148022546434,'','','','','','删除','','1','0','1','1','1',3,'2','1','delete','','删除','1','admin','2023-07-13 12:25:51','',NULL),('1679346471712948225',1667422148022546434,'','','','','','修改','','1','0','1','1','1',4,'2','1','update','','修改','1','admin','2023-07-13 12:26:14','',NULL),('1679346688654934017',1667422148022546434,'','','','','','导入','','1','0','1','1','1',6,'2','1','import','','导入','1','admin','2023-07-13 12:27:06','admin','2023-07-13 12:27:51'),('1679346778392068098',1667422148022546434,'','','','','','导出','','1','0','1','1','1',7,'2','1','export','','导出','1','admin','2023-07-13 12:27:27','',NULL),('1679347070739251201',1668556011188789249,'','','','','','新增','','1','0','1','1','1',1,'2','1','insert','','新增','1','admin','2023-07-13 12:28:37','',NULL),('1679347147608260609',1668556011188789249,'','','','','','删除','','1','0','1','1','1',2,'2','1','delete','','删除','1','admin','2023-07-13 12:28:55','',NULL),('1679347209226780673',1668556011188789249,'','','','','','修改','','1','0','1','1','1',3,'2','1','update','','修改','1','admin','2023-07-13 12:29:10','',NULL),('1679347255934550017',1668556011188789249,'','','','','','查看','','1','0','1','1','1',4,'2','1','view','','查看','1','admin','2023-07-13 12:29:21','admin','2023-07-13 12:29:31'),('1679347368199290882',1668556011188789249,'','','','','','导入','','1','0','1','1','1',5,'2','1','import','','导入','1','admin','2023-07-13 12:29:48','',NULL),('1679347433148088321',1668556011188789249,'','','','','','导出','','1','0','1','1','1',6,'2','1','export','','导出','1','admin','2023-07-13 12:30:04','',NULL),('1679348397099810817',1678307116735078401,'','','','','','新增','','1','0','1','1','1',1,'2','1','insert','','新增','1','admin','2023-07-13 12:33:53','',NULL),('1679348574409818114',1678307116735078401,'','','','','','删除','','1','0','1','1','1',2,'2','1','delete','','删除','1','admin','2023-07-13 12:34:36','',NULL),('1679348642894413825',1678307116735078401,'','','','','','修改','','1','0','1','1','1',3,'2','1','update','','修改','1','admin','2023-07-13 12:34:52','admin','2023-07-13 12:34:57'),('1679348717620133889',1678307116735078401,'','','','','','查看','','1','0','1','1','1',4,'2','1','view','','查看','1','admin','2023-07-13 12:35:10','',NULL),('1679348789317566466',1678307116735078401,'','','','','','导入','','1','0','1','1','1',5,'2','1','import','','导入','1','admin','2023-07-13 12:35:27','',NULL),('1679348847018606594',1678307116735078401,'','','','','','导出','','1','0','1','1','1',6,'2','1','export','','导出','1','admin','2023-07-13 12:35:41','',NULL),('1679348925242376194',1678006039665987585,'','','','','','新增','','1','0','1','1','1',1,'2','1','insert','','新增','1','admin','2023-07-13 12:35:59','',NULL),('1679349007333294081',1678006039665987585,'','','','','','删除','','1','0','1','1','1',2,'2','1','delete','','删除','1','admin','2023-07-13 12:36:19','',NULL),('1679349060747755521',1678006039665987585,'','','','','','修改','','1','0','1','1','1',3,'2','1','update','','修改','1','admin','2023-07-13 12:36:32','',NULL),('1679349119560286209',1678006039665987585,'','','','','','查看','','1','0','1','1','1',4,'2','1','view','','查看','1','admin','2023-07-13 12:36:46','',NULL),('1679349241312542722',1678006039665987585,'','','','','','导入','','1','0','1','1','1',5,'2','1','import','','导入','1','admin','2023-07-13 12:37:15','',NULL),('1679349317606932481',1678006039665987585,'','','','','','导出','','1','0','1','1','1',6,'2','1','export','','导出','1','admin','2023-07-13 12:37:33','',NULL),('1679349591335600130',1677957250817298433,'','','','','','新增','','1','0','1','1','1',1,'2','1','insert','','新增','1','admin','2023-07-13 12:38:38','',NULL),('1679349689461342210',1677957250817298433,'','','','','','删除','','1','0','1','1','1',2,'2','1','delete','','删除','1','admin','2023-07-13 12:39:01','',NULL),('1679349775176138753',1677957250817298433,'','','','','','修改','','1','0','1','1','1',3,'2','1','update','','修改','1','admin','2023-07-13 12:39:22','',NULL),('1679349899688247297',1677957250817298433,'','','','','','查看','','1','0','1','1','1',4,'2','1','view','','查看','1','admin','2023-07-13 12:39:52','',NULL),('1679349980625731586',1677957250817298433,'','','','','','导入','','1','0','1','1','1',5,'2','1','import','','导入','1','admin','2023-07-13 12:40:11','',NULL),('1679350061290586114',1677957250817298433,'','','','','','导出','','1','0','1','1','1',6,'2','1','export','','导出','1','admin','2023-07-13 12:40:30','',NULL),('1680070820866637825',1667422148022546434,'','','','','','配置','','1','0','1','1','1',9,'2','1','allocation','','配置','1','admin','2023-07-15 12:24:33','',NULL),('1680490143190429697',0,'/dataScreen','dataScreen','','/dataScreen/index','Histogram','数据大屏','','1','1','0','1','1',1,'1','1','dataScreen','','','1','admin','2023-07-16 08:10:47','admin','2023-09-18 12:33:05'),('1682966442644881409',0,'/captchaManage','captcha','','/captcha/captcha','Aim','行为验证码','','1','1','1','1','1',4,'1','0','captcha','','','0','admin','2023-07-23 12:10:43','admin','2023-07-23 16:20:01'),('1683329416190509057',0,'/dev','dev','/dev/xxlJobManage','','SetUp','开发工具','','1','1','1','1','1',6,'0','1','','','','1','admin','2023-07-24 12:13:02','admin','2023-09-18 12:33:10'),('1683329952449052674',1683329416190509057,'/dev/xxlJob','xxlJob','','/dev/xxl-job/index','Lock','xxl-job','','1','1','1','1','1',1,'1','1','xxl-job','','','1','admin','2023-07-24 12:15:10','admin','2023-09-18 12:33:12'),('1683383943761567745',0,'/iframeManage?url=http://localhost:8086/xxl-job','iframe','','/iframe/index','Apple','测试iframe','','1','1','1','1','1',7,'1','0','xxl-job','','','0','admin','2023-07-24 15:49:43','admin','2023-07-24 08:31:01');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_message`
--

DROP TABLE IF EXISTS `sys_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_message` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `title` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `path` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '页面路径',
  `type` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型（1通知 2消息 3代办）',
  `status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '状态（1未读 2已读）',
  `del_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_message`
--

LOCK TABLES `sys_message` WRITE;
/*!40000 ALTER TABLE `sys_message` DISABLE KEYS */;
INSERT INTO `sys_message` VALUES ('1686013322940239874','1678364156664236708','测试发送1',NULL,'/system/user','1','1','1','admin','2023-07-31 21:57:55','admin','2023-09-22 17:27:08'),('1686024095699574786','1678364156664236708','测试发送4',NULL,'/home1','1','2','0','admin','2023-07-31 22:40:44','admin','2023-12-05 14:45:31'),('2','1678364156664236708','标题2','内容2','/dev/xxlJob','1','1','1','admin','2023-07-31 21:25:02','admin','2023-09-22 17:27:13');
/*!40000 ALTER TABLE `sys_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_post` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '岗位名称',
  `post_sort` int(11) NOT NULL COMMENT '显示顺序',
  `remark` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '是否停用（0是 1否）',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES ('1','ceo','1670730961446264834',1,'1670634406928297986','1','0','admin','2023-05-25 03:10:50','admin','2023-06-28 20:05:10'),('1670626676813332481','1','1',1,'1','1','0','admin','2023-06-19 10:56:53','test1','2023-07-15 12:26:20'),('1670628401200762881','1','1',1,'1','1','0','admin','2023-06-19 11:03:44','',NULL),('1670635366580752386','file','1670635159080251394',9,'1670666536328736769','1','0','admin','2023-06-19 11:31:25','admin','2023-06-19 20:02:54'),('1670764084556992514','111','11',9,'11','1','0','admin','2023-06-19 20:02:54','',NULL),('1676582125354733570','ceo','董事长',1,'董事长','1','1','admin','2023-07-05 13:21:43','admin','2023-09-22 12:20:42'),('1677515812308533250','1','1',1,'1','1','0','admin','2023-07-08 11:11:51','admin','2023-07-15 04:08:44'),('1705074616745897986','xxx','测试',5,'222','1','0','admin','2023-09-22 12:20:42','admin','2023-09-22 12:21:17'),('2','se','项目经理',2,'','1','1','admin','2023-05-25 03:10:50','admin','2023-09-22 12:20:42'),('3','hr','人力资源',3,'','1','1','admin','2023-05-25 03:10:50','admin','2023-09-22 12:20:42'),('4','user','普通员工',4,'','1','1','admin','2023-05-25 03:10:50','admin','2023-09-22 12:20:42');
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(11) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '菜单树选择项是否关联显示（0是 1否）',
  `dept_check_strictly` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '部门树选择项是否关联显示（0是 1否）',
  `remark` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 NOT NULL DEFAULT '1' COMMENT '是否停用（0是 1否）',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('1678261433600671746','1','1',1,'1','','','1','1','0','admin','2023-07-10 12:34:41','',NULL),('1678291118216830977','2','2',2,'2','','','2','1','0','admin','2023-07-10 14:32:38','admin','2023-07-10 15:21:10'),('1678303948215279618','测试角色','test',1,'','','','测试','1','1','admin','2023-07-10 15:23:37','admin','2023-09-18 13:45:26');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_dept` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色部门关联表ID',
  `role_id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色ID',
  `dept_id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '部门ID',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色和部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色菜单关联表ID',
  `role_id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色ID',
  `menu_id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '菜单ID',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES ('1678291118426546177','1678291118216830977','1678066335860428464','0','admin','2023-07-10 14:32:38','',NULL),('1678291118426546178','1678291118216830977','1678066335860275039','0','admin','2023-07-10 14:32:38','',NULL),('1678291118481072129','1678291118216830977','1667422148022546434','0','admin','2023-07-10 14:32:38','',NULL),('1678291118481072130','1678291118216830977','1668556011188789249','0','admin','2023-07-10 14:32:38','',NULL),('1678303330029395969','1678291118216830977','1678012482444087298','0','admin','2023-07-10 15:21:10','',NULL),('1678303330092310530','1678291118216830977','1668556011188789249','0','admin','2023-07-10 15:21:10','',NULL),('1678303330092310531','1678291118216830977','1677957250817298433','0','admin','2023-07-10 15:21:10','',NULL),('1678303948278194177','1678303948215279618','1678012482444087298','0','admin','2023-07-10 15:23:37','',NULL),('1678303948278194178','1678303948215279618','1678066335860428464','0','admin','2023-07-10 15:23:37','',NULL),('1678303948278194179','1678303948215279618','1678066335860275039','0','admin','2023-07-10 15:23:37','',NULL),('1678303948341108738','1678303948215279618','1667422148022546434','0','admin','2023-07-10 15:23:37','',NULL),('1678303948404023298','1678303948215279618','1668556011188789249','0','admin','2023-07-10 15:23:37','',NULL),('1678313469981564930','1678303948215279618','0','0','admin','2023-07-10 16:01:27','',NULL),('1678313470044479490','1678303948215279618','1677957250817298433','0','admin','2023-07-10 16:01:27','',NULL),('1678313470044479491','1678303948215279618','1670616474226077697','0','admin','2023-07-10 16:01:27','',NULL),('1678313470111588354','1678303948215279618','1678006039665987585','0','admin','2023-07-10 16:01:27','',NULL),('1678313470111588355','1678303948215279618','1678307116735078401','0','admin','2023-07-10 16:01:28','',NULL),('1678399901295308802','1678303948215279618','1670616474226077697','0','admin','2023-07-10 21:44:54','',NULL),('1678399901362417666','1678303948215279618','1678398942359973890','0','admin','2023-07-10 21:44:54','',NULL),('1678399901433720834','1678303948215279618','1678399119275716609','0','admin','2023-07-10 21:44:54','',NULL),('1678399901458886657','1678303948215279618','1678399182903308290','0','admin','2023-07-10 21:44:54','',NULL),('1678792056438304769','1678303948215279618','1678422776597311489','0','admin','2023-07-11 23:43:11','',NULL),('1678792056492830722','1678303948215279618','1678422864635752449','0','admin','2023-07-11 23:43:11','',NULL),('1678792056492830723','1678303948215279618','1678422925436383233','0','admin','2023-07-11 23:43:11','',NULL),('1680069616097374210','1678303948215279618','1678307116735078401','0','admin','2023-07-15 04:19:45','',NULL),('1680069616097374211','1678303948215279618','1679348717620133889','0','admin','2023-07-15 04:19:45','',NULL),('1680069616177065985','1678303948215279618','1679348847018606594','0','admin','2023-07-15 04:19:45','',NULL),('1680069616202231809','1678303948215279618','1667422148022546434','0','admin','2023-07-15 04:19:45','',NULL),('1680071019395629057','1678303948215279618','1668556011188789249','0','admin','2023-07-15 12:25:20','',NULL),('1680071019529846786','1678303948215279618','1679347070739251201','0','admin','2023-07-15 12:25:20','',NULL),('1680071019924111361','1678303948215279618','1679347255934550017','0','admin','2023-07-15 12:25:20','',NULL),('1680071019991220225','1678303948215279618','1680070820866637825','0','admin','2023-07-15 12:25:20','',NULL),('1680121987716427778','1678303948215279618','1678307116735078401','0','admin','2023-07-15 07:47:52','',NULL),('1680121987745787905','1678303948215279618','1679348397099810817','0','admin','2023-07-15 07:47:52','',NULL),('1680121987775148033','1678303948215279618','1679348574409818114','0','admin','2023-07-15 07:47:52','',NULL),('1680122427564699650','1678303948215279618','1679348642894413825','0','admin','2023-07-15 07:49:37','',NULL),('1680122427619225601','1678303948215279618','1679348717620133889','0','admin','2023-07-15 07:49:37','',NULL),('1680122427661168641','1678303948215279618','1678006039665987585','0','admin','2023-07-15 07:49:37','',NULL),('1680122427694723073','1678303948215279618','1679348925242376194','0','admin','2023-07-15 07:49:37','',NULL),('1680127015164391425','1678303948215279618','1678307116735078401','0','admin','2023-07-15 08:07:50','',NULL),('1682679043192823809','1678303948215279618','1678066335860428464','1','admin','2023-07-22 17:08:41','',NULL),('1682679043230572546','1678303948215279618','1677957250817298433','1','admin','2023-07-22 17:08:41','',NULL),('1682679043297681409','1678303948215279618','1679349591335600130','0','admin','2023-07-22 17:08:41','',NULL),('1682679043360595970','1678303948215279618','1679349689461342210','0','admin','2023-07-22 17:08:41','',NULL),('1682679043436093442','1678303948215279618','1679349775176138753','0','admin','2023-07-22 17:08:41','',NULL),('1682679043490619394','1678303948215279618','1679349899688247297','0','admin','2023-07-22 17:08:41','',NULL),('1682679043557728257','1678303948215279618','1679349980625731586','0','admin','2023-07-22 17:08:41','',NULL),('1682679043624837121','1678303948215279618','1679350061290586114','0','admin','2023-07-22 17:08:41','',NULL),('1703646387833229313','1678303948215279618','1667422132092543798','1','admin','2023-09-18 13:45:26','',NULL);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户ID',
  `dept_id` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '头像地址',
  `password` varchar(200) CHARACTER SET utf8mb4 NOT NULL COMMENT '密码',
  `remark` varchar(500) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 DEFAULT '0' COMMENT '是否停用（0是 1否）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('1678364156664236708','100','admin','autumn','00','1060590974@qq.com','16638808906','0','1703646143217209345','5f2c6e63b41f4fa059ee39670862b96ec3ad693c59e6284b657471870ff58ea370d4e1e48e2ea9e0521b04a6df85b73de87afe9a5ebd8e7c5817c969dc61c548','','1','54.255.237.48','2023-12-05 14:49:39','1','','2023-06-28 19:04:55','admin','2023-12-05 14:49:39'),('1678364156664758274','105','test1','测试1','','','','0','1680071309859602433','6186b6850150072ea3981c523e0180b34d8285172161fdd8e1e2d263dae3d3f91fe78873d4b698c0873d7657e7571ba97bfae48a8f10c07606355a9fb7087754','','1','212.107.29.202','2023-09-21 17:07:00','1','admin','2023-07-10 19:22:52','test1','2023-09-21 17:07:00'),('1679438952295092225','103','test2','测试2','','','','2','1679439360031752193','6186b6850150072ea3981c523e0180b34d8285172161fdd8e1e2d263dae3d3f91fe78873d4b698c0873d7657e7571ba97bfae48a8f10c07606355a9fb7087754','','0','127.0.0.1','2023-07-13 18:34:03','0','admin','2023-07-13 18:33:43','admin','2023-07-22 17:07:36');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_post` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户岗位关联表ID',
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `post_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '岗位ID',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES ('1679426218279165954','1678364156664758274','3','0','admin','2023-07-13 17:43:07','',NULL),('1679426218295943170','1678364156664758274','4','1','admin','2023-07-13 17:43:07','',NULL),('1679436673999560705','1678364156664236708','1676582125354733570','1','admin','2023-07-13 18:24:40','',NULL),('1679436883433742337','1678364156664758274','3','1','admin','2023-07-13 18:25:30','',NULL),('1679438952840351745','1679438952295092225','4','1','admin','2023-07-13 18:33:43','',NULL);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户角色关联表ID',
  `user_id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户ID',
  `role_id` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '角色ID',
  `del_flag` char(1) CHARACTER SET utf8mb4 DEFAULT '1' COMMENT '删除标志（0代表删除 1代表存在）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('1678358286295908353','1','1678303948215279618','1','admin','2023-07-10 18:59:33','',NULL),('1678364156727672834','1678364156664758274','1678303948215279618','1','admin','2023-07-10 19:22:52','',NULL),('1679435394581651457','1678364156664236708','1678303948215279618','0','admin','2023-07-13 18:19:35','',NULL),('1679438952777437186','1679438952295092225','1678303948215279618','0','admin','2023-07-13 18:33:43','',NULL);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-16 13:15:34
