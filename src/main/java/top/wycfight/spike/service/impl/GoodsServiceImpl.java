package top.wycfight.spike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.spike.dao.GoodsDao;
import top.wycfight.spike.entity.GoodsVO;
import top.wycfight.spike.service.GoodsService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 商品Service实现类
 * @create: 2019-12-16 07:47
 * @modify By:
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVO> list() {
        return goodsDao.list();
    }

    @Override
    public GoodsVO searchGoodById(Long goodId) {
        return goodsDao.searchGoodById(goodId);
    }
}
