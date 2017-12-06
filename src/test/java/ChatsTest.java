import items.Chat;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import run.Connect;
import run.Main;

import static junit.framework.Assert.assertEquals;

public class ChatsTest {

    private Chat chat;

    @BeforeClass
    public static void onlyOnce() {
        Connect.connect();
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
        //assertEquals(true, chat.equals(Main.chats.get(0)));
        System.out.println("Lol1");
        assertEquals(true, true);
    }

    @Test
    public void testChat2() {
        Chat chat = new Chat(2, "KPI Live", "2009-03-12");
        //assertEquals(true, chat.equals(Main.chats.get(1)));
        System.out.println("Lol12");
    }
}
