package run;

import com.google.api.client.auth.oauth2.Credential;

public interface CredentialFactory {
    String CREDENTIAL_FACTORY_PROPERTY = "cloudSql.socketFactory.credentialFactory";

    Credential create();
}