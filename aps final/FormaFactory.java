import java.util.HashMap;

public class FormaFactory {
    private static HashMap<String, Forma> pool = new HashMap<>();
    
    public static Forma getForma(String tipo) {
        if (!pool.containsKey(tipo)) {
            if (tipo.equals("circulo")) pool.put(tipo, new Circulo());
            else if (tipo.equals("quadrado")) pool.put(tipo, new Quadrado());
        }
        return pool.get(tipo);
    }
}
