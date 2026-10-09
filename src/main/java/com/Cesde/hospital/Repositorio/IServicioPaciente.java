package com.Cesde.hospital.Repositorio;

import com.Cesde.hospital.DTO.PacienteCitaDTO;
import com.Cesde.hospital.DTO.PacienteDTO;
import java.util.List;

public interface IServicioPaciente {
    List<PacienteDTO> obtenerTodosLosActivos();
    // Añade esta línea debajo de tu método anterior
    List<PacienteCitaDTO> obtenerHistorialCitasPacientes();
}