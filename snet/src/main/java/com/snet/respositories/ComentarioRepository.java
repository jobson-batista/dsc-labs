package com.snet.respositories;

import com.snet.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface ComentarioRepository<T, ID extends Serializable>  extends JpaRepository<Comentario, Long> {
}
