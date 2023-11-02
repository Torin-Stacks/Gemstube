package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.AddCommentRequest;
import africa.semicolon.gemstube.dto.ApiResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;


public interface ICommentService {
    ApiResponse<?> addComment(Long mediaId, AddCommentRequest addCommentRequest) throws GemstubeException;
}
