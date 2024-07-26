/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.entity.NguoiHoc;
import com.mycompany.utils.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String> {

    final String INSERT_SQL = "insert into NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) values (?,?,?,?,?,?,?,?,?) ";
    final String UPDATE_SQL = " update NguoiHoc set HoTen = ?, NgaySinh = ?, GioiTinh =?, DienThoai=?, Email =?, GhiChu =?, MaNV =?, NgayDK= ? where MaNH = ?";
    final String DELETE_SQL = "DELETE from  NguoiHoc where MaNH =?";
    final String SELECT_ALL_SQL = "select * from NguoiHoc";
    final String SELECT_BY_ID_SQL = "select* from NguoiHoc where MaNH = ?";
    final String SELECT_BY_KEYWORD_AND_KH = "select* from NguoiHoc where HoTen like ? and MaNH NOT IN (Select MaNH from HocVien where MaKH = ?)";
    final String SELECT_BY_KEYWORD = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
    final String SELECT_NOT_IN_COURSE = "select * from NguoiHoc where MaNH NOT IN (Select MaNH from HocVien where MaKH = ?)";

    @Override
    public void insert(NguoiHoc entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaNH(), entity.getHoTen(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getHoTen(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK(), entity.getMaNH());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectById(String id) {
        List<NguoiHoc> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayDK(rs.getDate("NgayDK"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<NguoiHoc> selectNotInCourse(int MaKH) {
        return selectBySql(SELECT_NOT_IN_COURSE, MaKH);
    }

    public List<NguoiHoc> selectByKeyWordAndKH(int MaKH, String keyword) {
        return this.selectBySql(SELECT_BY_KEYWORD_AND_KH, "%" + keyword + "%", MaKH);
    }
    
    public List<NguoiHoc> selectByKeyword(String keyword) {
        return this.selectBySql(SELECT_BY_KEYWORD, "%" + keyword + "%");
    }

}
