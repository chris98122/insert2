package src.random;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class JobList {
    static String[] jobName;
    public static List<String> NameList = new ArrayList();

    static String text = "0102 行政总监\n" +
            "\n" +
            "0103 技术总监CTO/总工\n" +
            "\n" +
            "0104 人力资源总监\n" +
            "\n" +
            "0105 财务总监CFO/总会计师\n" +
            "\n" +
            "0106 首席信息官CIO\n" +
            "\n" +
            "0107 首席运营官/COO\n" +
            "\n" +
            "0108 市场/营销总监\n" +
            "\n" +
            "0109 联盟经理\n" +
            "\n" +
            "\n" +
            "0201 公关经理\n" +
            "\n" +
            "0202 公关专员\n" +
            "\n" +
            "0211 市场经理/营销经理\n" +
            "\n" +
            "0212 渠道经理\n" +
            "\n" +
            "0213 产品/品牌经理\n" +
            "\n" +
            "0214 市场助理/专员\n" +
            "\n" +
            "0215 市场营销/推广/合作\n" +
            "\n" +
            "0216 客户代表/营销代表\n" +
            "\n" +
            "0217 市场策划\n" +
            "\n" +
            "0218 市场分析/调研\n" +
            "\n" +
            "0221 CI设计与策划\n" +
            "\n" +
            "0222 广告文案/媒体策划/设计\n" +
            "\n" +
            "\n" +
            "0301 国内贸易\n" +
            "\n" +
            "0302 国外贸易/涉外业务\n" +
            "\n" +
            "0303 跟单员\n" +
            "\n" +
            "0304 报关员\n" +
            "\n" +
            "0311 销售经理/区域经理/商务经理\n" +
            "\n" +
            "0312 销售工程师/销售代表\n" +
            "\n" +
            "0313 销售助理/业务员\n" +
            "\n" +
            "0314 商务代表/商务助理/业务助理\n" +
            "\n" +
            "\n" +
            "0401 财务经理/主任\n" +
            "\n" +
            "0402 会计主管\n" +
            "\n" +
            "0411 注册会计师\n" +
            "\n" +
            "0412 会计\n" +
            "\n" +
            "0413 出纳\n" +
            "\n" +
            "0421 审计经理/主管/专员\n" +
            "\n" +
            "0422 注册审计师\n" +
            "\n" +
            "0431 统计\n" +
            "\n" +
            "0432 计划\n" +
            "\n" +
            "0433 稽核\n" +
            "\n" +
            "0434 财务分析\n" +
            "\n" +
            "0435 成本分析/核算\n" +
            "\n" +
            "0501 行政经理/主管\n" +
            "\n" +
            "0502 行政专员/行政秘书/助理\n" +
            "\n" +
            "0503 办公室主任\n" +
            "\n" +
            "0511 人力资源经理/专员/助理\n" +
            "\n" +
            "0512 培训经理/专员/助理\n" +
            "\n" +
            "0513 招聘经理/专员/助理\n" +
            "\n" +
            "0514 薪酬福利经理/专员/助理\n" +
            "\n" +
            "0515 绩效考核经理/专员/助理\n" +
            "\n" +
            "0601 图书情报/资料/文档管理\n" +
            "\n" +
            "0602 文秘/高级文员\n" +
            "\n" +
            "0603 资料/文档撰写/编辑\n" +
            "\n" +
            "0611 计算机操作员/打字员/文员/校对\n" +
            "\n" +
            "0612 前台/接待员/礼仪\n" +
            "\n" +
            "0613 收发员/话务员/后勤\n" +
            "\n" +
            "0621 英语翻译\n" +
            "\n" +
            "0622 日语翻译\n" +
            "\n" +
            "0623 法语翻译\n" +
            "\n" +
            "0624 德语翻译\n" +
            "\n" +
            "0625 韩语翻译\n" +
            "\n" +
            "0626 其它语种\n" +
            "\n" +
            "0701 客户服务经理\n" +
            "\n" +
            "0702 技术支持/客户培训\n" +
            "\n" +
            "0703 售前/售后服务\n" +
            "\n" +
            "0704 热线咨询\n" +
            "\n" +
            "0705 客户关系处理\n" +
            "\n" +
            "0706 客户分析\n" +
            "\n" +
            "0707 投诉处理\n" +
            "\n" +
            "\n" +
            "0801 厂长/副厂长\n" +
            "\n" +
            "0802 厂务管理\n" +
            "\n" +
            "0803 车间主任/拉长\n" +
            "\n" +
            "0811 产品开发\n" +
            "\n" +
            "0812 品质管理\n" +
            "\n" +
            "0813 采购管理\n" +
            "\n" +
            "0814 仓储管理\n" +
            "\n" +
            "0815 物料管理\n" +
            "\n" +
            "0816 设备管理\n" +
            "\n" +
            "0817 安全管理\n" +
            "\n" +
            "0821 配色美工\n" +
            "\n" +
            "0822 计划/调度/协调员\n" +
            "\n" +
            "0823 PMC/SMT技术员\n" +
            "\n" +
            "0824 生产控制文员\n" +
            "\n" +
            "\n" +
            "0901 技术主管/项目经理\n" +
            "\n" +
            "0902 信息经理/内容主管/栏目主持\n" +
            "\n" +
            "0911 程序员/软件工程师\n" +
            "\n" +
            "0912 系统集成/支持\n" +
            "\n" +
            "0913 系统分析员\n" +
            "\n" +
            "0914 硬件开发工程师/硬件工程师\n" +
            "\n" +
            "0921 软件测试工程师\n" +
            "\n" +
            "0922 硬件测试工程师\n" +
            "\n" +
            "0931 网站/电子商务开发\n" +
            "\n" +
            "0932 网络工程师\n" +
            "\n" +
            "0933 网站策划\n" +
            "\n" +
            "0934 网页设计与制作\n" +
            "\n" +
            "0935 网站美工/电脑美工\n" +
            "\n" +
            "0936 网站编辑\n" +
            "\n" +
            "0941 数据库开发与管理\n" +
            "\n" +
            "0942 系统/网络管理及维护\n" +
            "\n" +
            "0943 系统/网络/信息安全\n" +
            "\n" +
            "0951 多媒体设计与开发\n" +
            "\n" +
            "0952 计算机辅助设计与绘图\n" +
            "\n" +
            "1001 技术主管/项目经理\n" +
            "\n" +
            "1011 电子工程师\n" +
            "\n" +
            "1012 无线电工程师\n" +
            "\n" +
            "1013 电子元器件工程师\n" +
            "\n" +
            "1014 电路设计/电子测试/半导体技术\n" +
            "\n" +
            "1015 单片机/DSL/DSP/底层软件开发\n" +
            "\n" +
            "1016 广播视听设备工程师\n" +
            "\n" +
            "1017 电子/电器维修工程师\n" +
            "\n" +
            "1018 电子测试工程师\n" +
            "\n" +
            "1019 电子技术员\n" +
            "\n" +
            "1021 工艺工程师\n" +
            "\n" +
            "1021 仪器/仪表/测量工程师\n" +
            "\n" +
            "1022 绘图工程师\n" +
            "\n" +
            "1031 通讯/通信工程师\n" +
            "\n" +
            "1101 机械工程师/模具设计\n" +
            "\n" +
            "1102 机械制图工程师\n" +
            "\n" +
            "1103 机械制造工程师\n" +
            "\n" +
            "1104 机电工程师\n" +
            "\n" +
            "1105 结构工程师\n" +
            "\n" +
            "1106 注塑工程师/电镀工程师\n" +
            "\n" +
            "1111 机电技术员\n" +
            "\n" +
            "1201 城镇规划设计\n" +
            "\n" +
            "1202 风景园林规划设计\n" +
            "\n" +
            "1203 园艺工程师\n" +
            "\n" +
            "1211 建筑设计\n" +
            "\n" +
            "1212 土木建筑/工民建\n" +
            "\n" +
            "1213 绘图/建筑制图\n" +
            "\n" +
            "1214 结构工程师\n" +
            "\n" +
            "1215 测绘工程师\n" +
            "\n" +
            "1221 施工管理\n" +
            "\n" +
            "1222 工程监理\n" +
            "\n" +
            "1223 工程预决算\n" +
            "\n" +
            "1231 装饰/安装工程师\n" +
            "\n" +
            "1232 道桥设计与施工\n" +
            "\n" +
            "1233 港口与航道设计与施工\n" +
            "\n" +
            "1234 水电工程师/管道工程师\n" +
            "\n" +
            "1235 给排水工程师\n" +
            "\n" +
            "1236 制冷暖通工程师\n" +
            "\n" +
            "1237 智能楼宇设计与施工\n" +
            "\n" +
            "1238 岩土工程师/地下工程\n" +
            "\n" +
            "1241 安全注册主任\n" +
            "\n" +
            "1242 安全员\n" +
            "\n" +
            "1251 建材\n" +
            "1301 房地产开发/策划\n" +
            "\n" +
            "1302 房地产经纪\n" +
            "\n" +
            "1303 房地产评估/交易\n" +
            "\n" +
            "1304 房地产销售\n" +
            "\n" +
            "1311 物业管理经理/主管/主任\n" +
            "\n" +
            "1312 物业管理员/助理\n" +
            "\n" +
            "1401 银行会计\n" +
            "\n" +
            "1402 储蓄员\n" +
            "\n" +
            "1403 信贷/信贷风险控制\n" +
            "\n" +
            "1404 银行国际业务\n" +
            "\n" +
            "1405 投资银行\n" +
            "\n" +
            "1406 外汇\n" +
            "\n" +
            "1407 建筑审计\n" +
            "\n" +
            "1411 证券经纪人\n" +
            "\n" +
            "1412 证券投资顾问\n" +
            "\n" +
            "1413 操盘手/交易员\n" +
            "\n" +
            "1414 行业分析\n" +
            "\n" +
            "1415 股评\n" +
            "\n" +
            "1416 期货/股票经纪\n" +
            "\n" +
            "1421 投资管理/顾问\n" +
            "\n" +
            "1422 资产评估\n" +
            "\n" +
            "1423 融资\n" +
            "\n" +
            "1431 保险经纪人/保险业务员\n" +
            "\n" +
            "1441 拍卖师\n" +
            "\n" +
            "1501 平面设计\n" +
            "\n" +
            "1502 动画设计\n" +
            "\n" +
            "1511 产品外观设计\n" +
            "\n" +
            "1512 装璜美术设计/室内外设计\n" +
            "\n" +
            "1513 服装设计\n" +
            "\n" +
            "1514 广告设计\n" +
            "\n" +
            "1515 珠宝设计\n" +
            "\n" +
            "1516 展览设计\n" +
            "\n" +
            "1517 家具设计\n" +
            "\n" +
            "1518 工艺品设计\n" +
            "\n" +
            "1521 形象设计\n" +
            "\n" +
            "1601 律师\n" +
            "\n" +
            "1602 法律顾问\n" +
            "\n" +
            "1603 法律助理\n" +
            "\n" +
            "1701 酒店经理/餐馆经理\n" +
            "\n" +
            "1702 大堂副理/楼面经理\n" +
            "\n" +
            "1711 领班\n" +
            "\n" +
            "1712 厨师\n" +
            "\n" +
            "1721 服务员\n" +
            "\n" +
            "1722 咨客\n" +
            "\n" +
            "1801 物流经理/主管\n" +
            "\n" +
            "1802 货运仓储经理/主管\n" +
            "\n" +
            "1811 船务\n" +
            "\n" +
            "1821 运输管理/调度\n" +
            "\n" +
            "1901 商场经理/主管\n" +
            "\n" +
            "1902 业务经理/主任\n" +
            "\n" +
            "1911 店面设计/陈列\n" +
            "\n" +
            "1912 店长\n" +
            "\n" +
            "1913 营业员/导购员/店员\n" +
            "\n" +
            "1914 收银员\n" +
            "\n" +
            "1915 促销员\n" +
            "\n" +
            "1921 物价员\n" +
            "\n" +
            "2001 电力拖动与自动控制\n" +
            "\n" +
            "2002 电机与电器\n" +
            "\n" +
            "2003 电力工程师/电气\n" +
            "\n" +
            "2011 电路布线设计\n" +
            "\n" +
            "2012 智能大厦/综合布线/弱电\n" +
            "\n" +
            "2013 灯饰研发工程师\n" +
            "\n" +
            "2014 光源/照明\n" +
            "\n" +
            "2015 变压器/磁电工程师\n" +
            "\n" +
            "2021 家用电器研发\n" +
            "\n" +
            "2022 家用电器维修\n" +
            "\n" +
            "2101 企业管理咨询\n" +
            "\n" +
            "2102 企业管理顾问\n" +
            "\n" +
            "2103 信息咨询/中介\n" +
            "\n" +
            "2104 培训师\n" +
            "\n" +
            "2201 化工生产工程师\n" +
            "\n" +
            "2202 精细化工工程师\n" +
            "\n" +
            "2203 高分子材料工程师\n" +
            "\n" +
            "2204 化工制药\n" +
            "\n" +
            "2211 化验员/检验员\n" +
            "\n" +
            "2212 化工生产技术员\n" +
            "\n" +
            "2221 生物工程\n" +
            "\n" +
            "2301 图书情报/资料/文档管理\n" +
            "\n" +
            "2311 高等教育\n" +
            "\n" +
            "2312 中等教育\n" +
            "\n" +
            "2313 小学教育/幼儿教育/保育员\n" +
            "\n" +
            "2314 职业教育/培训/家教\n" +
            "\n" +
            "2321 体育教练/健美教练\n" +
            "\n" +
            "2331 模特\n" +
            "\n" +
            "2332 舞蹈\n" +
            "\n" +
            "2333 声乐\n" +
            "\n" +
            "2334 器乐\n" +
            "2401 西医\n" +
            "\n" +
            "2402 中医\n" +
            "\n" +
            "2403 心理医生\n" +
            "\n" +
            "2404 兽医/宠物医生\n" +
            "\n" +
            "2405 医疗技术/医学检验师\n" +
            "\n" +
            "2406 药剂师\n" +
            "\n" +
            "2407 麻醉师\n" +
            "\n" +
            "2411 护理人员/护士\n" +
            "\n" +
            "2421 卫生防疫\n" +
            "\n" +
            "2422 妇幼保健\n" +
            "\n" +
            "2423 针灸推拿\n" +
            "2501 总编/主编\n" +
            "\n" +
            "2502 文字编辑\n" +
            "\n" +
            "2503 美术编辑/美工\n" +
            "\n" +
            "2511 记者/新闻采编\n" +
            "\n" +
            "2512 摄影录制\n" +
            "\n" +
            "2521 节目主持/DJ/播音";

    static {
        jobName = text.split("\n|/|\b|1|2|3|4|5|6|7|8|9|0| ");
        for(int i = 0;i<jobName.length;i++)
        {
            if(jobName[i].length() > 2)
            {
            //    System.out.println(jobName[i]);
                NameList.add(jobName[i]);
            }
        }
    }
}
