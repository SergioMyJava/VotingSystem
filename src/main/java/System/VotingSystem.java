package System;
import Users.Admin;
import Users.User;

import java.sql.*;

public class VotingSystem {
    User user;

    public static Admin authorization(String login, String password) throws SQLException {
        String query = "SELECT name, id FROM election.administrate WHERE login = " + "'" + login + "' AND password = '" + password + "'";

        if (BDateMySql.query(query).next()) {
            String name = BDateMySql.query(query).getString("name");
            int id = BDateMySql.query(query).getInt("id");
            System.out.println("Администратор " + login);
            return new Admin(name, login, password, id);
        } else {
            System.out.println("Неверные login или password");
        }
        return null;
    }

    public User addUser(String name,String login,String password) throws SQLException {
        String query = "SELECT loginTest FROM election.votersTest WHERE loginTest = " + "'" + login + "'";

        if (BDateMySql.query(query).next()) {
            System.out.println("Уже есть такой");
        } else {
            BDateMySql.update("INSERT INTO election.votersTest (nameTest, loginTest, passwordTest) VALUES ('" + name + "' , '" + login + "' , '" + password + "')");
            User user = new User(name, login, password);
            this.user=user;
        }
        return user;
    }

    public boolean findUser(String login,String Password) throws SQLException {
        String guery = "SELECT loginTest,passwordTest FROM election.voterstest WHERE loginTest = " + " '"+ login +"' AND passwordTest ='" +Password+ "' ";

        if(BDateMySql.query(guery).next()){
            int id = BDateMySql.query(guery).getInt("idVoters");
            String name =BDateMySql.query(guery).getString("nameTest");
            System.out.print("Найден пользователь : "  + id + name + login);
            return true;

        }
        else{
            System.out.print("Такой пользователь не зарегестрирован");
            return false;
        }

    }
    public void getResalts() throws SQLException {
        String guery = "SELECT MAX(voices) FROM election.candidateTest ";
        ResultSet id = BDateMySql.query(guery);
        String gueryLost = "SELECT * FROM election.candidatetest WHERE voices = '"+id+"' ";

        while (BDateMySql.query(guery).next()) {
            int idCan = BDateMySql.query(guery).getInt("id_candidateTest");
            String name = BDateMySql.query(guery).getString("candidate");
            int voices = BDateMySql.query(guery).getInt("voices");
            System.out.print("В выборах победил : " + idCan + name + " с количеством голосов - " + voices);
            BDateMySql.closeConnection();
        }
    }
}
