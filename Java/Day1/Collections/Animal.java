package Java.Day1.Collections;

public class Animal {
    private String name;

    public Animal() { }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }

    /*
     * hashCode()
     *  - generates a unique hash value for an object
     *      hashing collections will use this function to determine locations
     * 
     *  - NEEDS to be overrriden if you override eqauls
     * 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
     * equals()
     *  - determines if two objects of this class are equivalent to eachother
     *      that could mean that they refer to the same place in memory
     *      OR that every value within the objects is equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    

    
}
