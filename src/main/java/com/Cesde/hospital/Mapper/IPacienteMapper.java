package com.Cesde.hospital.Mapper;

import com.Cesde.hospital.DTO.PacienteCitaDTO;
import com.Cesde.hospital.DTO.PacienteDTO;
import com.Cesde.hospital.Repositorio.IPacienteCitaProjection;
import com.Cesde.hospital.Repositorio.IPacienteProjection;
import org.springframework.stereotype.Component;

@Component
public class IPacienteMapper {

    // Método para la consulta de pacientes activos
    public PacienteDTO toDTO(IPacienteProjection projection) {
        if (projection == null) {
            return null;
        }
        return new PacienteDTO(
                projection.getIdpaciente(),
                projection.getNompaciente(),
                projection.getTelpaciente()
        );
    }

    // Método para la consulta del historial con JOIN
    public PacienteCitaDTO toPacienteCitaDTO(IPacienteCitaProjection projection) {
        if (projection == null) {
            return null;
        }
        return new PacienteCitaDTO(
                projection.getNompaciente(),
                projection.getTelpaciente(),
                projection.getCodcita(),
                projection.getFecha(),
                projection.getIdpaciente(),
                projection.getNommedico()
        );
    }
}