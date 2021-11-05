package com.alcancia.alcancia.repositories;

import java.util.ArrayList;

import com.alcancia.alcancia.models.MonedaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends CrudRepository<MonedaModel, Integer> {
    public abstract ArrayList<MonedaModel> findByTipo(String tipo);
}
