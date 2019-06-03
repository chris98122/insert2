package src;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ThreadWrite extends Thread {
    private Thread t;
    private String threadName;

    private String url = "jdbc:mysql://localhost:3306/myisamhireapp?useServerPrepStmts=false&rewriteBatchedStatements=true&useUnicode=true&amp&serverTimezone=GMT";
    private String user = "root";
    private String password = "root";


    ThreadWrite (String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);

        long sum = 0;
        try {
            long begin = 1;
            long end = begin + 1000;///每次循环插入的数据量

            BigInteger applicant_id = new BigInteger("310103199210102000");

            //定义连接、statement对象
            Connection conn = null;
            PreparedStatement pstm = null;

            int corp_id = 1;
            {
                //加载jdbc驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                //连接mysql
                conn = DriverManager.getConnection(url, user, password);
                //将自动提交关闭
                // conn.setAutoCommit(false);
                //编写sql
                String sql = "INSERT INTO applicant_to_corp VALUES (?,?,?,?)ON DUPLICATE KEY UPDATE Follows= true,Bans= false ";

                //预编译sql
                pstm = conn.prepareStatement(sql);
                //开始总计时
                long tmp_sum = 0;
                //循环10次，每次1000数据，一共10~50万

                applicant_id = new BigInteger("310103199210102000");
                for (int i = 0; i < 10; i++) {
                    //开始循环
                    long bTime = System.currentTimeMillis();
                    while (begin < end) {
                        int num = 20;
                        sum += num;
                        tmp_sum += num;
                        if (tmp_sum >= 99900)//十万个applicant
                        {
                            tmp_sum = 0;
                            applicant_id = new BigInteger("310103199210102000");
                        }
                        for (int j = 0; j < num; j++) {
                            applicant_id = applicant_id.add(new BigInteger("1"));
                            pstm.setString(1, applicant_id.toString());

                            //  System.out.println(applicant_id.toString());
                            pstm.setInt(2, corp_id);
                            Boolean a = RandomUtils.nextInt(0, 100) % 99 == 1;
                            pstm.setBoolean(3, !a);
                            pstm.setBoolean(4, a);
                            pstm.addBatch();
                        }
                        corp_id++;
                        begin++;
                    }
                    end += 1000;
                    //关闭分段计时

                    pstm.executeBatch();
                    long eTime = System.currentTimeMillis();
                    //输出
                    System.out.println(threadName +"成功插入" + sum + "条applicant_to_corp 数据耗时：" + (eTime - bTime));
                }
//                //提交事务
//                conn.commit();
                //边界值自增10W
                //关闭总计时
                long eTime1 = System.currentTimeMillis();
                //输出
                System.out.println(threadName +"插入applicant_to_corp" + sum + "数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        long eTime1 = System.currentTimeMillis();
        //输出
        System.out.println(threadName +"插入applicant_to_corp" + sum + "数据"+ (eTime1 ));

        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class ThreadRead extends Thread {
    private Thread t;
    private String threadName;

    private String url = "jdbc:mysql://localhost:3306/myisamhireapp?useUnicode=true&amp&serverTimezone=GMT";
    private String user = "root";
    private String password = "root";


    ThreadRead (String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);

        long sum = 0;
        try {
            long begin = 1;
            long end = begin + 1000;///每次循环插入的数据量

            BigInteger applicant_id = new BigInteger("310103199210102000");

            //定义连接、statement对象
            Connection conn = null;
            PreparedStatement pstm = null;

            int corp_id = 1;
            {
                //加载jdbc驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                //连接mysql
                conn = DriverManager.getConnection(url, user, password);
                //将自动提交关闭
                // conn.setAutoCommit(false);
                //编写sql
                String sql = "select * from applicant_to_corp where indentificationID=? ";

                //预编译sql
                pstm = conn.prepareStatement(sql);
                //开始总计时
                long tmp_sum = 0;
                //循环10次，每次1000数据，一共10~50万

                applicant_id = new BigInteger("310103199210102000");
                for (int i = 0; i < 10; i++) {
                    //开始循环
                    long bTime = System.currentTimeMillis();
                    while (begin < end) {
                        int num = 20;
                        sum += num;
                        tmp_sum += num;
                        if (tmp_sum >= 99900)//十万个applicant
                        {
                            tmp_sum = 0;
                            applicant_id = new BigInteger("310103199210102000");
                        }
                        for (int j = 0; j < num; j++) {
                            applicant_id = applicant_id.add(new BigInteger("1"));

                            pstm.setString(1, applicant_id.toString());
                            pstm.executeQuery();
                        }
                        begin++;
                    }
                    end += 1000;
                    //关闭分段计时

                    long eTime = System.currentTimeMillis();
                    //输出
                    System.out.println(threadName +"查询" + sum + "条applicant_to_corp 数据耗时：" + (eTime - bTime));
                }
//                //提交事务
//                conn.commit();
                //边界值自增10W
                //关闭总计时
                long eTime1 = System.currentTimeMillis();
                //输出
                System.out.println(threadName +"查询applicant_to_corp" + sum + "数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        long eTime1 = System.currentTimeMillis();
        //输出
        System.out.println(threadName +"查询applicant_to_corp" + sum + "数据"+ (eTime1 ));

        System.out.println("Thread查询 " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {

    public static void main(String args[]) {

        long bTime = System.currentTimeMillis();

        System.out.println(bTime);

        ThreadWrite  T1 = new  ThreadWrite ("Thread-1");

        T1.start();

        ThreadRead T3 = new ThreadRead("Thread-3");
        T3.start();

        ThreadWrite  T2 = new ThreadWrite ("Thread-2");
        T2.start();

        ThreadRead T4 = new ThreadRead("Thread-4");
        T4.start();

    }
}