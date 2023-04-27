package ma.ayman.spring.springprojettp.repository;

import ma.ayman.spring.springprojettp.entité.Medecin;
import ma.ayman.spring.springprojettp.entité.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    List<Medecin> findByNomContaining(String name);

    //Medecin findByNom(String nom);
}
