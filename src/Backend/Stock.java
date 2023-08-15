package Backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Stock implements Serializable {

    private Map<Vacina, Integer> stock;
    
    //Contrutor
    public Stock() {
        stock = new HashMap<>();
    }
    
    //Cria um stock de um fabricante
    public void criarStock(Vacina v, int n) {
        stock.put(v, n);
    }
    
    //Atualiza o stock
    public void atualizar(Vacina v, int delta) {
        stock.put(v, delta);
    }
    
    //Verifica o stock
    public void checkStock(Vacina v, int delta) {
        int q = stock.get(v) + delta;

        if (q <= 0) 
        {
            stock.put(v, q);
        } else {
            throw new IllegalArgumentException("Não posso ficar com stock negativo");
        }
    }

}
