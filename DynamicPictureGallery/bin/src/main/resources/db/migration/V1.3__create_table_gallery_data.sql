CREATE TABLE `dynamic_gallery`.`gallery_data` ( `id` INT NOT NULL AUTO_INCREMENT , `username` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL , `gallery_name` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL , `sizeOfGallery` INT NOT NULL , PRIMARY KEY (`id`), UNIQUE (`username`), UNIQUE (`gallery_name`)) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_croatian_ci;