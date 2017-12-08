package items;

public class News {

    public int id;
    public int chatId;
    public String dateOfCreating;
    public String context;

    public News(int id, int chatId, String dateOfCreating, String context) {
        this.id = id;
        this.chatId = chatId;
        this.dateOfCreating = dateOfCreating;
        this.context = context;
    }

    public int getId() {
        return id;
    }
    public int getChatId() {
        return chatId;
    }
    public String getDateOfCreating() {
        return dateOfCreating;
    }
    public String getContext() {
        return context;
    }

    public boolean equals(News news) {
        boolean bool = false;
        if(news.getId() == this.getId() && news.getChatId() == this.getChatId() && news.getDateOfCreating().equals(this.getDateOfCreating())
                && news.getContext().equals(this.getContext())) {
            bool = true;
        }
        return bool;
    }
}
