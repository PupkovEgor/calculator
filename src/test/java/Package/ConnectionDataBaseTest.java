package Package;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDataBaseTest {

    LogInReg cDB;
    Connection con;

    @Before
    public void beforeTest(){
        cDB = new LogInReg();
    }

    @Test
    public void test(){
        con = cDB.getConnection();
        assertNotNull(con);
    }

    @After
    public void afterTest(){
        try{
            if (con!=null){
                con.close();
            }
        }
        catch (SQLException sqEx){
            System.out.println(sqEx.getErrorCode());
        }
    }

}
