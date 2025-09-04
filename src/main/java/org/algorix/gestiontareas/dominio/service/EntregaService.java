package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.crud.EntregaCrud;
import org.algorix.gestiontareas.persistence.entity.Entrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntregaService implements IEntregaService {

    @Autowired
    private EntregaCrud crud;

    @Override
    public List<Entrega> listarEntregas() {
        List<Entrega> entregas = crud.findAll();
        return entregas;
    }

    @Override
    public Entrega buscarEntregaPorId(Integer id) {
        Entrega entrega = crud.findById(id).orElse(null);
        return entrega;
    }

    @Override
    public void guardarEntrega(Entrega entrega) {
        crud.save(entrega);
    }

    @Override
    public void eliminarEntrega(Entrega entrega) {
        crud.delete(entrega);
    }
}
