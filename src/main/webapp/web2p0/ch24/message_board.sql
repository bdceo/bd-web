-- --------------------------------------------------------

-- 
-- 表的结构 `messageboard`
-- 

CREATE TABLE `messageboard` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) NOT NULL default '',
  `content` text NOT NULL,
  `addTime` varchar(50) default NULL,
  `replyTime` varchar(50) default NULL,
  `name` varchar(20) NOT NULL default '',
  `qq` varchar(12) default ' ',
  `email` varchar(60) default NULL,
  `page` varchar(60) default NULL,
  `replyContent` text,
  `ip` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `messageboard`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `user`
-- 

CREATE TABLE `user` (
  `user` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  PRIMARY KEY  (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `user`
-- 

INSERT INTO `user` (`user`, `pass`) VALUES 
('admin', 'admin');
