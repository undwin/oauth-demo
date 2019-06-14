package win.und.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import win.und.demo.entity.Client;

@Mapper
public interface ClientDao {
    Client queryClientByClientId(String clientId);
}
