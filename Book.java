import java.util.List;

public class Book {
    private String author;
    private String title;
    private String genre;
    private String briefDescription;
    private int year;
    private double rating;
    private String isbn;
    private List<String> keywords;


    public Book(String title, String author, int year, String genre, String isbn,
                String briefDescription, double rating, List<String> keywords) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.briefDescription = briefDescription;
        this.isbn = isbn;
        this.keywords = keywords;
    }


    public String getTitle() {

        return title;
    }
    public String getBriefDescription() {

        return briefDescription;
    }
    public String getIsbn() {

        return isbn;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public double getRating(){

        return rating;
    }
    public int getYear(){
        return year;
    }
    public List<String>getKeywords(){
        return keywords;
    }

    @Override
    public String toString() {
        return title + " by " + author + "  (" + year + "), rating: " + rating + ", ISBN : " + isbn
                + "\n " + briefDescription + "\nKeywords" + String.join(",",keywords);
    }

}
