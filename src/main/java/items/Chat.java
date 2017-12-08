package items;

public class Chat {

    public int id;
    public String name;
    public String dateOfCreating;

    public Chat(int id, String name, String dateOfCreating) {
        this.id = id;
        this.name = name;
        this.dateOfCreating = dateOfCreating;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDateOfCreating() {
        return dateOfCreating;
    }
    public boolean equals(Chat chat) {
        boolean bool = false;
        if(chat.getId() == this.getId() && chat.getName().equals(this.getName()) && chat.getDateOfCreating().equals(this.getDateOfCreating())) {
            bool = true;
        }
        return bool;
    }
}
