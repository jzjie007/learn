package com.jzj.user.controller;


import com.jzj.order.client.IOrderRpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
@RequestMapping("rpc")
public class RpcController {
    private static Logger log = LoggerFactory.getLogger(RpcController.class);


    @DubboReference(interfaceClass = IOrderRpcService.class)
    private IOrderRpcService floorRpcService;


    @RequestMapping("order")
    public Object order() {
        log.info("进入 controller order");
        String orderInfo = floorRpcService.getOrderInfo("10000");
        log.info("rpc调用结果 result：{}", orderInfo);
        return orderInfo;
    }


}
