package com.zegra.bootboard.dto;

import com.zegra.bootboard.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {

    /**
     * 글번호
     */
    private Long bno;

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String content;

    /**
     * 삭제여부
     */
    private char delYn;

    /**
     * 작성자
     */
    private long writer;

    /**
     * 등록일
     */
    private LocalDateTime regDate;

    /**
     * 수정일
     */
    private LocalDateTime modDate;

    /**
     * 조회수
     */
    private int hit;
}
