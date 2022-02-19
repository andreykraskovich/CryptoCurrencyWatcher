package idfinance.service;

import idfinance.model.Crypto;

import java.util.List;

public interface CryptoService {

    Crypto findBySymbol(String symbol);
    List<Crypto> list();
}
