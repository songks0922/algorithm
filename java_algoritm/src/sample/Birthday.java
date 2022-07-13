package sample;

public class Birthday {

    public int month;
    public int day;
    public int age;
    public String name;

    public Birthday(int month, int day, int age, String name) {
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 31 || day < 1)) {
            this.month = 1;
            this.day = 1;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
            this.month = 1;
            this.day = 1;
        } else if ((month == 2) && (day < 1 || day > 28)) {
            this.month = 1;
            this.day = 1;
        } else if (month < 1 || month > 12) {
            this.month = 1;
            if (day > 31 || day < 1) {
                this.day = 1;
            } else {
                this.day = day;
            }
        } else {
            this.month = month;
            this.day = day;
        }

        this.age = age;
        this.name = name;
    }

    public Birthday(int month, int day, int age) {
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 31 || day < 1)) {
            this.month = 1;
            this.day = 1;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
            this.month = 1;
            this.day = 1;
        } else if ((month == 2) && (day < 1 || day > 28)) {
            this.month = 1;
            this.day = 1;
        } else if (month < 1 || month > 12) {
            this.month = 1;
            if (day > 31 || day < 1) {
                this.day = 1;
            } else {
                this.day = day;
            }
        } else {
            this.month = month;
            this.day = day;
        }
        this.name = "unknown";
        this.age = age;
    }

    public Birthday(int month, int day) {
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 31 || day < 1)) {
            this.month = 1;
            this.day = 1;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
            this.month = 1;
            this.day = 1;
        } else if ((month == 2) && (day < 1 || day > 28)) {
            this.month = 1;
            this.day = 1;
        } else if (month < 1 || month > 12) {
            this.month = 1;
            if (day > 31 || day < 1) {
                this.day = 1;
            } else {
                this.day = day;
            }
        } else {
            this.month = month;
            this.day = day;
        }
        this.name = "unknown";
        this.age = 1;
    }

    public Birthday() {
        this.month = 1;
        this.day = 1;
        this.age = 1;
        this.name = "unknown";
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "month=" + month +
                ", day=" + day +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void sayHello() {
        System.out.println("Hello birthday");
    }

    public static void main(String[] args) {
//        Birthday birthday1 = new Birthday();
//        System.out.println(birthday1);
//        Birthday birthday2 = new Birthday(0, 30, 30, "아무이름");
//        System.out.println(birthday2);
        Birthday birthday3 = new Birthday(2, 21);
        sayHello();

    }
}
