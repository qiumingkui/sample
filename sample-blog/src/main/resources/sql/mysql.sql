/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-04-27 14:53:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blogentry
-- ----------------------------
DROP TABLE IF EXISTS `blogentry`;
CREATE TABLE `blogentry` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `commentnumber` bigint(20) DEFAULT NULL,
  `authorid` varchar(255) DEFAULT NULL,
  `authoraccount` varchar(255) DEFAULT NULL,
  `authorname` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blogentrycategory
-- ----------------------------
DROP TABLE IF EXISTS `blogentrycategory`;
CREATE TABLE `blogentrycategory` (
  `blogentryid` varchar(255) DEFAULT NULL,
  `categoryid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blogger
-- ----------------------------
DROP TABLE IF EXISTS `blogger`;
CREATE TABLE `blogger` (
  `id` varchar(255) NOT NULL,
  `ownerid` varchar(255) DEFAULT NULL,
  `owneraccount` varchar(255) DEFAULT NULL,
  `ownername` varchar(255) DEFAULT NULL,
  `postnumber` int(11) DEFAULT NULL,
  `commentnumber` int(11) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(255) NOT NULL,
  `pid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `postnumber` int(11) DEFAULT NULL,
  `versionnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(255) NOT NULL,
  `blogid` varchar(255) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storedevent
-- ----------------------------
DROP TABLE IF EXISTS `storedevent`;
CREATE TABLE `storedevent` (
  `eventid` bigint(20) NOT NULL AUTO_INCREMENT,
  `typename` varchar(256) DEFAULT NULL,
  `occurredon` datetime DEFAULT NULL,
  `eventbody` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=518 DEFAULT CHARSET=utf8;
