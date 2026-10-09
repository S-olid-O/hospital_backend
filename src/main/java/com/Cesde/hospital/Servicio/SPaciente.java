package com.Cesde.hospital.Servicio;

import com.Cesde.hospital.DTO.PacienteDTO;
import com.Cesde.hospital.Mapper.IPacienteMapper;
import com.Cesde.hospital.Repositorio.IPaciente;
import com.Cesde.hospital.Repositorio.IServicioPaciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SPaciente implements IServicioPaciente {

    // Dependencias
    private final IPaciente repositorioPaciente;
    private final IPacienteMapper mapper;

    // Inyección de dependencias mediante constructor (Mejor práctica que usar @Autowired)
    public SPaciente(IPaciente repositorioPaciente, IPacienteMapper mapper) {
        this.repositorioPaciente = repositorioPaciente;
        this.mapper = mapper;
    }

    @Override
    public List<PacienteDTO> obtenerTodosLosActivos() {
        // 1. Ejecutar la consulta nativa que devuelve proyecciones
        return repositorioPaciente.obtenerPacientesActivos()
                // 2. Convertir la lista a un Stream para procesarla
                .stream()
                // 3. Mapear cada PacienteProjection a un PacienteDTO usando el Mapper
                .map(mapper::toDTO)
                // 4. Volver a empaquetar el resultado en una Lista
                .collect(Collectors.toList());
    }
}