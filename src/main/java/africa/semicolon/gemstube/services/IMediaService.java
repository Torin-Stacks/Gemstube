package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.UploadMediaRequest;
import africa.semicolon.gemstube.dto.UploadMediaResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.exceptions.MediaUploadException;
import africa.semicolon.gemstube.models.Media;
import africa.semicolon.gemstube.models.User;

public interface IMediaService {
   UploadMediaResponse upload(UploadMediaRequest request) throws GemstubeException;

   Media getMediaById(Long mediaId) throws GemstubeException;
}
