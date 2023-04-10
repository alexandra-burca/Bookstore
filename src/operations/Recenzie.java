package operations;

public class Recenzie {

    /**
     *
     */
    public String username;
    /**
     * @return
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
    public int getRating() {
        return rating;
    }
    /**
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * @return
     */
    public String getTextrecenzie() {
        return textrecenzie;
    }
    /**
     * @param textrecenzie
     */
    public void setTextrecenzie(String textrecenzie) {
        this.textrecenzie = textrecenzie;
    }
    /**
     *
     */
    public int bookID;
    /**
     *
     */
    public int rating;
    /**
     *
     */
    public String textrecenzie;
    /**
     * @param username
     * @param bookID
     * @param rating
     * @param textrecenzie
     */
    public Recenzie(String username, int bookID, int rating, String textrecenzie) {
        super();
        this.username = username;
        this.bookID = bookID;
        this.rating = rating;
        this.textrecenzie = textrecenzie;
    }

}
