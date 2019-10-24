CREATE TABLE `auth-service-db`.`oauth2access_token_entity` (
  `authentication_id` varchar(255) NOT NULL,
  `access_token` varchar(2048) NOT NULL,
  `authentication` varchar(4096) NOT NULL,
  `token_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
