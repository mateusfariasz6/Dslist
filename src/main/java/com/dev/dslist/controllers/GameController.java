package com.dev.dslist.controllers;

import com.dev.dslist.dtos.GameMaxGetRequestDto;
import com.dev.dslist.dtos.GameMinGetRequestDto;
import com.dev.dslist.dtos.GamePostRequestDto;
import com.dev.dslist.dtos.GameUpdateRequestDto;
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
    @GetMapping("/{id}")
    public ResponseEntity<GameMaxGetRequestDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.findById(id));
    }
    @PostMapping
    public ResponseEntity<GameMaxGetRequestDto> save(@RequestBody @Valid GamePostRequestDto gamePostRequestDto){
        URI uri = URI.create("/game");
        return ResponseEntity.created(uri).body(gameService.save(gamePostRequestDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GameMaxGetRequestDto> update(@RequestBody @Valid GameUpdateRequestDto gameUpdateRequestDto, @PathVariable Long id){
        return ResponseEntity.ok(gameService.update(id, gameUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        gameService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
