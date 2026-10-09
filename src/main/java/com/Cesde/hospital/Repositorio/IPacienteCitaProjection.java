package com.Cesde.hospital.Repositorio;

import java.time.LocalDate;

public interface IPacienteCitaProjection {
    // De Paciente (Cliente)
    String getNompaciente();
    String getTelpaciente();

    // De Cita
    Integer getCodcita();
    LocalDate getFecha();
    String getIdpaciente();

    // De Medico
    String getNommedico();
}