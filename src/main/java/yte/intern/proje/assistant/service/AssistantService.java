package yte.intern.proje.assistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yte.intern.proje.assistant.entity.Assistant;
import yte.intern.proje.assistant.repository.AssistantRepository;
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
public class AssistantService {
    private final AssistantRepository assistantRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MessageResponse addAssistant(Assistant assistant){
        Random random = new Random();
        int randomPassword = random.nextInt(10000000);

        assistantRepository.save(assistant);
        userRepository.save(new CustomUser(null, assistant.getName()+"."+assistant.getSurname(),passwordEncoder.encode(Integer.toString(randomPassword)), List.of(new Authority("ACADEMICIAN"))));

        return  new MessageResponse("Assistant has been added successfully\n"+"Password: "+randomPassword, ResultType.SUCCESS);
    }

    public List<Assistant> getAllAssistants(){
        return assistantRepository.findAll();
    }

    public Assistant getAssistantById(Long id){
        return assistantRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Assistant with ID %d not found".formatted(id)));
    }

    public MessageResponse updateAssistant(Long id, Assistant newAssistant){
        Assistant existingAssistant = getAssistantById(id);
        existingAssistant.update(newAssistant);
        assistantRepository.save(existingAssistant);
        return new MessageResponse("Assistant with ID %d has been update".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse deleteAssistant(Long id){
        assistantRepository.deleteById(id);
        return new MessageResponse("Assistant with ID %d has been update".formatted(id), ResultType.SUCCESS);
    }
}
