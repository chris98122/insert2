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

public class App {
    private String url = "jdbc:mysql://localhost:3306/hireapp?useServerPrepStmts=false&rewriteBatchedStatements=true&useUnicode=true&amp&serverTimezone=GMT";
    private String user = "root";
    private String password = "root";

    private static Map<Integer, Integer> corp_job_num = new HashMap<Integer, Integer>();

    private static Map<BigInteger, Integer> applicant_apply = new HashMap<BigInteger, Integer>();


    @org.junit.Test
    public void insertApplicantAndBanApplicant() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        //定义需要的身份证号
        BigInteger id = new BigInteger("310103199210102000");
        BigInteger one = new BigInteger("1");

        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;

        PreparedStatement pstm2 = null;
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO  ApplicantUser VALUES (?,?,?)";

            String sql2 = "INSERT INTO  bansuser VALUES (?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            pstm2 = conn.prepareStatement(sql2);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环100次，每次1000数据，一共10万
            for (int i = 0; i < 100; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {

                    //  System.out.println(id);
                    //赋值
                    pstm.setString(1, RandomValue.getChineseName());
                    pstm.setString(2, id.toString(10));
                    pstm.setString(3, RandomValue.getPassword(6, 10));
                    //添加到同一个批处理中
                    pstm.addBatch();

                    pstm2.setInt(1, RandomUtils.nextInt(1, 5000));
                    pstm2.setString(2, id.toString(10));
                    pstm2.setBoolean(3, RandomUtils.nextInt(0, 10) % 4 == 1);

                    pstm2.addBatch();

                    begin++;
                    id = id.add(one);
                }
                //执行批处理
                pstm.executeBatch();
                pstm2.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入1k Applicant 条数据耗时：" + "成功插入1k条ban Applicant数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入10w Applicant 共耗时：" + "插入10w ban Applicant 共耗时：" + (eTime1 - bTime1));
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

                    //  System.out.println(admin_id);
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
            System.out.println("插入1w admin 数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertcorpAndBanCorp() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;

        PreparedStatement pstm2 = null;
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

            String sql2 = "INSERT INTO banscorp VALUES (?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);//insert corp

            pstm2 = conn.prepareStatement(sql2);//ban corp
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共10万
            for (int i = 0; i < 100; i++) {

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
                    pstm2.setInt(1, RandomUtils.nextInt(1, 5000));
                    pstm2.setInt(2, corp_id);
                    pstm2.setBoolean(3, RandomUtils.nextInt(1, 10) % 4 == 1);

                    pstm2.addBatch();
                    begin++;
                    corp_id++;
                }
                //执行批处理
                pstm.executeBatch();
                pstm2.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入1k条数据耗时：" + "成功插入1k条数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入10w Corp共耗时：" + "插入10w ban corp 数据共耗时：" + (eTime1 - bTime1));
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

            //循环100次，每次1000数据，一共10万
            for (int i = 0; i < 100; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {
                    // System.out.println(corp_id);
                    //赋值
                    pstm.setInt(1, corp_id);
                    int job_num = RandomUtils.nextInt(1, 4);
                    sum += job_num;
                    corp_job_num.put(corp_id, job_num);
                    int job_id = 1;
                    //0到3个岗位per公司
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
                System.out.println("成功插入" + sum + "条job数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + "Job 数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @org.junit.Test
    public void insertApplicantTags() {
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
            for (int i = 0; i < 100; i++) {
                //开始循环
                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    int tag_num = RandomUtils.nextInt(0, 3);
                    sum += tag_num;
                    int tag_id = 1;
                    for (int j = 0; j < tag_num; j++) {
                        pstm.setString(1, id.toString(10));
                        pstm.setInt(2, tag_id);
                        pstm.setString(3, RandomValue.getTagContent());
                        tag_id++;
                        pstm.addBatch();
                    }
                    begin++;
                    //添加到同一个批处理中
                    id = id.add(one);
                }

                pstm.executeBatch();
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入" + sum + "条 applicanttag数据耗时：" + (eTime - bTime));
            }
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + " applicanttag 数据共耗时：" + (eTime1 - bTime1));
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

            //循环10次，每次1000数据，一共10万
            for (int i = 0; i < 100; i++) {
                //开始循环

                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    //开启分段计时，计1W数据耗时
                    for (int k = 0; k < corp_job_num.get(corp_id); k++) {
                        int job_id = k + 1;
                        int tag_id = 1;
                        int tag_num = RandomUtils.nextInt(0, 3);
                        sum += tag_num;
                        for (int j = 0; j < tag_num; j++) {
                            pstm.setInt(1, corp_id);
                            pstm.setInt(2, job_id);
                            pstm.setInt(3, tag_id);
                            pstm.setString(4, RandomValue.getTagContent());
                            tag_id++;
                            pstm.addBatch();
                        }
                        //添加到同一个批处理中
                    }
                    corp_id++;
                    begin++;
                }
                end += 1000;

                pstm.executeBatch();
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入" + sum + "条jobtag数据耗时：" + (eTime - bTime));
            }
            //执行批处理
//                //提交事务
//                conn.commit();
            //边界值自增10W
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + "jobtag数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertapply() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;

        BigInteger applicant_id = new BigInteger("310103199210102000");
        BigInteger one = new BigInteger("1");


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
            String sql = "INSERT INTO applyforjob VALUES (?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共10万
            for (int i = 0; i < 100; i++) {
                //开始循环

                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    //开启分段计时，计1W数据耗时
                    for (int k = 0; k < corp_job_num.get(corp_id); k++) {
                        int job_id = k + 1;
                        int apply_num = RandomUtils.nextInt(0, 5);
                        sum += apply_num;
                        applicant_apply.clear();
                        for (int j = 0; j < apply_num; j++) {
                            applicant_id = new BigInteger("310103199210102000");
                            //一共10w个applicant 分成 apply_num份 就不会有primary key 重复了
                            applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(0, 100000) + ""));
                            while (applicant_apply.get(applicant_id) != null) {
                                System.out.println(applicant_id.toString() + "is applied");
                                applicant_id = new BigInteger("310103199210102000");
                                applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(0, 100000) + ""));
                            }
                            applicant_apply.put(applicant_id, 1);

                            //随机applicant
                            pstm.setString(1, applicant_id.toString());
                            pstm.setInt(2, corp_id);
                            pstm.setInt(3, job_id);
                            pstm.setDate(4, RandomValue.getStartTime());//这里的时间可能不在Job的时间内
                            pstm.addBatch();
                        }
                        begin++;
                        //添加到同一个批处理中
                    }
                    corp_id++;
                }
                end += 1000;

                pstm.executeBatch();
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入" + sum + " applyforjob 条数据耗时：" + (eTime - bTime));
            }
            //执行批处理
//                //提交事务
//                conn.commit();
            //边界值自增10W
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + sum + " applyforjob 数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @org.junit.Test
    public void insert_applicant_to_corp() {

        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;

        BigInteger applicant_id = new BigInteger("310103199210102000");

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
            String sql = "INSERT INTO applicant_to_corp VALUES (?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共10~50万

            for (int i = 0; i < 100; i++) {
                //开始循环
                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    int num = RandomUtils.nextInt(0, 5);
                    sum += num;
                    applicant_id = new BigInteger("310103199210102000");
                    for (int j = 0; j < num; j++) {
                        applicant_id = applicant_id.add(new BigInteger("1"));
                        pstm.setString(1, applicant_id.toString());

                        //  System.out.println(applicant_id.toString());
                        pstm.setInt(2, corp_id);
                        Boolean a = RandomUtils.nextInt(0, 10) % 8 == 1;
                        pstm.setBoolean(3, a);
                        pstm.setBoolean(4, !a);
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
                System.out.println("成功插入" + sum + "条applicant_to_corp 数据耗时：" + (eTime - bTime));
            }
//                //提交事务
//                conn.commit();
            //边界值自增10W
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入applicant_to_corp" + sum + "数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insert_message() {

        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;

        BigInteger applicant_id = new BigInteger("310103199210102000");

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
            String sql = "INSERT INTO messagetocorp VALUES (?,?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();

            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 100; i++) {
                //开始循环

                int message_id = 1;
                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    int num = RandomUtils.nextInt(0, 3);
                    sum += num * 2;
                    for (int j = 0; j < num; j++) {
                        applicant_id = new BigInteger("310103199210102000");
                        applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(0, 100000) + ""));
                        pstm.setString(1, applicant_id.toString());
                        //  System.out.println(applicant_id.toString());
                        pstm.setInt(2, corp_id);
                        pstm.setInt(3, message_id);

                        message_id++;

                        pstm.setString(4, RandomValue.getMessageContent(applicant_id.toString()));
                        pstm.setBoolean(5, true);

                        pstm.addBatch();

                        pstm.setString(1, applicant_id.toString());
                        pstm.setInt(2, corp_id);
                        pstm.setInt(3, message_id);

                        message_id++;

                        pstm.setString(4, "你好 欢迎报名");
                        pstm.setBoolean(5, false);

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
                System.out.println(i+":"+"成功插入message" + sum + "条数据耗时：" + (eTime - bTime));
            }
//                //提交事务
//                conn.commit();
            //边界值自增10W
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入message" + sum + "数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @org.junit.Test
    public void insertcommentAndBanCommenAndTip() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        long sum = 0;

        BigInteger applicant_id = new BigInteger("310103199210102000");
        BigInteger one = new BigInteger("1");


        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;//insert comment
        PreparedStatement pstm2 = null;//ban comment
        PreparedStatement pstm_tip = null;//tip comment
        int corp_id = 1;

        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO comments VALUES (?,?,?,?,?)";

            String sql2 = "INSERT INTO banscomment VALUES (?,?,?,?,?,?)";

            String sql3 = "INSERT INTO tip_or_like_comment VALUES (?,?,?,?,?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            pstm2 = conn.prepareStatement(sql2);
            pstm_tip = conn.prepareStatement(sql3);//tip comment
            //开始总计时
            long bTime1 = System.currentTimeMillis();
            int tip_id = 1;
            //循环100次，每次1000数据，一共10万
            for (int i = 0; i < 100; i++) {
                int comment_id = 1;
                //开始循环

                long bTime = System.currentTimeMillis();
                while (begin < end) {
                    //开启分段计时，计1W数据耗时
                    for (int k = 0; k < corp_job_num.get(corp_id); k++) {
                        int job_id = k + 1;
                        int apply_num = RandomUtils.nextInt(0, 3);
                        sum += apply_num;
                        for (int j = 0; j < apply_num; j++) {
                            applicant_id = new BigInteger("310103199210102000");

                            //一共10w个applicant 分成 apply_num份 就不会有primary key 重复了
                            int a = 10000 / 2 / apply_num;
                            applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(a * j, a * j * 2) + ""));
                            //随机applicant
                            pstm.setString(1, applicant_id.toString());
                            pstm.setInt(2, corp_id);
                            pstm.setInt(3, job_id);
                            pstm.setInt(4, comment_id);
                            pstm.setString(5, RandomValue.getCommentContent());

                            pstm.addBatch();

                            pstm2.setInt(1, RandomUtils.nextInt(1, 5000));//admin number = 5000
                            pstm2.setString(2, applicant_id.toString());
                            pstm2.setInt(3, corp_id);
                            pstm2.setInt(4, job_id);
                            pstm2.setInt(5, comment_id);
                            pstm2.setBoolean(6, j % 4 == 1);

                            pstm2.addBatch();


                            pstm_tip.setInt(2, tip_id);
                            tip_id++;

                            pstm_tip.setString(3, applicant_id.toString());//admin number = 5000

                            pstm_tip.setInt(4, corp_id);
                            pstm_tip.setInt(5, job_id);
                            pstm_tip.setInt(6, comment_id);
                            applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(0, 1000) + ""));

                            pstm_tip.setString(1, applicant_id.toString());


                            if (RandomUtils.nextInt(0, 2) == 1) {
                                pstm_tip.setString(7, "tip");
                                pstm_tip.setString(8, RandomValue.getPassword(6, 10));


                            } else {
                                pstm_tip.setString(7, "like");
                                pstm_tip.setString(8, null);

                            }
                            pstm_tip.addBatch();

                            comment_id++;
                        }
                        begin++;
                        //添加到同一个批处理中
                    }
                    corp_id++;
                }
                end += 1000;
                pstm.executeBatch();
                pstm2.executeBatch();
                pstm_tip.executeBatch();
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println(i+":"+"成功插入" + sum + "条comment数据" + "耗时：" + (eTime - bTime));
            }
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入comment ban comment tip_or_like_comment 每个表" + sum + "条数据共耗时：" + (eTime1 - bTime1));
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    @org.junit.Test
    public void insertTipOrLike() {
        long begin = 1;
        long end = begin + 1000;///每次循环插入的数据量
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        PreparedStatement pstm_applicant = null;

        PreparedStatement pstm_job = null;
        int tip_id = 1;
        try {
            //加载jdbc驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url, user, password);
            //将自动提交关闭
            // conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO  tip_or_like VALUES (?,?,?)";

            String sql_applicant = "INSERT INTO  tip_or_like_applicant VALUES (?,?,?,?,?)";


            String sql_jobs = "INSERT INTO  tip_or_like_job VALUES (?,?,?,?,?,?)";
            //预编译sql
            pstm = conn.prepareStatement(sql);
            pstm_applicant = conn.prepareStatement(sql_applicant);

            pstm_job = conn.prepareStatement(sql_jobs);
            //开始总计时
            long bTime1 = System.currentTimeMillis();
            int corp_id = 1;
            //循环10次，每次1000数据，一共1万
            for (int i = 0; i < 100; i++) {

                //开启分段计时，计1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin < end) {

                    //赋值
                    pstm.setInt(1, tip_id);
                    //加applicant
                    BigInteger applicant_id = new BigInteger("310103199210102000");
                    applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(0, 50000) + ""));

                    pstm_applicant.setString(1, applicant_id.toString());

                    applicant_id = applicant_id.add(new BigInteger(RandomUtils.nextInt(1, 50000) + ""));
                    pstm_applicant.setString(3, applicant_id.toString());

                    pstm_applicant.setInt(2, tip_id);
                    //加job

                    pstm_job.setString(1, applicant_id.toString());
                    pstm_job.setInt(2, tip_id);
                    pstm_job.setInt(3, corp_id);
                    corp_id++;
                    tip_id++;

                    if (RandomUtils.nextInt(0, 2) == 1) {
                        pstm.setString(2, "tip");
                        pstm.setString(3, RandomValue.getPassword(6, 10));

                        pstm_applicant.setString(4, "tip");
                        pstm_applicant.setString(5, RandomValue.getPassword(6, 10));

                        //System.out.println(corp_job_num.get(corp_id));
                        //System.out.println(corp_id);

                        pstm_job.setInt(4, 1);
                        pstm_job.setString(5, "tip");
                        pstm_job.setString(6, RandomValue.getPassword(6, 10));
                        pstm_job.addBatch();

                    } else {
                        pstm.setString(2, "like");
                        pstm.setString(3, null);
                        pstm_applicant.setString(4, "like");
                        pstm_applicant.setString(5, null);
                        //System.out.println(corp_job_num.get(corp_id));

                        pstm_job.setInt(4, 1);
                        pstm_job.setString(5, "like");
                        pstm_job.setString(6, null);
                        pstm_job.addBatch();


                    }
                    //添加到同一个批处理中
                    pstm.addBatch();
                    pstm_applicant.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                pstm_applicant.executeBatch();
                pstm_job.executeBatch();
//                //提交事务
//                conn.commit();
                //边界值自增10W
                end += 1000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println(i+":"+"成功插入3k条 tip or like 数据耗时：" + (eTime - bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入" + "30w tip" + "数据共耗时：" + (eTime1 - bTime1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void insertAll() {
        insertadmin();
        insertApplicantAndBanApplicant();
        insertcorpAndBanCorp();
        insertJobs();
        insertApplicantTags();
        insertJobTags();
        insert_message();
        insertTipOrLike();
        insertcommentAndBanCommenAndTip();
        insertapply();
        insert_applicant_to_corp();
    }

}
