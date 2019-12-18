package top.wycfight.spike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * spike_order
 * @author 
 */
@Getter
@Setter
@ToString
public class SpikeOrder implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单ID
     */
    private Long orderId;

    private static final long serialVersionUID = 1L;
}