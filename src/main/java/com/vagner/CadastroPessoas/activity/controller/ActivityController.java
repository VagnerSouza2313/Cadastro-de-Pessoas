package com.vagner.CadastroPessoas.activity.controller;

import com.vagner.CadastroPessoas.activity.dto.ActivityDto;
import com.vagner.CadastroPessoas.activity.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atividade")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    //create activity
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ActivityDto activityDto){
        activityDto = activityService.create(activityDto);
        return ResponseEntity.ok(activityDto);
    }

    //read all
    @GetMapping("/read")
    public ResponseEntity<?> read(){
        List<ActivityDto> list = activityService.read();
        return ResponseEntity.ok(list);
    }

    //read by id
    @GetMapping("/read/{id}")
    public ResponseEntity<?> readId(@PathVariable Long id){
        ActivityDto activityDto = activityService.readId(id);
        if (activityDto != null){
            return ResponseEntity.ok(activityDto);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found in our records, ID: " + id);
        }
    }

    //update activity
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ActivityDto activityDto){
        if (activityService.readId(id) != null){
            ActivityDto activityDtoUpdate = activityService.update(id, activityDto);
            return ResponseEntity.ok(activityDtoUpdate);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity with id: " + id + " not found in our records.");
        }
    }

    //delete activity
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (activityService.readId(id) != null){
            activityService.delete(id);
            return ResponseEntity.ok("Activity with id: " + id + " deleted.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity with id: " + id + " deleted.");
        }
    }


}
