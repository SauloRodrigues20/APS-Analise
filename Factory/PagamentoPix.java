public class PagamentoPix implements Pagamento {
    private String chavePix;
    
    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }
    
    @Override
    public void processar(double valor) {
        System.out.println("\n=== Processando Pagamento PIX ===");
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Chave PIX: " + chavePix);
        System.out.println("Gerando QR Code...");
        System.out.println("QR Code gerado com sucesso!");
        System.out.println("Aguardando confirmação do pagamento...");
        System.out.println("Pagamento confirmado via PIX!");
    }
    
    @Override
    public String obterDetalhes() {
        return "PIX - Chave: " + chavePix;
    }
    
    @Override
    public boolean validar() {
        return chavePix != null && !chavePix.isEmpty();
    }
}
