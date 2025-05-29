import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class SystemLibrary {
    private static List<Book> books = new ArrayList<>();
    private List<User>users = new ArrayList<>();
    private User currentUser = null;
    private static boolean fileOpen = false;
    private static String currentFilePath = null;


    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                currentUser = user;
                System.out.println("Welcome " + user.getUsername());
                return true;
            }
        }
        System.out.println("Invalid username or password");
        return false;
    }

    public void logout() {
        if (currentUser != null) {
            System.out.println("Goodbye " + currentUser.getUsername());
            currentUser = null;
        }
    }

    private boolean saveUsers() {
        return true;
    }
    public boolean addUser(String username, String password, boolean isAdmin){
        if(username == null || password == null){
            return false;
        }
        users.add(new User(username, password, isAdmin));
        return saveUsers();
    }

    public boolean removeUser(String username){
        if(username == null){
            return false;
        }
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                users.remove(user);
                return saveUsers();
            }
        }
        return false;
    }

    private void addAdmin() {
        boolean hasAdmin = false;
        for (User user : users) {
            if (user.isAdmin()) {
                hasAdmin = true;
                break;
            }
        }
        if (!hasAdmin) {
            users.add(new User("admin", "i<3c++", true));
            saveUsers();
        }
    }


    public static void addBook(String title, String author, int year, String genre, String isbn, String
            briefDescription, double rating, List<String> keywords) {
        books.add(new Book(title,author,year,genre,isbn,briefDescription,rating,keywords));
        System.out.println("Book added: " + title + " by " + author + "publishing year: "+ year +
                "genre: " + genre + "ISBN " + isbn + "\nDescription: " + briefDescription +
                "rated " + rating);
    }

    public SystemLibrary() {
        this.books = books != null ? new ArrayList<>(books) : new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Book getIsbn(String isbn) {
        if (isbn == null) {
           System.out.println("ISBN can't be null");
        }
        for (Book book : books) {
            if (isbn.equals(book.getIsbn())) {
                return book;
            }
        }
        return null;
    }

    public List<Book> sortByTitle(boolean ascending) {
        List<Book> sorted = new ArrayList<>(books);
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        sorted.sort(comparator);
        return sorted;
    }

    public List<Book> sortByAuthor(boolean ascending) {
        List<Book> sorted = new ArrayList<>(books);
        Comparator<Book> comparator = Comparator.comparing(Book::getAuthor);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        sorted.sort(comparator);
        return sorted;
    }

    public List<Book> sortByYear(boolean ascending) {
        List<Book> sorted = new ArrayList<>(books);
        Comparator<Book> comparator = Comparator.comparingInt(Book::getYear);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        sorted.sort(comparator);
        return sorted;
    }

    public List<Book> sortByRating(boolean ascending) {
        List<Book> sorted = new ArrayList<>(books);
        Comparator<Book> comparator = Comparator.comparingDouble(Book::getRating);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        sorted.sort(comparator);
        return (List<Book>) sorted;
    }


    public boolean isFileOpen() {
        return fileOpen;
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public static void openFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            books = (List<Book>) ois.readObject();
            fileOpen = true;
            currentFilePath = path;
            System.out.println("Opened " + path);
        } catch (Exception e) {
            System.out.println("Failed to open " + e.getMessage());
        }
    }

    public static void saveFile() {
        if (!fileOpen || currentFilePath == null) {
            System.out.println("There aren't any open file");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(currentFilePath))) {
            oos.writeObject(books);
            System.out.println("Saved " + currentFilePath);
        } catch (Exception e) {
            System.out.println("Error saving " + e.getMessage());
        }
    }

    public static void saveFileAs(String newPath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newPath))) {
            oos.writeObject(books);
            currentFilePath = newPath;
            fileOpen = true;
            System.out.println("Saved as " + newPath);
        } catch (Exception e) {
            System.out.println("Error saving " + e.getMessage());
        }
    }


    public static void closeFile() {
        books.clear();
        fileOpen = false;
        currentFilePath = null;
        System.out.println("File closed");
    }
}
