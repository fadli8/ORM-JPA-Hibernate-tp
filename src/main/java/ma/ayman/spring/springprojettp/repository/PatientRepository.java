package ma.ayman.spring.springprojettp.repository;

import ma.ayman.spring.springprojettp.entité.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient , Long> {
    List<Patient> findByNomContaining(String name);

    //Patient findByNom(String nom);
}
