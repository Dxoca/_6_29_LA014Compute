package compute;

import java.sql.*;
/**
 * 如果有数据变化 就从变化位置 开始往后 迭代

 */

/**
 * 连接数据库...
 *  实例化Statement对象...
 * LA001:1 	LA005:1 	LA011:1 	LA014:1
 * LA001:214 	LA005:1 	LA011:1 	LA014:2
 * LA001:295 	LA005:1 	LA011:1 	LA014:3
 * LA001:415 	LA005:1 	LA011:1 	LA014:4
 * LA001:1129 	LA005:1 	LA011:1 	LA014:5
 * LA001:2588 	LA005:1 	LA011:1 	LA014:6
 * LA001:3381 	LA005:1 	LA011:1 	LA014:7
 * LA001:3525 	LA005:1 	LA011:1 	LA014:8
 * LA001:3686 	LA005:1 	LA011:1 	LA014:9
 * LA001:3713 	LA005:1 	LA011:1 	LA014:10
 * LA001:3807 	LA005:1 	LA011:1 	LA014:11
 * LA001:3871 	LA005:1 	LA011:1 	LA014:12
 * Goodbye!
 */
public class testCompute extends MySQLDemo {

    public static void main(String[] args) {
        linkDB();
    }

    /**
     * 使用 la string存储数据库字段名
     * 增加数据库的字段修改后的可维护性
     */
    static String[] la = {"", "LA001", "LA002", "LA003", "LA004", "LA005", "LA006", "LA007", "LA008", "LA009", "LA010", "LA011", "LA012", "LA013", "LA014", "LA015", "LA016", "LA017"};

    private static void linkDB() {
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();//select
            stmt2 = conn.createStatement();//updata

            // 执行查询
            ResultSet rs = stmt.executeQuery("SELECT * FROM invla WHERE LA001>7");

            // 展开结果集数据库
            int la014_iterate = 0;//迭代 第一条开始 默认上一条0
            while (rs.next()) {
                // 获取对应字段的值
                int LA001 = rs.getInt(la[1]);//key 仅打印需要
                int LA005 = rs.getInt(la[5]);//sql
                int LA011 = rs.getInt(la[11]);
                int LA014 = rs.getInt(la[14]);
//                System.out.print("修改前");
//                la_print(LA001, LA005, LA011, LA014);//打印
                la014_iterate += LA011 * LA005;
                String sql = "UPDATE invla SET LA014=" + la014_iterate + " WHERE LA001=" + LA001;
                //更新LA0014
                int result = stmt2.executeUpdate(sql);// 返回值代表收到影响的行数
                if (result <= 0) {
                    System.out.println("修改失败 key:" + LA001);
                }

//                System.out.print("修改后");
                la_print(LA001, LA005, LA011, la014_iterate);//直接调rs.getInt的话 取得值还是修改之前的？
//                initLA014(conn);//初始化LA014
            }
            //完成后关闭
            rs.close();
            stmt.close();
            stmt2.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    /**
     * 初始化
     *
     * @param conn
     * @throws SQLException
     */
    private static void initLA014(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "UPDATE invla SET LA014=0 ";
        int result = stmt.executeUpdate(sql);// 返回值代表收到影响的行数
        if (result <= 0) {
            System.out.println("init失败");
        }

    }

    /**
     * 打印
     *
     * @param a
     * @param b
     * @param c
     */
    private static void la_print(int key, int a, int b, int c) {
        System.out.print(la[1] + ":" + key + " \t");
        System.out.print(la[5] + ":" + a + " \t");
        System.out.print(la[11] + ":" + b + " \t");
        System.out.print(la[14] + ":" + c + " \t");
        System.out.print("\n");

    }
    /**
     * 不同1：
     * execute可以执行查询语句
     * 然后通过getResultSet，把结果集取出来
     * executeUpdate不能执行查询语句
     * 不同2:
     * execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
     * executeUpdate返回的是int，表示有多少条数据受到了影响
     * ————————————————
     */

}
