package fawry.file;

import jakarta.servlet.http.Part;
import org.apache.taglibs.standard.resources.Resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileStorage{

    public static String storeFile(Part file) throws IOException {
        if(file == null){
            throw new NullPointerException("file is null");
        }
        Path path = Path.of("uploads");
        if(!Files.exists(path)){
            Files.createDirectory(path);
        }
        Path filePath = path.resolve(file.getSubmittedFileName());
        try(InputStream in = file.getInputStream();){
            Files.copy(in , filePath , StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(path.toUri().getPath());
        return file.getSubmittedFileName();
    }

    public static File getResources(String fileName) throws IOException {
        Path path = Path.of("uploads/" + fileName);
        if(!Files.exists(path)){
            return null;
        }
        return path.toFile();
    }
}
