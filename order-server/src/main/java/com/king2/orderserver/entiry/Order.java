package com.king2.orderserver.entiry;


import lombok.Data;

@Data//自动创建get/set
public class Order {

    private String oId;

    private String orderNumber;

}
