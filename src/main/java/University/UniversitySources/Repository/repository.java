package University.UniversitySources.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import University.UniversitySources.Entity.courseEntity;

public interface repository extends JpaRepository<courseEntity, Long> {
    
}
