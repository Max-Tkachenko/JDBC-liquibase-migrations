package items;

public class UsersChats {

    public int id;
    public int userId;
    public int chatId;

    public UsersChats(int id, int userId, int chatId) {
        this.id = id;
        this.userId = userId;
        this.chatId = chatId;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public int getChatId() {
        return chatId;
    }

    public boolean equals(UsersChats us_ch) {
        boolean bool = false;
        if(us_ch.getId() == this.getId() && us_ch.getUserId() == this.getUserId() && us_ch.getChatId() == this.getChatId()) {
            bool = true;
        }
        return bool;
    }
}
