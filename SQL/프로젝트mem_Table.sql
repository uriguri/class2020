CREATE TABLE `mem` (
  `mem_idx` int NOT NULL AUTO_INCREMENT,
  `mem_Id` varchar(45) NOT NULL,
  `mem_Pw` varchar(45) NOT NULL,
  `mem_Name` varchar(45) NOT NULL,
  `mem_Photo` varchar(45) DEFAULT 'default.png',
  `mem_Loc` varchar(45) DEFAULT NULL,
  `mem_Lev` varchar(45) DEFAULT NULL,
  `mem_Like` varchar(45) DEFAULT NULL,
  `mem_Bookmark` varchar(45) DEFAULT NULL,
  `mem_Gender` varchar(45) DEFAULT NULL,
  `mem_Regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mem_Emailchk` int NOT NULL,
  `mem_Social` int DEFAULT NULL,
  PRIMARY KEY (`mem_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8