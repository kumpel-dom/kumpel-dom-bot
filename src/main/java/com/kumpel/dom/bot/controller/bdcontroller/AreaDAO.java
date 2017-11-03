package com.kumpel.dom.bot.controller.bdcontroller;

import com.kumpel.dom.bot.model.Area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO implements DataBaseInterface<Area>{
    @Override
    public void create(Area table) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO areas(areaid, areaname, nodeid) ");
        sql.append("VALUES (?, ?, ?)");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, table.getAreaid());
            pstmt.setString(2, table.getArename());
            pstmt.setInt(3, table.getForeignid());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Area> read() {
        String sql = "SELECT * FROM areas";

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet result = pstmt.executeQuery();

            List<Area> list = new ArrayList<>();

            while (result.next()) {
                Area row = new Area();
                row.setId(result.getInt("areaid"));
                row.setName(result.getString("areaname"));
                row.setForeignid(result.getInt("nodeid"));
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
    public void update(Area table) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE areas ");
        sql.append("SET areaname=? ");
        sql.append("WHELE areaid=?");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setString(1, table.getArename());
            pstmt.setInt(2, table.getAreaid());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Area table) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM areas ");
        sql.append("WHERE areaid=?");

        try (Connection conn = DataBaseConnection.connection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setInt(1, table.getAreaid());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
