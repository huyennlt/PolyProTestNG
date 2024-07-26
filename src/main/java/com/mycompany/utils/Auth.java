/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.mycompany.entity.NhanVien;


public class Auth {

    // Đối tượng chứa thông tin ng dùng sau khi đăng nhập
    public static NhanVien user = null;

    // Xóa thông tin của ng sử dụng khi có yêu cầu đăng xuất   
    public static void clear() {
        Auth.user = null;
    }

    // Kiểm tra xem đăng nhập hay chưa và trả về đn hay chưa. 
    public static boolean isLogin() {
        return Auth.user != null;
    }

    // Kiểm tra xem có phải là trưởng phòng hay không
    public static boolean isManager() {
        return Auth.isLogin() && user.isVaiTro();
    }
}
