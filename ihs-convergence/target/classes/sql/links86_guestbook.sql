/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : links86_guestbook

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/25/2016 10:45:25 AM
*/

CREATE TABLE guestbook(
	id BIGINT(20) NOT NULL COMMENT '编号' ,
	group_id BIGINT(20) NOT NULL COMMENT '留言组编号',
	re_id BIGINT(20) COMMENT '回复编号',
	user_id BIGINT(20) NOT NULL COMMENT '留言者编号',
	comment_type VARCHAR(64) COMMENT '留言类型',
	content VARCHAR(1024) NOT NULL COMMENT '内容',
	ip VARCHAR(1024) COMMENT '发布ip',
	post_date DATETIME COMMENT '留言时间',
	del_flag INT(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
	PRIMARY KEY (id)
)COMMENT = '留言表';



