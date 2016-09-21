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


