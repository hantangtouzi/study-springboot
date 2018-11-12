drop table if exists t_role;
drop table if exists t_user;


create table t_role (
  id long primary key auto_increment,
  name varchar(20),
  description varchar(100),
  enabled varchar(2)
);

create table t_user (
  id long primary key auto_increment,
  username varchar,
  password varchar,
  email varchar(100),
  mobile varchar(11),
  nickname varchar(20),
  registerDate varchar(20),
  enabled varchar(4),
  salt varchar(20),
  roleId long
);



insert into t_role (name, description, enabled) values ('superadmin','超级管理员', 1);
insert into t_role (name, description, enabled) values ('admin','超级管理员', 1);
insert into t_role (name, description, enabled) values ('svip','超级会员', 1);
insert into t_role (name, description, enabled) values ('vip','普通会员', 1);
insert into t_role (name, description, enabled) values ('commonuser','普通用户', 1);

insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('zhangsan', 'zs','zhangsan@sina.com', '13900010001', 'zhangsan', '2018-01-01', '1', 1);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('lisi', 'ls','lisi@sina.com', '13900010001', 'lisi', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('wangwu', 'ww','wangwu@sina.com', '13900010001', 'wangwu', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('a', 'mima','a@sina.com', '13900010001', 'a', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('b', 'mima','b@sina.com', '13900010001', 'b', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('c', 'mima','c@sina.com', '13900010001', 'c', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('d', 'mima','d@sina.com', '13900010001', 'd', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('e', 'mima','e@sina.com', '13900010001', 'e', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('f', 'mima','f@sina.com', '13900010001', 'f', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('g', 'mima','g@sina.com', '13900010001', 'g', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('h', 'mima','h@sina.com', '13900010001', 'h', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('i', 'mima','i@sina.com', '13900010001', 'i', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('j', 'mima','j@sina.com', '13900010001', 'j', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('k', 'mima','k@sina.com', '13900010001', 'k', '2018-01-01', '1', 2);
insert into t_user (username, password, email, mobile, nickname, registerDate, enabled, roleId) values ('l', 'mima','l@sina.com', '13900010001', 'l', '2018-01-01', '1', 2);
