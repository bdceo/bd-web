--------
目录说明
--------
database 目录存放数据库SQL文件
java     目录存放java源文件
webapp   目录存放实例页面及JSP源文件

--------------
数据库安装说明
--------------
了解MySQL的用户可以直接使用自己熟悉的方式创建名为ajax的数据库，并将ajax.sql文件导入即可。

下面是简要操作方法：

1. 实例数据库在MySQL 5.0.27 版本下测试通过
2. 将database目录中ajax.sql文件复制到C:\
3. 进入MySQL安装目录中的bin目录
4. 输入 mysql -u root -p ，然后输入密码登录本地MySQL服务器
5. 输入 CREATE DATABASE ajax DEFAULT CHARACTER SET utf8; 创建名为ajax的数据库
6. 输入 use ajax
7. 输入 source c:\ajax.sql 执行数据库初始化语句

------------------
Java源文件使用说明
------------------
实例中大部分文件为HTML及JSP文件，部分Java源文件存放在java目录中。
可将目录中的内容作为Eclipse的一个项目导入Eclipse中使用。

-----------
WEB发布方法
-----------
所有实例在jdk 1.4.2 + Tomcat 5.0.28 环境下测试通过。
将webapp目录中的内容复制到Tomcat的webapps目录中作为一个web应用发布即可。

启动Tomcat前注意修改 ajax/WEB-INF/classes/ajax_db.properties 文件。
将其中的URL、USER和PASSWORD属性根据实际情况进行修改。

Tomcat正常启动后使用 http://localhost:8080/ajax 进行访问