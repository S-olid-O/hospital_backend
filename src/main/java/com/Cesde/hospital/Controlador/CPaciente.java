package com.Cesde.hospital.Controlador;

import com.Cesde.hospital.DTO.PacienteCitaDTO;
import com.Cesde.hospital.DTO.PacienteDTO;
import com.Cesde.hospital.Repositorio.IServicioPaciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class CPaciente {

    private final IServicioPaciente servicioPaciente;

    // Inyección del servicio
    public CPaciente(IServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    // Ruta 1: http://localhost:8080/api/pacientes/activos
    @GetMapping("/activos")
    public List<PacienteDTO> listarPacientesActivos() {
        return servicioPaciente.obtenerTodosLosActivos();
    }

    // Ruta 2: http://localhost:8080/api/pacientes/historial
    @GetMapping("/historial")
    public List<PacienteCitaDTO> listarHistorialCitas() {
        return servicioPaciente.obtenerHistorialCitasPacientes();
    }
}