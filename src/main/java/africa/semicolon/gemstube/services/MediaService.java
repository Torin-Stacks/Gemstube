package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.UploadMediaRequest;
import africa.semicolon.gemstube.dto.UploadMediaResponse;
import africa.semicolon.gemstube.dto.UploadSubtitleRequest;
import africa.semicolon.gemstube.dto.UploadSubtitleResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.exceptions.MediaUploadException;
import africa.semicolon.gemstube.models.Media;
import africa.semicolon.gemstube.models.User;
import africa.semicolon.gemstube.repositories.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MediaService implements IMediaService{


   private final ICloudService iCloudService;

    private final MediaRepository mediaRepository;

    private final UserService userService;

    private final ModelMapper modelMapper;
    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) throws GemstubeException {

        String mediaUrlFromCloudinary = iCloudService.upload(request.getMuiltipartfile());

        String subtitleUrlFromCloudinary="";
        if (request.getSubtitleFile().isPresent()) {
           subtitleUrlFromCloudinary = iCloudService.upload(request.getSubtitleFile().get());
        }
        User user = userService.getUserById(request.getCreatorId());

        Media media = modelMapper.map(request,Media.class);
        media.setUrl(mediaUrlFromCloudinary);
        media.setUploader(user);
        media.setSubtitleUrl(subtitleUrlFromCloudinary);
        Media savedMedia = mediaRepository.save(media);

        UploadMediaResponse uploadResponse = new UploadMediaResponse();
        modelMapper.map(savedMedia, uploadResponse);
        uploadResponse.setMediaId(savedMedia.getId());
        uploadResponse.setResponse("media uploaded");
        return uploadResponse;


    }

    public UploadSubtitleResponse uploadSubtitle(UploadSubtitleRequest uploadSubtitleRequest) throws GemstubeException {
        String subtitleUrl = iCloudService.upload(uploadSubtitleRequest.getSubtitleFIle());
        Long mediaId = uploadSubtitleRequest.getMediaId();
        Media foundMedia = getMediaById(mediaId);
        foundMedia.setSubtitleUrl(subtitleUrl);
        mediaRepository.save(foundMedia);
        UploadSubtitleResponse response = new UploadSubtitleResponse();
        response.setResponse("subtitle upload successful");
        return response;
    }

    @Override
    public Media getMediaById(Long mediaId) throws GemstubeException {
        return mediaRepository.findById(mediaId).orElseThrow(()->new GemstubeException(String.format("media with id %d not found", mediaId)));
    }
}
