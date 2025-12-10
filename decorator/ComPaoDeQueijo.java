public class ComPaoDeQueijo extends PedidoDecorator {
    public ComPaoDeQueijo(Pedido pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + ", Pão de Queijo";
    }

    @Override
    public double getPreco() {
        return pedidoDecorado.getPreco() + 4.00;
    }
}
