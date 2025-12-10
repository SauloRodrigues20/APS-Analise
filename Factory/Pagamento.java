public interface Pagamento {
    void processar(double valor);
    String obterDetalhes();
    boolean validar();
}
