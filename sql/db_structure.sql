-- 植物数据库结构
CREATE DATABASE IF NOT EXISTS chronogarden CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE chronogarden;

-- 植物基本信息表
CREATE TABLE IF NOT EXISTS plants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    scientific_name VARCHAR(100),
    original_name VARCHAR(150),
    description TEXT,
    era VARCHAR(50),
    first_appearance VARCHAR(100),
    extinction_time VARCHAR(100),
    source VARCHAR(255),
    crawl_time VARCHAR(30),
    source_language VARCHAR(10),
    care_needs JSON,
    growth_stages JSON,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 植物时代表 (用于分类)
CREATE TABLE IF NOT EXISTS eras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    display_order INT DEFAULT 0,
    UNIQUE KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 插入已知时代
INSERT INTO eras (name, display_order) VALUES 
('古生代植物', 1),
('中生代植物', 2),
('近期已灭绝植物', 3),
('野外灭绝植物', 4);

-- 示例数据插入语句
INSERT INTO plants (name, scientific_name, original_name, description, era, first_appearance, extinction_time, source, crawl_time, source_language, care_needs)
VALUES (
    '轮叶属',
    'Annularia',
    '轮叶属 (Annularia)',
    'Annularia is a form taxon, applied to fossil foliage belonging to extinct plants of the genus Calamites...',
    '古生代植物',
    'Carboniferous',
    'Carboniferous',
    'https://en.wikipedia.org/wiki/Annularia',
    '2025-03-20 11:57:19',
    'en',
    '{"growthEnvironment": "", "lightConditions": "", "soilType": "", "nutritionRequirements": ""}'
);
