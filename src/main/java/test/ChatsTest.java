package test;

import items.Chat;
import run.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ChatsTest {

    private Chat chat;
    public static List<Chat> chats = new ArrayList<>();

    @BeforeClass
    public static void onlyOnce() {
        getChatsFromDB();
    }

    @Before
    public void initTest() {
        chat = new Chat();
    }

    @After
    public void afterTest() {
        chat = null;
    }

    @Test
    public void testChat1() {
        Chat chat = new Chat(1, "KPI Chan", "2010-05-10");
        assertEquals(true, chat.equals(chats.get(0)));
        System.out.println("  -- TestChat - 1");
    }

    @Test
    public void testChat2() {
        Chat chat = new Chat(2, "KPI Live", "2009-03-12");
        assertEquals(true, chat.equals(chats.get(1)));
        System.out.println("  -- TestChat - 2");
    }

    public static void getChatsFromDB() {
        try {
            Statement stmt = Connect.connection.createStatement();
            String sql = "SELECT * FROM \"Chats\"";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Chat chat = new Chat(result.getInt(1), result.getString(2), result.getDate(3).toString());
                if(!chats.contains(chat)) {
                    chats.add(chat);
                }
            }
            System.out.printf("-Getting chats successful... [count: %d]\n", chats.size());
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("-Exception in getting Chats from DB!\n");
        }
    }
}
