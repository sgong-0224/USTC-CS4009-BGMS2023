# 桌游管理系统


#### 主要功能
1.  登录、注销、修改密码
2.  管理员：对桌游信息的增删改查、查看用户、查看或删除借用记录
3.  用户：借用/归还/续借桌游、对桌游信息的查询、修改个人信息、查看借用记录


#### 技术实现
数据库：MySQL
后端框架: SpringBoot
HTML模板: ThymeLeaf
持久层: Mybatis
UI: Bootstrap
登录验证和用户权限: SpringSecurity

#### 依赖项

编译环境：Maven(>=3.8.1)、MySQL、Java Development Kit(<=17)

运行环境：Java Runtime Environment

#### 使用说明
1. 使用MySQL图形化管理工具(如Navicat)，新建连接，新建数据库library，右键数据库-->运行library.sql脚本

2. 配置src/main/resources/application.yml，修改username/password为连接凭据

3. 调试：IDE中找到BoardmanagerApplication类，运行main方法

3. 编译(以IntelliJ IDEA为例)：导入Maven项目后选择Maven-Boardmanager-Lifecycle-package，双击编译。

   终端切换至jar包所在目录，执行`java -jar PACKAGENAME`（将`PACKAGENAME`替换成文件名）即可运行。
