package br.com.mosdev.apisiteviagem.repository;

import java.util.Optional;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mosdev.apisiteviagem.model.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long>{
	
  @Query("SELECT r FROM Rota r WHERE r.aeroportoOrigem.id = :idOrigem AND  r.aeroportoDestino.id = :idDestino")
  Optional<Rota> findByOrigemDestino(@Param("idOrigem")Long idOrigem, @Param("idDestino")Long idDestino);

}
