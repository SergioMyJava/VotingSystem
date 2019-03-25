package System;
import Users.Candidate;

import java.sql.SQLException;
import java.util.Scanner;

public class Voting {
    VotingSystem votingSystem;
    Candidate candidate;
    private String title;


    public Voting(String title,VotingSystem votingSystem){
        this.votingSystem = votingSystem;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public Candidate addCandidate(String NameCandidate) throws SQLException {
        String query = "SELECT NameCandidate FROM election.candidate WHERE NameCandidate = " + "'" + NameCandidate + "'";

        if (BDateMySql.query(query).next()) {
            System.out.println("Уже есть такой");
        } else {
            BDateMySql.update("INSERT INTO election.candidate (NameCandidate,Voices) VALUES ('" + NameCandidate + "' ,'"+ 0 +"')");
            Candidate candidate = new Candidate(NameCandidate);
            this.candidate = candidate;
        }
        return candidate;
    }

    public void getListCandidate() throws SQLException {
        String guery = "SELECT * FROM election.voters";

        while (BDateMySql.query(guery).next()) {
            int id = BDateMySql.query(guery).getInt("id");
            String NameCandidate = BDateMySql.query(guery).getString("NameCandidate");

            System.out.println(id + ". " + NameCandidate);
        }
    }

    public void beginVoid(String Login,String Password) throws SQLException {

        if (votingSystem.findUser(Login, Password)) {
            getListCandidate();
            Scanner in = new Scanner(System.in);
            int choose = Integer.parseInt(in.nextLine());
            String guery ="update election.candidate set Voices = Voices+1 where id = '" + choose + "' ";
            BDateMySql.update(guery);
        }
    }
}
