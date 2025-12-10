public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PEDIDOS DA PADARIA ===\n");
        
        Pedido pedido1 = new Cafe();
        imprimirPedido("Pedido 1", pedido1);
        
        Pedido pedido2 = new ComAcucar(new Cafe());
        imprimirPedido("Pedido 2", pedido2);
        
        Pedido pedido3 = new ComChocolate(new ComAcucar(new Cafe()));
        imprimirPedido("Pedido 3", pedido3);
        
        Pedido pedido4 = new ComPaoDeQueijo(new ComChocolate(new Cafe()));
        imprimirPedido("Pedido 4", pedido4);
        
        Pedido pedido5 = new ComBiscoito(
                            new ComBolo(
                                new ComPaoDeQueijo(
                                    new ComChocolate(
                                        new ComAcucar(new Cafe())))));
        imprimirPedido("Pedido 5 (Completo)", pedido5);
        
        Pedido pedido6 = new ComBolo(new Cafe());
        imprimirPedido("Pedido 6", pedido6);
    }
    
    private static void imprimirPedido(String titulo, Pedido pedido) {
        System.out.println("--- " + titulo + " ---");
        System.out.println("Descrição: " + pedido.getDescricao());
        System.out.printf("Preço Total: R$ %.2f%n", pedido.getPreco());
        System.out.println();
    }
}
