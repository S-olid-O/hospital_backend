package com.Cesde.hospital.Repositorio;

import com.Cesde.hospital.DTO.PacienteDTO;
import java.util.List;

public interface IServicioPaciente {
    List<PacienteDTO> obtenerTodosLosActivos();
}