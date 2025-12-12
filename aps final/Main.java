public class Main {
    public static void main(String[] args) {
        FormaFactory.getForma("circulo").desenhar(10, 20, "Vermelho");
        FormaFactory.getForma("quadrado").desenhar(30, 40, "Azul");
        FormaFactory.getForma("circulo").desenhar(50, 60, "Verde");
        FormaFactory.getForma("quadrado").desenhar(70, 80, "Amarelo");
    }
}
