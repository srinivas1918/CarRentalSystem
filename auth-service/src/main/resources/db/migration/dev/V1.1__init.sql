CREATE TABLE `client_details` (
  `client_id` varchar(255) NOT NULL,
  `access_token_validity_seconds` int(11) DEFAULT NULL,
  `auto_approve_scopes` bit(1) NOT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `refresh_token_validity_seconds` int(11) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `client_details_authorized_grant_types` (
  `client_details_client_id` varchar(255) NOT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  KEY `FK2a6l3vqjfciup69lwgie0kwfq` (`client_details_client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `client_details_scopes` (
  `client_details_client_id` varchar(255) NOT NULL,
  `scopes` varchar(255) DEFAULT NULL,
  KEY `FKcnccn8tsgihg6c17xdlf0jwmw` (`client_details_client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `user_profiles` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `user_profile_authorities` (
  `user_profile_username` varchar(255) NOT NULL,
  `authorities` tinyblob,
  KEY `FKa2v5rqn481e1vtnt91e6b3rvl` (`user_profile_username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) NOT NULL,
  `token` blob NOT NULL,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `client_id` varchar(45) NOT NULL,
  `authentication` blob NOT NULL,
  `refresh_token` blob,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) NOT NULL,
  `token` blob NOT NULL,
  `authentication` blob NOT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

