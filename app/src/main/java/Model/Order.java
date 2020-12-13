package Model;

public class Order {


    private Integer qty;

    private Integer pid;

    public Order(Integer qty, Integer pid) {
        this.qty = qty;
        this.pid = pid;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
