package Main;

import java.sql.*;
import System.*;



public class App{
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String url = "jdbc:mysql://localhost:3306/election"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";

    public static void main( String[] args )throws SQLException{
        /*
        VotingSystem testOne = new VotingSystem();
        Voting testNext = new Voting("Voting 2017");
        testNext.addCandidate("Patapov");
        testNext.addCandidate("Barakabramovich");
        testOne.addUser("Misha","mihan","12345");
        testOne.addUser("Valera","bimba","5454");
        testOne.addUser("Kosta","ginger","3636");
        */
        VotingSystem testOne = new VotingSystem();
        Voting testNext = new Voting("Voting 2017",testOne);
        testNext.beginVoid("bimba","5454");
    }
}
