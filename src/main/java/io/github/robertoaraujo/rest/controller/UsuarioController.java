package io.github.robertoaraujo.rest.controller;

import io.github.robertoaraujo.dominio.entity.UsuarioEntity;
import io.github.robertoaraujo.rest.dto.UsuarioDTO;
import io.github.robertoaraujo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/cadastar")
    public ResponseEntity<UsuarioEntity> criarUsuario(@Validated @RequestBody UsuarioDTO dto) {
        UsuarioEntity usuario = usuarioService.salvar(dto);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<UsuarioEntity>> getAllUsers() {
        try {
            List<UsuarioEntity> usuarios = usuarioService.getAllUsers();
            if (!usuarios.isEmpty()) {
                LOGGER.info("Dados Retornado com sucesso" + usuarios);
                return ResponseEntity.status(HttpStatus.OK).body(usuarios);
            }else {
                LOGGER.info("Não ha dados na base");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            LOGGER.info("Não ha dados na base" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioEntity> getPorId(@PathVariable Long id) {

        Optional<UsuarioEntity> usuario = usuarioService.getPorId(id);
        try{
            return usuario.map(ResponseEntity::ok).orElseGet(() ->
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioEntity> updateUser(@PathVariable("id") Long id, @RequestBody UsuarioEntity usuario) {
        UsuarioEntity updatedUser = usuarioService.updateUser(id, usuario);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
