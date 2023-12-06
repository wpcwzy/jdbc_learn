public class Main {
    public static void main(String[] args) {
        try {
            JDBCUtil jdbc=new JDBCUtil();
            jdbc.addUser("Bob","123456","12345678910");
            System.out.println("Add User Success");
            jdbc.updateUser("Bob","654321","98765432101");
            System.out.println("Update User Success");
            String password=jdbc.getPassword("Bob");
            String phone=jdbc.getPhone("Bob");
            System.out.println("pwd:"+password);
            System.out.println("phone:"+phone);
            jdbc.deleteUser("Bob");
            System.out.println("Delete User Success");
        }
        catch (java.sql.SQLException e){
            e.printStackTrace();
        }
    }
}