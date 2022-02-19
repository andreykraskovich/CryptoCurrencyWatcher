package idfinance.dao;

import idfinance.model.Crypto;
import org.springframework.data.repository.CrudRepository;

public interface CryptoDao extends CrudRepository<Crypto, Long> {
    Crypto findBySymbol(String symbol);
}
