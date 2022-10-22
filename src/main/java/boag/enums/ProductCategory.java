package boag.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ProductCategory {
    JUICE, BREAD, MILK;

    public static List<String> getExpectedCategories() {
        return Arrays.stream(ProductCategory.values()).map(ProductCategory::name).collect(Collectors.toList());
    }
}