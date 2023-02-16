package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Info;
import ru.hogwarts.school.services.InfoService;

public interface InfoRepository extends JpaRepository<Info,Long>{
}
