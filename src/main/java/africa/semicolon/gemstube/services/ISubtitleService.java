package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.UploadSubtitleRequest;
import africa.semicolon.gemstube.dto.UploadSubtitleResponse;
import africa.semicolon.gemstube.exceptions.MediaUploadException;

public interface ISubtitleService {
    UploadSubtitleResponse uploadSubtitle(UploadSubtitleRequest uploadSubtitleRequest) throws MediaUploadException;
}
