DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	tenant_id BIGINT(20) NOT NULL COMMENT '租户ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	PRIMARY KEY (id)
);