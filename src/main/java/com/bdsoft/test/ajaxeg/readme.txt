--------
Ŀ¼˵��
--------
database Ŀ¼������ݿ�SQL�ļ�
java     Ŀ¼���javaԴ�ļ�
webapp   Ŀ¼���ʵ��ҳ�漰JSPԴ�ļ�

--------------
���ݿⰲװ˵��
--------------
�˽�MySQL���û�����ֱ��ʹ���Լ���Ϥ�ķ�ʽ������Ϊajax�����ݿ⣬����ajax.sql�ļ����뼴�ɡ�

�����Ǽ�Ҫ����������

1. ʵ�����ݿ���MySQL 5.0.27 �汾�²���ͨ��
2. ��databaseĿ¼��ajax.sql�ļ����Ƶ�C:\
3. ����MySQL��װĿ¼�е�binĿ¼
4. ���� mysql -u root -p ��Ȼ�����������¼����MySQL������
5. ���� CREATE DATABASE ajax DEFAULT CHARACTER SET utf8; ������Ϊajax�����ݿ�
6. ���� use ajax
7. ���� source c:\ajax.sql ִ�����ݿ��ʼ�����

------------------
JavaԴ�ļ�ʹ��˵��
------------------
ʵ���д󲿷��ļ�ΪHTML��JSP�ļ�������JavaԴ�ļ������javaĿ¼�С�
�ɽ�Ŀ¼�е�������ΪEclipse��һ����Ŀ����Eclipse��ʹ�á�

-----------
WEB��������
-----------
����ʵ����jdk 1.4.2 + Tomcat 5.0.28 �����²���ͨ����
��webappĿ¼�е����ݸ��Ƶ�Tomcat��webappsĿ¼����Ϊһ��webӦ�÷������ɡ�

����Tomcatǰע���޸� ajax/WEB-INF/classes/ajax_db.properties �ļ���
�����е�URL��USER��PASSWORD���Ը���ʵ����������޸ġ�

Tomcat����������ʹ�� http://localhost:8080/ajax ���з���