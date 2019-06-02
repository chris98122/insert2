package src.random;

import cn.binarywang.tools.generator.base.GenericGenerator;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class CorpNameGenerator extends GenericGenerator {
    private static Map<String, Boolean> usedName = new HashMap<String, Boolean>();

    private static CorpNameGenerator instance = new CorpNameGenerator();


    private CorpNameGenerator() {
    }

    public static GenericGenerator getInstance() {
        return instance;
    }

    public String generate() {
        StringBuilder result = new StringBuilder(genName());
        return result.toString();
    }

    public static String genName() {
        String str = "";
        while (true) {
            str = "";
            int index = RandomUtils.nextInt(0, CorpList.base.length() - 3);
            int length = RandomUtils.nextInt(2, 3);
            str = CorpList.base.substring(index, index + length);
            index = RandomUtils.nextInt(0, CorpList.base.length() - 6);
            length = RandomUtils.nextInt(2, 5);
            str = str + CorpList.base.substring(index, index + length);
            str = str + CorpList.end;
            if (usedName.get(str) == null) {
                usedName.put(str, true);
                break;
            }
            System.out.println(str + "is used.");
        }
        return str;
    }

    private static String genCity() {
        return CorpList.cityNameList.get(
                RandomUtils.nextInt(0, CorpList.cityNameList.size()));
    }

    public static String genType() {
        return CorpList.TypeList.get(
                RandomUtils.nextInt(0, CorpList.TypeList.size()));
    }
}
