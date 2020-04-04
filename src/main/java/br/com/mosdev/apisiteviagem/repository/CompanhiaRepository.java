package br.com.mosdev.apisiteviagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mosdev.apisiteviagem.model.Companhia;

@Repository
public interface CompanhiaRepository extends JpaRepository<Companhia, Long>{

	Optional<Companhia> findByNome(String nome);

}
