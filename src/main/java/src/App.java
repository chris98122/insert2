package src;

import org.apache.commons.lang3.RandomUtils;
import src.random.RandomValue;

import java.math.BigInteger;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    private String url = "jdbc:mysql://localhost:3306/hireapp?useServerPrepStmts=false&rewriteBatchedStatements=true&useUnicode=true&amp&serverTimezone=GMT";
    private String user = "root";
    private String password = "root";

    private static Map<Integer, Integer> corp_job_num = new HashMap<Integer, Integer>();

    @org.junit.Test
    public void insertApplicant() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        //定义需要的身份证号
        BigInteger id = new BigInteger("310103199210102000");
        BigInteger one = new BigInteger("1");

        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO  ApplicantUser VALUES (?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 10; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {

                    System.out.println(id);
                    //赋值
                    pstm.setString(1, RandomValue.getChineseName());
                    pstm.setString(2, id.toString(10));
                    pstm.setString(3, RandomValue.getPassword(6, 10));
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                    id = id.add(one);
                }
                //执行批处理
                pstm.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入1k条数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入1w数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertadmin() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        int admin_id = 1;
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO  admin VALUES (?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 10; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {

                    System.out.println(admin_id);
                    //赋值
                    pstm.setInt(1, admin_id);
                    pstm.setString(2, RandomValue.getPassword(6, 10));
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                    admin_id++;
                }
                //执行批处理
                pstm.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入1k条数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入1w数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertcorp() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        int corp_id = 1;
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO corp VALUES (?,?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 10; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {

                    //System.out.println(corp_id);
                    //赋值
                    pstm.setInt(1, corp_id);
                    pstm.setString(2, RandomValue.getCorpName());
                    pstm.setString(3, RandomValue.getAddress());
                    pstm.setString(4, RandomValue.getCorpType());
                    pstm.setString(5, RandomValue.getPassword(6, 10));
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                    corp_id++;
                }
                //执行批处理
                pstm.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入1k条数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入1w数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertJobs() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        int corp_id = 1;
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO jobs VALUES (?,?,?,?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 10; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {
                    System.out.println(corp_id);
                    //赋值
                    pstm.setInt(1, corp_id);
                    int job_num = RandomUtils.nextInt(0, 10);
                    sum += job_num;
                    corp_job_num.put(corp_id, job_num);
                    int job_id = 1;
                    //0到10个岗位per公司
                    for (int j = 0; j < job_num; j++) {
                        pstm.setInt(2, job_id);
                        String jobName = RandomValue.getJobName();
                        pstm.setString(3, jobName);
                        pstm.setInt(4, RandomValue.getSalary());
                        Date startTime = RandomValue.getStartTime();
                        pstm.setDate(5, startTime);
                        pstm.setDate(6, RandomValue.getEndTime(startTime));
                        pstm.setString(7, RandomValue.getDemand(jobName));
                        pstm.addBatch();
                        job_id++;
                    }
                    //添加到同一个批处理中
                    begin++;
                    corp_id++;
                }
                //执行批处理
                pstm.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入" + sum + "条数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + "数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @org.junit.Test
    public void insertApplicantTags() {
        insertApplicant();
        BigInteger id = new BigInteger("310103199210102000");
        BigInteger one = new BigInteger("1");
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;
        int tag_sum = 0;
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO applicanttag VALUES (?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 10; i++) {
                //开始循环

                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    //开启分段计时，计1W数据耗时
                    pstm.setString(1, id.toString(10));
                    int tag_num = RandomUtils.nextInt(0, 10);
                    sum += tag_num;
                    int tag_id = 1;
                    for (int j = 0; j < tag_num; j++) {
                        pstm.setInt(2, tag_id);
                        pstm.setString(3, RandomValue.getTagContent());
                        tag_id++;
                    }
                    begin++;
                    if (tag_num > 0)
                        pstm.addBatch();
                    //添加到同一个批处理中
                    id = id.add(one);
                }

                pstm.executeBatch();
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入" + sum + "条数据耗时：" + (eTime - bTime));
            }
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + "数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertJobTags() {
        insertcorp();
        insertJobs();

        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;
        int tag_sum = 0;
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        int corp_id = 1;

        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO jobtag VALUES (?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 10; i++) {
                //开始循环

                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    //开启分段计时，计1W数据耗时
                    pstm.setInt(1, corp_id);

                    for (int k = 0; k < corp_job_num.get(corp_id); k++) {
                        int job_id = k + 1;
                        int tag_id = 1;
                        int tag_num = RandomUtils.nextInt(0, 3);
                        sum += tag_num;
                        pstm.setInt(2, job_id);
                        for (int j = 0; j < tag_num; j++) {
                            pstm.setInt(3, tag_id);
                            pstm.setString(4, RandomValue.getTagContent());
                            tag_id++;
                        }

                        if (tag_num > 0)
                            pstm.addBatch();
                        begin++;
                        //添加到同一个批处理中
                    }
                    corp_id++;
                }
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入" + sum + "条数据耗时：" + (eTime - bTime));
            }
            //执行批处理
            pstm.executeBatch();
//                //提交事务
//                conn.commit();
            //边界值自增10W
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + "数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
