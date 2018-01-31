package Users;

public class Admin {
    private String name;
    private String login;
    private String password;
    private int id;

    public Admin(String name, String login, String password, int id) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

