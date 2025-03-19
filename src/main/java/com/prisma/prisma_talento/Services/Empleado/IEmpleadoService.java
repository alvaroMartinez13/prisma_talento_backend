package com.prisma.prisma_talento.Services.Empleado;

import java.util.List;

import com.prisma.prisma_talento.Entities.Empleado;

public interface IEmpleadoService {
    public List<Empleado> obtenerEmpleados();

    public Empleado obtenerEmpleado(String identificacion);

    public Empleado guardarEmpleado(Empleado empleado);
    
    public void eliminarEmpleado(Empleado empleado);
    
}
