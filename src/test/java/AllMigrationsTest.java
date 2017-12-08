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
    public static void onlyOnce() throws SQLException, ClassNotFoundException{
        Connect.connect();
    }

    @AfterClass
    public static void afterTest() throws SQLException, ClassNotFoundException {
        Connect.connection.close();
    }

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        DatabaseMetaData md = Connect.connection.getMetaData ();
        ResultSet rs = md.getTables ("messanger_db", "", "%", null);
        while (rs.next ())
            System.out.println (rs.getString (3)); // столбец 3 = имя таблицы
        rs.close ();
    }

    @Test
    public void setDataTest1() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.set_data();
        GetData.getData();
        Chat chat = new Chat(1, "KPI Chan", "2010-05-10");
        assertEquals(true, chat.equals(GetData.chats.get(0)));
    }

    @Test
    public void setDataTest2() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Message message = new Message(1, 1, 1, "2014-05-23 19:52:10.0", "Привет!");
        assertEquals(true, message.equals(GetData.messages.get(0)));
    }

    @Test
    public void setDataTest3() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        News news = new News(1, 1, "2014-05-23 19:52:10.0", "Шутка про ГБ2");
        assertEquals(true, news.equals(GetData.news.get(0)));
    }

    @Test
    public void setDataTest4() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Notification note = new Notification(1, 2, "КР с вышки 22.09");
        assertEquals(true, note.equals(GetData.notifications.get(0)));
    }

    @Test
    public void setDataTest5() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Notification note = new Notification(2, 2, "Лаба СУБД на пятницу");
        assertEquals(true, note.equals(GetData.notifications.get(1)));
    }

    @Test
    public void setRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Main.set_row();
        GetData.getData();
        Chat chat = new Chat(4, "FICT_ACTS", "2010-05-10");
        assertEquals(true, chat.equals(GetData.chats.get(3)));
    }

    @Test
    public void updateRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Main.update_row();
        GetData.getData();
        UsersChats usersChats = new UsersChats(1, 2, 2);
        assertEquals(true, usersChats.equals(GetData.usersChats.get(0)));
    }

    @Test
    public void copyTableTest1() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Main.new_table();
        GetData.getData();
        User user = new User(1, "Max", "Tkachenko", 19);
        assertEquals(true, user.equals(GetData.users.get(0)));
    }

    @Test
    public void copyTableTest2() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Main.new_table();
        GetData.getData();
        User user = new User(2, "Sasha", "Yurchuk", 18);
        assertEquals(true, user.equals(GetData.users.get(1)));
    }

    @Test
    public void deleteRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Main.delete_row();
        GetData.getData();
        boolean bool = true;
        if(GetData.notifications.size() > 2) {
            bool = false;
        }
        assertEquals(true, bool);
    }

    @Test
    public void joinTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.create_tables();
        Main.set_data();
        Main.query_join();
        GetData.getData();
    }

}
