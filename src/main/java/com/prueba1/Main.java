package com.prueba1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba1.model.Article;
import com.prueba1.model.Order;
public class Main {
    public static void main(String[] args) {
         
        System.out.println("Hello world!");

        Calculator calculator = new Calculator();
        int result = calculator.multiply(2,3);
        System.out.println("Result of multiplication: "+ result);
        


        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream =
                Main.class.getClassLoader().getResourceAsStream("orders.json");

        List<Order> orders;
        try {
            orders = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Order>>() {}
            );
            for (Order order : orders) {
                System.out.println("Loaded order: " + order.getIdPedido());
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     
    }
    
    
    }
