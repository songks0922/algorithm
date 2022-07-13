public class Customer {
    public String name;
    public int age;
    public static int numOfCustomers = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNumOfCustomers() {
        return numOfCustomers;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.numOfCustomers++;
    }

    public Customer() {
        this.name = "unknown";
        this.age = 1;
        this.numOfCustomers++;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer();
        System.out.println(customer1);
        System.out.println(Customer.getNumOfCustomers());
        Customer customer2 = new Customer("아무개", 20);
        System.out.println(customer2);
        System.out.println(Customer.getNumOfCustomers());
    }
}
