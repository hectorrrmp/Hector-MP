package com.prueba1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba1.controller.OrderController;
import com.prueba1.model.Article;
import com.prueba1.model.Order;
import com.prueba1.view.OrderView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
         
        System.out.println("Hello world!");

        Calculator calculator = new Calculator();
        int result = calculator.multiply(2,3);
        System.out.println("Result of multiplication: "+ result);
        


        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream =
                Main.class.getClassLoader().getResourceAsStream("orders.json");

        List<Order> orders = null;
        try {
            orders = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Order>>() {}
            );
            for (Order order : orders) {
               log.info("Loaded order: " + order.getIdPedido());
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("Error occurred while reading orders", e);
        }
         OrderView view = new OrderView();
            new OrderController(view, orders);
      
    }
    
    
    }
