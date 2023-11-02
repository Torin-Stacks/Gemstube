package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.AddCommentRequest;
import africa.semicolon.gemstube.dto.ApiResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.models.Comment;
import africa.semicolon.gemstube.models.Media;
import africa.semicolon.gemstube.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService{

    private final IMediaService mediaService;

    private final UserService userService;

    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;
    @Override
    public ApiResponse<?> addComment(Long id, AddCommentRequest addCommentRequest) throws GemstubeException {

        Media foundMedia = mediaService.getMediaById(id);
        Comment comment = modelMapper.map(addCommentRequest, Comment.class);
        comment.setMedia(foundMedia);
        comment.setCommenter(userService.getUserById(addCommentRequest.getCommenterId()));
        commentRepository.save(comment);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Comment added successfully");
        return response;
    }
}
