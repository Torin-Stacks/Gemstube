package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.UploadMediaRequest;
import africa.semicolon.gemstube.dto.UploadMediaResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.exceptions.MediaUploadException;
import africa.semicolon.gemstube.models.Media;
import africa.semicolon.gemstube.models.User;
import africa.semicolon.gemstube.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class MediaService implements IMediaService{

    @Autowired
   private ICloudService iCloudService;
    private MediaRepository mediaRepository;
    @Autowired
    private UserService userService;
    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) throws GemstubeException {
        String mediaUrlFromCloudinary = iCloudService.upload(request.getMuiltipartfile());
        User user = userService.getUserById(request.getCreatorId());
        Media media = new Media();
        media.setDescription(request.getDescription());
        media.setUrl(mediaUrlFromCloudinary);
        media.setTitle(request.getTitle());
        media.setCreatedAt(LocalDateTime.now());
        media.setUploader(user);
        mediaRepository.save(media);
        return null;


    }
}
