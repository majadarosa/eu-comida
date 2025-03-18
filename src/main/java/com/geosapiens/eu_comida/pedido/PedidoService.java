package com.geosapiens.eu_comida.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geosapiens.eu_comida.entity.Pedido;
@Service
public  class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoDTO criarPedido(PedidoDTO dto) {
		Pedido pedido = dtoToEntity(dto);
		pedido.setStatus(StatusPedido.EM_ANDAMENTO);
		return entityToDto(pedidoRepository.save(pedido));
	}
	
	private Pedido dtoToEntity(PedidoDTO dto) {
		Pedido p = new Pedido();
		p.setDescricao(dto.getDescricao());
		p.setId(dto.getId());
		p.setStatus(dto.getStatus());
		return p;
	}
	
	private PedidoDTO entityToDto(Pedido pedido) {
		PedidoDTO p = new PedidoDTO();
		p.setDescricao(pedido.getDescricao());
		p.setId(pedido.getId());
		p.setStatus(pedido.getStatus());
		return p;
	}

	public Pedido buscarPedido(Long id) {
		return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
	}
}