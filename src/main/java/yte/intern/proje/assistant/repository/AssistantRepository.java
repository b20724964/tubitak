package yte.intern.proje.assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.proje.assistant.entity.Assistant;

public interface AssistantRepository extends JpaRepository<Assistant, Long> {
}
