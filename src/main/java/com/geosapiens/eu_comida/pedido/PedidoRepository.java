package com.geosapiens.eu_comida.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geosapiens.eu_comida.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
