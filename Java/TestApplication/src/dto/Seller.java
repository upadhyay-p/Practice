package dto;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    String name;
    List<Auction> auctionList;
    public Seller(String name) {
        this.name = name;
        this.auctionList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Auction> getAuctionList() {
        return auctionList;
    }
    public void setAuctionList(List<Auction> auctionList) {
        this.auctionList = auctionList;
    }
}
