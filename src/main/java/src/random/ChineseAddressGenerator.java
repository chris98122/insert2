package src.random;
import org.apache.commons.lang3.RandomUtils;

import cn.binarywang.tools.generator.util.ChineseCharUtils;
import cn.binarywang.tools.generator.base.GenericGenerator;

public class ChineseAddressGenerator extends GenericGenerator {
    private static GenericGenerator instance = new ChineseAddressGenerator();

    private ChineseAddressGenerator() {
    }

    public static GenericGenerator getInstance() {
        return instance;
    }

    @Override
    public String generate() {
        StringBuilder result = new StringBuilder(genProvinceAndCity());
        result.append(ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "路");
        result.append(RandomUtils.nextInt(1, 8000) + "号");
        return result.toString();
    }

    private static String genProvinceAndCity() {
        return ChineseAreaList.provinceCityList.get(
                RandomUtils.nextInt(0, ChineseAreaList.provinceCityList.size()));
    }

}
