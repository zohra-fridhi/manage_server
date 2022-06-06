package com.itfridhi.server.repositories;

import com.itfridhi.server.models.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ServerRepo extends JpaRepository<Server, Long> {
    Collection<Server> findAll(int limit);

   Server findByIpAdress(String ipAdress);
}
