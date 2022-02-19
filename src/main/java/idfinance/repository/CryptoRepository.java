package idfinance.repository;

import idfinance.model.Crypto;
import idfinance.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoRepository extends CrudRepository<Crypto, Long> {
    Optional<Crypto> findBySymbol(String symbol);
}
