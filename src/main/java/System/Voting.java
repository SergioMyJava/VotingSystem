package System;
import Users.Candidate;

import java.sql.SQLException;
import java.util.Scanner;

public class Voting {
    VotingSystem votingSystem;
    Candidate candidate;
    private String title;


    Voting(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public Candidate addCandidate(String NameCandidate) throws SQLException {
        String query = "SELECT candidate FROM election.candidatetest WHERE candidate = " + "'" + NameCandidate + "'";

        if (BDateMySql.query(query).next()) {
            System.out.println("Уже есть такой");
        } else {
            BDateMySql.update("INSERT INTO election.candidatetest (candidate,voices) VALUES ('" + NameCandidate + "' ,'"+ 0 +"')");
            Candidate candidate = new Candidate(NameCandidate);
            this.candidate = candidate;
        }
        return candidate;
    }

    public void getListCandidate() throws SQLException {
        String guery = "SELECT * FROM election.voterstest";

        while (BDateMySql.query(guery).next()) {
            int id = BDateMySql.query(guery).getInt("id_candidateTest");
            String n = BDateMySql.query(guery).getString("candidate");

            System.out.println(id + ". " + n);
        }
    }
    public void beginVoid(String Login,String Password) throws SQLException {

        if (votingSystem.findUser(Login, Password)) {
            getListCandidate();
            Scanner in = new Scanner(System.in);
            int choose = Integer.parseInt(in.nextLine());
            String guery ="update election.candidatetest set voices = voices+1 where id_candidateTest = '" + choose + "' ";
            BDateMySql.update(guery);
        }
    }
}
