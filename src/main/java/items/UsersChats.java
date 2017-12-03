package items;

import java.util.ArrayList;
import java.util.List;

public class UsersChats {

    public int id;
    public int userId;
    public int chatId;
    public static List<UsersChats> users_chats = new ArrayList<>();

    public UsersChats() { }
    public UsersChats(int id, int userId, int chatId) {
        this.id = id;
        this.userId = userId;
        this.chatId = chatId;
        if(!users_chats.contains(this)) {
            users_chats.add(this);
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getChatId() {
        return chatId;
    }
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public boolean equals(UsersChats us_ch) {
        boolean bool;
        if(us_ch.getId() == this.getId() && us_ch.getUserId() == this.getUserId() && us_ch.getChatId() == this.getChatId()) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }
}
