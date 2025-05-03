import java.util.List;

public class Book {

    private String author;
    private String title;
    private String genre;
    private String briefDescription;
    private int year;
    private double rating;
    private int uniqueNumber;
    private List<String> keywords;


    public Book(String author,String title,String genre,String briefDescription, int year,double rating,
                int uniqueNumber,List<String> keywords){

        this.author = author;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.briefDescription = briefDescription;
        this.uniqueNumber = uniqueNumber;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

}
