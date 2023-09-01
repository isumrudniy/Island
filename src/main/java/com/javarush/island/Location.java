package com.javarush.island;

import com.javarush.island.entities.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Location {
    private int x;
    private int y;
    private List<Entities> entitiesList = new ArrayList<>();

}
