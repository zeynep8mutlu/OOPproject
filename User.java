public class User {
    private String username;
    private String password;
    private boolean isAdmin;


    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    public String getUsername() {
        return username;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    @Override
    public String toString(){
        return "Username: "+ username + "\nUser Type: " + (isAdmin ? "admin" : "client");
    }

}
