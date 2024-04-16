package info;

public class Author {

    private String lastName;
    private String firstName;
    private String nationality;
    private String yearOfBirth;
    private String earOfDeath;


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEarOfDeath() {
        return earOfDeath;
    }


    public Author(String lastName, String firstName, String nationality, String yearOfBirth, String earOfDeath) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.nationality = nationality;
        this.yearOfBirth = yearOfBirth;
        this.earOfDeath = earOfDeath;
    }


    @Override
    public String toString() {
        return "Author{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", earOfDeath='" + earOfDeath + '\'' +
                '}';
    }
}
