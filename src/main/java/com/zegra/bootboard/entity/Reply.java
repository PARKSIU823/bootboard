package com.zegra.bootboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Reply extends BaseEntity{

    //댓글 번호
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long rno;

    //댓글 내용
    private String rtext;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Board board;

}
