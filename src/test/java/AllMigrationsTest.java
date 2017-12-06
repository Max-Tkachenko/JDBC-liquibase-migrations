import items.*;
import liquibase.exception.LiquibaseException;
import org.junit.*;
import run.Connect;
import run.GetData;
import run.Main;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;

public class AllMigrationsTest {

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
        Connect.connect();
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
    public void setDataTest2() throws SQLException, LiquibaseException {
        Main.create_tables();
        Main.set_data();
        Message message = new Message(1, 1, 1, "2014-05-23 19:52:10.0", "Привет!");
        assertEquals(true, message.equals(GetData.messages.get(0)));
    }

    @Test
    public void setDataTest3() throws SQLException, LiquibaseException {
        Main.create_tables();
        Main.set_data();
        News news = new News(1, 1, "2014-05-23 19:52:10.0", "Шутка про ГБ2");
        assertEquals(true, news.equals(GetData.news.get(0)));
    }

    @Test
    public void setRowTest() throws SQLException, LiquibaseException {
        Main.create_tables();
        Main.set_data();
        Main.set_row();
        GetData.getData();
        Chat chat = new Chat(3, "FICT online", "2013-12-24");
        assertEquals(true, chat.equals(GetData.chats.get(3)));
    }

    @Test
    public void updateRowTest() throws SQLException, LiquibaseException {
        Main.create_tables();
        Main.set_data();
        Main.update_row();
        GetData.getData();
        News news = new News(2, 2, "2017-12-06 22:19:00.0", "Голосование за городской бюджет");
        assertEquals(true, news.equals(GetData.news.get(1)));
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
