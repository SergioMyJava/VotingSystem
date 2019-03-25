package System;
import Users.Admin;
import Users.User;
import java.sql.*;

public class VotingSystem {
    User user;

    public static Admin authorization(String login, String password) throws SQLException {
        String query = "SELECT name, id FROM election.administrate WHERE login = " + "'" + login + "' AND password = '" + password + "'";

        if (BDateMySql.query(query).next()) {
            int id = BDateMySql.query(query).getInt("id");
            System.out.println("Администратор " + login);
            return new Admin(login, password, id);
        } else {
            System.out.println("Неверные login или password");
        }
        return null;
    }

    public User addUser(String name,String login,String password) throws SQLException {
        String query = "SELECT Login FROM election.voters WHERE Login = " + "'" + login + "'";

        if (BDateMySql.query(query).next()) {
            System.out.println("Уже есть такой");
        } else {
            BDateMySql.update("INSERT INTO election.voters (Name, Login, Password) VALUES ('" + name + "' , '" + login + "' , '" + password + "')");
            User user = new User(name, login, password);
            this.user=user;
        }
        return user;
    }

    public boolean findUser(String Login,String Password) throws SQLException {
        String guery = "SELECT Login,Password FROM election.voters WHERE Login = " + " '"+ Login +"' AND Password ='" +Password+ "' ";

        if(BDateMySql.query(guery).next()){
            int id = BDateMySql.query(guery).getInt("id");
            String name =BDateMySql.query(guery).getString("Name");
            System.out.print("Найден пользователь : "  + id + name + Login);
            return true;
        } else{
            System.out.print("Такой пользователь не зарегестрирован");
            return false;
        }

    }

    public void getResalts() throws SQLException {
        String guery = "SELECT MAX(voices) FROM election.candidate ";
        ResultSet id = BDateMySql.query(guery);
        String gueryLost = "SELECT * FROM election.candidate WHERE Voices = '"+id+"' ";

        while (BDateMySql.query(guery).next()) {
            int idCan = BDateMySql.query(guery).getInt("Namber");
            String name = BDateMySql.query(guery).getString("NameCandidate");
            int voices = BDateMySql.query(guery).getInt("Voices");
            System.out.print("В выборах победил : " + idCan + name + " с количеством голосов - " + voices);
            BDateMySql.closeConnection();
        }
    }
}
