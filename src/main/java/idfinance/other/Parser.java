package idfinance.other;

import idfinance.model.Crypto;
import idfinance.repository.CryptoRepository;
import idfinance.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    private static final String SOL_ACTUAL  = "https://api.coinlore.net/api/ticker?id=48543";
    private static final String BTC_ACTUAL = "https://api.coinlore.net/api/ticker?id=90";
    private static final String ETH_ACTUAL = "https://api.coinlore.net/api/ticker?id=80";

    private static UserRepository userRepository;
    private static CryptoRepository cryptoRepository;

    Crypto sol = setCryptoInfo(SOL_ACTUAL);
    Crypto btc = setCryptoInfo(BTC_ACTUAL);
    Crypto eth = setCryptoInfo(ETH_ACTUAL);


    private Crypto setCryptoInfo(String url){
        Crypto crypto = new Crypto();
        RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);
    Object[] objects = responseEntity.getBody();
        List<Object> searchList = Arrays.asList(objects);
        Map<String, Object> data = (Map<String, Object>) searchList.get(0);
        crypto.setId(Long.parseLong((String) data.get("id")));
        crypto.setSymbol((String) data.get("symbol"));
        crypto.setPriceUSD(Double.parseDouble((String) data.get("price_usd")));

        return cryptoRepository.save(crypto);
    }
}
