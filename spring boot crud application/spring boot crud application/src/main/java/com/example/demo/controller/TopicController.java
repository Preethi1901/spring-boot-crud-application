package com.example.demo.controller;

import com.example.demo.services.TopicService;
import com.example.demo.classes.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
@Autowired
    private TopicService topicservice;
    @RequestMapping("/topics")
    public List<Topics> getTopics(){
        return topicservice.getAllTopics();
    };
@RequestMapping("/topics/{id}")
    public Topics getTopic(@PathVariable String id){

    return topicservice.getTopic(id);
    };

    @RequestMapping(method = RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topics topic){
        topicservice.addTopic(topic);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/topics/{id}")
    public void updateTopic(@RequestBody Topics topic,@PathVariable String id ){
        topicservice.updateTopic(topic,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicservice.deleteTopic(id);
    }


}
