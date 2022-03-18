/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.jdbcUtils;
import com.mycompany.pojo.Choice;
import com.mycompany.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class QuestionService {

    private static final int MAX_CHOICE = 4;

    public void addQuestion(Question q, List<Choice> choices) throws SQLException {
        if (choices.size() == MAX_CHOICE) {
            try ( Connection conn = jdbcUtils.getConn()) {
                conn.setAutoCommit(false);

                PreparedStatement stm1 = conn.prepareStatement("Insert into question(id, content, category_id) values (?, ?, ?)");
                stm1.setString(1, q.getId());
                stm1.setString(2, q.getContent());
                stm1.setInt(3, q.getCategory_id());

                stm1.executeUpdate();

                PreparedStatement stm2 = conn.prepareStatement("Insert into choice(id, content, is_correct, question_id) values (?, ?, ?, ?)");
                for (Choice c : choices) {
                    stm2.setString(1, c.getId());
                    stm2.setString(2, c.getContent());
                    stm2.setBoolean(3, c.isCorrect());
                    stm2.setString(4, c.getQuestion_id());
                    stm2.executeUpdate();
                }

                

                conn.commit();

            }
        }
    }
}
