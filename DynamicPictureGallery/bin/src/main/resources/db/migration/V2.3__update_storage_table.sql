ALTER TABLE `storage_system` ADD `date_of_upload` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `gallery_name`, ADD `date_of_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `date_of_upload`;