package com.prisma.prisma_talento.Controllers.Empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prisma.prisma_talento.Entities.Empleado;
import com.prisma.prisma_talento.Services.Empleado.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoController {


    @Autowired
    private EmpleadoService EmpleadoServicio;

    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        try{
            var empleados = EmpleadoServicio.obtenerEmpleados();
            return empleados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(empleados);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/[{identificacion}]")
    public ResponseEntity<Empleado> getEmpleadoByIdentificacion(@PathVariable String identificacion){
        try{
            var empleado = EmpleadoServicio.obtenerEmpleado(identificacion);
            return empleado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(empleado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado){
        try{
            var nuevoEmpleado = EmpleadoServicio.guardarEmpleado(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEmpleado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmpleado(@RequestBody Empleado empleado){
        try{
            EmpleadoServicio.eliminarEmpleado(empleado);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
                
    }

    
}
