package win.und.demo.service;

import win.und.demo.entity.Client;

public interface ClientService {
    Client queryClientByClientId(String clientId);
}
