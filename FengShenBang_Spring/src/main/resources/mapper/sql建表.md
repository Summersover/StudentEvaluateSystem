-- username=学号=唯一标识id
-- 删掉了```sql, 在--后面加了一个空格，这样可以一次性复制下去建所有表

-- 用户表
CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);
INSERT INTO `user` (`username`, `password`) VALUES ('2200022701', '123456');
INSERT INTO `user` (`username`, `password`) VALUES ('2200022702', '123456');
INSERT INTO `user` (`username`, `password`) VALUES ('2200022703', '123456');
INSERT INTO `user` (`username`, `password`) VALUES ('1200012700', '123456');
INSERT INTO `user` (`username`, `password`) VALUES ('1300012700', '123456');



-- 学生列表
CREATE TABLE `studentlist` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL,
`name` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);
INSERT INTO `studentlist` (`username`, `name`) VALUES ('2200022701', '茶同学');
INSERT INTO `studentlist` (`username`, `name`) VALUES ('2200022702', '哈同学');
INSERT INTO `studentlist` (`username`, `name`) VALUES ('2200022703', '果同学');



-- 评分总表
CREATE TABLE `marklist` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL COMMENT '用户名',
`name` VARCHAR(255) COMMENT '姓名',
`rsmark` varchar(255) COMMENT '科研评分',
`wsmark` varchar(255) COMMENT '学生骨干服务岗位评分',
`spmark` varchar(255) COMMENT '社会实践评分',
    `psmark` varchar(255) COMMENT '个人学年总结评分',
`gpmark` varchar(255) COMMENT 'GPA评分',
`vsmark` varchar(255) COMMENT '志愿服务评分',
`totmark` varchar(255) COMMENT '总评分',
PRIMARY KEY (`id`)
);

INSERT INTO marklist (`username`, `name`, rsmark, wsmark, spmark, psmark, gpmark, vsmark, totmark)
VALUES ('2200022701', '茶同学', '4', '5', '9', '1', '9', '7', '35');
INSERT INTO marklist (`username`, `name`)
VALUES
('2200022702', '哈同学'),
('2200022703', '果同学');



-- 科研情况表
CREATE TABLE `researchsituation` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL COMMENT '用户名',
`rank` varchar(255) COMMENT '名称',
`time` varchar(255) COMMENT '时间',
`place` varchar(255) COMMENT '地点',
`prize` varchar(255) COMMENT '奖项',
PRIMARY KEY (`id`)
);

-- 学生骨干岗位服务表
CREATE TABLE `workservice` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL COMMENT '用户名',
`time` varchar(255) COMMENT '起始时间',
`job` varchar(255) COMMENT '服务岗位名称',
`post` varchar(255) COMMENT '职务',
`level` varchar(255) COMMENT '考核级别',
PRIMARY KEY (`id`)
);

-- 社会实践表
CREATE TABLE `socialpractice` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL COMMENT '用户名',
`initiator` varchar(255) COMMENT '发起单位',
`spot` varchar(255) COMMENT '地点',
`days` varchar(255) COMMENT '天数',
`size` varchar(255) COMMENT '团队人数',
`post` varchar(255) COMMENT '团队职务',
`online` varchar(255) COMMENT '是否线上',
`award` varchar(255) COMMENT '是否获得奖励',
`awardname` varchar(255) COMMENT '奖励名称',
PRIMARY KEY (`id`)
);


-- 个人学年总结表1
CREATE TABLE `personalstatement1` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL COMMENT '用户名',
`time` varchar(255) COMMENT '时间',
`spot` varchar(255) COMMENT '地点',
`level` varchar(255) COMMENT '活动级别',
`role` varchar(255) COMMENT '角色',
`eventname` varchar(255) COMMENT '活动名称',
PRIMARY KEY (`id`)
);

-- 个人学年总结表2
CREATE TABLE `personalstatement2` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL COMMENT '用户名',
`behaviour` varchar(255) COMMENT '行为规范',
`study` varchar(255) COMMENT '学习态度',
`health` varchar(255) COMMENT '身体健康',
PRIMARY KEY (`id`)
);

-- 学生成绩表
CREATE TABLE `gpalist` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(255) NOT NULL COMMENT '用户名',
`name` VARCHAR(255) NOT NULL COMMENT '姓名',
`grade` varchar(255) COMMENT '成绩',
`gpa` varchar(255) COMMENT 'GPA',
`gpmark` varchar(255) COMMENT '评分',
PRIMARY KEY (`id`)
);

INSERT INTO gpalist (`username`, `name`, `grade`, `gpa`, `gpmark`)
VALUES
('2200022701', '茶同学', '90', '3.8', '9'),
('2200022702', '哈同学', '85', '3.7', '8'),
('2200022703', '果同学', '80', '3.6', '7');


-- 学生志愿
CREATE TABLE `volserlist` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(255) NOT NULL COMMENT '学号',
`name` VARCHAR(255) NOT NULL COMMENT '姓名',
`time` varchar(255) COMMENT '志愿时长',
`vsmark` varchar(255) COMMENT '评分',
PRIMARY KEY (`id`)
);

INSERT INTO volserlist (`username`, `name`, `time`, `vsmark`)
VALUES
('2200022701', '茶同学', '90', '7'),
('2200022702', '哈同学', '30', '2'),
('2200022703', '果同学', '60', '4');



-- 角色表
CREATE TABLE Role (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`role_id` INT,
`role_name` VARCHAR(50)
);

INSERT INTO Role (role_id, role_name)
VALUES (1, '学生'),
(2, '评委老师'),
(3, '学工老师');


-- 用户角色表
CREATE TABLE UserRole (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(50),
`role_id` INT
);

INSERT INTO UserRole (username, role_id)
VALUES (2200022701, 1),
(1200012700, 2),
(1300012700, 3);

-- 权限表
CREATE TABLE Permission (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`permission_name` VARCHAR(255)
);

INSERT INTO Permission (permission_name)
VALUES
('/admin-api/user/profile/get'),

('/admin-api/student/get'),
('/admin-api/student/updateResSitu'),
('/admin-api/student/getResSitu'),
('/admin-api/student/updateWorServ'),
('/admin-api/student/getWorServ'),
('/admin-api/student/updateSocPrac'),
('/admin-api/student/getSocPrac'),
('/admin-api/student/updatePerStat'),
('/admin-api/student/getPerStat1'),
('/admin-api/student/getPerStat2'),

('/admin-api/judge/resSitu/getStuList'),
('/admin-api/judge/resSitu/sendStuNum'),
('/admin-api/judge/resSitu/getResSitu'),
('/admin-api/judge/resSitu/getResSituMarkList'),
('/admin-api/judge/resSitu/updateResSituMark'),
('/admin-api/judge/workServe/getStuList'),
('/admin-api/judge/workServe/sendStuNum'),
('/admin-api/judge/workServe/getWorServ'),
('/admin-api/judge/workServe/getWorServMarkList'),
('/admin-api/judge/workServe/updateWorServMark'),
('/admin-api/judge/socPrac/getStuList'),
('/admin-api/judge/socPrac/sendStuNum'),
('/admin-api/judge/socPrac/getSocPrac'),
('/admin-api/judge/socPrac/getSocPracMarkList'),
('/admin-api/judge/socPrac/updateSocPracMark'),
('/admin-api/judge/perStat/getStuList'),
('/admin-api/judge/perStat/sendStuNum'),
('/admin-api/judge/perStat/getPerStat1'),
('/admin-api/judge/perStat/getPerStat2'),
('/admin-api/judge/perStat/getPerStatMarkList'),
('/admin-api/judge/perStat/updatePerStatMark'),

('/admin-api/studentInfo/get'),
('/admin-api/totalMark/getTotalMarkList'),

('/admin-api/auth/login'),
('/admin-api/auth/captcha'),
('/admin-api/menu/getMenu'),
('/admin-api/menu/getRole'),
('/admin-api/studentVolSer/upload'),
('/admin-api/studentGPA/upload'),
('/admin-api/studentVolSer/getStudentVolSerData'),
('/admin-api/studentGPA/getStudentGPAData'),
('/admin-api/studentVolSer/getVolSer'),
('/admin-api/studentGPA/getGPA'),
('/admin-api/file/upload'),
('/admin-api/studentInfo/upload'),
('/admin-api/student/deleteResSitu'),
('/admin-api/student/deleteSocPrac'),
('/admin-api/student/deletePerStat'),
('/admin-api/student/deletePerStat2'),
('/admin-api/student/deleteWorServ');








-- 角色权限表
CREATE TABLE RolePermission (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`role_id` INT,
`permission_id` INT
);

INSERT INTO RolePermission (role_id, permission_id)
VALUES

(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),
(1,10),
(1,11),
(1,35),
(1,36),
(1,37),
(1,38),
(1,43),
(1,44),
(1,45),
(1,47),
(1,48),
(1,49),
(1,50),
(1,51),

(2,1),
(2,12),
(2,13),
(2,14),
(2,15),
(2,16),
(2,17),
(2,18),
(2,19),
(2,20),
(2,21),
(2,22),
(2,23),
(2,24),
(2,25),
(2,26),
(2,27),
(2,28),
(2,29),
(2,30),
(2,31),
(2,32),
(2,35),
(2,36),
(2,37),
(2,38),
(2,39),
(2,40),
(2,41),
(2,42),

(3,1),
(3,33),
(3,34),
(3,35),
(3,36),
(3,37),
(3,38),
(3,46);


-- 菜单表 动态路由菜单栏制作
CREATE TABLE Menu (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`path` VARCHAR(100),
`component` VARCHAR(100)
);

INSERT INTO Menu (name, path, component)
VALUES
('科研情况填报', '/student/SRS', 'student/StudentResearchSituation'),
('社会实践填报', '/student/SSP', 'student/StudentSocialPractice'),
('学生骨干岗位填报', '/student/SWS', 'student/StudentWorkService'),
('个人学年总结填报', '/student/SPS', 'student/StudentPersonalStatement'),
('学生成绩填报', '/student/SGE', 'student/StudentGradeEvaluation'),
('志愿服务填报', '/student/SVS', 'student/StudentVolunteerService'),

('科研情况评分', '/judge/JRS', 'judge/JudgeResSituList'),
('社会实践评分', '/judge/JSP', 'judge/JudgeSocPracList'),
('学生骨干岗位服务评分', '/judge/JWS', 'judge/JudgeWorServList'),
('个人学年总结评分', '/judge/JPS', 'judge/JudgePerStatList'),
('学生成绩导入', '/judge/JGE', 'judge/JudgeGradeEvaluation'),
('志愿服务导入', '/judge/JVS', 'judge/JudgeVolunteerService'),

('学生信息导入', '/staff/SNA', 'staff/StaffNotAssessed'),
('测评结果汇总', '/staff/SA', 'staff/StaffAssessed');


-- 角色菜单表
CREATE TABLE RoleMenu (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`role_id` INT,
`menu_id` INT
);

INSERT INTO RoleMenu (role_id, menu_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),

(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 12),

(3, 13),
(3, 14);



