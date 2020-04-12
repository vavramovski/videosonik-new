package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.config.JwtTokenUtil;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.model.jwt.JwtRequest;
import mk.com.videosonik.store.model.jwt.JwtResponse;
import mk.com.videosonik.store.repository.UserRepository;
import mk.com.videosonik.store.service.UserService;
import mk.com.videosonik.store.service.jwt.JwtUserDetailsService;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(path = "/authenticate")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class AuthenticateREST {

    private final UserService userService;


    //    @Autowired
    private AuthenticationManager authenticationManager;

    //    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //    @Autowired
    private JwtUserDetailsService userDetailsService;


    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPass());

        //user i enkriptiran pass
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);

        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping(path = "/register")
    public void register(@RequestBody User user) throws Exception   {
        if(validateEmail(user.getEmail()))
            userService.addUser(user);
        else throw new Exception("WRONG EMAIL");
    }

    private boolean validateEmail(String email){
        String regex = "[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher= pattern.matcher(email.subSequence(0,email.length()));
        return matcher.matches();
    }


}