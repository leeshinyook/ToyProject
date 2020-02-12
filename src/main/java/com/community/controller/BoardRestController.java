package com.community.controller;

import com.community.domain.Board;
import com.community.repository.BoardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardRestController {

    private BoardRepository boardRepository;

    public BoardRestController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllBoard(){
        List<Board> board = boardRepository.findAll();
        return ResponseEntity.ok(board);
    }

    @GetMapping("/{idx}")
    public ResponseEntity<?> getOneBoard(@PathVariable("idx") Long idx) {
        Board board = boardRepository.getOne(idx);
        return ResponseEntity.ok(board);
    }

    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody Board board) {
        board.setCreatedDate(LocalDateTime.now());
        boardRepository.save(board);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) {
        Board board = boardRepository.getOne(idx);
        boardRepository.delete(board);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


}
