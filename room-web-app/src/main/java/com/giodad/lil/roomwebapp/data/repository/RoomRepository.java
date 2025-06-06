package com.giodad.lil.roomwebapp.data.repository;

import com.giodad.lil.roomwebapp.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

}