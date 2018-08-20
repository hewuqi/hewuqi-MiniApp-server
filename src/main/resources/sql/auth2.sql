/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/8/5 23:14:08                            */
/*==============================================================*/


drop table if exists tb_baidu_token;

drop table if exists tb_permission;

drop table if exists tb_role;

drop table if exists tb_role_permission;

drop table if exists tb_user;

drop table if exists tb_user_role;

/*==============================================================*/
/* Table: tb_baidu_token                                        */
/*==============================================================*/
create table tb_baidu_token
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

/*==============================================================*/
/* Table: tb_permission                                         */
/*==============================================================*/
create table tb_permission
(
   id                   bigint not null,
   resource_code        varchar(32),
   resorce_name         varchar(32),
   permission_code      varchar(32),
   permission_name      varchar(32),
   required_permission  bigint,
   primary key (id)
);

alter table tb_permission comment '权限';

/*==============================================================*/
/* Table: tb_role                                               */
/*==============================================================*/
create table tb_role
(
   id                   bigint not null,
   role_name            varchar(32),
   create_time          datetime,
   update_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_role_permission                                    */
/*==============================================================*/
create table tb_role_permission
(
   id                   bigint not null,
   role_id              bigint,
   permission_id        bigint,
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   ID                   bigint not null auto_increment,
   username             varchar(64),
   password             varchar(64),
   nickname             varchar(64),
   active_code_id       varchar(128),
   role_id              int,
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   begin_time           datetime,
   end_time             datetime,
   user_status          tinyint default 0,
   user_type            tinyint default 0,
   delete_status        tinyint default 0,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_user_role                                          */
/*==============================================================*/
create table tb_user_role
(
   id                   bigint not null,
   user_id              bigint,
   role_id              bigint,
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

