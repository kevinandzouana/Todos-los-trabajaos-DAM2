package example.newspapercrud.domain.service;

import jakarta.inject.Inject;
import example.newspapercrud.dao.CredentialRepository;
import example.newspapercrud.dao.basic.CredentialRepositoryBasic;
import example.newspapercrud.dao.model.CredentialEntity;
import example.newspapercrud.domain.model.CredentialDTO;

public class CredentialService {
    private final CredentialRepository credentialRepository;

    @Inject
    public CredentialService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }
    public boolean checklogin(CredentialDTO credentialDTO) {
       CredentialEntity credentialEntity= credentialRepository.get(credentialDTO.getUsername());
            if (credentialEntity.getPassword().equals(credentialDTO.getPassword())) {

            }
       return credentialEntity.getPassword().equals(credentialDTO.getPassword());
    }
}
