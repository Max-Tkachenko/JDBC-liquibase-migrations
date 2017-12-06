package run;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LiquibaseException {
        Connect.connect();
        try {
            testMigrations();
            System.out.println("All migrations successful...");
        } catch (LiquibaseException ex) {
            ex.printStackTrace();
        }
        Connect.disconnect();
    }

    public static void testMigrations() throws LiquibaseException {
        create_tables();
        set_data();
        set_row();
        update_row();
        query_join();
        rename_column();
        new_column();
        new_table();
        delete_row();
        delete_all_rows();
        drop_tables();
    }

    public static void create_tables() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_create_tables = new File(ClassLoader.getSystemResource("liquibase/1.0-create-tables.xml").getFile());
        Liquibase create_tables = new liquibase.Liquibase(change_create_tables.toString(), new FileSystemResourceAccessor(), database);
        create_tables.update(new Contexts(), new LabelExpression());
    }

    public static void set_data() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_set_data = new File(ClassLoader.getSystemResource("liquibase/3.0-set-data.xml").getFile());
        Liquibase set_data = new liquibase.Liquibase(change_set_data.toString(), new FileSystemResourceAccessor(), database);
        set_data.update(new Contexts(), new LabelExpression());
    }

    public static void set_row() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_set_row = new File(ClassLoader.getSystemResource("liquibase/3.1-set-row.xml").getFile());
        Liquibase set_row = new liquibase.Liquibase(change_set_row.toString(), new FileSystemResourceAccessor(), database);
        set_row.update(new Contexts(), new LabelExpression());
    }

    public static void update_row() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_update_row = new File(ClassLoader.getSystemResource("liquibase/3.2-update-row.xml").getFile());
        Liquibase update_row = new liquibase.Liquibase(change_update_row.toString(), new FileSystemResourceAccessor(), database);
        update_row.update(new Contexts(), new LabelExpression());
    }

    public static void query_join() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_join = new File(ClassLoader.getSystemResource("liquibase/3.3-query-join.xml").getFile());
        Liquibase query_join = new liquibase.Liquibase(change_join.toString(), new FileSystemResourceAccessor(), database);
        query_join.update(new Contexts(), new LabelExpression());
    }

    public static void rename_column() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_rename = new File(ClassLoader.getSystemResource("liquibase/5.0-rename-column.xml").getFile());
        Liquibase rename_column = new liquibase.Liquibase(change_rename.toString(), new FileSystemResourceAccessor(), database);
        rename_column.update(new Contexts(), new LabelExpression());
    }

    public static void new_column() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_new_column = new File(ClassLoader.getSystemResource("liquibase/5.1-new-column.xml").getFile());
        Liquibase new_column = new liquibase.Liquibase(change_new_column.toString(), new FileSystemResourceAccessor(), database);
        new_column.update(new Contexts(), new LabelExpression());
    }

    public static void new_table() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_new_table = new File(ClassLoader.getSystemResource("liquibase/5.2-new-table.xml").getFile());
        Liquibase new_table = new liquibase.Liquibase(change_new_table.toString(), new FileSystemResourceAccessor(), database);
        new_table.update(new Contexts(), new LabelExpression());
    }

    public static void delete_row() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_delete_row = new File(ClassLoader.getSystemResource("liquibase/4.1-delete-row.xml").getFile());
        Liquibase delete_row = new liquibase.Liquibase(change_delete_row.toString(), new FileSystemResourceAccessor(), database);
        delete_row.update(new Contexts(), new LabelExpression());
    }

    public static void delete_all_rows() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_delete_rows = new File(ClassLoader.getSystemResource("liquibase/4.0-delete-all-rows.xml").getFile());
        Liquibase delete_all_rows = new liquibase.Liquibase(change_delete_rows.toString(), new FileSystemResourceAccessor(), database);
        delete_all_rows.update(new Contexts(), new LabelExpression());
    }

    public static void drop_tables() throws LiquibaseException{
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_drop_tables = new File(ClassLoader.getSystemResource("liquibase/2.0-drop-tables.xml").getFile());
        Liquibase drop_tables = new liquibase.Liquibase(change_drop_tables.toString(), new FileSystemResourceAccessor(), database);
        drop_tables.update(new Contexts(), new LabelExpression());
    }
}
