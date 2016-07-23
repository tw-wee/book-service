### Run clean and build
./gradlew clean build

### 重新加载IntelliJ IDEA project
./gradlew cleanIdea idea

### Run unit test
./gradlew test

### Run integration test
./gradlew intgTest 

### Run checkStyle
./gradlew check

### Run Sonar
./gradlew sonar
然后访问http://localhost:9000/

### 启动Project
./gradlew bootRun

### 访问BookAPI
http://localhost:8080/books?name=bookName

### Remote Debug
- Edit Configurations -> Add New Configuration -> Remote -> set name as RemoteDebug, port as 5005 -> Apply/OK
- Launch ./gradlew run --debug-jvm
- Choose RemoteDebug -> Debug

### DataSource
#### 目前暂时用Mysql,在本地运行之前确保:
* 有一个用户`apiuser`
* 用户`apiuser`密码为`password`
* 有一个数据库名为`book_db`
* 用户`apiuser`有数据库`book_db`的权限
>以下指令仅作参考:
``` sql
CREATE USER 'apiuser'@'localhost' IDENTIFIED BY 'password’;
grant all on book_db.* to 'apiuser'@'localhost';
```
#### 插入Book
* 可以采用`db/insertBook.sql`里的指令添加Book.
* 其中`Active`为`Y`或者`N`
