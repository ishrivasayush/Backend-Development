package com.narainox.bookmanager.Helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Component
public class FileUploadHelper {

    //Static Path
    // public final String UPLOAD_DIR="C:\\Users\\Dell\\OneDrive\\Desktop\\BackendDevelopment\\book-manager\\src\\main\\resources\\static\\Images";

    //Daynamic  Path

    public final String UPLOAD_DIR=new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploadHelper()throws IOException {

    }

    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean upload=false;
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            upload=true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return upload;
    }
}
