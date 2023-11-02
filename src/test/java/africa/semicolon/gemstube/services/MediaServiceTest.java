package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.dto.UploadMediaRequest;
import africa.semicolon.gemstube.dto.UploadMediaResponse;
import africa.semicolon.gemstube.dto.UploadSubtitleRequest;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

public class MediaServiceTest {
    @Autowired
    private IMediaService mediaService;
    @Autowired
    private IUserService iUserService;
    @Test
    public void testUploadMediaWithoutSubtitleUrl() throws GemstubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@emil.com");
        registerRequest.setPassword(" password");
        iUserService.register(registerRequest);
        UploadMediaRequest request = new UploadMediaRequest();
        request.setCreatorId(1L);
        request.setDescription("This is our test media");
        request.setMuiltipartfile(getTestFile("/home/user/Downloads/gemstube/src/main/resources/assets/New-mtn-logo.jpg"));
        request.setSubtitleFile(Optional.empty());
        UploadMediaResponse response = mediaService.upload(request);
        assertNotNull(response);
    }

    @Test
    public void testUploadMediaWithSubtitleUrl() throws GemstubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@emil.com");
        registerRequest.setPassword(" password");
        iUserService.register(registerRequest);
        UploadMediaRequest request = new UploadMediaRequest();
        request.setCreatorId(1L);
        request.setDescription("This is our test media");
        request.setMuiltipartfile(getTestFile("/home/user/Downloads/gemstube/src/main/resources/assets/New-mtn-logo.jpg"));
        request.setSubtitleFile(Optional.of(getTestFile("/home/user/Downloads/gemstube/src/main/resources/assets/subtitle.txt")));
        UploadMediaResponse response = mediaService.upload(request);
        assertNotNull(response);
    }

@Test

    public void TestUploadSubtitleToMedia() throws GemstubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@emil.com");
        registerRequest.setPassword(" password");
        iUserService.register(registerRequest);
        UploadMediaRequest request = new UploadMediaRequest();
        request.setCreatorId(1L);
        request.setDescription("This is our test media");
        request.setMuiltipartfile(getTestFile("/home/user/Downloads/gemstube/src/main/resources/assets/New-mtn-logo.jpg"));
        request.setSubtitleFile(Optional.empty());
        UploadMediaResponse response = mediaService.upload(request);

        UploadSubtitleRequest uploadSubtitleRequest = new UploadSubtitleRequest();
        uploadSubtitleRequest.setSubtitleFIle(getTestFile("/home/user/Downloads/gemstube/src/main/resources/assets/subtitle.txt"));
        uploadSubtitleRequest.setMediaId(response.getMediaId());
    }

    public static MultipartFile getTestFile( String fileLocation) {
        Path path = Paths.get(fileLocation);
        try(var inputStream = Files.newInputStream(path);){
             return new MockMultipartFile("New-mtn-logo.jpg", inputStream);
        }

        catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
