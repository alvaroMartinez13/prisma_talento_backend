package com.prisma.prisma_talento.Services.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prisma.prisma_talento.Entities.Empleado;
import com.prisma.prisma_talento.Repositories.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll().isEmpty() ? null : empleadoRepository.findAll();
    }

    @Override
    public Empleado obtenerEmpleado(String identificacion) {
        return empleadoRepository.findByIdentificacion(identificacion).orElse(null);

    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }
     
}
