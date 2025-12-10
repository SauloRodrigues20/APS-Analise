public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PAGAMENTO E-COMMERCE ===");
        System.out.println("Padrão Factory Method\n");
        
        System.out.println("--- CENÁRIO 1: Pagamento via PayPal ---");
        Pagamento pagamento1 = PagamentoFactory.criarPagamento(
            PagamentoFactory.TipoPagamento.PAYPAL, 
            "cliente@email.com"
        );
        System.out.println("Forma de pagamento: " + pagamento1.obterDetalhes());
        if (pagamento1.validar()) {
            pagamento1.processar(150.00);
        }
        
        System.out.println("\n--- CENÁRIO 2: Pagamento via Boleto ---");
        Pagamento pagamento2 = PagamentoFactory.criarPagamento(
            PagamentoFactory.TipoPagamento.BOLETO, 
            "12345678901"
        );
        System.out.println("Forma de pagamento: " + pagamento2.obterDetalhes());
        if (pagamento2.validar()) {
            pagamento2.processar(350.50);
        }
        
        System.out.println("\n--- CENÁRIO 3: Pagamento via PIX ---");
        Pagamento pagamento3 = PagamentoFactory.criarPagamento(
            PagamentoFactory.TipoPagamento.PIX, 
            "cliente@email.com"
        );
        System.out.println("Forma de pagamento: " + pagamento3.obterDetalhes());
        if (pagamento3.validar()) {
            pagamento3.processar(89.90);
        }
        
        System.out.println("\n--- CENÁRIO 4: Usando Factory com String ---");
        Pagamento pagamento4 = PagamentoFactory.criarPagamento("pix", "11987654321");
        System.out.println("Forma de pagamento: " + pagamento4.obterDetalhes());
        if (pagamento4.validar()) {
            pagamento4.processar(200.00);
        }
        
        System.out.println("\n--- CENÁRIO 5: Tratamento de erro ---");
        try {
            Pagamento pagamentoInvalido = PagamentoFactory.criarPagamento("cartao", "1234");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
