package src.random;

import cn.binarywang.tools.generator.base.GenericGenerator;
import org.apache.commons.lang3.RandomUtils;

public class TagGenerator extends GenericGenerator {


    private static TagGenerator instance = new TagGenerator();


    private TagGenerator() {
    }

    public static GenericGenerator getInstance() {
        return instance;
    }

    public String generate() {
        int i = RandomUtils.nextInt(0, TagList.TagList.size());
        return TagList.TagList.get(i);
    }

}
