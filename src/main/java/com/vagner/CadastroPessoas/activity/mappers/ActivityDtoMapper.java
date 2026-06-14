package com.vagner.CadastroPessoas.activity.mappers;

import com.vagner.CadastroPessoas.activity.domain.Activity;
import com.vagner.CadastroPessoas.activity.dto.ActivityDto;
import org.springframework.stereotype.Component;

@Component
public class ActivityDtoMapper {

    public Activity toDomain(ActivityDto activityDto){
        Activity activity = new Activity();

        activity.setIdActivity(activityDto.getId());
        activity.setDescricao(activityDto.getDescricao());
        activity.setActivityDegree(activityDto.getGrauAtividade());
        activity.setPeople(activityDto.getPessoaList());
        return activity;
    }

    public ActivityDto toDto(Activity activity){
        ActivityDto activityDto = new ActivityDto();

        activityDto.setId(activity.getIdActivity());
        activityDto.setDescricao(activity.getDescricao());
        activityDto.setGrauAtividade(activity.getActivityDegree());
        activityDto.setPessoaList(activity.getPeople());
        return activityDto;
    }


}
