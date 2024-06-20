package com.example.moviezip.controller;

import com.example.moviezip.domain.Review;
import com.example.moviezip.service.ReviewImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class ReviewController {

    private final ReviewImpl reviewImpl;

    @Autowired
    public ReviewController(ReviewImpl reviewImpl) {
        this.reviewImpl = reviewImpl;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{mvId}/regReview")
    public void insertMyReview(@RequestBody Review review, @PathVariable Long mvId) {
        try {
            // 필수 필드 설정
            review.setMvId(mvId); // Review 객체에 mvId 설정
            review.setIs_Critic("N"); // 평론가 여부 설정
            reviewImpl.insertMyReview(review); // 서비스로 리뷰 저장 요청
            System.out.println("리뷰가 성공적으로 저장되었습니다: " + review.getContent());
        } catch (Exception e) {
            System.out.println("실패");
            e.printStackTrace();
            // 필요에 따라 예외 처리 로직 추가
        }
    }
}
