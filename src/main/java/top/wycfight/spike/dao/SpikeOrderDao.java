package top.wycfight.spike.dao;

import top.wycfight.spike.entity.SpikeOrder;

public interface SpikeOrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(SpikeOrder record);

    int insertSelective(SpikeOrder record);

    SpikeOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpikeOrder record);

    int updateByPrimaryKey(SpikeOrder record);
}