-- --------------------------------------------------------
-- 호스트:                          localhost
-- 서버 버전:                        10.3.14-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- test 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;

-- 테이블 test.part 구조 내보내기
CREATE TABLE IF NOT EXISTS `part` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  KEY `idx` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 test.project 구조 내보내기
CREATE TABLE IF NOT EXISTS `project` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  KEY `idx` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 test.resource 구조 내보내기
CREATE TABLE IF NOT EXISTS `resource` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `part_idx` int(11) DEFAULT NULL,
  `project_idx` int(11) DEFAULT NULL,
  KEY `idx` (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=latin1;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
