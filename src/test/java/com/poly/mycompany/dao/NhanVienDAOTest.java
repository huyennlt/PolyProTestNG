/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poly.mycompany.dao;

import com.mycompany.dao.NhanVienDAO;
import com.mycompany.entity.NhanVien;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class NhanVienDAOTest {
    
    public NhanVienDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        NhanVien entity = null;
        NhanVienDAO instance = new NhanVienDAO();
        instance.insert(entity);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        NhanVien entity = null;
        NhanVienDAO instance = new NhanVienDAO();
        instance.update(entity);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        NhanVienDAO instance = new NhanVienDAO();
        instance.delete(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        NhanVienDAO instance = new NhanVienDAO();
        List<NhanVien> expResult = null;
        List<NhanVien> result = instance.selectAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectById() {
        System.out.println("selectById");
        String id = "";
        NhanVienDAO instance = new NhanVienDAO();
        NhanVien expResult = null;
        NhanVien result = instance.selectById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectBySql() {
        System.out.println("selectBySql");
        String sql = "";
        Object[] args = null;
        NhanVienDAO instance = new NhanVienDAO();
        List<NhanVien> expResult = null;
        List<NhanVien> result = instance.selectBySql(sql, args);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
