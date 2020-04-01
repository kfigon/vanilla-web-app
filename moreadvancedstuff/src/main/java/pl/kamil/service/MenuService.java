package pl.kamil.service;

import pl.kamil.dto.MenuItem;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MenuService {
    private List<MenuItem> menu;

    public MenuService() {
        menu = Arrays.asList(
                MenuItem.builder().name("fish").price(new BigDecimal("20.10")).build(),
                MenuItem.builder().name("meat").price(new BigDecimal("22.90")).build(),
                MenuItem.builder().name("salad").price(new BigDecimal("10.99")).build()
        );
    }

    public List<MenuItem> getMenu() {
        return menu;
    }
}
