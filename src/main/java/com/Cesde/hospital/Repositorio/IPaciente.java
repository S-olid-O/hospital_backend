package com.Cesde.hospital.Repositorio;

import com.Cesde.hospital.Modelo.MPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IPaciente extends JpaRepository<MPaciente, String> {

    // Consulta nativa SQL pura apuntando a la tabla 'paciente'
    @Query(value = """
            SELECT 
                p.nompaciente, p.telpaciente, 
                c.codcita, c.fecha, c.idpaciente, 
                m.nommedico 
            FROM paciente p
            INNER JOIN cita c ON p.idpaciente = c.idpaciente
            INNER JOIN medico m ON c.idmedico = m.idmedico
            """, nativeQuery = true)
    List<IPacienteCitaProjection> obtenerHistorialCitasPacientes();

    Collection<Object> obtenerPacientesActivos();
}