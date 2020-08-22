package com.ktds.esign.client.example.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ListReq {

    @Data
    @JsonIgnoreProperties
    public static class SearchDto implements Serializable {
        private static final long serialVersionUID = -4087399523870085728L;
        private Long id;
        private String userPledgeStatus;
        private String pledgeType;
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

}
