/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_14_q1;

import java.util.Objects;

/**
 *
 * @author anatfradin
 */
public class CustomerTestObject {
    
    private String name;
    private String tz;
    private String inquireDetails;

    public CustomerTestObject(String name, String tz, String inquireDetails) {
        this.name = name;
        this.tz = tz;
        this.inquireDetails = inquireDetails;
    }

    public String getTz() {
        return tz;
    }

    public String getInquireDetails() {
        return inquireDetails;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof CustomerTestObject)) {
            return false;
        }

        CustomerTestObject other = (CustomerTestObject) o;

        if (this.tz.equals(other.tz)) {
            if (this.inquireDetails.equals(other.inquireDetails)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.tz);
        hash = 89 * hash + Objects.hashCode(this.inquireDetails);
        return hash;
    }
    
    @Override
    public String toString(){
       return new String(" < name: " + name + " tz: " + tz + " inquire: " + inquireDetails + "> ");
    }
    
}
