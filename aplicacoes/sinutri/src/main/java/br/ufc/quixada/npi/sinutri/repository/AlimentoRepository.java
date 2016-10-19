package br.ufc.quixada.npi.sinutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.quixada.npi.sinutri.model.Alimento;
import br.ufc.quixada.npi.sinutri.model.enuns.FonteAlimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
	@Query("select a.id, a.nome, a.medidaCaseira, a.medidaPadrao, a.valorMedidaCaseira, a.valorMedidaPadrao from Alimento a where a.fonte like :fonte") 
	List<Alimento> getAlimentosByFonte(@Param("fonte") FonteAlimento fonte);
}