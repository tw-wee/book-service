### 启动Project
./gradlew bootRun

### 访问BookAPI
http://localhost:8080/books?name=bookName

### DataSource
目前暂时用Mysql,在本地运行之前确保:
* 有一个用户`apiuser`
* 用户`apiuser`密码为`password`
* 有一个数据库名为`db_book`
* 用户`apiuser`有数据库`db_book`的权限
>以下指令仅作参考:
``` sql
CREATE USER 'apiuser'@'localhost' IDENTIFIED BY 'password’;
grant all on db_book.* to 'apiuser'@'localhost';
```