public class PagamentoBoleto implements Pagamento {
    private String cpf;
    
    public PagamentoBoleto(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public void processar(double valor) {
        System.out.println("\n=== Processando Pagamento Boleto ===");
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("CPF: " + cpf);
        System.out.println("Gerando código de barras...");
        System.out.println("Código de Barras: 23791.12345 67890.123456 78901.234567 8 12345678901234");
        System.out.println("Boleto gerado com sucesso!");
        System.out.println("Vencimento: 3 dias úteis");
    }
    
    @Override
    public String obterDetalhes() {
        return "Boleto Bancário - CPF: " + cpf;
    }
    
    @Override
    public boolean validar() {
        return cpf != null && cpf.length() >= 11;
    }
}
