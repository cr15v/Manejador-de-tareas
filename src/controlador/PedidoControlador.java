package controlador;

import dao.PedidoDAO;
import modelo.Pedido;
import java.util.List;

public class PedidoControlador {
    private PedidoDAO pedidoDAO;

    public PedidoControlador(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void agregarPedido(String cliente, double total) {
        if (cliente == null || cliente.isEmpty() || total <= 0) {
            throw new IllegalArgumentException("Datos inválidos para el pedido");
        }
        Pedido pedido = new Pedido(cliente, total);
        pedidoDAO.guardarPedido(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoDAO.obtenerPedidos();
    }
}
