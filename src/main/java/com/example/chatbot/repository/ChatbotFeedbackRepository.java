package com.example.chatbot.repository;

import com.example.chatbot.model.ChatbotFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotFeedbackRepository extends JpaRepository<ChatbotFeedback, Long> {
}
