-- 创建新的数据库架构
CREATE DATABASE IF NOT EXISTS voting_app CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 使用新创建的数据库
USE voting_app;

-- 创建 `users` 表来存储用户信息
CREATE TABLE IF NOT EXISTS `users` (
                                       `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                       `username` VARCHAR(50) NOT NULL UNIQUE,
                                       `password` VARCHAR(255) NOT NULL,
                                       `email` VARCHAR(100) NOT NULL UNIQUE,
                                       `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建 `polls` 表来存储投票信息
CREATE TABLE IF NOT EXISTS `polls` (
                                       `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                       `question` TEXT NOT NULL,
                                       `creator_id` INT UNSIGNED NOT NULL,
                                       `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       `end_date` TIMESTAMP NOT NULL,
                                       FOREIGN KEY (`creator_id`) REFERENCES `users`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建 `choices` 表来存储每个投票的候选项
CREATE TABLE IF NOT EXISTS `choices` (
                                         `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                         `poll_id` INT UNSIGNED NOT NULL,
                                         `description` TEXT NOT NULL,
                                         FOREIGN KEY (`poll_id`) REFERENCES `polls`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建 `votes` 表来存储用户的投票记录
CREATE TABLE IF NOT EXISTS `votes` (
                                       `id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                       `user_id` INT UNSIGNED NOT NULL,
                                       `choice_id` INT UNSIGNED NOT NULL,
                                       `vote_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       UNIQUE INDEX `user_vote` (`user_id`, `choice_id`),
                                       FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE,
                                       FOREIGN KEY (`choice_id`) REFERENCES `choices`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
