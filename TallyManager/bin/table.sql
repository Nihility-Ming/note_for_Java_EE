-- 创建数据表的语句
CREATE TABLE `gjp_zhangwu` (
  `zwid` int(11) NOT NULL AUTO_INCREMENT,
  `flname` varchar(200) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `zhanghu` varchar(100) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`zwid`)
) 