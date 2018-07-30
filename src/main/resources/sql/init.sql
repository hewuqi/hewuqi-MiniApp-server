/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/15 14:07:00                           */
/*==============================================================*/


drop table if exists baidu_token;

/*==============================================================*/
/* Table: baidu_token                                           */
/*==============================================================*/
create table baidu_token
(
   id                   int not null auto_increment,
   access_token         varchar(256),
   session_key          varchar(2048),
   scope                varchar(256),
   refresh_token        varchar(256),
   session_secret       varchar(256),
   expires_in           varchar(256),
   primary key (id)
);

