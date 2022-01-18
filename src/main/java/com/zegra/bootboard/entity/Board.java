package com.zegra.bootboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Board extends BaseEntity{

    //글번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    //제목
    @Column(length = 200, nullable = false)
    private String title;

    //내용
    @Column(length = 4000, nullable = false)
    private String content;

    //삭제여부
    private char delYn;
    
    //작성자
    @ManyToOne
    private Member writer;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hit;
}
