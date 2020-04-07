package br.com.mosdev.apisiteviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mosdev.apisiteviagem.model.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long>{

}
