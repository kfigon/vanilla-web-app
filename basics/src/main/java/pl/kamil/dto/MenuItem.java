package pl.kamil.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MenuItem {
    private String name;
    private BigDecimal price;

    @Override
    public String toString() {
        return name + " - " + price + "zl";
    }
}
