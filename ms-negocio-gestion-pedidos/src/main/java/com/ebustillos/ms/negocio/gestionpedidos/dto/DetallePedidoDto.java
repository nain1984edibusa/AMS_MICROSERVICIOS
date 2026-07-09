package com.ebustillos.ms.negocio.gestionpedidos.dto;

import com.ebustillos.ms.negocio.gestionpedidos.entity.PedidoEntity;
import com.ebustillos.ms.negocio.gestionpedidos.services.client.clientes.ClienteDto;
import com.ebustillos.ms.negocio.gestionpedidos.services.client.productos.ProductoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoDto {

    private Long idDetallePedido;
   	
    //private Long idPedido;
   	
    private Long idProducto;
    
    private ProductoDto productoDto;

    private Integer cantidad;
    
    private  Double precio;

    private  Double subtotal;
}
