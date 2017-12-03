package items;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    public int id;
    public String name;
    public String dateOfCreating;
    public List<News> news = new ArrayList<>();
    public List<Message> messages = new ArrayList<>();

    public Chat() { }
    public Chat(int id, String name, String dateOfCreating) {
        this.id = id;
        this.name = name;
        this.dateOfCreating = dateOfCreating;
    }
    public String toString() {
        return String.format("|Id: %d|Name: %s|DateOfCreating: %s|", id, name, dateOfCreating);
    }

    public void setNews(News n) {
        if(!news.contains(n)) {
            news.add(n);
        }
    }
    public News getNews(int id) {
        News n = new News();
        for(int i = 0; i < news.size(); i++) {
            if(news.get(i).id == id) {
                n = news.get(i);
                break;
            }
        }
        return n;
    }
    public void setMessage(Message m) {
        if(!messages.contains(m)) {
            messages.add(m);
        }
    }
    public Message getMesasge(int id) {
        Message m = new Message();
        for(int i = 0; i < messages.size(); i++) {
            if(news.get(i).id == id) {
                m = messages.get(i);
                break;
            }
        }
        return m;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateOfCreating() {
        return dateOfCreating;
    }
    public void setDateOfCreating(String dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public boolean equals(Chat chat) {
        boolean bool;
        if(chat.getId() == this.getId() && chat.getName().equals(this.getName()) && chat.getDateOfCreating().equals(this.getDateOfCreating())) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }
}
