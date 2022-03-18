/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.jdbcUtils;
import com.mycompany.pojo.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CategoryService {

    public List<Category> getCategories() throws SQLException {
        List<Category> results = new ArrayList<>();

        try ( Connection conn = jdbcUtils.getConn()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");

            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                results.add(c);
            }
        }

        return results;
    }
}
