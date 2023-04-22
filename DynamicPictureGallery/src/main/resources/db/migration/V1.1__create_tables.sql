CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nickname` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_croatian_ci NOT NULL,
  `hash_password` longtext COLLATE utf8_croatian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;


ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nickname` (`nickname`),
  ADD UNIQUE KEY `email` (`email`);

ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
