package com.example.chatbot.controller;

import com.example.chatbot.model.ChatbotFeedback;
import com.example.chatbot.model.User;
import com.example.chatbot.repository.ChatbotFeedbackRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeedbackController {

    private final ChatbotFeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(ChatbotFeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @PostMapping("/submit-feedback") // "localhost:8001" 제거
    public ResponseEntity<String> submitFeedback(@RequestBody Map<String, Object> feedbackData, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        String userIdString = user.getUserId();
        if (userIdString == null || userIdString.isEmpty()) {
            return ResponseEntity.badRequest().body("User ID가 null이거나 비어 있습니다.");
        }

        Long userId;
        try {
            userId = Long.parseLong(userIdString);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("User ID를 Long 타입으로 변환할 수 없습니다.");
        }

        Integer rating = (Integer) feedbackData.get("rating");
        String feedbackComment = (String) feedbackData.getOrDefault("feedbackComment", "");

        if (rating == null) {
            return ResponseEntity.badRequest().body("필수 필드(rating)가 누락되었습니다.");
        }

        ChatbotFeedback feedback = new ChatbotFeedback();
        feedback.setUserId(userId);
        feedback.setRating(rating);
        feedback.setFeedbackComment(feedbackComment);

        feedbackRepository.save(feedback);

        return ResponseEntity.ok("피드백이 성공적으로 저장되었습니다.");
    }
}