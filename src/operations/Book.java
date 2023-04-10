package operations;
/**
 * @author Alexandra
 *
 */

public class Book {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String titlu;
    /**
     *
     */
    private String autor;
    /**
     *
     */
    private int nrbucati;
    /**
     *
     */
    private double pret;
    /**
     * @param id is the id of a book
     * @param titlu is the title of a book
     * @param autor is the author of a book
     * @param nrbucati is the quantity of books
     * @param pret is the  price of a book
     */
    public Book(int id, String titlu, String autor, int nrbucati, double pret) {
        super();
        this.setId(id);
        this.setTitlu(titlu);
        this.setAutor(autor);
        this.setNrbucati(nrbucati);
        this.setPret(pret);
    }
    /**
     * @return of the getters
     */
    public int getId() {
        return id;
    }
    /**
     * @param id is the id of a book
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return returns the id
     */
    public String getTitlu() {
        return titlu;
    }
    /**
     * @param titlu is the title of a book
     */
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }
    /**
     * @return returns the author
     */
    public String getAutor() {
        return autor;
    }
    /**
     * @param autor is the author of a book
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * @return returns the quantity
     */
    public int getNrbucati() {
        return nrbucati;
    }
    /**
     * @param nrbucati is the quantity of books
     */
    public void setNrbucati(int nrbucati) {
        this.nrbucati = nrbucati;
    }
    /**
     * @return returns the price
     */
    public double getPret() {
        return pret;
    }
    /**
     * @param pret is the  price of a book
     */
    public void setPret(double pret) {
        this.pret = pret;
    }


}
