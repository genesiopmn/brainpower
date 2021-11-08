package br.com.brainpower.bluebank.repository;

import br.com.brainpower.bluebank.entity.FullAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullAddressRepository extends JpaRepository<FullAddress,Integer> {
}
