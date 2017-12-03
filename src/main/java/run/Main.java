package run;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import test.ChatsTest;

public class Main {
    public static void main(String[] args) {
        Connect.connect();
        try {
            testMigrations();
            System.out.println("All migrations successful...");
        }
        catch (LiquibaseException ex) {
            ex.printStackTrace();
        }
        Connect.disconnect();
    }
    public static void testMigrations() throws DatabaseException, LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));

        Liquibase create_tables = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/1.0-create-tables.xml",new FileSystemResourceAccessor(), database );
        Liquibase set_data = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/3.0-set-data.xml",new FileSystemResourceAccessor(), database );
        Liquibase set_row = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/3.1-set-row.xml",new FileSystemResourceAccessor(), database );
        Liquibase update_row  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/3.2-update-row.xml",new FileSystemResourceAccessor(), database );
        Liquibase query_join  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/3.3-query-join.xml",new FileSystemResourceAccessor(), database );
        Liquibase rename_column  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/5.0-rename-column.xml",new FileSystemResourceAccessor(), database );
        Liquibase new_column  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/5.1-new-column.xml",new FileSystemResourceAccessor(), database );
        Liquibase new_table  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/5.2-new-table.xml",new FileSystemResourceAccessor(), database );
        Liquibase delete_row  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/4.1-delete-row.xml",new FileSystemResourceAccessor(), database );
        Liquibase delete_all_rows  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/4.0-delete-all-rows.xml",new FileSystemResourceAccessor(), database );
        Liquibase drop_tables  = new liquibase.Liquibase("D:/Projects/Projects_JAVA/JDBC/src/main/resources/liquibase/2.0-drop-tables.xml",new FileSystemResourceAccessor(), database );

        //create_tables.update(new Contexts(), new LabelExpression());
        //set_data.update(new Contexts(), new LabelExpression());

        JUnitCore junit = new JUnitCore();
        Result result = junit.run(ChatsTest.class);

        /**
        set_row.update(new Contexts(), new LabelExpression());
        update_row.update(new Contexts(), new LabelExpression());
        query_join.update(new Contexts(), new LabelExpression());
        rename_column.update(new Contexts(), new LabelExpression());
        new_column.update(new Contexts(), new LabelExpression());
        new_table.update(new Contexts(), new LabelExpression());
        delete_row.update(new Contexts(), new LabelExpression());
        delete_all_rows.update(new Contexts(), new LabelExpression());
        drop_tables.update(new Contexts(), new LabelExpression()); */
    }
}
