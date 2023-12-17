import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
         Scanner sc = new Scanner(System.in);


        //1. step is Translation:- load and register the Drive
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.Establish the connection with database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","localhost123");

        // 3:-car :- crate the statement object
      Statement st = con.createStatement();

      // we use the while loop
        boolean flag= true;

        while (flag) {
            System.out.println("Enter the choice");
            System.out.println("view the scoreboard");
            System.out.println(" insert the record");
            System.out.println("Update the record");
            System.out.println("Delete the record");
            System.out.println("Exit");

            int choice = sc.nextInt();
            switch(choice){
                // view the data

                case 1:
                    viewTable(st);
                    // we can execute the query
                    String sql = "select * from socertable;";
                    ResultSet rs =st.executeQuery(sql);
                    System.out.println("ID\t| NAME\t| RUNS\t| BALLS\t|");

                    while(rs.next())
                        System.out.println(rs.getInt(1)+"\t"+
                                rs.getString(2)+"\t"+
                               rs.getInt(3)+"\t"+
                                rs.getInt(4));
                    System.out.println("----------------------------");


                    break;
                    // insert the data in score table
                case 2:
                    insertTable(st,sc);
                    System.out.println("Enter the id: ");
                    int  id = sc.nextInt();
                    System.out.println("Enter the name of the player ");

                    String name = sc.next();
                    System.out.println("Enter the ScoreBoard");
                    int runs = sc.nextInt();
                    System.out.println("In how many Ball???");
                    int balls = sc.nextInt();

                    // we use sql query for inserting the data
                    String insertQuery = "INSERT into socertable VALUE ("+id+",'"+name+"',"+runs+","+balls+");";
                     int rows= st.executeUpdate(insertQuery);
                    System.out.println(rows+" rows inserted" );
                    System.out.println("------------------------------");



                    break;
                case 3:
                    updateTable(st,sc);
                    // Update  methode in query
                    // UPDATE socertable set  runs = 140,ball=70,WHERE id =1

                    System.out.println("Enter the id of player : ");
                    id = sc.nextInt();
                    System.out.println("Enter the runs");
                     runs = sc.nextInt();
                    System.out.println("In how many balls");
                    int  ball = sc.nextInt();

                    String updateQuery ="UPDATE socertable set runs = "+runs+",ball = "+ball+" WHERE id ="+id+" ; ";
                      rows = st.executeUpdate(updateQuery);
                    System.out.println( rows+"rows Update");
                    System.out.println("------------------------------");



                    break;

                case 4:
                    // Delete the data from table
                    deleteTable(st,sc);
                    System.out.println("Enter the id of the Player:");
                     id = sc.nextInt();
                     String deleteQuery ="DELETE from socertable where id = "+id +";";
                    rows = st.executeUpdate(deleteQuery);
                    System.out.println( rows+"rows Update");
                    System.out.println("------------------------------");




                    break;

                default:
                    flag =false;
                    break;

            }

        }

    }
    public static void viewTable(Statement st)throws Exception{
        String sql = "select * from socertable;";
        ResultSet rs =st.executeQuery(sql);
        System.out.println("ID\t| NAME\t| RUNS\t| BALLS\t|");

        while(rs.next())
            System.out.println(rs.getInt(1)+"\t"+
                    rs.getString(2)+"\t"+
                    rs.getInt(3)+"\t"+
                    rs.getInt(4));
        System.out.println("----------------------------");



    }
    public static void insertTable(Statement st,Scanner sc) throws Exception{
        System.out.println("Enter the id: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the player ");

        String name = sc.next();
        System.out.println("Enter the ScoreBoard");
        int runs = sc.nextInt();
        System.out.println("In how many Ball???");
        int balls = sc.nextInt();

        // we use sql query for inserting the data
        String insertQuery = "INSERT into socertable VALUE ("+id+",'"+name+"',"+runs+","+balls+");";
        int rows= st.executeUpdate(insertQuery);
        System.out.println(rows+" rows inserted" );
        System.out.println("------------------------------");


    }
    public static void updateTable(Statement st,Scanner sc) throws Exception{
        System.out.println("Enter the id of player : ");
        int id = sc.nextInt();
        System.out.println("Enter the runs");
       int  runs = sc.nextInt();
        System.out.println("In how many balls");
        int  ball = sc.nextInt();

        String updateQuery ="UPDATE socertable set runs = "+runs+",ball = "+ball+" WHERE id ="+id+" ; ";
         int rows = st.executeUpdate(updateQuery);
        System.out.println( rows+"rows Update");
        System.out.println("------------------------------");
    }
    public static void deleteTable(Statement st,Scanner sc) throws Exception{
        deleteTable(st,sc);
        System.out.println("Enter the id of the Player:");
        int id = sc.nextInt();
        String deleteQuery ="DELETE from socertable where id = "+id +";";
        int rows = st.executeUpdate(deleteQuery);
        System.out.println( rows+"rows Update");
        System.out.println("------------------------------");

    }

}
