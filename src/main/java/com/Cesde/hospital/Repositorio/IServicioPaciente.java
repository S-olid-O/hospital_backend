package com.Cesde.hospital.Repositorio; // Paquete corregido

import com.Cesde.hospital.DTO.PacienteCitaDTO;
import com.Cesde.hospital.DTO.PacienteDTO;
import java.util.List;

public interface IServicioPaciente {
    List<PacienteDTO> obtenerTodosLosActivos();
    List<PacienteCitaDTO> obtenerHistorialCitasPacientes();
}