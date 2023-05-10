package com.dev.dslist.dtos;

import com.dev.dslist.entities.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GameUpdateRequestDto(
        @NotBlank
        String title,
        @NotNull
        Integer year,
        @NotBlank
        String genre,
        @NotBlank
        String platforms,
        Double score,
        String imgUrl,
        String description
) {
    public Game toGame(Game game){
       game.setTitle(title);
       game.setYear(year);
       game.setScore(score);
       game.setGenre(genre);
       game.setDescription(description);
       game.setPlatforms(platforms);
       game.setImgUrl(imgUrl);
       return game;
    }
}
