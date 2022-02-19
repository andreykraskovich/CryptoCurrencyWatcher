package idfinance.contoller;

import idfinance.model.Crypto;
import idfinance.repository.CryptoRepository;
import idfinance.service.CryptoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class CryptoController {

    private final CryptoServiceImpl cryptoService;

    public CryptoController(CryptoServiceImpl cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/all")
    public List<Crypto> list()
    {
        return cryptoService.list();
    }

    @GetMapping("/get/{symbol}")
    public Crypto getCrypto(@PathVariable(name = "symbol") String symbol){
       return cryptoService.findBySymbol(symbol);
    }


}
