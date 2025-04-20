/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : employee_management

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 30/03/2025 13:36:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
                                `dept_id` int NOT NULL AUTO_INCREMENT,
                                `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES (1, 'HR', 'New York');
INSERT INTO `departments` VALUES (2, 'IT', 'San Francisco');
INSERT INTO `departments` VALUES (3, 'Finance', 'Chicago');
INSERT INTO `departments` VALUES (4, 'Marketing', 'Los Angeles');
INSERT INTO `departments` VALUES (5, 'Operations', 'Houston');

-- ----------------------------
-- Table structure for employee_projects
-- ----------------------------
DROP TABLE IF EXISTS `employee_projects`;
CREATE TABLE `employee_projects`  (
                                      `emp_id` int NOT NULL,
                                      `project_id` int NOT NULL,
                                      PRIMARY KEY (`emp_id`, `project_id`) USING BTREE,
                                      INDEX `project_id`(`project_id`) USING BTREE,
                                      CONSTRAINT `employee_projects_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                      CONSTRAINT `employee_projects_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_projects
-- ----------------------------
INSERT INTO `employee_projects` VALUES (2, 1);
INSERT INTO `employee_projects` VALUES (6, 1);
INSERT INTO `employee_projects` VALUES (9, 1);
INSERT INTO `employee_projects` VALUES (2, 2);
INSERT INTO `employee_projects` VALUES (5, 2);
INSERT INTO `employee_projects` VALUES (6, 2);
INSERT INTO `employee_projects` VALUES (9, 2);
INSERT INTO `employee_projects` VALUES (4, 3);
INSERT INTO `employee_projects` VALUES (10, 3);
INSERT INTO `employee_projects` VALUES (3, 4);
INSERT INTO `employee_projects` VALUES (7, 4);
INSERT INTO `employee_projects` VALUES (4, 5);
INSERT INTO `employee_projects` VALUES (5, 5);
INSERT INTO `employee_projects` VALUES (10, 5);

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
                              `emp_id` int NOT NULL AUTO_INCREMENT,
                              `first_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `hire_date` date NULL DEFAULT NULL,
                              `job_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              `salary` decimal(10, 2) NULL DEFAULT NULL,
                              `dept_id` int NULL DEFAULT NULL,
                              PRIMARY KEY (`emp_id`) USING BTREE,
                              UNIQUE INDEX `email`(`email`) USING BTREE,
                              INDEX `dept_id`(`dept_id`) USING BTREE,
                              CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', '2345678901', '2019-05-20', 'Software Engineer', 85000.00, 2);
INSERT INTO `employees` VALUES (3, 'Mike', 'Johnson', 'mike.johnson@example.com', '3456789012', '2018-11-10', 'Financial Analyst', 70000.00, 3);
INSERT INTO `employees` VALUES (4, 'Emily', 'Brown', 'emily.brown@example.com', '4567890123', '2021-03-01', 'Marketing Specialist', 65000.00, 4);
INSERT INTO `employees` VALUES (5, 'David', 'Wilson', 'david.wilson@example.com', '5678901234', '2017-09-15', 'Operations Manager', 80000.00, 5);
INSERT INTO `employees` VALUES (6, 'Sarah', 'Lee', 'sarah.lee@example.com', '6789012345', '2020-07-01', 'IT Support', 60000.00, 2);
INSERT INTO `employees` VALUES (7, 'Chris', 'Anderson', 'chris.anderson@example.com', '7890123456', '2019-12-01', 'Accountant', 68000.00, 3);
INSERT INTO `employees` VALUES (9, 'Tom', 'Martin', 'tom.martin@example.com', '9012345678', '2018-06-15', 'Software Developer', 82000.00, 2);
INSERT INTO `employees` VALUES (10, 'Amyone', 'White', 'amy.white@example.com', '0123456789', '2021-09-01', 'Marketing Manager', 78000.00, 4);

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects`  (
                             `project_id` int NOT NULL AUTO_INCREMENT,
                             `project_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                             `start_date` date NULL DEFAULT NULL,
                             `end_date` date NULL DEFAULT NULL,
                             PRIMARY KEY (`project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES (1, 'Website Redesign', '2023-01-01', '2024-11-30');
INSERT INTO `projects` VALUES (2, 'ERP Implementation', '2023-03-15', '2025-03-14');
INSERT INTO `projects` VALUES (3, 'Marketing Campaign', '2023-05-01', '2023-08-31');
INSERT INTO `projects` VALUES (4, 'Financial Audit', '2023-07-01', '2025-09-30');
INSERT INTO `projects` VALUES (5, 'New Product Launch', '2023-09-01', '2024-02-29');

SET FOREIGN_KEY_CHECKS = 1;
