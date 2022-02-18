package Pom.Objects;

public class User {
    private String userName;

    public User(String userName, String password) {
        this.userName = userName;
        Password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;

}