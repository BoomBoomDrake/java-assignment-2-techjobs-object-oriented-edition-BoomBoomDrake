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
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job3.getName() != null);
        assertEquals("Product tester", job3.getName());

        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals("ACME", job3.getEmployer().toString());

        assertTrue(job3.getLocation() instanceof Location);
        assertEquals("Desert", job3.getLocation().toString());

        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job3.getPositionType().toString());

        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job3.getCoreCompetency().toString());
   }

   @Test
   public void testJobsForEquality() {
       Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertFalse(job4.equals(job5));
   }

   @Test
   public void testToStringStartsAndEndsWithNewLine() {
       Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertEquals('\n', job6.toString().charAt(0));
       assertEquals('\n', job6.toString().charAt(job6.toString().length() - 1));
   }

   @Test
   public void testToStringContainsCorrectLabelsAndData() {
       Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertEquals("\nID: 4\n" +
               "Name: Product tester\n" +
               "Employer: ACME\n" +
               "Location: Desert\n" +
               "Position Type: Quality control\n" +
               "Core Competency: Persistence\n", job7.toString());
   }

   @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

       assertEquals("\nID: 3\n" +
               "Name: Data not available\n" +
               "Employer: Data not available\n" +
               "Location: Data not available\n" +
               "Position Type: Data not available\n" +
               "Core Competency: Data not available\n", job8.toString());
   }
}