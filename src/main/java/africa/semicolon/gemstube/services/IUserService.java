package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.dto.RegisterResponse;
import africa.semicolon.gemstube.dto.UserResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.models.User;

public interface IUserService {
    RegisterResponse register(RegisterRequest registerRequest);

    User getUserById(Long creatorId) throws GemstubeException;

    UserResponse getUserInfo(Long creatorId)throws GemstubeException;
}

