package com.prisma.prisma_talento.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prisma.prisma_talento.Enums.estado_Civil;
import com.prisma.prisma_talento.Enums.estado_Empleado;
import com.prisma.prisma_talento.Enums.genero_Empleado;
import com.prisma.prisma_talento.Enums.nivel_Educacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data   
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String identificacion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_ingreso;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nacimiento;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private estado_Empleado estado;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private genero_Empleado genero;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String departamento_demografico;

    private String departamento;
    private String puesto;
    private String ciudad;
    private String foto;
    private estado_Civil estado_civil;
    private nivel_Educacion nivel_educacion; 
    private List<String> habilidades;
    private List<String> idiomas;
    private List<String> certificaciones;
    private String experiencia;
    private List<String> referencias;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_salida;

    @PrePersist
    protected void onCreate() {
        this.estado = estado_Empleado.ACTIVO;
        this.estado_civil = estado_Civil.SOLTERO;
        this.nivel_educacion = nivel_Educacion.PRIMARIA;
        this.genero = genero_Empleado.NO_ESPECIFICADO;
        this.fecha_nacimiento = LocalDate.now().minusYears(18);
        this.fecha_ingreso = LocalDate.now();
    }

}
