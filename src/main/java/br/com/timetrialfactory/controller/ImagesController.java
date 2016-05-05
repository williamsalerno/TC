package br.com.timetrialfactory.controller;

import java.io.File;
import java.io.IOException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.timetrialfactory.images.Images;
import br.com.timetrialfactory.model.entity.Game;

@Resource
public class ImagesController {

    private final Images images;
    private final Result result;

    public ImagesController(Images images, Result result) {
        this.images = images;
        this.result = result;
    }

    @Post("/games/{game.id}/image")
    public void upload(Game game, final UploadedFile image) throws IOException {
        images.save(game, image);
        result.redirectTo(GamesController.class).edit(game.getId());
    }

    @Get("/games/{game.id}/image")
    public File download(Game game) {
        return images.show(game);
    }
}
