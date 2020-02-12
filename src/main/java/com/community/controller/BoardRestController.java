package com.community.controller;

import com.community.domain.Board;
import com.community.repository.BoardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneBoard(@PathVariable("id") Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return ResponseEntity.ok(board);
    }

    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody Board board) {
        board.setCreatedDate(LocalDateTime.now());
        boardRepository.save(board);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long idx) {
        Board board = boardRepository.getOne(idx);
        boardRepository.delete(board);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


}
