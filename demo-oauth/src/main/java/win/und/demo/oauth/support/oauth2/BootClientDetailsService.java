package win.und.demo.oauth.support.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;
import win.und.demo.entity.Client;
import win.und.demo.service.ClientService;

/**
 * @author yuit
 * @date  2018/10/16  9:22
 *
 **/
@Component
public final class BootClientDetailsService implements ClientDetailsService {
    @Autowired
    private ClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = clientService.queryClientByClientId(clientId);
        if(client == null){
            throw new ClientRegistrationException("客户端不存在");
        }
        BootClientDetails details=new BootClientDetails(client);
        return details;
    }

}
