package org.demo.t5rest.model;

public class Person
{
    private static int idCounter = 1;

    private final int id;
    private String firstName;
    private String lastName;
    private int weightInPounds;
    private int heightInInches;

    public Person(String firstName, String lastName, int weightInPounds, int heightInInches)
    {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.weightInPounds = weightInPounds;
        this.heightInInches = heightInInches;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getWeightInPounds()
    {
        return weightInPounds;
    }

    public void setWeightInPounds(int weightInPounds)
    {
        this.weightInPounds = weightInPounds;
    }

    public int getHeightInInches()
    {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches)
    {
        this.heightInInches = heightInInches;
    }
}
