public abstract class PedidoDecorator implements Pedido {
    protected Pedido pedidoDecorado;

    public PedidoDecorator(Pedido pedidoDecorado) {
        this.pedidoDecorado = pedidoDecorado;
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao();
    }

    @Override
    public double getPreco() {
        return pedidoDecorado.getPreco();
    }
}
