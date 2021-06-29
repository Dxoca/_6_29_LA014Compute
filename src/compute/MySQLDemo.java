package compute;

import java.sql.*;

public class MySQLDemo {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

    //     MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/_6_29?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";


//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            System.out.println("连接数据库...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//
//            // 执行查询
//            String sql;
//            sql = "SELECT * FROM invla";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while (rs.next()) {
//                // 通过字段检索
//                int LA014 = rs.getInt(la[14]);
//                String LA011 = rs.getString(la[11]);
//                String LA005 = rs.getString(la[05]);
//
//                // 输出数据
//                System.out.print(la[14] + ":" + LA014 + " ");
//                System.out.print(la[11] + ":" + LA011 + " ");
//                System.out.print(la[05] + ":" + LA005 + " ");
//                System.out.print("\n");
//            }
////             完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        } catch (Exception e) {
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            try {
//                if (stmt != null) stmt.close();
//            } catch (SQLException se2) {
//            }// 什么都不做
//            try {
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Goodbye!");
//    }
}
