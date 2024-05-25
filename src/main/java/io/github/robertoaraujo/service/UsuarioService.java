package io.github.robertoaraujo.service;

import io.github.robertoaraujo.dominio.entity.UsuarioEntity;
import io.github.robertoaraujo.dominio.repository.UsuarioRepository;
import io.github.robertoaraujo.rest.dto.UsuarioDTO;
import io.github.robertoaraujo.rest.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity salvar(UsuarioDTO dto) {
        UsuarioEntity usuario = UsuarioMapper.toEntity(dto);
        return repository.save(usuario);
    }
    public List<UsuarioEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UsuarioEntity> getPorId(Long id){
        return repository.findById(id);
    }

    public UsuarioEntity updateUser(Long id, UsuarioEntity user) {
        Optional<UsuarioEntity> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            UsuarioEntity usuarioAtualizado = usuario.get();
            usuarioAtualizado.setNome(user.getNome());
            usuarioAtualizado.setEmail(user.getEmail());
            usuarioAtualizado.setDataNascimento(user.getDataNascimento());
            usuarioAtualizado.setIdade(user.getIdade());
            usuarioAtualizado.setUsername(user.getUsername());
            usuarioAtualizado.setAceitouTermos(user.isAceitouTermos());
            return repository.save(usuarioAtualizado);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
