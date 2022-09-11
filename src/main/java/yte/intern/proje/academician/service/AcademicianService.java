package yte.intern.proje.academician.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.academician.repository.AcademicianRepository;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.login.entity.Authority;
import yte.intern.proje.login.entity.CustomUser;
import yte.intern.proje.login.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AcademicianService {
    private final AcademicianRepository academicianRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MessageResponse addAcademician(Academician academician){
        Random random = new Random();
        int randomPassword = random.nextInt(10000000);

        academicianRepository.save(academician);
        userRepository.save(new CustomUser(null, academician.getName()+"."+academician.getSurname(),passwordEncoder.encode(Integer.toString(randomPassword)), List.of(new Authority("ACADEMICIAN"))));

        return  new MessageResponse("Academician has been added successfully\n"+"Password: "+randomPassword, ResultType.SUCCESS);
    }

    public List<Academician> getAllAcademician(){
        return academicianRepository.findAll();
    }

    public Academician getAcademicianById(Long id){
        return academicianRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Academician with ID %d not found".formatted(id)));
    }

    public MessageResponse updateAcademician(Long id, Academician newAcademician){
        Academician existingAcademician = getAcademicianById(id);
        existingAcademician.update(newAcademician);
        academicianRepository.save(existingAcademician);
        return new MessageResponse("Academician with ID %d has been update".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse deleteAcademician(Long id){
        academicianRepository.deleteById(id);
        return new MessageResponse("Academician with ID %d has been update".formatted(id), ResultType.SUCCESS);
    }
}
