package ma.ayman.spring.springprojettp.repository;

import ma.ayman.spring.springprojettp.entité.Consultation;
import ma.ayman.spring.springprojettp.entité.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {


}
