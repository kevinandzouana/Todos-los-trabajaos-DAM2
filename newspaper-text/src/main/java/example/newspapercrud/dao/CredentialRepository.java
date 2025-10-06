package example.newspapercrud.dao;

import example.newspapercrud.dao.model.CredentialEntity;

import java.util.List;

public interface CredentialRepository {
    List<CredentialEntity> getAll();
    CredentialEntity get(String username);
    int save(CredentialEntity credential);
    boolean delete(CredentialEntity credential);
    void update(CredentialEntity credential);
}
