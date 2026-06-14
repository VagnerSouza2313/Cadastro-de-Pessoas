package com.vagner.CadastroPessoas.activity.service;

import com.vagner.CadastroPessoas.activity.domain.Activity;
import com.vagner.CadastroPessoas.activity.dto.ActivityDto;
import com.vagner.CadastroPessoas.activity.mappers.ActivityDtoMapper;
import com.vagner.CadastroPessoas.activity.repository.ActivityRepository;
import com.vagner.CadastroPessoas.activity.service.exceptions.IdNotFoundException;
import com.vagner.CadastroPessoas.person.domain.Person;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    ActivityRepository activityRepository;
    ActivityDtoMapper activityDtoMapper;

    public ActivityService(ActivityRepository activityRepository, ActivityDtoMapper activityDtoMapper) {
        this.activityRepository = activityRepository;
        this.activityDtoMapper = activityDtoMapper;
    }

    //Create activity
    public ActivityDto create(ActivityDto activityDto){
        Activity activity = activityDtoMapper.toDomain(activityDto);
        activityRepository.save(activity);
        return  activityDtoMapper.toDto(activity);
    }

    //Read activity
    public List<ActivityDto> read(){
        List<Activity> activityList = activityRepository.findAll();
        return activityList.stream().map(activityDtoMapper::toDto).collect(Collectors.toList());
    }

    //Read by id
    public ActivityDto readId(Long id){
        Optional<Activity> atividade = activityRepository.findById(id);
        return atividade.map(activityDtoMapper::toDto).orElseThrow(() -> new IdNotFoundException("Id not found in our regiters, digit a Id valid"));
    }

    //Update activity
    public ActivityDto update(Long id, ActivityDto activityDto){
        Optional<Activity> atividade = activityRepository.findById(id);
        if (atividade.isPresent()){
            Activity activityUpdate = atividade.get();
            activityUpdate.setDescricao(activityDto.getDescricao());
            activityUpdate.setActivityDegree(activityDto.getGrauAtividade());
            Activity activitySave = activityRepository.save(activityUpdate);
            return activityDtoMapper.toDto(activitySave);
        }
        else {
            return atividade.map(activityDtoMapper::toDto).orElseThrow(() -> new IdNotFoundException("Id not found in our regiters, digit a Id valid"));
        }
    }

    //Delete activity
    @Transactional
    public void delete(Long id){
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        for (Person person : activity.getPeople()){
            person.setActivity(null);
        }
        activityRepository.deleteById(id);
    }

}
