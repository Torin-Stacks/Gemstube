package africa.semicolon.gemstube.controllers;

import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.repositories.UserRepository;
import africa.semicolon.gemstube.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping()
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<>(userService.register(registerRequest),HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getUserById (@PathVariable Long id){
        try{
        return new ResponseEntity<>(userService.getUserInfo(id),HttpStatus.OK);}
        catch(GemstubeException e)
        {return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);}
    }

}
