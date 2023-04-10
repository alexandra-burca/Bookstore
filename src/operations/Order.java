package operations;

public class Order {
    /**
     *
     */
    private int orderID;
    /**
     *
     */
    private int userID;
    /**
     *
     */
    private int bookID;
    /**
     *
     */
    private int quantity;
    /**
     * @param orderID
     * @param userID
     * @param bookID
     * @param quantity
     */
    public Order(int orderID, int userID, int bookID, int quantity) {
        super();
        this.setOrderID(orderID);
        this.setUserID(userID);
        this.setBookID(bookID);
        this.setQuantity(quantity);
    }
    /**
     * @return
     */
    public int getOrderID() {
        return orderID;
    }
    /**
     * @param orderID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    /**
     * @return
     */
    public int getUserID() {
        return userID;
    }
    /**
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
    /**
     * @return
     */
    public int getBookID() {
        return bookID;
    }
    /**
     * @param bookID
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    /**
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
