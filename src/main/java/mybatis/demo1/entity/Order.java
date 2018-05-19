package mybatis.demo1.entity;

public class Order {
    private int id;
    private String numbering;
    private String orderTime;
    private int userId;

    public Order(String numbering, String orderTime, int userId) {
        this.numbering = numbering;
        this.orderTime = orderTime;
        this.userId = userId;
    }

    public Order(int id, String numbering, String orderTime, int userId) {
        this.id = id;
        this.numbering = numbering;
        this.orderTime = orderTime;
        this.userId = userId;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", numbering='" + numbering + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}
