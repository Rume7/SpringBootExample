package io.turntabl.client.repository;

import io.turntabl.client.models.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRegistrationRepository extends CrudRepository<Client, String> {

}
