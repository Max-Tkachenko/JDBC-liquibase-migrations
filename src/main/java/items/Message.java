package items;

public class Message {

    public int id;
    public int userId;
    public int chatId;
    public String date;
    public String context;

    public Message(int id, int userId, int chatId, String date, String context) {
        this.id = id;
        this.userId = userId;
        this.chatId = chatId;
        this.date = date;
        this.context = context;
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
    public String getDate() {
        return date;
    }

    public boolean equals(Message message) {
        boolean bool = false;
        if(message.getId() == this.getId() && message.getUserId() == this.getUserId() && message.getChatId() == this.getChatId()
                && message.getDate().equals(this.getDate())) {
            bool = true;
        }
        return bool;
    }
}
