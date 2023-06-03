# 桌游管理系统


#### 主要功能
1.  登录、注销、修改密码
2.  管理员对桌游信息的增删改查、查看用户、查看借用记录
3.  用户对桌游信息的查询、修改个人信息、查看借用记录


#### 技术实现
数据库：MySQL
后端框架: SpringBoot
HTML模板: ThymeLeaf
持久层: Mybatis
UI: Bootstrap
登录验证和用户权限: SpringSecurity

#### 依赖项

Maven、MySQL、Java Development Kit(<=JDK17)

#### 使用说明
1. 使用MySQL图形化管理工具(如Navicat)，新建连接，新建数据库library，右键数据库-->运行library.sql脚本

2. 打开src/main/resources/application.yml，修改username/password为连接凭据

3. IDE中找到BoardmanagerApplication类运行main方法

   or 项目目录下打开终端，执行`mvn clean package`，在target目录下用java -jar命令运行对应jar包
