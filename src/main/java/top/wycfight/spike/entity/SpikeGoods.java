package top.wycfight.spike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * spike_goods
 * @author 
 */
@Getter
@Setter
@ToString
public class SpikeGoods implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 商品单价
     */
    private BigDecimal spikePrice;

    /**
     * 秒杀库存
     */
    private Integer stockCount;

    /**
     * 秒杀结束是啊金
     */
    private String endStart;

    private static final long serialVersionUID = 1L;


}