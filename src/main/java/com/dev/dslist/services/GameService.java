package com.dev.dslist.services;

import com.dev.dslist.dtos.GameMinGetRequestDto;
import com.dev.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    public List<GameMinGetRequestDto> listAll(Pageable pageable) {
        return gameRepository.findAll(pageable).map(GameMinGetRequestDto::new).toList();
    }
}
