package mk.com.videosonik.store.web;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.config.JwtTokenUtil;
import mk.com.videosonik.store.model.Admin;
import mk.com.videosonik.store.model.ContactEMail;
import mk.com.videosonik.store.model.User;
import mk.com.videosonik.store.service.ContactService;
import mk.com.videosonik.store.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/contact")
@AllArgsConstructor
public class ContactREST {
    private final ContactService contactService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    @PostMapping(path = "/send")
    public void sendContact(@RequestBody ContactEMail contactEMail ){
        contactService.sendContact(contactEMail);
    }

    @GetMapping(path = "/all")
    public List<ContactEMail> getAllEmails(@RequestHeader(name = "Authorization") String header) throws Exception {
        String token = JwtTokenUtil.getTokenFromHeader(header);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userService.findUserByUsername(username);

        if(user.getClass() == Admin.class)
            return contactService.getAllContacts();
        else
            throw new Exception();
    }

}
