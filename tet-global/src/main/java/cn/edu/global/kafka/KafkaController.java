package cn.edu.global.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("kafka")
//@Controller
public class KafkaController {
    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("send/{message}")
    @ResponseBody
    public String send(@PathVariable String message){
        kafkaSender.sendMessage("hellokafka",message);
        return "send success";
    }
}
