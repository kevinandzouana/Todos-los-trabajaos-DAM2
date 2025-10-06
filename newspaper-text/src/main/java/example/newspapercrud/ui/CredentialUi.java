package example.newspapercrud.ui;

import jakarta.inject.Inject;
import example.newspapercrud.domain.service.CredentialService;
import example.newspapercrud.domain.model.CredentialDTO;

public class CredentialUi {
    private final CredentialService credentialService;
    @Inject
    public CredentialUi(CredentialService credentialService) {
        this.credentialService = credentialService;
    }
    public boolean checkLogin(CredentialDTO credentialDTO){
        return credentialService.checklogin(credentialDTO);
    }


}
