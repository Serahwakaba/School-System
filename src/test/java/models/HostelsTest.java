package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostelsTest {
    @Test
    public void sightingsInstantiatesCorrectly_true() {
        Hostels testHostel =createHostel();
        assertEquals(true,  testHostel instanceof  Hostels);
    }

    @Test
    public void hostel_instantiatesWithStudentId_int() {
        Hostels testHostel =createHostel();
        assertEquals(1,testHostel.getStudentId());
    }

    @Test
    public void hostel_instantiatesWithLocation_string() {
        Hostels testHostel =createHostel();
        assertEquals("Near The River", testHostel.getLocation());
    }

    @Test
    public void hostel_instantiatesWithName_String() {
        Hostels testHostel =createHostel();
        assertEquals("SOUTH", testHostel.getName());
    }

    @Test
    public void equals_returnsTrueIfSightDetailsAreEqual_true() {
        Hostels firstHostel=createHostel();
        Hostels secondHostel=createHostel();
        assertTrue(firstHostel.equals(secondHostel));
    }

    @Test
    public void save_savesHostelToTheDatabase() {
        Hostels testHostel =createHostel();
        testHostel.saveHostel();
        assertTrue(Hostels.getAll().get(0).equals(testHostel));
    }

    @Test
    public void save_assignsIdToHostel() {
        Hostels testHostel =createHostel();
        testHostel.saveHostel();
        Hostels savedSight = Hostels.getAll().get(0);
        assertEquals(savedSight.getId(),testHostel.getId());
    }



    @Test
    public void getAll_returnsAllInstancesOfHostel() {
        Hostels testHostel =createHostel();
        testHostel.saveHostel();
        Hostels testSecondSHostel=createSecondHostel();
        testSecondHostel.saveHostel();
        assertTrue(Hostels.getAll().get(0).equals(testHostel));
        assertTrue(Hostels.getAll().get(1).equals(testSecondHostel));
    }

    @Test
    public void findById_returnsAllHostelsWithSameId_SecondHostel() {
        Hostels testHostel = createHostel();
        testHostel.saveHostel();
        Hostels savedHostel1 = Hostels.findById(testHostel.getId());
        Hostels secondHostel =createSecondHostel();
        testHostel.saveHostel();
        Hostels savedHostel2 = Hostels.findById(secondHostel.getId());

        assertEquals(Hostels.findById(testHostel.getId()),savedHostel1);
        assertEquals(Hostel.findById(secondHostel.getId()),savedHostel2);
    }

    @Test
    public void update_updatesHostelDetails() {
        Hostels testHostel = createHostel();
        testHostel.saveHostel();

        testHostel.update(2,"Gate C","ngara");
        Hostels updatedHostel=Hostels.findById(testHostel.getId());

        assertEquals(testHostel.getId(),updatedHostel.getId());
        assertNotEquals(testHostel.getStudentId(),updatedHostel.getStudentId());
        assertNotEquals(testHostel.getLocation(),updatedHostel.getLocation());
        assertNotEquals(testHostel.getName(),updatedHostelgetName());
    }

    @Test
    public void removeById_removesHostelById() {
        Hostels testHostel=createHostel();
        testHostel.saveHostel();
        testHostel.removeById();
        assertEquals(null,Hostels.findById(testHostel.getId()));
    }

    @Test
    public void removeAll_clearsHostelSDatabase() {
        Hostels testHostel=createHostel();
        testHostel.saveHostel();
        testHostel.removeAll();
        assertEquals(null,HostelS.findById(testHostel.getId()));
    }

    public Hostels createHostel()
    {
        return new Hostels(1,"56677","James");
    }
    public Hostels createSecondHostel()
    {
        return new Hostels(1,"Zone A", "Mark");
    }

}