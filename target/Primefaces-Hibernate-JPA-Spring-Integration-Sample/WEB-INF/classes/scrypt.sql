CREATE TABLE `crane_scale` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `title` varchar(45) DEFAULT NULL,
        `price` INT DEFAULT NULL,
        `cargo_capacity` INT DEFAULT NULL,
        `height` INT DEFAULT NULL,
        `length` INT DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
CREATE TABLE `orders` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `phone_number` VARCHAR(45) NOT NULL,
        `order_description` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`id`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8;