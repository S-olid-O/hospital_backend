package com.Cesde.hospital.Repositorio;

// Los nombres de los métodos deben coincidir con los nombres de las columnas en la DB
public interface IPacienteProjection {
    String getIdpaciente();
    String getNompaciente();
    String getTelpaciente();
}