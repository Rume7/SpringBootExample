package io.turntabl.client;

import io.turntabl.client.models.Client;
import io.turntabl.client.repository.ClientRegistrationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ClientApplication {

	@Bean
	public ClientRegistrationRepository createRepo() {
		return new ClientRegistrationRepository() {
			@Override
			public <S extends Client> S save(S entity) {
				return null;
			}

			@Override
			public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
				return null;
			}

			@Override
			public Optional<Client> findById(String s) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(String s) {
				return false;
			}

			@Override
			public Iterable<Client> findAll() {
				return null;
			}

			@Override
			public Iterable<Client> findAllById(Iterable<String> strings) {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(String s) {

			}

			@Override
			public void delete(Client entity) {

			}

			@Override
			public void deleteAllById(Iterable<? extends String> strings) {

			}

			@Override
			public void deleteAll(Iterable<? extends Client> entities) {

			}

			@Override
			public void deleteAll() {

			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

}
