package utils;

import dataModel.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetListHandler {
    private final List<Pet> data;

    public PetListHandler(List<Pet> d){
        this.data = d;
    }

    public Map<String,Integer> petsWithRepeatedName(){
        Map<String, Integer> res = new HashMap<>();

        for (Pet p : data){
            if(res.containsKey(p.getName())){
                int oldCount = res.get(p.getName());
                res.replace(p.getName(),oldCount+1);
            }else{
                res.put(p.getName(),1);
            }
        }

        res.values().removeIf(value -> value == 1);

        return res;
    }

}