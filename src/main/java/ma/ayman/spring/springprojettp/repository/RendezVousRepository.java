package ma.ayman.spring.springprojettp.repository;

import ma.ayman.spring.springprojettp.entité.Patient;
import ma.ayman.spring.springprojettp.entité.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {


}
