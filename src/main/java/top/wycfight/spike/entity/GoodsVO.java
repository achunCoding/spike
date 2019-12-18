package top.wycfight.spike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 商品列表展示详情
 * @create: 2019-12-16 07:51
 * @modify By:
 **/
@Getter
@Setter
@ToString
public class GoodsVO extends Goods {
    /**
     * 秒杀价格
     */
    private BigDecimal spikePrice;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 库存数量
     */
    private Integer stock;
}
