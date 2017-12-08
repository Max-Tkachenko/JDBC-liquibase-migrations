package items;

public class User {

    public int id;
    public String name;
    public String surname;
    public int age;

    public User(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }

    public boolean equals(User user) {
        boolean bool = false;
        if(user.getId() == this.getId() && user.getName().equals(this.getName()) && user.getSurname().equals(this.getSurname())
                && user.getAge() == this.getAge()) {
            bool = true;
        }
        return bool;
    }
}
