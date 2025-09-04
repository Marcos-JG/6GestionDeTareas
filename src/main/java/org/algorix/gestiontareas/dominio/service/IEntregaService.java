package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.entity.Entrega;

import java.util.List;

public interface IEntregaService {
    List<Entrega> listarEntregas();
    Entrega buscarEntregaPorId(Integer id);
    void guardarEntrega(Entrega entrega);
    void eliminarEntrega(Entrega entrega);
}
