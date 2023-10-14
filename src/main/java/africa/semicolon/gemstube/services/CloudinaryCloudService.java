package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaUploadException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class CloudinaryCloudService implements ICloudService{
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile file) throws MediaUploadException {
        try{
       Map<?,?> uploadResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
       log.info("upload response ->{}",uploadResponse.get("url"));

       return (String) uploadResponse.get("secure_url");

    }
        catch(IOException e){
            throw new MediaUploadException(e.getMessage());  }
    }
}
