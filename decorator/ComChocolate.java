public class ComChocolate extends PedidoDecorator {
    public ComChocolate(Pedido pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + ", Chocolate";
    }

    @Override
    public double getPreco() {
        return pedidoDecorado.getPreco() + 1.50;
    }
}
