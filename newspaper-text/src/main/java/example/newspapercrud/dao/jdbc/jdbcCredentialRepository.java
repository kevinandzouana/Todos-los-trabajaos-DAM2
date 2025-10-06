package example.newspapercrud.dao.jdbc;

import example.newspapercrud.dao.CredentialRepository;
import example.newspapercrud.dao.model.CredentialEntity;

import java.util.List;

public class jdbcCredentialRepository implements CredentialRepository {
    @Override
    public List<CredentialEntity> getAll() {
        return List.of();
    }

    @Override
    public CredentialEntity get(String username) {
        return null;
    }

    @Override
    public int save(CredentialEntity credential) {
        return 0;
    }

    @Override
    public boolean delete(CredentialEntity credential) {
        return false;
    }

    @Override
    public void update(CredentialEntity credential) {

    }
}
