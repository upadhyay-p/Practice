package dto;

import java.util.Map;

public class Auction {
    String name;
    Integer minValue;
    Integer maxValue;
    Seller seller;
    Map<String, Integer> BuyerBidMap;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Auction(String name, Integer minValue, Integer maxValue, Seller seller) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.seller = seller;
    }
    public Integer getMinValue() {
        return minValue;
    }
    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }
    public Integer getMaxValue() {
        return maxValue;
    }
    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    public Map<String, Integer> getBuyerBidMap() {
        return BuyerBidMap;
    }
    public void setBuyerBidMap(Map<String, Integer> buyerBidMap) {
        BuyerBidMap = buyerBidMap;
    }
    
}
