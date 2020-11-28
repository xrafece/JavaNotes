package com.xrafece.service.impl;

import com.xrafece.entity.Classroom;
import com.xrafece.mapper.ClassroomMapper;
import com.xrafece.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xrafece
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> listAllClassroom() {
        return classroomMapper.listAllClassroom();
    }

    @Override
    public List<Classroom> listAvailableClassroom() {
        return classroomMapper.listAvailableClassroom();
    }

    @Override
    public void insertClassroom(Classroom classroom) {
        classroomMapper.insertClassroom(classroom);
    }

    @Override
    public void removeClassroom(Classroom classroom) {
        classroomMapper.removeClassroom(classroom);
    }

    @Override
    public void updateClassroomStatus(Classroom classroom) {
        classroomMapper.updateClassroomStatus(classroom);
    }
}
