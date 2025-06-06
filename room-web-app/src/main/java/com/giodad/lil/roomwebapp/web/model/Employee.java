package com.giodad.lil.roomwebapp.web.model;

import com.giodad.lil.roomwebapp.data.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private UUID id;
    private String lastName;
    private String firstName;
    private Position position;
}
