package com.kumpel.dom.bot.controller.bdcontroller.dao;

import com.kumpel.dom.bot.controller.bdcontroller.DataBaseConnection;
import com.kumpel.dom.bot.controller.bdcontroller.DataBaseInterface;
import com.kumpel.dom.bot.model.Node;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NodeDAO implements DataBaseInterface<Node> {

    @Override
    public void create(Node node) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO nodes(nodeid, nodename) ");
        sql.append("VALUES (?, ?)");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, node.getId());
            pstmt.setString(2, node.getName());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Node> read() {
        String sql = "SELECT * FROM nodes";

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet result = pstmt.executeQuery();

            List<Node> list = new ArrayList<>();

            while (result.next()) {
                Node row = new Node();
                row.setId(result.getInt("nodeid"));
                row.setName(result.getString("nodename"));
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
    public void update(Node table) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE nodes ");
        sql.append("SET nodename=? ");
        sql.append("WHERE nodeid=?");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setString(1, table.getName());
            pstmt.setInt(2, table.getId());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Node table) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM nodes ");
        sql.append("WHERE nodeid=?");

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
