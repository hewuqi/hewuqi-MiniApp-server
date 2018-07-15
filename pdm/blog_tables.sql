/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/6/10 19:25:52                           */
/*==============================================================*/


drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   username             varchar(128) not null,
   password             varchar(256),
   email                varchar(128),
   regist_date          datetime,
   primary key (username)
)
auto_increment = 1;

