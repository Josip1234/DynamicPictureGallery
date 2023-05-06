ALTER TABLE `storage_system` ADD `gallery_name` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL AFTER `relative_link`, ADD INDEX (`gallery_name`);
