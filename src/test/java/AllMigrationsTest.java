import items.*;
import liquibase.exception.LiquibaseException;
import org.junit.*;
import run.Connect;
import run.GetData;
import run.Main;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class AllMigrationsTest {

    public static List<Chat> chats = new ArrayList<>();
    public static List<Message> messages = new ArrayList<>();
    public static List<News> news = new ArrayList<>();

    @BeforeClass
    public static void onlyOnce() {
        Connect.connect();
    }

    @AfterClass
    public static void afterTest() {
        Connect.disconnect();
    }

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException {
        Main.create_tables();
        DatabaseMetaData md = Connect.connection.getMetaData ();
        ResultSet rs = md.getTables ("messanger_db", "", "%", null);
        while (rs.next ())
            System.out.println (rs.getString (3)); // столбец 3 = имя таблицы
        rs.close ();
    }

    @Test
    public void setDataTest1() throws SQLException, LiquibaseException {
        Main.set_data();
        GetData.getData();
        Chat chat = new Chat(1, "KPI Chan", "2010-05-10");
        assertEquals(true, chat.equals(GetData.chats.get(0)));
    }

    @Test
    public void setDataTest2() {
        Message message = new Message(1, 1, 1, "2014-05-23 19:52:10.0", "Привет!");
        assertEquals(true, message.equals(GetData.messages.get(0)));
    }

    @Test
    public void setDataTest3() {
        News news = new News(2, 2, "2015-04-23 19:48:10.0", "Голосование за ГБ2");
        assertEquals(true, news.equals(GetData.news.get(1)));
    }

    @Test
    public void setRowTest() {

    }

    @Test
    public void updateRowTest() {

    }

    @Test
    public void queryJoinTest() {

    }

    @Test
    public void renameColumnTest() {

    }

    @Test
    public void copyTableTest() {

    }

    @Test
    public void dropTablseTest() {

    }
}
