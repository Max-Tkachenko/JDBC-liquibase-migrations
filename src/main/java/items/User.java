package items;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int id;
    public String name;
    public String surname;
    public int age;
    public List<Message> messages = new ArrayList<>();
    public List<Notification> notifications = new ArrayList<>();

    public User() {}
    public User(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String toString() {
        return String.format("|Id: %d|Name: %s|Surname: %s|Age: %d|", id, name, surname, age);
    }

    public void setMessage(Message m) {
        if(!messages.contains(m)) {
            messages.add(m);
        }
    }
    public Message getMessage(int id) {
        Message m = new Message();
        for(int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getId() == id) {
                m = messages.get(i);
                break;
            }
        }
        return m;
    }
    public void setNotification(Notification n) {
        if(!notifications.contains(n)) {
            notifications.add(n);
        }
    }
    public Notification getNotification(int id) {
        Notification n = new Notification();
        for(int i = 0; i < notifications.size(); i++) {
            if(notifications.get(i).getId() == id) {
                n = notifications.get(i);
                break;
            }
        }
        return n;
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(User user) {
        boolean bool;
        if(user.getId() == this.getId() && user.getName().equals(this.getName()) && user.getSurname().equals(this.getSurname())
                && user.getAge() == this.getAge()) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }
}
