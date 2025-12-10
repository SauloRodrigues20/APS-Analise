public class PagamentoPayPal implements Pagamento {
    private String email;
    
    public PagamentoPayPal(String email) {
        this.email = email;
    }
    
    @Override
    public void processar(double valor) {
        System.out.println("\n=== Processando Pagamento PayPal ===");
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Email: " + email);
        System.out.println("Redirecionando para o PayPal...");
        System.out.println("Pagamento processado com sucesso via PayPal!");
    }
    
    @Override
    public String obterDetalhes() {
        return "PayPal - Email: " + email;
    }
    
    @Override
    public boolean validar() {
        return email != null && email.contains("@");
    }
}
