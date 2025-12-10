public class ComBolo extends PedidoDecorator {
    public ComBolo(Pedido pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + ", Bolo";
    }

    @Override
    public double getPreco() {
        return pedidoDecorado.getPreco() + 5.50;
    }
}
