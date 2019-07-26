package src;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import src.random.RandomValue;

import java.math.BigInteger;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import java.util.Collection;

import src.random.ProvinceGenerator;
public class App {
    private String url = "jdbc:mysql://202.120.40.8:30553/parttimejob_user?useServerPrepStmts=false&rewriteBatchedStatements=true&useUnicode=true&amp&serverTimezone=GMT";
    private String user = "root";
    private String password = "cyjnb666";

    private static Map<Integer, Integer> corp_job_num = new HashMap<Integer, Integer>();

    private static Map<BigInteger, Integer> applicant_apply = new HashMap<BigInteger, Integer>();


    @org.junit.Test
    public void insert_merchant_user() {
        long begin = 1;
        long end = begin + 100;///每次循环插入的数据量
        //定义需要的身份证号

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
            String sql = "INSERT INTO  merchant_user VALUES (?,?,?,?,?)";


            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            for (int i = 0; i < 1; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                int id=  6;
                while (begin < end) {

                    //  System.out.println(id);
                    //赋值
                    pstm.setInt(1,id++);
                    pstm.setObject(2,false);//banned
                    pstm.setString(3, RandomValue.getPassword(6, 10));
                    pstm.setString(4, RandomValue.getChineseName());
                    pstm.setObject(5, null);

                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入 数据耗时："  +(eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insert_company() {
        long begin = 1;
        long end = begin + 100;///每次循环插入的数据量
        //定义需要的身份证号

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
            String sql = "INSERT INTO  company VALUES (?,?,?)";


            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            for (int i = 0; i < 1; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                int id=  4;
                while (begin < end) {

                    //  System.out.println(id);
                    //赋值
                    pstm.setInt(1,id);
                    pstm.setString(2, RandomValue.getCorpName());
                    pstm.setObject(3,id);
                    id+=1;
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入 数据耗时："  +(eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }



    @org.junit.Test
    public void insert_shop() {
        long begin = 1;
        long end = begin + 100;///每次循环插入的数据量
        //定义需要的身份证号

        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //编写sql
            String sql = "INSERT INTO  shop VALUES (?,?,?,?,?, ?,?,?,?,? ,?)";


            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            for (int i = 0; i < 1; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                int id =  11;
                int companyid=1;
                while (begin < end) {
                    //赋值
                    pstm.setInt(1,id);//shop id
                    pstm.setString(2, RandomValue.getAddress());//address
                    pstm.setString(3,"公司品牌");//brand
                    pstm.setString(4,"310100");//city
                    pstm.setString(5, "店铺介绍");//introduction
                    pstm.setDouble(6, 31.2038);//latitude
                    pstm.setDouble(7, 121.504);//logitude
                    pstm.setObject(8,"310000");//province
                    pstm.setString(9,RandomValue.getShopName() );//shopname
                    pstm.setInt(10, companyid );//company  id
                    pstm.setInt(11,1 );//industry id
                    id+=1;
                    companyid+=1;
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入 数据耗时："  +(eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insert_job() {
        long begin = 1;
        long end = begin + 100;///每次循环插入的数据量
        //定义需要的身份证号

        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //编写sql
            String sql = "INSERT INTO  job VALUES (?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?, ?)";


            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            for (int i = 0; i < 1; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                int id = 6;
                int shopid=1;
                while (begin < end) {
                    //赋值
                    pstm.setInt(1,id);//job id
                    pstm.setInt(2, 0);//applied amount
                    Date workstart =  RandomValue.getStartTime();
                    Date workend = RandomValue.getEndTime(workstart );

                    Date applystart = RandomValue.getEndTime(workend);
                    Date applyend =  RandomValue.getEndTime(applystart);
                    pstm.setDate(3,applystart );
                    pstm.setDate(4,   workstart);
                    pstm.setTime(5, java.sql.Time.valueOf("8:44:53"));
                    pstm.setString(6, RandomValue.getEducation());

                    pstm.setDate(7, applyend);
                    pstm.setDate(8,workend  );
                    pstm.setTime(9, java.sql.Time.valueOf("15:44:53"));
                    String jobname= RandomValue.getJobName();
                    pstm.setString(10, "需要"+jobname);
                    pstm.setString(11,jobname);
                    pstm.setObject(12,null);


                    pstm.setInt(13,RandomUtils.nextInt(1,15));

                    pstm.setInt(14,2);
                    pstm.setDouble(15,RandomValue.getSalary());
                    pstm.setInt(16,shopid);

                    id+=1;
                    shopid+=1;
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入 数据耗时："  +(eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insert_wechat_user() {
        long begin = 1;
        long end = begin + 100;///每次循环插入的数据量
        //定义需要的身份证号

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
            String sql = "INSERT INTO  wechat_user VALUES (?,?,?,?,?, ?,?,?,?)";


            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            for (int i = 0; i < 1; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                int id=  4;
                while (begin < end) {

                    //  System.out.println(id);
                    //赋值
                    pstm.setInt(1,id++);
                    pstm.setString(2, "shanghai");
                    pstm.setString(3, "China");
                    pstm.setString(4, RandomValue.getEducation());
                    pstm.setInt(5, 1);
                    pstm.setString(6, "3101101234123"+  RandomUtils.nextInt(10000,99999)  );

                    pstm.setString(7,  RandomValue.getChineseName()  );

                    pstm.setString(8,  "fakeopenid" +id );
                    pstm.setString(9,    "138874"+ RandomUtils.nextInt(10000,99999)    );

                    pstm.setString(9,    "138874"+ RandomUtils.nextInt(10000,99999)    );


                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入 数据耗时："  +(eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void insertAll() {
        insert_merchant_user();
        insert_company();
        insert_shop();
        insert_job();
    }

}
