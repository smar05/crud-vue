package com.example.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.models.Item;
import com.example.crud.services.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/items")
@Tag(name = "Api")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemService itemService;

    /**
     * GET Metodo para obtener todos los items
     * 
     * @return
     */
    @GetMapping("/getAll")
    @Operation(summary = "Obtener todos los items")
    public ResponseEntity<List<Item>> getItems() {
        logger.info("Metodo GET para obtener todos los items");
        return ResponseEntity.ok(itemService.getItems());
    }

    /**
     * GET Metodo para obtener un item por id
     * documento
     * 
     * @param id
     * @return
     */
    @GetMapping("/getById")
    @Operation(summary = "Obtener un item por id")
    public ResponseEntity<Item> getById(
            @RequestParam("id") Long id) {
        logger.info("Metodo GET para obtener el item por id: " + id);
        Optional<Item> item = this.itemService.getById(id);

        // Si se encuentra al item
        if (item.isPresent()) {
            logger.info("Se encontro el item");
            return ResponseEntity.ok(item.get());
        } else {
            logger.error("No se encontro el item");
            return ResponseEntity.notFound().build();
        }
    }
}
