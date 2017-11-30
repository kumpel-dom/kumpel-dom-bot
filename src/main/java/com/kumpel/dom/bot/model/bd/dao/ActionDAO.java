package com.kumpel.dom.bot.model.bd.dao;

import com.kumpel.dom.bot.model.bd.DataBaseConnection;
import com.kumpel.dom.bot.model.bd.DataBaseInterface;
import com.kumpel.dom.bot.controller.cmdcontroller.Sync;
import com.kumpel.dom.bot.model.pojo.Action;
import com.mysql.jdbc.CommunicationsException;

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
        sql.append("INSERT INTO actions(actionid, actionname, areaid, state) ");
        sql.append("VALUES (?, ?, ?, ?)");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, table.getId());
            pstmt.setString(2, table.getName());
            pstmt.setInt(3, table.getId());
            pstmt.setString(4, table.getState());
            pstmt.executeUpdate();
        } catch (CommunicationsException e) {
            Sync.exc = e;
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
                row.setForeignId(result.getInt("areaid"));
                row.setState(result.getString("state"));
                list.add(row);
            }
            return list;
        } catch (CommunicationsException e) {
            Sync.exc = e;
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
        sql.append("SET actionname=?, ");
        sql.append("state=? ");
        sql.append("WHERE actionid=?");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setString(1, table.getName());
            pstmt.setString(2, table.getState());
            pstmt.setInt(3, table.getId());
            pstmt.execute();
        } catch (CommunicationsException e) {
            Sync.exc = e;
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

            pstmt.setInt(1, table.getId());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
