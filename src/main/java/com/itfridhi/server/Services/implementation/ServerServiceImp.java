package com.itfridhi.server.Services.implementation;

import com.itfridhi.server.Services.ServerService;
import com.itfridhi.server.emum.Status;
import com.itfridhi.server.models.Server;
import com.itfridhi.server.repositories.ServerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ServerServiceImp implements ServerService {
    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("saving a new server: {}", server.getName());
        server.setUrlImage(setServerImageUrl());
        return serverRepo.save(server);
    }

    private String setServerImageUrl() {
        return null;
    }

    @Override
    public Server ping(String ipAdress) throws IOException {

        log.info("pinging server IP {}", ipAdress);
        Server server = serverRepo.findByIpAdress(ipAdress);
        InetAddress address = InetAddress.getByName(ipAdress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);

        return serverRepo.save(server);
    }

    @Override
    public Server update(Server server) {
        log.info("updating server: {}",server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("fetching all server");
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server getbyId(Long id) {
        log.info("Fetching server by id : {}", id);
        return serverRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        log.info("deleting server: {}",id);
        serverRepo.deleteById(id);
    }


}
