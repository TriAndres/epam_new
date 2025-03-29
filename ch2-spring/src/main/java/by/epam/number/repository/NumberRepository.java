package by.epam.number.repository;

import by.epam.number.model.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<Number, Long> {
}
