package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch07ObjectOrientedDesign.Q7_03_Jukebox1;

public class User {
    private String name;
    private long ID;

    public User(String name, long iD) {
        this.name = name;
        ID = iD;
    }

    public static User addUser(String name, long iD) {
        return new User(name, iD);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public User getUser() {
        return this;
    }
}
