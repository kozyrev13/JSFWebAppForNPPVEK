CREATE TABLE `crane_scale` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `title` varchar(45) DEFAULT NULL,
        `price` INT DEFAULT NULL,
        `cargo_capacity` INT DEFAULT NULL,
        `height` INT DEFAULT NULL,
        `length` INT DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
