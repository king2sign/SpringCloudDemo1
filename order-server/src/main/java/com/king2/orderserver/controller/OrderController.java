package com.king2.orderserver.controller;


import com.king2.orderserver.RemoteClient.ProductRemoteClient;
import com.king2.orderserver.entiry.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    private RestTemplate  restTemplate;

    @Autowired
    private ProductRemoteClient productRemoteClient; // //使用Fegin组件调用远程的商品服务信息

    @GetMapping("/getProducts")
    public SystemResult getOrderOnProducts(){
        //return this.restTemplate.getForObject("http://PRODUCT-SERVER/product/getProducts/上海中心",SystemResult.class);
        return productRemoteClient.getProducts("江西省上饶市广丰县");
    }

}
