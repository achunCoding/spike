package top.wycfight.spike.dao;

import top.wycfight.spike.entity.SpikeGoods;

public interface SpikeGoodsDao {
    int deleteByPrimaryKey(Long id);

    int insert(SpikeGoods record);

    int insertSelective(SpikeGoods record);

    SpikeGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpikeGoods record);

    int updateByPrimaryKeyWithBLOBs(SpikeGoods record);

    int updateByPrimaryKey(SpikeGoods record);
}