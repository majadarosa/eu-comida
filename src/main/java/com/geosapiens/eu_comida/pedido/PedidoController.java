package com.geosapiens.eu_comida.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geosapiens.eu_comida.entity.Pedido;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;


	@PostMapping
	public PedidoDTO criarPedido(@RequestBody PedidoDTO pedido) {
		return pedidoService.criarPedido(pedido);
	}

	@GetMapping("/{id}")
	public Pedido buscarPedido(@PathVariable Long id) {
		return pedidoService.buscarPedido(id);
	}
	
	@GetMapping("/entrega/{id}")
	public Pedido buscarPedidoEntrega(@PathVariable Long id) {
		return pedidoService.buscarPedido(id);
	}
}
