package com.example.BookMyShow.Adapter;

import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.example.BookMyShow.Model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserAdapter {

    public UserEntity DTOtoEntity(UserEntryDTO userEntryDTO){
        return UserEntity.builder()
                .name(userEntryDTO.getName())
                .mobile(userEntryDTO.getMobNo())
                .build();
    }

    public UserResponseDTO EntityToDTO(UserEntity userEntity){
        return UserResponseDTO.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobNo(userEntity.getMobile())
                .build();
    }

}
