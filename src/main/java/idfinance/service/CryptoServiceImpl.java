package idfinance.service;

import idfinance.dao.CryptoDao;
import idfinance.model.Crypto;
import idfinance.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class CryptoServiceImpl implements  CryptoService{

    private final CryptoRepository cryptoRepository;
    private CryptoDao cryptoDao;
    @Autowired
    public CryptoServiceImpl(CryptoRepository cryptoRepository, CryptoDao cryptoDao) {
        this.cryptoDao = cryptoDao;
        this.cryptoRepository = cryptoRepository;
    }

    @Override
    public Crypto findBySymbol(String symbol) {
        return cryptoDao.findBySymbol(symbol);
    }

    @Override
    public List<Crypto> list() {
        Iterable<Crypto> list = cryptoRepository.findAll();
        return new ArrayList<>((Collection<? extends Crypto>) list);
    }
}
