package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.dto.RegisterResponse;

public interface IUserService {
    RegisterResponse register(RegisterRequest registerRequest);
}

