package de.thunderfrog;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MediumHandler {
    //  Medium ArrayList
    private List<Medium> mediumList = new ArrayList<>();

    //  Get all Elements from List
    public List<Medium> getMediums(){
        return mediumList;
    }

    //  Get one type from List
    public List<Medium> getMedium(String typ){
        return mediumList.stream().filter(new Predicate<Medium>() {
            @Override
            public boolean test(Medium medium) {
                return medium.getmType().equals(typ);
            }
        }).collect(Collectors.toList());
    }

    //  Add Elements to List
    public void addMedium(Medium medium){
        mediumList.add(medium);
    }
}
