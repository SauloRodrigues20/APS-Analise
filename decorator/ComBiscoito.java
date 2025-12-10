public class ComBiscoito extends PedidoDecorator {
    public ComBiscoito(Pedido pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + ", Biscoito";
    }

    @Override
    public double getPreco() {
        return pedidoDecorado.getPreco() + 2.50;
    }
}
