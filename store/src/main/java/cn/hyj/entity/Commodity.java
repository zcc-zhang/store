package cn.hyj.entity;

import java.math.BigDecimal;

public class Commodity {
    private Integer commodityId;

    private Integer merchantId;

    private String commodityPicture;

    private String productName;

    private Integer commodityTypeId;

    private String commodityAttribute;

    private BigDecimal commodityPrice;

    private BigDecimal commodityFreight;

    private Integer commodityInventory;

    private Double commodityWeight;

    private Integer commodityStatus;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture == null ? null : commodityPicture.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getCommodityTypeId() {
        return commodityTypeId;
    }

    public void setCommodityTypeId(Integer commodityTypeId) {
        this.commodityTypeId = commodityTypeId;
    }

    public String getCommodityAttribute() {
        return commodityAttribute;
    }

    public void setCommodityAttribute(String commodityAttribute) {
        this.commodityAttribute = commodityAttribute == null ? null : commodityAttribute.trim();
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public BigDecimal getCommodityFreight() {
        return commodityFreight;
    }

    public void setCommodityFreight(BigDecimal commodityFreight) {
        this.commodityFreight = commodityFreight;
    }

    public Integer getCommodityInventory() {
        return commodityInventory;
    }

    public void setCommodityInventory(Integer commodityInventory) {
        this.commodityInventory = commodityInventory;
    }

    public Double getCommodityWeight() {
        return commodityWeight;
    }

    public void setCommodityWeight(Double commodityWeight) {
        this.commodityWeight = commodityWeight;
    }

    public Integer getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Integer commodityStatus) {
        this.commodityStatus = commodityStatus;
    }
}