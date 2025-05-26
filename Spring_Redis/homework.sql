CREATE TABLE `product`
(
    `id`          BIGINT         NOT NULL AUTO_INCREMENT COMMENT '商品编码',
    `name`        VARCHAR(255)   NOT NULL COMMENT '商品名称',
    `description` TEXT COMMENT '商品描述',
    `price`       DECIMAL(10, 2) NOT NULL COMMENT '价格',
    `stock`       INT            NOT NULL COMMENT '库存数量',
    `category_id` BIGINT         NOT NULL COMMENT '分类ID',
    `status`      TINYINT        NOT NULL DEFAULT '1' COMMENT '状态 (1: 上架, 0: 下架)',
    `created_at`  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    INDEX `idx_category_id` (`category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='商品表';


-- 插入 10 条测试数据到 product 表
INSERT INTO `product` (`name`, `description`, `price`, `stock`, `category_id`, `status`, `created_at`, `updated_at`)
VALUES
-- 数据 1: 电子产品，价格较高，库存适中
('智能手机 X1', '高性能智能手机，配备 8GB RAM 和 128GB 存储', 4999.99, 50, 1, 1, '2025-05-01 10:00:00',
 '2025-05-01 10:00:00'),
-- 数据 2: 电子产品，价格中等，库存较多
('蓝牙耳机 Pro', '无线降噪耳机，续航 20 小时', 799.00, 200, 1, 1, '2025-05-02 12:00:00', '2025-05-02 12:00:00'),
-- 数据 3: 家居用品，价格较低，库存充足
('多功能电饭煲', '智能电饭煲，支持多种烹饪模式', 299.50, 100, 2, 1, '2025-05-03 14:30:00', '2025-05-03 14:30:00'),
-- 数据 4: 服装，价格适中，下架状态
('男士休闲夹克', '秋季新款，保暖舒适', 199.00, 30, 3, 0, '2025-05-04 09:15:00', '2025-05-04 09:15:00'),
-- 数据 5: 食品，价格低，库存少
('有机牛奶', '1L 装，纯天然无添加', 15.99, 20, 4, 1, '2025-05-05 11:20:00', '2025-05-05 11:20:00'),
-- 数据 6: 电子产品，价格高，库存少
('笔记本电脑 Ultra', '14 寸轻薄本，16GB RAM，512GB SSD', 7999.00, 10, 1, 1, '2025-05-06 16:45:00', '2025-05-06 16:45:00'),
-- 数据 7: 家居用品，价格中等，库存较多
('LED 台灯', '护眼台灯，支持亮度调节', 89.90, 150, 2, 1, '2025-05-07 08:00:00', '2025-05-07 08:00:00'),
-- 数据 8: 服装，价格较高，库存适中
('女士运动鞋', '轻便透气，适合跑步健身', 399.00, 60, 3, 1, '2025-05-08 13:10:00', '2025-05-08 13:10:00'),
-- 数据 9: 食品，价格低，库存较多
('全麦面包', '500g 装，健康低糖', 12.50, 200, 4, 1, '2025-05-09 15:30:00', '2025-05-09 15:30:00'),
-- 数据 10: 电子产品，价格中等，库存适中
('智能手表 S2', '支持心率监测和防水功能', 1299.00, 80, 1, 1, '2025-05-10 17:00:00', '2025-05-10 17:00:00');