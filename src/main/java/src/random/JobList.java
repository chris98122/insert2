package src.random;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class JobList {
    static String[] jobName;
    public static List<String> NameList = new ArrayList();


    static {
        for(int i = 0;i<100000;i++)//十万种tag
        {
            //    System.out.println(jobName[i]);
                NameList.add("Tag"+i);
        }
    }
}
