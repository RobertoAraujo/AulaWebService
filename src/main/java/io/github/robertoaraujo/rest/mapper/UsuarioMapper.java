package io.github.robertoaraujo.rest.mapper;

import io.github.robertoaraujo.dominio.entity.UsuarioEntity;
import io.github.robertoaraujo.rest.dto.UsuarioDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(UsuarioEntity usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setIdade(usuario.getIdade());
        dto.setUsername(usuario.getUsername());
        dto.setAceitouTermos(usuario.isAceitouTermos());
        return dto;
    }

    public static UsuarioEntity toEntity(UsuarioDTO dto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setIdade(dto.getIdade());
        usuario.setUsername(dto.getUsername());
        usuario.setAceitouTermos(dto.isAceitouTermos());
        return usuario;
    }

    public static String formataData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
