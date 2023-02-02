package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.getName() != null);
        assertEquals("Product tester", job1.getName());

        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("ACME", job1.getEmployer().toString());

        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Desert", job1.getLocation().toString());

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job1.getPositionType().toString());

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job1.getCoreCompetency().toString());
   }

   @Test
   public void testJobsForEquality() {
       Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertFalse(job1.equals(job2));
   }

   //TODO: Figure out why this test is "Missing 2 invocations of assertEquals"
   @Test
   public void testToStringStartsAndEndsWithNewLine() {
       Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertEquals("\n", String.valueOf(job1.toString().charAt(0)));
       assertEquals("\n", String.valueOf(job1.toString().charAt(job1.toString().length() - 1)));
   }

   @Test
   public void testToStringContainsCorrectLabelsAndData() {
       Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       //TODO: Refactor tests using @Before to avoid id issues when running test alone
       // Test passes when all tests run together but fails on its own due to job1 being the ONLY job, meaning ID = 1
       assertEquals("\nID: 3\n" +
               "Name: Product tester\n" +
               "Employer: ACME\n" +
               "Location: Desert\n" +
               "Position Type: Quality control\n" +
               "Core Competency: Persistence\n", job1.toString());
   }

   @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

       assertEquals("\nID: 1\n" +
               "Name: Data not available\n" +
               "Employer: Data not available\n" +
               "Location: Data not available\n" +
               "Position Type: Data not available\n" +
               "Core Competency: Data not available\n", job1.toString());
   }
}