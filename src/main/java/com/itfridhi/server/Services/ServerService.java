package com.itfridhi.server.Services;

import com.itfridhi.server.models.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Optional;

public interface ServerService {

    Server create(Server server);

    Server getbyId(Long id);

    void delete(Long id);

    Collection<Server> list(int limit);

    Server ping(String ipAdress) throws IOException;
    Server update(Server server);

}
