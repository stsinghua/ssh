create database ssh_root character set utf8;

# 插入数据
# 以下代码需要在启动tomcat运行项目后才能执行,不然还没有创建表结构,我们怎么插入数据呢.

INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

INSERT INTO `customer` VALUES ('1', '苹果', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('2', '香蕉', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('3', '芒果', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('4', '西瓜', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('5', '番茄', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('6', '土豆', '13800138000', '北京', '测试');
INSERT INTO `customer` VALUES ('7', '榴莲', '13800138001', '北京', '测试');