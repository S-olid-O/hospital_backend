package com.Cesde.hospital.Servicio;

import com.Cesde.hospital.DTO.PacienteCitaDTO;
import com.Cesde.hospital.DTO.PacienteDTO;
import com.Cesde.hospital.Mapper.IPacienteMapper; // Ajustado al nuevo nombre del Mapper
import com.Cesde.hospital.Repositorio.IPaciente;
import com.Cesde.hospital.Repositorio.IServicioPaciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SPaciente implements IServicioPaciente {

    private final IPaciente repositorioPaciente;
    private final IPacienteMapper mapper;

    public SPaciente(IPaciente repositorioPaciente, IPacienteMapper mapper) {
        this.repositorioPaciente = repositorioPaciente;
        this.mapper = mapper;
    }

    @Override
    public List<PacienteDTO> obtenerTodosLosActivos() {
        return repositorioPaciente.obtenerPacientesActivos()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteCitaDTO> obtenerHistorialCitasPacientes() {
        return repositorioPaciente.obtenerHistorialCitasPacientes()
                .stream()
                .map(mapper::toPacienteCitaDTO)
                .collect(Collectors.toList());
    }
}