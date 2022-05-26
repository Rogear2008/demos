/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/5/9 23:23:24                            */
/*==============================================================*/


drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment comment '主键',
   create_time          timestamp not null comment '创建时间',
   update_time          timestamp default CURRENT_TIMESTAMP comment '最后修改时间',
   username             varchar(255) not null comment '用户名',
   password             varchar(255) comment '密码',
   birthday             date comment '生日',
   enable               tinyint default 1 comment '是否启用，1-启用，0-禁用',
   primary key (id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_general_ci;

alter table user comment '用户表';

