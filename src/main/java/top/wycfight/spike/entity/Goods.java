package top.wycfight.spike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * goods
 * @author 
 */
@Getter
@Setter
@ToString
public class Goods implements Serializable {
    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图片存放路径
     */
    private String goodsImg;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品库存, -1表示没有限制
     */
    private Integer goodsStock;

    /**
     * 商品消息介绍
     */
    private String goodsDetail;

    private static final long serialVersionUID = 1L;


}