CREATE TABLE `storage_system` (
  `id` int(11) NOT NULL,
  `nickname` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `user_folder` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `file_name` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `file_extension` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `local_path` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `relative_link` VARCHAR(255) COLLATE utf8_croatian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;
ALTER TABLE `storage_system`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nickname` (`nickname`);

ALTER TABLE `storage_system`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `storage_system`
  ADD CONSTRAINT `nickname_fk` FOREIGN KEY (`nickname`) REFERENCES `user` (`nickname`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
