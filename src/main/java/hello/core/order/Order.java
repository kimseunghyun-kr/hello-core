package hello.core.order;
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountedPrice;
    public Order(Long memberId, String itemName, int itemPrice, int
            discountedPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountedPrice = discountedPrice;
    }
    public int calculatePrice() {
        return itemPrice - discountedPrice;
    }
    public Long getMemberId() {
        return memberId;
    }
    public String getItemName() {
        return itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public int getDiscountedPrice() {
        return discountedPrice;
    }
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}