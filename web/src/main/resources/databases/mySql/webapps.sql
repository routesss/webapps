user
	id 	v64	id值
	login_name	v64 登录名
	password	v100 密码
	real_name	v100 真实姓名
	email	v100 邮箱
	phone v100 电话
	mobile v100 手机
	user_type char 1 用户类型
	company_id v64 公司id
	office_id v64 部门id
	photo v1000 用户头像
	id_type int 10 证件类型
	id_code varchar50 证件号码
	user_source int 10 用户来源
	login_ip v100 最后登陆IP
	login_date datetime 最后登陆时间
	create_by v64 创建者
	create_date datetime 创建时间
	update_by v64 更新者
	update_date datetime 更新时间
	remarks v255 备注信息
	del_flag char1 删除标记

role
	id
	office_id v64 归属机构
	name v100 角色名称
	enname v255 英文名称
	role_type v255 角色类型
	data_scope char 1 数据范围
	is_sys v64 是否系统数据
	useable v64 是否可用
	create_by v64 创建者
	create_date datetime 创建时间
	update_by v64 更新者
	update_date datetime 更新时间
	del_flag char1 删除标记


menu
	id
	parent_id v64 父级编号
	parent_ids v2000 所有父级编号
	name v100 名称
	sort decimal 10 排序
	href v2000 链接
	target v20 目标
	icon v100 图标
	is_show char 1 是否在菜单中显示
	permission v200 权限标识
	create_by v64 创建者
	create_date datetime 创建时间
	update_by v64 更新者
	update_date datetime 更新时间
	remarks v255 备注信息
	del_flag char1 删除标记

user_role
	user_id v64 用户编号
	role_id v64 角色编号

role-menu
	role_id v64 角色编号
	menu_id v64 菜单编号





CREATE TABLE sys_user(
	id VARCHAR(64) NOT NULL COMMENT "id" ,
	login_name VARCHAR(64) NOT NULL COMMENT "登录名" ,
	password VARCHAR(100) NOT NULL COMMENT "密码",
	real_name VARCHAR(100) DEFAULT "" COMMENT "真实姓名" ,
	email VARCHAR(100) DEFAULT "" COMMENT "邮箱",
	phone VARCHAR(100) DEFAULT "" COMMENT "电话",
	mobile VARCHAR(100) DEFAULT "" COMMENT "手机",
	user_type CHAR(1) DEFAULT "0" COMMENT "用户类型 0普通用户" ,
	company_id VARCHAR(64) DEFAULT "" COMMENT "公司id" ,
	office_id VARCHAR(64) DEFAULT "" COMMENT "部门id" ,
	photo VARCHAR(1000)  DEFAULT "" COMMENT "用户头像" ,
	id_type CHAR(2) DEFAULT "0" COMMENT "证件类型 0身份证" ,
	id_code VARCHAR(50) DEFAULT "" COMMENT "证件号码" ,
	user_source INT(10) DEFAULT 0 COMMENT "用户来源 0后台" ,
	login_ip VARCHAR(100) DEFAULT "" COMMENT "最后登陆IP" ,
	login_date datetime DEFAULT NOW() COMMENT "最后登陆时间" ,
	create_by VARCHAR(64) DEFAULT "" COMMENT "创建者" ,
	create_date datetime DEFAULT NOW() COMMENT "创建时间" ,
	update_by VARCHAR(64) DEFAULT "" COMMENT "更新者" ,
	update_date datetime DEFAULT NOW() COMMENT "更新时间" ,
	remarks VARCHAR(255) DEFAULT "" COMMENT "备注信息" ,
	del_flag CHAR(1) DEFAULT "0" COMMENT "删除标记 0正常 1删除" ,
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户表" ;



CREATE TABLE sys_role(
	id VARCHAR(64) NOT NULL COMMENT "id" ,
	office_id VARCHAR(64) DEFAULT "" COMMENT "归属机构" ,
	name VARCHAR(100) DEFAULT "" COMMENT "角色名称" ,
	enname VARCHAR(255) DEFAULT "" COMMENT "英文名称" ,
	role_type VARCHAR(8) DEFAULT "0" COMMENT "角色类型 0普通角色 1管理角色 2任务角色" ,
	data_scope CHAR(1) DEFAULT "" COMMENT "数据范围" ,
	is_sys VARCHAR(8) DEFAULT "" COMMENT "是否系统数据" ,
	useable VARCHAR(64) DEFAULT "0" COMMENT "是否可用 0可用 1不可用" ,
	create_by VARCHAR(64) DEFAULT "" COMMENT "创建者" ,
	create_date datetime DEFAULT NOW() COMMENT "创建时间" ,
	update_by VARCHAR(64) DEFAULT "" COMMENT "更新者" ,
	update_date datetime DEFAULT NOW() COMMENT "更新时间" ,
	remarks VARCHAR(255) DEFAULT "" COMMENT "备注信息" ,
	del_flag CHAR(1) DEFAULT "0" COMMENT "删除标记 0正常 1删除" ,
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="角色表" ;




CREATE TABLE sys_menu(
	id VARCHAR(64) NOT NULL COMMENT "id" ,
	parent_id VARCHAR(64) NOT NULL COMMENT "父级编号",
	parent_ids VARCHAR(2000) NOT NULL COMMENT "所有父级编号",
	name VARCHAR(100) NOT NULL COMMENT "名称" ,
	sort DECIMAL(10) DEFAULT 0 COMMENT "排序",
	href VARCHAR(2000) NOT NULL COMMENT "链接",
	target VARCHAR(20) DEFAULT "" COMMENT "目标",
	icon VARCHAR(100) DEFAULT "" COMMENT "图标",
	is_show CHAR(1) DEFAULT "0" COMMENT "是否在菜单中显示 0显示 1不显示",
	permission VARCHAR(200) NOT NULL COMMENT "权限标识",
	create_by VARCHAR(64) DEFAULT "" COMMENT "创建者" ,
	create_date datetime DEFAULT NOW() COMMENT "创建时间" ,
	update_by VARCHAR(64) DEFAULT "" COMMENT "更新者" ,
	update_date datetime DEFAULT NOW() COMMENT "更新时间" ,
	remarks VARCHAR(255) DEFAULT "" COMMENT "备注信息" ,
	del_flag CHAR(1) DEFAULT "0" COMMENT "删除标记 0正常 1删除" ,
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="菜单表" ;



CREATE TABLE sys_user_role(
	user_id VARCHAR(64) NOT NULL COMMENT "用户编号" ,
	role_id VARCHAR(64) NOT NULL COMMENT "角色编号"
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户-角色" ;



CREATE TABLE sys_role_menu(
	role_id VARCHAR(64) NOT NULL COMMENT "角色编号" ,
	menu_id VARCHAR(64) NOT NULL COMMENT "菜单编号"
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="角色-菜单" ;


