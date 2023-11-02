package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.AddCommentRequest;
import africa.semicolon.gemstube.dto.ApiResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest

public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    @Sql("/insert.sql")
    public void testAddComment() throws GemstubeException {
        AddCommentRequest addCommentRequest = new AddCommentRequest();
        addCommentRequest.setCommenterId(2L);
        addCommentRequest.setComment("I hate your picture");
        var response = commentService.addComment(102L, addCommentRequest) ;
        org.assertj.core.api.Assertions.assertThat(response).isNotNull();
        org.assertj.core.api.Assertions.assertThat(response).isInstanceOf(ApiResponse.class);

    }

}
