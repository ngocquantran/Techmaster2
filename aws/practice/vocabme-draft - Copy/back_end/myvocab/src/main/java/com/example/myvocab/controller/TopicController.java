package com.example.myvocab.controller;


import com.example.myvocab.dto.CommentDto;
import com.example.myvocab.dto.FilterVocabDto;
import com.example.myvocab.dto.TopicToCourseDto;
import com.example.myvocab.model.Comments;
import com.example.myvocab.model.Sentence;
import com.example.myvocab.model.Topic;
import com.example.myvocab.model.Vocab;
import com.example.myvocab.request.CommentRequest;
import com.example.myvocab.service.UserLearningService;
import com.example.myvocab.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TopicController {
    @Autowired private ViewService viewService;
    @Autowired private UserLearningService userLearningService;

    @GetMapping("/topic/{id}")
    public Topic getTopicById(@PathVariable Long id){
        return viewService.getTopicById(id);
    }

    @GetMapping("/topic/{id}/vocabs")
    public List<Vocab> getVocabsByTopic(@PathVariable("id") Long topicId){
        return viewService.getVocabsByTopic(topicId);
    }

    @GetMapping("/topic/{id}/sentences")
    public List<Sentence> getSentencesByTopic(@PathVariable("id") Long topicId){
        return viewService.getSentencesByTopic(topicId);
    }

    @GetMapping("/topic/{id}/filter-vocabs")
    public List<FilterVocabDto> getTopicVocabsToFilter(@PathVariable("id") Long topicId){
        return viewService.getTopicVocabsToFilter(topicId);
    }

    @GetMapping("/topic/{id}/to-course")
    public TopicToCourseDto getCourseFromTopic(@PathVariable("id") Long topicId){
        return viewService.getCourseFromTopic(topicId);
    }

    @GetMapping("/topic/{id}/comments")
    public List<CommentDto> getAllTopicComments(@PathVariable("id") Long topicId){

        return userLearningService.getAllCommentsByTopic(topicId);
    }

    @PostMapping(value = "/topic/{id}/create_comment",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Comments createComment(@PathVariable("id") Long topicId,@RequestBody CommentRequest request){
        System.out.println(request);
        return userLearningService.createComment(topicId,"1",request);
    }

}
