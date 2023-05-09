package com.dev.dslist.controllers;

import com.dev.dslist.dtos.GameMinGetRequestDto;
import com.dev.dslist.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    @GetMapping
    public ResponseEntity<List<GameMinGetRequestDto>> listAll(Pageable pageable){
        return ResponseEntity.ok(gameService.listAll(pageable));
    }
}
