package com.king2.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到改服务。
//不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心
//@EnableDiscoveryClient
@EnableEurekaClient //指定Eureka-Client客户端也就是服务提供者
@SpringBootApplication
public class ProductServerApplication {

                        //开启客户端负载均衡的功能,这样就能使用服务名调用服务而不是直接ip+端口访问
    @Bean               //resttemplate只是类似于httpclient的一个发送rest风格的请求，它这里是没有办法去识别所谓的服务名的
    @LoadBalanced       //@loadBalance注解修饰的restTemplate才能实现服务名的调用，没有修饰的restTemplate是没有该功能的
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);
    }

}
