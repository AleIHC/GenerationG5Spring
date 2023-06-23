package com.example.demo.services;



import com.example.demo.entities.PersonajeEntity;
import com.example.demo.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service//Con esto indicamos a Spring que estamos trabajando con un service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired//Inyección de dependencia del repository
    private PersonajeRepository personajeRepository;

    //Método para obtener una lista de personajes, definimos la lógica del método
    @Override
    public List<PersonajeEntity> findAll() {
        List<PersonajeEntity> listaPersonajes = personajeRepository.findAll();
        return listaPersonajes;
    }

    //En este método retornamos un Optional de nuestro objeto, es otro tipo de variable mas no es nuestro objeto como tal
    @Override
    public Optional<PersonajeEntity> findById(Long id) {
        Optional<PersonajeEntity> personajeElegido = personajeRepository.findById(id);
        return personajeElegido;
    }

    @Override
    public PersonajeEntity save(PersonajeEntity personajeEntity) {
        PersonajeEntity nuevoPersonaje = personajeRepository.save(personajeEntity);
        return nuevoPersonaje;
    }

    @Override
    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }

}
