package com.Cesde.hospital.Repositorio;

import com.Cesde.hospital.Modelo.MPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaciente extends JpaRepository<MPaciente, String> {

    // 1. Consulta nativa para pacientes activos (Recuperada)
    @Query(value = "SELECT idpaciente, nompaciente, telpaciente FROM paciente WHERE activo = true", nativeQuery = true)
    List<IPacienteProjection> obtenerPacientesActivos();

    // 2. Consulta nativa para el historial cruzando las 3 tablas
    @Query(value = """
            SELECT 
                p.nompaciente AS nompaciente, p.telpaciente, 
                c.codcita, c.fecha, c.idpaciente, 
                m.nommedico 
            FROM paciente p
            INNER JOIN cita c ON p.idpaciente = c.idpaciente
            INNER JOIN medico m ON c.idmedico = m.idmedico
                        where 
            """, nativeQuery = true)
    List<IPacienteCitaProjection> obtenerHistorialCitasPacientes();
}