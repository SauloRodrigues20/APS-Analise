public class ComAcucar extends PedidoDecorator {
    public ComAcucar(Pedido pedidoDecorado) {
        super(pedidoDecorado);
    }

    @Override
    public String getDescricao() {
        return pedidoDecorado.getDescricao() + ", Açúcar";
    }

    @Override
    public double getPreco() {
        return pedidoDecorado.getPreco() + 0.50;
    }
}
