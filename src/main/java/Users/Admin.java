package Users;

public class Admin {
    private String login;
    private String password;
    private int id;

    public Admin( String login, String password, int id) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

