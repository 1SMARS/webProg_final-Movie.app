package webFinalProject.repository;


import webFinalProject.entity.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Films, Long> {
}