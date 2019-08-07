package com.king2.productserver.controller;


import com.king2.productserver.entity.SystemResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {


    private int countA=1;

    @RequestMapping("/getProducts/{mess}")
    public SystemResult getProducts(@PathVariable("mess") String mess2)
    {
        return SystemResult.ok("我是第三个商品服务 信息为："+mess2+"==="+countA++);
    }
}
