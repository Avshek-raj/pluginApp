package android;

public class employee {
    int id;
    String employeeName;
    String salary;
    String address;
    int contact;
    String post;

    public employee(int id, String employeeName, String salary, String address, int contact, String post){
        this.id = id;
        this.employeeName = employeeName;
        this.salary = salary;
        this.address = address;
        this.contact = contact;
        this.post = post;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    
    public String getSalary(){
        return salary;
    }

    public void setSalary(String salary){
        this.salary = salary;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getContact(){
        return contact;
    }

    public void setContact(int contact){
        this.contact = contact;
    }

    public String getPost(){
        return post;
    }

    public void setPost(String post){
        this.post = post;
    }
}
