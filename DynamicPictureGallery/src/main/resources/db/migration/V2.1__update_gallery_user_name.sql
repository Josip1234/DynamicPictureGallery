ALTER TABLE `dynamic_gallery`.`gallery_data` DROP INDEX `username`, ADD INDEX `username` (`username`) USING BTREE;