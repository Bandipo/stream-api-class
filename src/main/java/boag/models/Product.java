package boag.models;

import boag.enums.ProductCategory;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "productName")
public class Product {

    private ProductCategory productCategory;
    private String productName;
    private int quantity;
    private BigDecimal price;;

}
