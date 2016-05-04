package br.com.timetrialfactory.images;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.Game;

@Component
public class Images {

    private File imagesFolder;

    public Images(ServletContext context) {
        String imagesPath = context.getRealPath("/WEB-INF/images");
        this.imagesFolder = new File(imagesPath);
        this.imagesFolder.mkdir();
    }

    public void save(UploadedFile image, Game game) {
        File destiny = new File(imagesFolder, game.getId() + ".image");

        try {
            IOUtils.copy(image.getFile(), new FileOutputStream(destiny));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao copiar imagem.", e);
        }
    }

    public File show(Game game) {
        return new File(imagesFolder, game.getId() + ".image");
    }

}
