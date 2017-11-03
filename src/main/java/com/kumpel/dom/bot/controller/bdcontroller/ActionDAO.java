package com.kumpel.dom.bot.controller.bdcontroller;

import com.kumpel.dom.bot.model.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO implements DataBaseInterface<Action> {

    @Override
    public void create(Action table) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO actions(actionid, actionname, areaid) ");
        sql.append("VALUES (?, ?, ?)");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, table.getActionid());
            pstmt.setString(2, table.getActionname());
            pstmt.setInt(3, table.getForeignid());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Action> read() {
        String sql = "SELECT * FROM actions";

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet result = pstmt.executeQuery();

            List<Action> list = new ArrayList<>();

            while (result.next()) {
                Action row = new Action();
                row.setId(result.getInt("actionid"));
                row.setName(result.getString("actionname"));
                row.setForeignid(result.getInt("areaid"));
                list.add(row);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Action table) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE actions ");
        sql.append("SET actionname=? ");
        sql.append("WHELE actionid=?");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setString(1, table.getActionname());
            pstmt.setInt(2, table.getActionid());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Action table) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM actions ");
        sql.append("WHERE actionid=?");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setInt(1, table.getActionid());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
