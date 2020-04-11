package com.mycompany.orderapi.runner;

import com.mycompany.orderapi.model.Order;
import com.mycompany.orderapi.model.User;
import com.mycompany.orderapi.security.WebSecurityConfig;
import com.mycompany.orderapi.service.OrderService;
import com.mycompany.orderapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserService userService;
    private final OrderService orderService;

    public DatabaseInitializer(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        users.forEach(userService::saveUser);
        orders.forEach(orderService::saveOrder);
        log.info("Database initialized");
    }

    private final List<User> users = Arrays.asList(
            new User("admin", "admin", WebSecurityConfig.ADMIN),
            new User("user", "user", WebSecurityConfig.USER)
    );

    private final List<Order> orders = Collections.singletonList(
            new Order("abc", "Buy one MacBook Pro")
    );

}
