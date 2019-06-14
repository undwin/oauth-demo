package win.und.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.und.demo.dao.ClientDao;
import win.und.demo.entity.Client;
import win.und.demo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public Client queryClientByClientId(String clientId) {
        return clientDao.queryClientByClientId(clientId);
    }
}
