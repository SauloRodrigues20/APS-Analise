public class PagamentoFactory {
    
    public enum TipoPagamento {
        PAYPAL,
        BOLETO,
        PIX
    }
    
    public static Pagamento criarPagamento(TipoPagamento tipo, String identificador) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de pagamento não pode ser nulo!");
        }
        
        switch (tipo) {
            case PAYPAL:
                return new PagamentoPayPal(identificador);
            case BOLETO:
                return new PagamentoBoleto(identificador);
            case PIX:
                return new PagamentoPix(identificador);
            default:
                throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipo);
        }
    }
    
    public static Pagamento criarPagamento(String tipoString, String identificador) {
        try {
            TipoPagamento tipo = TipoPagamento.valueOf(tipoString.toUpperCase());
            return criarPagamento(tipo, identificador);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de pagamento inválido: " + tipoString);
        }
    }
}
