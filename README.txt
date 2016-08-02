Тестовое задание для JavaRush (CRUD).
После удачного деплоя необходимо поменять относительный путь с "/CRUD" на "/".
Для этого нужно найти файл ${папка где установлен TomCat}/conf/server.xml и в нём 
нужно найти тэг <host> и в него вставить строчку: <Context path="" docBase="CRUD" debug="0" reloadable="true"></Context>