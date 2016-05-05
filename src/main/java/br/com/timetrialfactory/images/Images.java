package br.com.timetrialfactory.images;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.com.timetrialfactory.model.entity.Game;

@Component
public class Images {

    private File imagesFolder;

    public Images(ServletContext context) {
        imagesFolder = new File("C:/uploadImagens");
        imagesFolder.mkdir();
    }

    public void save(Game game, UploadedFile image) throws IOException {
        File destiny = new File("C:/uploadImagens", game.getId() + ".jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(destiny);
        try {
            IOUtils.copy(image.getFile(), fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Não foi possível enviar o arquivo!");
        } finally {
            fileOutputStream.close();
            image.getFile().close();
        }

    }

    public File show(Game game) {
        File file = new File(imagesFolder, game.getId() + ".jpg");
        if (file.exists()) {
            return file;
        } else {
            return new File(imagesFolder + "/default.jpg");
        }
    }

    public void delete(Game game) {
        Path fileToDeletePath = Paths.get("C:/uploadImagens/" + game.getId() + ".jpg");
        try {
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
