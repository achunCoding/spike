package top.wycfight.spike.dao;

import top.wycfight.spike.entity.Goods;
import top.wycfight.spike.entity.GoodsVO;

import java.util.List;

public interface GoodsDao {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查询商品列表
     * @return
     */
    List<GoodsVO> list();

    /**
     * 查询商品详情
     * @param goodId 商品ID
     * @return
     */
    GoodsVO searchGoodById(Long goodId);
}