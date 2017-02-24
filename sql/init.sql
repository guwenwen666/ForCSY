/*-----------------------修改数据的安全模式--------------------------*/

SET SQL_SAFE_UPDATES = 0;


/*-----------------------代码类型初始化------------------------------*/

/**
 * date: 2016-09-21
 * author: wangqiang
 * description: 新增血型代码类型
*/
delete from b_xtpz_dmlx where dmlxbh = 10001;
INSERT INTO `b_xtpz_dmlx` (`id`,`dmlxbh`,`ywm`,`zwm`,`p_ywm`,`dmlxms`) VALUES (NULL,10001,'bloodType','血型',NULL,'血型');


/*-----------------------代码项初始化--------------------------------*/

/**
 * date: 2016-09-21
 * author: wangqiang
 * description: 新增血型代码项
*/
delete from b_xtpz_dmx where dmlxbh = 10001;

INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','未知','未知','-1',NULL,1,1,1,1,'未知',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','A','A型','1',NULL,1,1,0,2,'A型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','B','B型','2',NULL,1,1,0,3,'B型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','O','O型','3',NULL,1,1,0,4,'O型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','AB','AB型','4',NULL,1,1,0,5,'AB型',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES (NULL,'10001','其他','其他','5',NULL,1,1,0,6,'其他',NULL);


/*-----------------------系统配置表初始化--------------------------------*/

delete from b_qj_xtpz where name = 'cysf';
INSERT INTO `b_qj_xtpz` (`id`,`name`,`name_cn`,`val`,`expand`,`description`) VALUES (null,'cysf','常用省份','鲁',null,'用于配置常用省份=---其中id的值是关联dmx中简称省份的id值');
/**
 * date: 2017-02-17
 * author: wangyonghui
 * description: 新增省份简称代码项
*/
delete from b_xtpz_dmx where dmlxbh = '8';
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('903','8','闽','闽','29',NULL,1,1,0,29,'闽',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('904','8','粤','粤','30',NULL,1,1,0,30,'粤',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('905','8','琼','琼','31',NULL,1,1,0,31,'琼',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('906','8','台','台','32',NULL,1,1,0,32,'台',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('907','8','空','空','34',NULL,1,1,0,34,'空',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('908','8','海','海','35',NULL,1,1,0,35,'海',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('909','8','广','广','38',NULL,1,1,0,38,'广',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('910','8','成','成','39',NULL,1,1,0,39,'成',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('911','8','兰','兰','41',NULL,1,1,0,41,'兰',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('875','8','京','京','0',NULL,1,1,0,0,'京',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('876','8','津','津','1',NULL,1,1,0,1,'津',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('877','8','沪','沪','2',NULL,1,1,1,2,'沪',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('878','8','渝','渝','4',NULL,1,1,0,4,'渝',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('879','8','辽','辽','5',NULL,1,1,0,5,'辽',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('880','8','吉','吉','6',NULL,1,1,0,6,'吉',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('881','8','黑','黑','7',NULL,1,1,0,7,'黑',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('883','8','甘','甘','9',NULL,1,1,0,9,'甘',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('882','8','新','新','8',NULL,1,1,0,8,'新',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('884','8','青','青','10',NULL,1,1,0,10,'青',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('885','8','宁','宁','11',NULL,1,1,0,11,'宁',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('886','8','蒙','蒙','12',NULL,1,1,0,12,'蒙',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('887','8','陕','陕','13',NULL,1,1,0,13,'陕',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('888','8','晋','晋','14',NULL,1,1,0,14,'晋',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('889','8','冀','冀','15',NULL,1,1,0,15,'冀',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('890','8','鲁','鲁','16',NULL,1,1,0,16,'鲁',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('891','8','豫','豫','17',NULL,1,1,0,17,'豫',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('892','8','苏','苏','18',NULL,1,1,1,18,'苏',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('893','8','浙','浙','19',NULL,1,1,0,19,'浙',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('894','8','皖','皖','20',NULL,1,1,0,20,'皖',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('895','8','湘','湘','21',NULL,1,1,0,21,'湘',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('896','8','赣','赣','22',NULL,1,1,0,22,'赣',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('897','8','鄂','鄂','23',NULL,1,1,0,23,'鄂',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('898','8','川','川','24',NULL,1,1,0,24,'川',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('899','8','藏','藏','25',NULL,1,1,0,25,'藏',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('900','8','云','云','26',NULL,1,1,0,26,'云',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('901','8','贵','贵','27',NULL,1,1,0,27,'贵',NULL);
INSERT INTO `b_xtpz_dmx` (`id`,`dmlxbh`,`dmxywm`,`dmxzwm`,`dmxz`,`p_dmxywm`,`sfxs`,`sfky`,`sfmr`,`xssx`,`dmxms`,`dmxkz`) VALUES ('902','8','桂','桂','28',NULL,1,1,0,28,'桂',NULL);

delete from b_qj_xtpz where name = 'wxResource';
INSERT INTO `b_qj_xtpz` (`id`,`name`,`name_cn`,`val`,`expand`,`description`) VALUES (null,'wxResource','微信存储资源路径','http://127.0.0.1:8090/wxfile',null,'微信存储资源路径');

