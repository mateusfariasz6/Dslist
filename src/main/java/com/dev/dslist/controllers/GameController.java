package com.dev.dslist.controllers;

import com.dev.dslist.dtos.GameMaxGetRequestDto;
import com.dev.dslist.dtos.GameMinGetRequestDto;
import com.dev.dslist.dtos.GamePostRequestDto;
import com.dev.dslist.services.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    @PostMapping
    public ResponseEntity<GameMaxGetRequestDto> save(@RequestBody @Valid GamePostRequestDto gamePostRequestDto){
        URI uri = URI.create("/game");
        return ResponseEntity.created(uri).body(gameService.save(gamePostRequestDto));
    }
}
