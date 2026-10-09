package com.Cesde.hospital.DTO;

import java.time.LocalDate;

public record PacienteCitaDTO(
        String nombrePaciente,
        String telefonoPaciente,
        Integer codigoCita,
        LocalDate fechaCita,
        String identificacionPaciente,
        String nombreMedico
) {
}