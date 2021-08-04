public class Main{
    public static String firstname;
    public static String lastname;
    public static int age;
    public static int mobile;
    public static String gender;
    public static String username;
    public static String date;
    public static String useremail;
    public static String companyname;
    public static int companymobile;
    public static String keyname;
    public static String companemail;
    public static String companypassword;
    public static boolean userlogged=false;
    public static boolean cinemalogged=false;

    public Main(){

    }

    public Main(String Firstname,String Lastname,int Age,int Mobile,String Gender,String Username,String Useremail,String Companyname, String Companemail,int Companymobile,String Keyname,String Companypassword,boolean Userlogged,boolean Cinemalogged,String Date){
        this.firstname=Firstname;
        this.date=Date;
        this.lastname=Lastname;
        this.age=Age;
        this.mobile=Mobile;
        this.gender=Gender;
        this.username=Username;
        this.useremail=Useremail;
        this.companyname=Companyname;
        this.keyname=Keyname;
        this.companemail=Companemail;
        this.companypassword=Companypassword;
        this.userlogged=Userlogged;
        this.cinemalogged=Cinemalogged;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getCompanymobile() {
        return companymobile;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Main.date = date;
    }

    public void setCompanymobile(int companymobile) {
        this.companymobile = companymobile;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getCompanemail() {
        return companemail;
    }

    public void setCompanemail(String companemail) {
        this.companemail = companemail;
    }

    public String getCompanypassword() {
        return companypassword;
    }

    public void setCompanypassword(String companypassword) {
        this.companypassword = companypassword;
    }

    public boolean isUserlogged() {
        return userlogged;
    }

    public void setUserlogged(boolean userlogged) {
        this.userlogged = userlogged;
    }

    public boolean isCinemalogged() {
        return cinemalogged;
    }

    public void setCinemalogged(boolean cinemalogged) {
        this.cinemalogged = cinemalogged;
    }
}