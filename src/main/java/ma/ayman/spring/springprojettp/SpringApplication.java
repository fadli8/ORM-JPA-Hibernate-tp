package ma.ayman.spring.springprojettp;

import ma.ayman.spring.springprojettp.entité.Medecin;
import ma.ayman.spring.springprojettp.entité.Patient;
import ma.ayman.spring.springprojettp.entité.RendezVous;
import ma.ayman.spring.springprojettp.entité.StatusRDV;
import ma.ayman.spring.springprojettp.repository.MedecinRepository;
import ma.ayman.spring.springprojettp.repository.PatientRepository;
import ma.ayman.spring.springprojettp.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//@EnableJpaRepositories
@SpringBootApplication
public class SpringApplication  {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }



  /*  @Override
    public void  run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Hamza", new Date("13/03/2000"),true,80,null));
        patientRepository.save(new Patient(null,"ayman",new Date("01/02/1999"),false,60,null));
        patientRepository.save(new Patient(null,"Hamdi",new Date("20/03/1994"),true,55,null));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        Patient patient=patientRepository.findById(Long.valueOf(1)).get();
        System.out.println("**********************");
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getDateNaissance());
        System.out.println("***********************");
        List<Patient>patientList = patientRepository.findByNomContaining("ayman");
        patientList.forEach(p->{
            System.out.println(p);
        } );
        System.out.println("***********************");
        Optional<Patient> patient2 = patientRepository.findById(Long.valueOf(1));
        patient2.ifPresent(p -> {
            p.setMalade(false);
            p.setScore(50);
            patientRepository.save(p);
            System.out.println(p);
        });
        System.out.println("***********************");
        patientRepository.deleteById(1L);
        Patient deletedPatient = patientRepository.findById(1L).orElse(null);
        if (deletedPatient == null) {
            System.out.println("Le patient a été supprimé");
        } else {
            System.out.println("Le patient n'a pas été supprimé");
        }

        */

    @Bean
            CommandLineRunner start(PatientRepository patientRepository,
                                    MedecinRepository medecinRepository,
                                    RendezVousRepository rendezVousRepository) {
        return args -> {
            Stream.of("ayman", "Hamdi", "Walid")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(Math.random() > 0.5 ? false : true);
                        patient.setScore(Math.random() > 0.5 ? 50 : 70);
                        patientRepository.save(patient);

                    });


            Stream.of("Hassan", "Soufian", "Imene")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name + "@gmail.com");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                        medecinRepository.save(medecin);

                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
           // Patient patient1 = patientRepository.findByNomContaining("ayman");

          // List<Medecin> medecin = medecinRepository.findByNomContaining("Hassan");
            Medecin medecin = medecinRepository.findById(1L).orElse(null);


            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRDV(StatusRDV.PENDING);
            rendezVous.setMedecin( medecin);
            rendezVous.setPatient(patient);
            rendezVousRepository.save(rendezVous);


        };
    }


}






