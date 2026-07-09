package com.ebustillos.ms.negocio.gestionpedidos.dto;

import java.util.List;

import com.ebustillos.ms.negocio.gestionpedidos.entity.DetallePedidoEntity;
import com.ebustillos.ms.negocio.gestionpedidos.services.client.clientes.ClienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDto {
    private Long idPedido;
    private Long idCliente;
    private ClienteDto clienteDto;
    private String resumen;
    private Double total;
    private List<DetallePedidoDto> listDetallePedido;
}
