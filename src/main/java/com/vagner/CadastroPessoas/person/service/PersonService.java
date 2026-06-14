package com.vagner.CadastroPessoas.person.service;

import com.vagner.CadastroPessoas.activity.domain.Activity;
import com.vagner.CadastroPessoas.activity.repository.ActivityRepository;
import com.vagner.CadastroPessoas.person.domain.Person;
import com.vagner.CadastroPessoas.person.service.exceptions.EmailDuplicateException;
import com.vagner.CadastroPessoas.person.dto.PersonDto;
import com.vagner.CadastroPessoas.person.mappers.PersonDtoMapper;
import com.vagner.CadastroPessoas.person.repository.PersonRepository;
import com.vagner.CadastroPessoas.person.service.exceptions.IdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonDtoMapper personDtoMapper;
    private final ActivityRepository activityRepository;

    public PersonService(PersonRepository personRepository, PersonDtoMapper personDtoMapper, ActivityRepository activityRepository) {
        this.personRepository = personRepository;
        this.personDtoMapper = personDtoMapper;
        this.activityRepository = activityRepository;
    }

    //Create people
    public PersonDto create(PersonDto personDto){
        Person person1 = personDtoMapper.toDomain(personDto);
        if(personRepository.existsByEmail(person1.getEmail())){
            throw new EmailDuplicateException("Email already registered, register another email");
        }
        if(personDto.getIdAtividade() != null){
            Activity activity = activityRepository
                    .findById(personDto.getIdAtividade())
                    .orElseThrow(() ->
                            new IdNotFoundException("Activity not found"));
            person1.setActivity(activity);
        }
        personRepository.save(person1);
        return personDtoMapper.toDto(person1);
    }

    //Read people
    public List<PersonDto> read(){
        List<Person> personList = personRepository.findAll();
        return personList.stream().map(personDtoMapper::toDto).collect(Collectors.toList());
    }

    //Read by id
    public PersonDto readId(Long id){
        Optional<Person> peopleId = personRepository.findById(id);
        return peopleId.map(personDtoMapper::toDto).orElseThrow(() -> new IdNotFoundException("Id not found in our regiters, digit a Id valid"));
    }

    //Update people
    public PersonDto update(Long id, PersonDto personDto){
        Optional<Person> pessoaExiste = personRepository.findById(id);
        Activity atividade = activityRepository.findById(personDto.getIdAtividade()).orElseThrow(() ->  new RuntimeException("Atividade não encontrada. ID recebido: " + personDto.getIdAtividade()));
        if(pessoaExiste.isPresent()){
            Person peopleUpdate = pessoaExiste.get();
            peopleUpdate.setNome(personDto.getNome());
            peopleUpdate.setIdade(personDto.getIdade());
            peopleUpdate.setEmail(personDto.getEmail());
            peopleUpdate.setSocialStates(personDto.getStatusSocial());
            peopleUpdate.setActivity(atividade);

            Person peopleSave = personRepository.save(peopleUpdate);
            return personDtoMapper.toDto(peopleSave);
        }
        return null;
    }

    //Delete people
    public void delete(Long id){
        personRepository.deleteById(id);
    }


}
