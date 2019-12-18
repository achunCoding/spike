package top.wycfight.spike.service;

import top.wycfight.spike.entity.GoodsVO;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 商品service
 * @create: 2019-12-16 07:47
 * @modify By:
 **/
public interface GoodsService {
    /**
     * 查询商品详情列表
     * @return
     */
    List<GoodsVO> list();

    /**
     * 查询某个商品详情
     * @param goodId 商品ID
     * @return
     */
    GoodsVO searchGoodById(Long goodId);
}
