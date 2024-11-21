package org.example.wsidea.api;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.example.wsidea.config.WebSocketServer;
import org.example.wsidea.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/news")
@Slf4j
public class TestApi {
    @Autowired
    private ItemService itemService;
    /**
     * 3秒执行一次
     * @return
     * @throws Exception
     */
    @Scheduled(fixedRate = 3 * 1000)
    @GetMapping("/send")
    public String send() throws Exception {
        this.itemService = new ItemService();
        Map<String,Object> map = new HashMap<>();
        map.put("server",itemService.getData());
        map.put("pie",itemService.getPieData());
        JSONObject jsonObject =  new JSONObject(map);
        WebSocketServer.sendAllMessage(jsonObject.toString());
        return jsonObject.toString();
    }
}