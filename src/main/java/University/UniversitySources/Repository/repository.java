package University.UniversitySources.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import University.UniversitySources.entity.courseEntity;

public interface repository extends JpaRepository<courseEntity, Long> {
    
}
