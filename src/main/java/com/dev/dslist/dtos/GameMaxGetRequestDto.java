package com.dev.dslist.dtos;

import com.dev.dslist.entities.Game;

public record GameMaxGetRequestDto(
        Long id,
        String title,
        Integer year,
        String genre,
        String platforms,
        Double score,
        String imgUrl,
        String description
) {
    public GameMaxGetRequestDto(Game game){
        this(game.getId(), game.getTitle(), game.getYear(), game.getGenre(), game.getPlatforms(), game.getScore(), game.getImgUrl(), game.getDescription());
    }
}
