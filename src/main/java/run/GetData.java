package run;

import items.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetData {

    public static List<Chat> chats = new ArrayList<>();
    public static List<Message> messages = new ArrayList<>();
    public static List<News> news = new ArrayList<>();
    public static List<UsersChats> usersChats = new ArrayList<>();
    public static List<Notification> notifications = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    public static void getData() {
        getChatsFromDB();
        getMessagesFromDB();
        getNewsFromDB();
        getUsersChatsFromDB();
        getNotificationsFromDB();
        getUsersFromDB();
    }

    public static void getChatsFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM Chats";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Chat chat = new Chat(result.getInt(1), result.getString(2), result.getDate(3).toString());
                if (!chats.contains(chat)) {
                    chats.add(chat);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void getMessagesFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM UserMessages";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Message message = new Message(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4).toString(), result.getString(5));
                if (!messages.contains(message)) {
                    messages.add(message);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void getNewsFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM News";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                News novelty = new News(result.getInt(1), result.getInt(2), result.getTimestamp(3).toString(), result.getString(4));
                if (!news.contains(novelty)) {
                    news.add(novelty);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void getUsersChatsFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM UsersChats";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                UsersChats userChat = new UsersChats(result.getInt(1), result.getInt(2), result.getInt(3));
                if(!usersChats.contains(userChat)) {
                    usersChats.add(userChat);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void getNotificationsFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM Notifications";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Notification note = new Notification(result.getInt(1), result.getInt(2), result.getString(3));
                if(!notifications.contains(note)) {
                    notifications.add(note);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void getUsersFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM CopyUsers";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                User user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
                if(!users.contains(user)) {
                    users.add(user);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}