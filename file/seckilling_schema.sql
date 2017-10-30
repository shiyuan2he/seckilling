-- 数据库初始化脚本

-- 创建数据库
create DATABASE seckilling ;
-- 使用数据库
use seckilling ;

create TABLE t_seckilling_item(
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
  name VARCHAR(100) NOT NULL COMMENT '商品名称',
  number INT NOT NULL COMMENT '商品库存',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间',
  start_time TIMESTAMP NOT NULL COMMENT '开始时间',
  end_time TIMESTAMP NOT NULL COMMENT '结束时间',
  PRIMARY KEY (id) ,
  key idx_create_time(create_time) ,
  key idx_start_time(start_time),
  key inx_end_time(end_time)
) ENGINE = InnoDB  AUTO_INCREMENT=10000 DEFAULT CHARSET = utf8 COMMENT = '秒杀项目表';

insert into
  t_seckilling_item(name,number,create_time,start_time,end_time)
values
  ('1000元秒杀iphone x',100,now(),'2017-11-01 00:00:00','2017-11-02 00:00:00'),
  ('1000元秒杀小米6',100,now(),'2017-11-01 00:00:00','2017-11-02 00:00:00'),
  ('1000元秒杀华为meta10',100,now(),'2017-11-01 00:00:00','2017-11-02 00:00:00'),
  ('1000元秒杀oppo r20s',100,now(),'2017-11-01 00:00:00','2017-11-02 00:00:00');

create TABLE t_seckilling_success(
  seckilling_item_id BIGINT NOT NULL COMMENT '秒杀项目表主键' ,
  user_phone BIGINT(11) NOT NULL COMMENT '用户手机号',
  state TINYINT NOT NULL  DEFAULT -1 COMMENT '状态标识：-1 无效，0 成功 1 已付款 2 已发货',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckilling_item_id,user_phone),
  key idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '秒杀成功明细表';

