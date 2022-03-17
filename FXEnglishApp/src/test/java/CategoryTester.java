/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
import com.mycompany.conf.jdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.*;

public class CategoryTester {
    private static Connection conn;
    
    @BeforeAll
    public static void beforeAll() throws SQLException {
        conn = jdbcUtils.getConn();
    }
    
    @AfterAll
    public static void afterAll() throws SQLException {
        if (conn != null)
            conn.close();
    }
    
    @Test
    public void testQuantity() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM category");
        
        while (rs.next()) {
            String name = rs.getString("name");
            System.out.println(name);
        }
    }
    
    @Test
    public void testUnique() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM category");
        
        List <String> kq = new ArrayList<>();
        
        while (rs.next()) {
            String name = rs.getString("name");
            kq.add(name);
        }
        
        Set<String> kq2 = new HashSet<>(kq);
        
        Assertions.assertEquals(kq.size(), kq2.size());
    }
}
