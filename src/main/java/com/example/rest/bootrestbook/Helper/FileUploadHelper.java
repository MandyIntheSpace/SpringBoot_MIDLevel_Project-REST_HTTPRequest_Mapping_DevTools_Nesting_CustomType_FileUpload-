package com.example.rest.bootrestbook.Helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "C:\\Users\\Acer\\Desktop\\Spring\\Rest_API\\bootrestbook\\src\\main\\resources\\static\\images";

    public boolean fileUploadChecker(MultipartFile multipartFile) {
        boolean file = false;
        try{
//            InputStream stream = multipartFile.getInputStream();
//            byte data[] = new byte[stream.available()];
//            FileOutputStream outputStream = new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
//            System.out.println(outputStream);
//             outputStream.write(data);
//             outputStream.close();
//             file = true;
            Path filePath = Paths.get(UPLOAD_DIR, multipartFile.getOriginalFilename());
            Files.copy(multipartFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            file = true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
