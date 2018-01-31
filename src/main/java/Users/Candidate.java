package Users;

public class Candidate {
    private String name;
    private int voises = 0;
    public Candidate(String name){
        this.name = name;

    }
    @Override
    public String toString() {
        return "\t" + name + voises;
    }
}
