-- 设置字符集
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- =============================
-- 表：courses 课程信息表
-- =============================
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`
(
    `course_id`   INT          NOT NULL AUTO_INCREMENT COMMENT '课程ID，主键',
    `course_name` VARCHAR(100) NOT NULL COMMENT '课程名称',
    `credit`      INT          NOT NULL COMMENT '课程学分',
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '课程表';

-- =============================
-- 表：departments 部门信息表
-- =============================
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`
(
    `dept_id`   INT          NOT NULL AUTO_INCREMENT COMMENT '部门ID，主键',
    `dept_name` VARCHAR(50)  NOT NULL COMMENT '部门名称',
    `location`  VARCHAR(100) NOT NULL COMMENT '部门所在地',
    PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '部门表';

-- =============================
-- 表：employees 员工信息表
-- =============================
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`
(
    `emp_id`     INT            NOT NULL AUTO_INCREMENT COMMENT '员工ID，主键',
    `first_name` VARCHAR(50)    NOT NULL COMMENT '员工名',
    `last_name`  VARCHAR(50)    NOT NULL COMMENT '员工姓',
    `salary`     DECIMAL(10, 2) NOT NULL COMMENT '员工薪资',
    `dept_id`    INT DEFAULT NULL COMMENT '所属部门ID，外键',
    PRIMARY KEY (`emp_id`) USING BTREE,
    INDEX `dept_id` (`dept_id`) USING BTREE,
    CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '员工表';

-- =============================
-- 表：id_cards 身份证信息表
-- =============================
DROP TABLE IF EXISTS `id_cards`;
CREATE TABLE `id_cards`
(
    `card_id`     INT         NOT NULL AUTO_INCREMENT COMMENT '身份证ID，主键',
    `card_number` VARCHAR(18) NOT NULL COMMENT '身份证号',
    `issue_date`  DATE        NOT NULL COMMENT '签发日期',
    `user_id`     INT DEFAULT NULL COMMENT '绑定用户ID，外键',
    PRIMARY KEY (`card_id`) USING BTREE,
    UNIQUE INDEX `card_number` (`card_number`) USING BTREE,
    UNIQUE INDEX `user_id` (`user_id`) USING BTREE,
    CONSTRAINT `id_cards_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '身份证表';

-- =============================
-- 表：student_courses 学生选课关联表
-- =============================
DROP TABLE IF EXISTS `student_courses`;
CREATE TABLE `student_courses`
(
    `student_id`      INT  NOT NULL COMMENT '学生ID，外键',
    `course_id`       INT  NOT NULL COMMENT '课程ID，外键',
    `enrollment_date` DATE NOT NULL COMMENT '选课时间',
    PRIMARY KEY (`student_id`, `course_id`) USING BTREE,
    INDEX `course_id` (`course_id`) USING BTREE,
    CONSTRAINT `student_courses_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT `student_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '学生选课表';

-- =============================
-- 表：students 学生信息表
-- =============================
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`
(
    `student_id`      INT         NOT NULL AUTO_INCREMENT COMMENT '学生ID，主键',
    `student_name`    VARCHAR(50) NOT NULL COMMENT '学生姓名',
    `enrollment_year` INT         NOT NULL COMMENT '入学年份',
    PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '学生表';

-- =============================
-- 表：users 用户账号表
-- =============================
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `user_id`    INT          NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
    `username`   VARCHAR(50)  NOT NULL COMMENT '用户名',
    `email`      VARCHAR(100) NOT NULL COMMENT '电子邮件',
    `created_at` TIMESTAMP    NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    PRIMARY KEY (`user_id`) USING BTREE,
    UNIQUE INDEX `username` (`username`) USING BTREE,
    UNIQUE INDEX `email` (`email`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '用户表';

SET FOREIGN_KEY_CHECKS = 1;



-- 清空表数据（可选，慎用！生产环境勿执行）
/*
TRUNCATE TABLE student_courses;
TRUNCATE TABLE courses;
TRUNCATE TABLE students;
TRUNCATE TABLE employees;
TRUNCATE TABLE departments;
TRUNCATE TABLE id_cards;
TRUNCATE TABLE users;
*/

-- 1. 插入用户（users）数据
INSERT INTO users (username, email, created_at)
VALUES ('alice', 'alice@example.com', '2024-01-01 10:00:00'),
       ('bob', 'bob@example.com', '2024-01-02 11:00:00'),
       ('charlie', 'charlie@example.com', '2024-01-03 12:00:00');

-- 2. 插入身份证（id_cards）数据（一对一）
INSERT INTO id_cards (card_number, issue_date, user_id)
VALUES ('110101200001011234', '2020-01-01', 1),
       ('110101198512123456', '2015-05-15', 2),
       ('110101199909094321', '2018-08-20', 3);

-- 3. 插入部门（departments）数据
INSERT INTO departments (dept_name, location)
VALUES ('Human Resources', 'New York'),
       ('Engineering', 'San Francisco');

-- 4. 插入员工（employees）数据（一对多）
INSERT INTO employees (first_name, last_name, salary, dept_id)
VALUES ('John', 'Doe', 60000.00, 1),
       ('Jane', 'Smith', 55000.00, 1),
       ('Mike', 'Johnson', 80000.00, 2),
       ('Sarah', 'Lee', 75000.00, 2);

-- 5. 插入学生（students）数据
INSERT INTO students (student_name, enrollment_year)
VALUES ('David', 2023),
       ('Emma', 2022),
       ('Frank', 2023);

-- 6. 插入课程（courses）数据
INSERT INTO courses (course_name, credit)
VALUES ('Database Design', 3),
       ('Software Development', 4),
       ('Cybersecurity', 3);

-- 7. 插入选课记录（student_courses）数据（多对多）
INSERT INTO student_courses (student_id, course_id, enrollment_date)
VALUES (1, 1, '2023-09-01'),
       (1, 3, '2023-09-10'),
       (2, 2, '2022-09-05'),
       (2, 3, '2023-09-15'),
       (3, 1, '2023-09-02'),
       (3, 2, '2023-09-03');
