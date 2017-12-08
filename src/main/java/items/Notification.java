package items;

public class Notification {

    public int id;
    public int userId;
    public String context;

    public Notification(int id, int userId, String context) {
        this.id = id;
        this.userId = userId;
        this.context = context;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public String getContext() {
        return context;
    }

    public boolean equals(Notification note) {
        boolean bool = false;
        if(note.getId() == this.getId() && note.getUserId() == this.getUserId() && note.getContext().equals(this.getContext())) {
            bool = true;
        }
        return bool;
    }
}
