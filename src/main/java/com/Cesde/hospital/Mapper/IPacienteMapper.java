package com.Cesde.hospital.Mapper;

import com.Cesde.hospital.DTO.PacienteDTO;
import com.Cesde.hospital.Repositorio.IPacienteProjection;
import org.springframework.stereotype.Component;

@Component
public class IPacienteMapper {

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
}