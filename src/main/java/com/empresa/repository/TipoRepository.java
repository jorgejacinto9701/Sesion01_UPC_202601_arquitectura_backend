package com.empresa.repository;


import com.empresa.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {



    //Usando JPQL (Query usando clases)
    @Query("select p from Tipo p where p.idTipo = ?1")
    public List<Tipo> listaPorId(int tipo);
}
