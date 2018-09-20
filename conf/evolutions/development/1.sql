# --- !Ups

CREATE TABLE `domain` (
  `website_id` varchar(36) NOT NULL,
  `domain` varchar(255) NOT NULL
);

CREATE TABLE `website` (
  `type` varchar(15) NOT NULL,
  `id` varchar(36) NOT NULL
);

ALTER TABLE `website` ADD PRIMARY KEY (`id`);

ALTER TABLE `domain`
  ADD PRIMARY KEY (`website_id`,`domain`),
  ADD CONSTRAINT `fk_domain_website_id` FOREIGN KEY (`website_id`) REFERENCES `website` (`id`);


INSERT INTO `website` (`type`, `id`) VALUES ('a', '3feff467-cce5-4914-a5e1-ba8e021ccf8e');
INSERT INTO `domain` (`website_id`, `domain`) VALUES
  ('3feff467-cce5-4914-a5e1-ba8e021ccf8e', '127.0.0.1'),
  ('3feff467-cce5-4914-a5e1-ba8e021ccf8e', 'localhost');






CREATE TABLE `domaina` (
  `websitea_id` varchar(36) NOT NULL,
  `domain` varchar(255) NOT NULL
);

CREATE TABLE `websitea` (
  `id` varchar(36) NOT NULL
);

ALTER TABLE `websitea` ADD PRIMARY KEY (`id`);

ALTER TABLE `domaina`
  ADD PRIMARY KEY (`websitea_id`,`domain`),
  ADD CONSTRAINT `fk_domaina_websitea_id` FOREIGN KEY (`websitea_id`) REFERENCES `websitea` (`id`);


INSERT INTO `websitea` (`id`) VALUES ('3feff467-cce5-4914-a5e1-ba8e021ccf8e');
INSERT INTO `domaina` (`websitea_id`, `domain`) VALUES
                                                     ('3feff467-cce5-4914-a5e1-ba8e021ccf8e', '127.0.0.1'),
                                                     ('3feff467-cce5-4914-a5e1-ba8e021ccf8e', 'localhost');
