package com.zegra.bootboard.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity {

    //회원 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    //아이디
    private String email;

    //비밀번호
    private String password;

    //이름
    private String name;

    //펜네임
    private String penName;

    //생년월일
    @Column(length = 8)
    private String birth;

    //탈퇴여부
    private char resignYn;

}
