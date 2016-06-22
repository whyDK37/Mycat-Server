# 命令管理
  登录：目前mycat有两个端口，8066 数捤端口，9066 管理端口，命令的登录是通过9066管理端口来操作，
  登录方式类似于mysql的服输端登录。

    mysql -h127.0.0.1 -utest -ptest -P9066

  登录后可以使用下面命令查看支持的命令
  ```
    mysql> show @@help;
    +------------------------------------------+--------------------------------------------+
    | STATEMENT                                | DESCRIPTION                                |
    +------------------------------------------+--------------------------------------------+
    | show @@time.current                      | Report current timestamp                   |
    | show @@time.startup                      | Report startup timestamp                   |
    | show @@version                           | Report Mycat Server version                |
    | show @@server                            | Report server status                       |
    | show @@threadpool                        | Report threadPool status                   |
    | show @@database                          | Report databases                           |
    | show @@datanode                          | Report dataNodes                           |
    | show @@datanode where schema = ?         | Report dataNodes                           |
    | show @@datasource                        | Report dataSources                         |
    | show @@datasource where dataNode = ?     | Report dataSources                         |
    | show @@datasource.synstatus              | Report datasource data synchronous         |
    | show @@datasource.syndetail where name=? | Report datasource data synchronous detail  |
    | show @@datasource.cluster                | Report datasource galary cluster variables |
    | show @@processor                         | Report processor status                    |
    | show @@command                           | Report commands status                     |
    | show @@connection                        | Report connection status                   |
    | show @@cache                             | Report system cache usage                  |
    | show @@backend                           | Report backend connection status           |
    | show @@session                           | Report front session details               |
    | show @@connection.sql                    | Report connection sql                      |
    | show @@sql.execute                       | Report execute status                      |
    | show @@sql.detail where id = ?           | Report execute detail status               |
    | show @@sql                               | Report SQL list                            |
    | show @@sql.high                          | Report Hight Frequency SQL                 |
    | show @@sql.slow                          | Report slow SQL                            |
    | show @@sql.sum                           | Report  User RW Stat                       |
    | show @@sql.sum.user                      | Report  User RW Stat                       |
    | show @@sql.sum.table                     | Report  Table RW Stat                      |
    | show @@parser                            | Report parser status                       |
    | show @@router                            | Report router status                       |
    | show @@heartbeat                         | Report heartbeat status                    |
    | show @@heartbeat.detail where name=?     | Report heartbeat current detail            |
    | show @@slow where schema = ?             | Report schema slow sql                     |
    | show @@slow where datanode = ?           | Report datanode slow sql                   |
    | show @@sysparam                          | Report system param                        |
    | show @@syslog limit=?                    | Report system mycat.log                    |
    | show @@white                             | show mycat white host                      |
    | show @@white.set=?,?                     | set mycat white host,[ip,user]             |
    | switch @@datasource name:index           | Switch dataSource                          |
    | kill @@connection id1,id2,...            | Kill the specified connections             |
    | stop @@heartbeat name:time               | Pause dataNode heartbeat                   |
    | reload @@config                          | Reload basic config from file              |
    | reload @@config_all                      | Reload all config from file                |
    | reload @@route                           | Reload route config from file              |
    | reload @@user                            | Reload user config from file               |
    | reload @@sqlslow=                        | Set Slow SQL Time(ms)                      |
    | reload @@user_stat                       | Reset show @@sql  @@sql.sum @@sql.slow     |
    | rollback @@config                        | Rollback all config from memory            |
    | rollback @@route                         | Rollback route config from memory          |
    | rollback @@user                          | Rollback user config from memory           |
    | reload @@sqlstat=open                    | Open real-time sql stat analyzer           |
    | reload @@sqlstat=close                   | Close real-time sql stat analyzer          |
    | offline                                  | Change MyCat status to OFF                 |
    | online                                   | Change MyCat status to ON                  |
    | clear @@slow where schema = ?            | Clear slow sql by schema                   |
    | clear @@slow where datanode = ?          | Clear slow sql by datanode                 |
    +------------------------------------------+--------------------------------------------+
    56 rows in set (0.00 sec)
  ```
# 源码启动mycat
  org.opencloudb.MycatStartup

  vm 参数: -XX:MaxDirectMemorySize=128M

# 建表语句
  ```
  CREATE TABLE travelrecord (id BIGINT NOT NULL PRIMARY KEY,user_id VARCHAR(100),traveldate DATE, fee DECIMAL,days INT);sam_test

  create table sam_test(
    id_ int,
    name_ varchar(100),
    user_id varchar(100)
  )
  ```