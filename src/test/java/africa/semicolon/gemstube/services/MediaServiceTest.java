package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.UploadMediaRequest;
import africa.semicolon.gemstube.dto.UploadMediaResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.exceptions.MediaUploadException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

public class MediaServiceTest {
    @Autowired
    private IMediaService mediaService;
    @Test
    public void testUploadMedia() throws GemstubeException {
        UploadMediaRequest request = new UploadMediaRequest();
        request.setCreatorId(1L);
        request.setDescription("This is our test media");
        request.setMuiltipartfile(getTestFile());
        UploadMediaResponse response = mediaService.upload(request);
        assertNotNull(response);
    }

    public static MultipartFile getTestFile() {
        Path path = Paths.get("/home/user/Downloads/gemstube/src/main/resources/assets/New-mtn-logo.jpg");
        try(var inputStream = Files.newInputStream(path);){
             return new MockMultipartFile("New-mtn-logo.jpg", inputStream);
        }

        catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
