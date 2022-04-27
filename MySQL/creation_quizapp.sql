CREATE DATABASE IF NOT EXISTS `quizappdb` DEFAULT CHARACTER SET utf8;

use quizappdb;

DROP TABLE IF EXISTS `role`;
CREATE TABLE  `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE  `user` (
  `id` int(11) NOT NULL auto_increment,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE  `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `user_role_key` (`role_id`),
  CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE  `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- quiz part

DROP TABLE IF EXISTS `quiz`;
CREATE TABLE  `quiz` (
  `quiz_id` int(11) NOT NULL auto_increment,
  `quiz_name` varchar(255) NOT NULL,
  `quiz_description` varchar(255) NOT NULL,
  PRIMARY KEY  (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `take_quiz`;
CREATE TABLE  `take_quiz` (
  `take_quiz_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `startTime` datetime NULL,
  `finishTime` datetime NULL,
  `score` int NULL,
  PRIMARY KEY  (`take_quiz_id`),
  
  CONSTRAINT `take_quiz_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `take_quiz_quiz_id` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `question`;
CREATE TABLE  `question` (
  `question_id` int(11) NOT NULL auto_increment,
  `quiz_id` int(11) NOT NULL,
  `question_content` varchar(255) NULL,
  `question_status` varchar(10) NULL,
  PRIMARY KEY  (`question_id`),

  CONSTRAINT `question_quiz_id` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `choice`;
CREATE TABLE  `choice` (
  `choice_id` int(11) NOT NULL auto_increment,
  `question_id` int(11) NOT NULL,
  `choice_content` varchar(255) NULL,
  `is_correct` TINYINT NULL,
  PRIMARY KEY  (`choice_id`),

  CONSTRAINT `choice_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `quiz_result`;
CREATE TABLE  `quiz_result` (
  `quiz_result_id` int(11) NOT NULL auto_increment,
  `take_quiz_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_choice` int NULL,
  PRIMARY KEY  (`quiz_result_id`),
  
  CONSTRAINT `quiz_result_take_quiz_id` FOREIGN KEY (`take_quiz_id`) REFERENCES `take_quiz` (`take_quiz_id`),
  CONSTRAINT `quiz_result_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `feedback`;
CREATE TABLE  `feedback` (
  `feedback_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `rating` int NULL,
  `review` varchar(255) NULL,
  PRIMARY KEY  (`feedback_id`),
  
  CONSTRAINT `feedback_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `feedback_quiz_id` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;










