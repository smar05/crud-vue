package com.example.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.crud.models.Item;

import org.slf4j.Logger;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private List<Item> items = new ArrayList<Item>();

    private ItemService() {
        this.inicializarUsuarios();
    }

    /**
     * Se inicializan los items con datos quemados
     * 
     * @private
     */
    private void inicializarUsuarios() {
        logger.info("Se inicializan los items");
        this.items.add(
                new Item(1L, "Juan"));
        this.items.add(
                new Item(2L, "Pedro"));
        this.items.add(
                new Item(3L, "Pepita"));
    }

    /**
     * Se obtienen todos los items
     * 
     * @return List<Usuario>
     */
    public List<Item> getItems() {
        logger.info("Obtener todos los items");
        return this.items;
    }

    /**
     * Se obtiene un item por id
     * 
     * @param id
     * @return
     */
    public Optional<Item> getById(Long id) {
        logger.info("Obtener por id: ", id);
        return this.items.stream().filter((item) -> item.getId().equals(id)).findFirst();
    }

}
