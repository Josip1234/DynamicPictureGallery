
ALTER TABLE `gallery_data` ADD CONSTRAINT `category_fk` FOREIGN KEY (`category`) REFERENCES `category`(`category_name`) ON DELETE CASCADE ON UPDATE CASCADE;