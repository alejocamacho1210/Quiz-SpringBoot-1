package com.biblioteca.negocio;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class ServicioLibros {

    private final RepositorioLibros repositorio;

    public ServicioLibros(RepositorioLibros repositorio) {
        this.repositorio = repositorio;
    }

    public List<Libro> listar() {
        return repositorio.listar();
    }

    public Libro buscarPorId(Long id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("No existe el libro " + id));
    }
}
