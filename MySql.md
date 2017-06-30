MySql

```
mysql -u root -p
```

数据类型 **整型 浮点型 字符型 日期时间型**

```mysql
SHOW DATABASES;
USE test;
SELECT DATABASE();
CREATE TABLE tb1(
  username VARCHAR(20),
  age TINYINT UNSIGNED,
  salary FLOAT(8,2) UNSIGNED   表示一共占8位，小数点后占2位
);
SHOW CREATE TABLE tb1;
SHOW TABLES [FROM TABLENAME];  []表示缺省
SHOW COLUMNS FROM tb1;  获取表结构 
DESC tb1;				获取表结构 
INSERT　［INTO］tb1 values('Tom',25,7600);
INSERT tb1(username,salary) values('Tom',4900);
SELECT * from tb1;

CREATE TABLE tb1(
  id SMALLINT UNSIGNED AUTO_INCREMENT [PRIMARY] KEY,
  username VARCHAR(20) NOT NULL
  );
```

### select命令表示当前选择（连接）的数据库。

select命令格式：

> select database();

MySQL中SELECT命令类似于其他编程语言里的print或者write

**1) 显示MYSQL的版本**

> select version(); 

**2) 显示当前时间**

> select now(); 

**3) 显示年月日**
SELECT DAYOFMONTH(CURRENT_DATE);  

**4) 显示字符串**

> SELECT "welecome to my blog!"; 

**5) 当计算器用**
select ((4 * 4) / 10 ) + 25; 
+----------------------+ 
| ((4 * 4) / 10 ) + 25 | 
+----------------------+ 
|                26.60 | 
+----------------------+ 
1 row in set (0.00 sec) 

**6) 串接字符串**
select CONCAT(f_name, " ", l_name) 
AS Name 
from employee_data 
where title = 'Marketing Executive'; 
+---------------+ 
| Name          | 
+---------------+ 
| Monica Sehgal | 
| Hal Simlai    | 
| Joseph Irvine | 
+---------------+ 
3 rows in set (0.00 sec) 

注意：这里用到CONCAT()函数，用来把字符串串接起来。

### 获取表结构

```mysql
desc 表名;
show columns from 表名;
```

使用MySQL数据库desc 表名时，我们看到Key那一栏，可能会有4种值，即 ' '，'PRI'，'UNI'，'MUL'。

1. 如果Key是空的，那么该列值的可以重复，表示该列没有索引，或者是一个非唯一的复合索引的非前导列；
2. 如果Key是PRI，那么该列是主键的组成部分；
3. 如果Key是UNI，那么该列是一个唯一值索引的第一列（前导列），并别不能含有空值（NULL）；
4. 如果Key是MUL，那么该列的值可以重复，该列是一个非唯一索引的前导列（第一列）或者是一个唯一性索引的组成部分但是可以含有空值NULL。

如果对于一个列的定义，同时满足上述4种情况的多种，比如一个列既是PRI，又是UNI，那么"desc 表名"的时候，显示的Key值按照优先级来显示 PRI->UNI->MUL。那么此时，显示PRI。

一个唯一性索引列可以显示为PRI，并且该列不能含有空值，同时该表没有主键。

一个唯一性索引列可以显示为MUL，如果多列构成了一个唯一性复合索引，因为虽然索引的多列组合是唯一的，比如ID+NAME是唯一的，但是没一个单独的列依然可以有重复的值，只要ID+NAME是唯一的即可。

### 自动编号 AUTO_INCREMENT

AUTO_CREMENT必须和主键组合使用,**但主键不一定和AUTO_CREMENT一起使用**

因为`CREATE TABLE tb1( id SMALLINT UNSIGNED AUTO_INCREMENT [PRIMARY] KEY,username VARCHAR(20) NOT NULL);`不能为自增字段赋值  而`CREATE TABLE tb1( id SMALLINT UNSIGNED [PRIMARY] KEY,username VARCHAR(20) NOT NULL);`必须为主键赋值，但随意2 22赋，但不能赋相同值

默认情况，起始值为1，每次增量1  **<u>不需要为自增字段赋值</u>**

### 主键约束 PRIMARY KEY

- 每张表只能存在一个主键

- 主键保证记录的唯一性   

- 自动为NOT NULL


### 唯一约束 UNIQUE KEY

-   可保证记录的唯一性


- 唯一约束的字段可以为空值（NULL） 由于唯一性所以**只能有一个空值**
- 每张表可以存在多个唯一约束
###默认约束 DEFAULT

当插入记录时，如果没有明确为字段赋值，则自动赋予默认值。

sex ENUM('1','2','3') DEFAULT '3'

### 非空约束 NOT NULL

### 外键约束 FOREIGN KEY

父表和子表必须default-storage-engine=INNODB

外键列和参照列必须数据类型相同  smallint不等于bigint  ，unsigned也得一致

外键列和参照列必须创建索引。如果外键列不存在索引，MYSQL会自动创建索引

保持数据一致性，完整性。实现**一对一或一对多**关系

```mysql
create table provinces(   父表  子表所参照的表
  id smallint unsigned not null primary key auto_increment,
  pname varchar(20) not null
);
create table users(  子表
  id smallint unsigned primary key auto_increment,
  username varchar(10) not null,
  pid smallint unsigned,
  foreign key(pid) references provinces(id)  外键列
);
show indexes from provinces\G;加\G不以网格形式表示
```



根据约束针对的字段数目多少 约数分为表级约束和列级约束

只针对**某一个**字段使用 称为列级约束  针对2个或以上字段使用的话称为表级约束 