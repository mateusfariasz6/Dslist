package com.dev.dslist.dtos;

import com.dev.dslist.entities.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GamePostRequestDto(
        @NotBlank
        String title,
        @NotNull
        Integer year,
        @NotBlank
        String genre,
        @NotBlank
        String platforms,
        Double score,
        @NotBlank
        String imgUrl,
        String description) {

        public Game toGame(){
                Game game = new Game();
                game.setDescription(this.description);
                game.setGenre(this.genre);
                game.setScore(this.score);
                game.setYear(this.year);
                game.setPlatforms(this.platforms);
                game.setImgUrl(this.imgUrl);
                game.setTitle(this.title);
                return game;
        }
}
