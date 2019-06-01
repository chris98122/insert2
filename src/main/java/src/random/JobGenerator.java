package src.random;

import cn.binarywang.tools.generator.base.GenericGenerator;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class JobGenerator extends GenericGenerator {


    private static JobGenerator instance = new JobGenerator();


    private JobGenerator() {
    }

    public static GenericGenerator getInstance() {
        return instance;
    }

    public String generate() {
        StringBuilder result = new StringBuilder(genName());
        return result.toString();
    }


    public static String genName() {
        int i = RandomUtils.nextInt(0, JobList.NameList.size());
        return JobList.NameList.get(i);
    }

    public static String genDemand(String JobName) {
        return JobName+"需要有"+RandomUtils.nextInt(1, 10)+"年经验。";
    }
}
