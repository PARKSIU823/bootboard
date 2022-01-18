package com.zegra.bootboard.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {

    //게시글 리스트
    private List<DTO> dtoList;

    //총 페이지 번호
    private int totalPage;

    //현재 페이지 번호
    private int pageNo;

    //목록 사이즈
    private int size;

    //시작 페이지 번호
    private int startNo;

    //끝 페이지 번호
    private int endNo;

    //이전 페이지 여부
    private boolean prevNo;

    //다음 페이지 여부
    private boolean nextNo;

    //페이지 번호 목록
    private List<Integer> pageList;

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    public void makePageList(Pageable pageable) {

        this.pageNo = pageable.getPageNumber() + 1; //JPA는 0부터 페이지 시작
        this.size = pageable.getPageSize();

        int tempEndNo = (int) (Math.ceil(pageNo/20.0)) * 10;
        startNo = tempEndNo - 9;
        prevNo = startNo > 1;
        endNo = totalPage > tempEndNo ? tempEndNo : totalPage;
        nextNo = totalPage > tempEndNo;

        pageList = IntStream.rangeClosed(startNo, endNo).boxed().collect(Collectors.toList());
    }


}
