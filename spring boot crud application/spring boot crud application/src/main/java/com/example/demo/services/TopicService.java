package com.example.demo.services;

import com.example.demo.classes.Topics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    List<Topics> topics= new ArrayList<>(Arrays.asList(
            new Topics("first","java","java class"),
            new Topics("second","Spring"," spring class"),
            new Topics("third","java beans","java class")
    ));


    public  List<Topics> getAllTopics() {
        return topics;
    }

    public Topics getTopic(String id) {
        return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topics topic) {
        topics.add(topic);
    }

    public void updateTopic(Topics topic, String id) {
        for(int i=0;i<topics.size();i++){
            Topics t=topics.get(i);
            if(t.getId().equals(topic.getId())){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));
    }
}
