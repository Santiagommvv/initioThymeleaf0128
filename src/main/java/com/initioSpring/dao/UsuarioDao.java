
package com.initioSpring.dao;

import com.initioSpring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    //chequear si el parámetro debe ser llamado "username" por culpa de la columna en la base de datos
    Usuario findByUsername(String username);
}
