/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poly.mycompany.dao;

import com.mycompany.dao.ChuyenDeDAO;
import com.mycompany.entity.ChuyenDe;
import com.mycompany.utils.jdbcHelper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({jdbcHelper.class, ChuyenDeDAO.class})
public class ChuyenDeDAOTest {
    
    ChuyenDeDAO chuyenDeDAO;
    ChuyenDeDAO chuyenDeDAOSpy;
    public ChuyenDeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         chuyenDeDAO = new ChuyenDeDAO();
        PowerMockito.mockStatic(jdbcHelper.class);
        chuyenDeDAOSpy = PowerMockito.spy(new ChuyenDeDAO()); //cung cấp giả lập cho jdbc
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)//ném ra ngoại lệ
    public void testInsertWithNullModel() {
        ChuyenDe model = null;
        chuyenDeDAO.insert(model);
    }
    
     @Test(expected = Exception.class)//ném ra ngoại lệ
    public void testInsertWithEmptyModel() {
        ChuyenDe model = new ChuyenDe();
        chuyenDeDAO.insert(model);
    }

    @Test()
    public void testInsertWithValiModel() {

        ChuyenDe model = new ChuyenDe();
        model.setMaCD("01"); //nội dung dả lập
        model.setTenCD("ChuyenDe");
        model.setHocPhi(100);
        model.setThoiLuong(20);
        model.setHinh("hello.jpg");
        model.setMoTa("OK");
        chuyenDeDAO.insert(model);
    }
    
     @Test(expected = Exception.class)
    public void testUpdateWithNullModel() {
        ChuyenDe model = null;
        chuyenDeDAO.update(model);
    }

    @Test(expected = Exception.class)
    public void testUpdateWithEmptyModel() {
        ChuyenDe model = new ChuyenDe();
        chuyenDeDAO.update(model);
    }

    @Test()
    public void testUpdateWithValiModel() {
        ChuyenDe model = new ChuyenDe();
        model.setMaCD("01");
        model.setTenCD("ChuyenDe");
        model.setHocPhi(100);
        model.setThoiLuong(20);
        model.setHinh("hello.jpg");
        model.setMoTa("OK");
        chuyenDeDAO.update(model);
    }

    @Test(expected = Exception.class)
    public void testDeleteWithEmptyId() {
        String MaNV = "";
        chuyenDeDAO.delete(MaNV);
    }

    @Test(expected = Exception.class)
    public void testDeleteWithNullId() {
        String MaNV = null;
        chuyenDeDAO.delete(MaNV);
    }

    @Test()
    public void testDeleteWithValidId() {
        String MaNV = "NV001";
        chuyenDeDAO.delete(MaNV);
    }
    @Test
    public void testSelectAll() {
    }

    @Test
    public void testSelectById() {
    }

    @Test
    public void testSelectBySql() {
    }

    @Test
    public void testSelect() {
    }
    
}
