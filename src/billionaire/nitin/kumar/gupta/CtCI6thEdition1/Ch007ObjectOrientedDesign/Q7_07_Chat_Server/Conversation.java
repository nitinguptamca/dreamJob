package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch007ObjectOrientedDesign.Q7_07_Chat_Server;

import java.util.ArrayList;

public abstract class Conversation {
    protected ArrayList<User> participants = new ArrayList<User>();
    protected int id;
    protected ArrayList<Message> messages = new ArrayList<Message>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public boolean addMessage(Message m) {
        messages.add(m);
        return true;
    }

    public int getId() {
        return id;
    }
}
