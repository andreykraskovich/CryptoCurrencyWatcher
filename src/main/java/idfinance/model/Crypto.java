package idfinance.model;

import javax.persistence.*;

@Entity
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String symbol;

    @Column(name = "price_usd")
    private Double priceUSD;

    public Crypto(Long id, String symbol, Double priceUSD) {
        this.id = id;
        this.symbol = symbol;
        this.priceUSD = priceUSD;
    }

    public Crypto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Double priceUSD) {
        this.priceUSD = priceUSD;
    }
}
