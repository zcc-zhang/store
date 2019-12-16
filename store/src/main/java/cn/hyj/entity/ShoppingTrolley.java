package cn.hyj.entity;

public class ShoppingTrolley {
    private Integer shoppingTrolleyId;

    private Integer commodityId;

    private Integer userId;

    private Integer status;

    public Integer getShoppingTrolleyId() {
        return shoppingTrolleyId;
    }

    public void setShoppingTrolleyId(Integer shoppingTrolleyId) {
        this.shoppingTrolleyId = shoppingTrolleyId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}