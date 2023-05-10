package com.dev.dslist.services;

import com.dev.dslist.dtos.GameMaxGetRequestDto;
import com.dev.dslist.dtos.GameMinGetRequestDto;
import com.dev.dslist.dtos.GamePostRequestDto;
import com.dev.dslist.dtos.GameUpdateRequestDto;
import com.dev.dslist.entities.Game;
import com.dev.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinGetRequestDto> listAll(Pageable pageable) {
        return gameRepository.findAll(pageable).map(GameMinGetRequestDto::new).toList();
    }
    @Transactional
    public GameMaxGetRequestDto save(GamePostRequestDto gamePostRequestDto) {
        Game game = gamePostRequestDto.toGame();
        return new GameMaxGetRequestDto(gameRepository.save(game));
    }
    @Transactional(readOnly = true)
    public GameMaxGetRequestDto findById(Long id) {
        return new GameMaxGetRequestDto(gameRepository.findById(id).orElseThrow());
    }
    @Transactional
    public GameMaxGetRequestDto update(Long id, GameUpdateRequestDto gameUpdateRequestDto) {
        Game game = gameUpdateRequestDto.toGame(gameRepository.findById(id).orElseThrow());
        return new GameMaxGetRequestDto(gameRepository.save(game));
    }
    @Transactional
    public void delete(Long id) {

        if (!gameRepository.existsById(id)){
            throw new NoSuchElementException("Game Not Found!");
        }
        gameRepository.deleteById(id);
    }
}
