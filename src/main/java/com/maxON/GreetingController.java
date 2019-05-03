package com.maxON;

import com.maxON.domain.Message;
import com.maxON.repository.MessageReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageReprository messageReprository;
    @GetMapping("/greeting")
        public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Map<String,Object> model) {
            model.put("name", name);
            return "greeting";
        }

    @GetMapping
    public String main(Map<String,Object>model) {
        Iterable<Message> reprositoryAll = messageReprository.findAll();
        model.put("messages", reprositoryAll);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text,@RequestParam String tag, Map<String,Object>model) {
        Message message = new Message(text, tag);
        messageReprository.save(message);
        model.put("messages", message);

        return "main";

    }
    }

