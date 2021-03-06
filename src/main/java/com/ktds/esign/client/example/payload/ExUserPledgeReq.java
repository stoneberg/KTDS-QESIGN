package com.ktds.esign.client.example.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExUserPledgeReq {

    @Data
    @JsonIgnoreProperties
    public static class SearchDto implements Serializable {
        private static final long serialVersionUID = -4087399523870085728L;
        // 서약유형
        private String contentsType;
        // 승인 진행 유형
        private String progsSttusType;
        // 검색 조건 타입
        private String searchType;
        // 서약명
        private String pledgeName;
        // 요청부서
        private String reqDept;
        // 요청자
        private String reqUser;
        // 날짜 검새 조건(시작, 마감)
        private String dateType;
        // 서약 요청일
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime startDt;
        // 서약 마감일
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private LocalDateTime endDt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties
    public static class CreateDto implements Serializable {
        private static final long serialVersionUID = -5364399554165748530L;
        private String progsSttusType;
        private String contentsType;
        private String pledgeName;
        // 서약 요청일
        private LocalDateTime startDt;
        // 서약 마감일
        private LocalDateTime endDt;
        // 요청부서
        private String reqDept;
        // 요청자
        private String reqUser;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties
    public static class UpdateDto implements Serializable {
        private static final long serialVersionUID = -6322399634165758641L;
        private String progsSttusType;
        private String contentsType;
        private String pledgeName;
    }

}
