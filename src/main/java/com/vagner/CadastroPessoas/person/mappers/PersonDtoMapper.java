package com.vagner.CadastroPessoas.person.mappers;

import com.vagner.CadastroPessoas.person.domain.Person;
import com.vagner.CadastroPessoas.person.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoMapper {

    public Person toDomain(PersonDto personDto){

        Person person = new Person();

        person.setIdPerson(personDto.getId());
        person.setNome(personDto.getNome());
        person.setIdade(personDto.getIdade());
        person.setEmail(personDto.getEmail());
        person.setSocialStates(personDto.getStatusSocial());
        return person;
    }

    public PersonDto toDto(Person person){

        PersonDto personDto = new PersonDto();

        personDto.setId(person.getIdPerson());
        personDto.setNome(person.getNome());
        personDto.setIdade(person.getIdade());
        personDto.setEmail(person.getEmail());
        personDto.setStatusSocial(person.getSocialStates());

        if(person.getActivity() != null){

            personDto.setIdAtividade(
                    person.getActivity().getIdActivity()
            );

            personDto.setAtividadeDesc(
                    person.getActivity().getDescricao()
            );
        }

        return personDto;
    }
}