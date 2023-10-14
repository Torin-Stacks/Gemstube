package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface ICloudService {

     String upload(MultipartFile file) throws MediaUploadException;
}
