package br.com.timetrialfactory.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import java.io.File;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.com.timetrialfactory.images.Images;
import br.com.timetrialfactory.model.entity.Game;

@Resource
public class ImagesController {

    private final Validator validator;
    private final Images images;
    private final Result result;

    public ImagesController(Validator validator, Images images, Result result) {
        this.validator = validator;
        this.images = images;
        this.result = result;
    }

    @Post("/games/{game.id}/image")
    public void upload(final UploadedFile image, Game game) {
        validator.checking(new Validations() {
            {
                if (that(image, is(notNullValue()), "image", "imagem.nula")) {
                    that(image.getContentType(), startsWith("image"), "image", "nao.eh.imagem");
                }
            }
        });
        validator.onErrorRedirectTo(GamesController.class).edit(game.getId());
        images.save(image, game);
        result.redirectTo(GamesController.class).edit(game.getId());
    }

    @Get("/games/{game.id}/image")
    public File download(Game game) {
        return images.show(game);
    }
}
