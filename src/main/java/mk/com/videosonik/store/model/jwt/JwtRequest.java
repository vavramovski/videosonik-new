package mk.com.videosonik.store.model.jwt;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String pass;

    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }


}