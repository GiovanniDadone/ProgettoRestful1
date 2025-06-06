package com.giodad.lil.roomwebapp.web.controller;

import com.giodad.lil.roomwebapp.data.entity.RoomEntity;
import com.giodad.lil.roomwebapp.data.repository.RoomRepository;
import com.giodad.lil.roomwebapp.service.RoomService;
import com.giodad.lil.roomwebapp.web.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getRoomsPage(Model model){
        model.addAttribute("rooms", this.roomService.getAllRooms());
        return "rooms";
    }
}