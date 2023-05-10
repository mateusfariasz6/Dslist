package com.dev.dslist.dtos;

import com.dev.dslist.entities.Game;

public record GameMinGetRequestDto(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String description
) {
    public GameMinGetRequestDto(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getDescription());
    }
}
