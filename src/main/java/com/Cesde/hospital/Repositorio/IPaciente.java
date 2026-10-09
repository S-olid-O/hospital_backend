package com.Cesde.hospital.Repositorio;

import com.Cesde.hospital.Modelo.MPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaciente extends JpaRepository<MPaciente, String> {

    // Consulta nativa SQL pura apuntando a la tabla 'paciente'
    @Query(value = "SELECT idpaciente, nompaciente, telpaciente FROM paciente WHERE activo = true", nativeQuery = true)
    List<IPacienteProjection> obtenerPacientesActivos();

}