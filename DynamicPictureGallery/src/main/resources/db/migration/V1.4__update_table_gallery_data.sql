ALTER TABLE `gallery_data` ADD CONSTRAINT `user_fk` FOREIGN KEY (`username`) REFERENCES `user`(`username`) ON DELETE CASCADE ON UPDATE CASCADE;