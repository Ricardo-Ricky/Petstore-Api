package com.test.pet.ApiTestCases;

import controller.PetsController;
import dataModel.Pet;
import dataModel.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PetListHandler;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class PetTests extends BaseTest {
    PetsController petsController;

    @BeforeClass
    public void beforeClass() {
        petsController = new PetsController();
    }

    List<Pet> soldPets = new ArrayList<>();

    @Test(priority = 1)
    public void getPetByStatus() {
        soldPets= petsController.getPetsByStatus(Status.sold, captor);
        for(Pet p : soldPets){
            System.out.printf("{%s, %s}\n",p.getId(),p.getName());
        }
    }

    @Test(priority = 2)
    public void getPetsWithRepeatedName() {
        PetListHandler pdf = new PetListHandler(soldPets);
        System.out.println(pdf.petsWithRepeatedName());
    }

}
