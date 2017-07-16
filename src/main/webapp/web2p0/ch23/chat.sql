CREATE TABLE `chat` (
  `nickname` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `face` varchar(5),
  `sex` varchar(5),
  `qq` varchar(12),
  `email` varchar(20),
  PRIMARY KEY  (`nickname`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;