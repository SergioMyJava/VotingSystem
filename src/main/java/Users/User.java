package Users;

public class User {
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Пользователь :"  + name + "\t" + " login :"  + login;
    }
}

