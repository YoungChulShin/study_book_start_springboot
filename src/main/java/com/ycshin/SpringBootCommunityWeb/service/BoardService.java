package com.ycshin.SpringBootCommunityWeb.service;

import com.ycshin.SpringBootCommunityWeb.domain.Board;
import com.ycshin.SpringBootCommunityWeb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());

        return  boardRepository.findAll(pageable);
    }

    public Board findBoardByIdx(Long idx) {
        return  boardRepository.findById(idx).orElse(new Board());
    }
}
