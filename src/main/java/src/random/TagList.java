package src.random;

import java.util.ArrayList;
import java.util.List;

public class TagList {

    static String[] tagName;
    public static List<String> TagList = new ArrayList();
    static{
        for(int i = 0;i<100000;i++)//十万条tag
        {
                TagList.add("Tag"+i);
        }
    }
}
