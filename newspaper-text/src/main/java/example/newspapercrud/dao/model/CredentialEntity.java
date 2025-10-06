package example.newspapercrud.dao.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialEntity {
    private String username;
    private String password;
    private int idReader;

}
