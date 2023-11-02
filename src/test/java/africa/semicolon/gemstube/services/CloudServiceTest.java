package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaUploadException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {
    @Autowired
    private ICloudService cloudService;

    private static final String IMAGE_FILE = "/home/user/Downloads/gemstube/src/main/resources/assets/New-mtn-logo.jpg";

    private static final String VIDEO_FILE = "/home/user/Downloads/gemstube/src/main/resources/assets/Thanos _You could not live with your own failure_ (Avengers End Game Trailer).mp4";

    private static final String AUDIO_FILE = "/home/user/Downloads/gemstube/src/main/resources/assets/Ed Sheeran - Castle On The Hill [Official Music Video].mp3";
    @Test
    public void testUploadImageFile() throws MediaUploadException {


        String response = cloudService.upload(MediaServiceTest.getTestFile(IMAGE_FILE));
       assertNotNull(response);

    }
    @Test
    public void testUploadVideoFile() throws MediaUploadException {

        String response = cloudService.upload(MediaServiceTest.getTestFile(VIDEO_FILE));
        assertNotNull(response);
    }

    @Test
    public void testUploadAudioFile() throws MediaUploadException {

        String response = cloudService.upload(MediaServiceTest.getTestFile(AUDIO_FILE));
        assertNotNull(response);
    }
}
